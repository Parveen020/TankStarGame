package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FillViewport;

import java.util.ArrayList;

public class TankSelect implements Screen {
    private final MyGdxGame game;
    SpriteBatch spriteBatch;
    private Stage stage;
    private OrthographicCamera camera;
    private TextureAtlas atlas;
    private Texture health1,health2,health3,health4;
    private Texture background,homebutton,backbutton1,backbutton2,backbutton3,backbutton4,HP,HPR,texture,texture1,texturename,texturename1;
    private TextureRegion backgroundTexture,bbt,bbt1,bbt2,bbt3,bbt4,bbt5,bbt6,bbt7,bbt8,bbt9,bbt10;
    private TextureRegionDrawable bbtt,bbtt1,bbtt2,bbtt3,bbtt4,bbtt6,bbtt5,bbtt7,bbtt8,bbtt9,bbtt10;
    private ImageButton bt,bt1,bt2,bt3,bt4,bt5,bt6,bt7,bt8,bt9,bt10;
    Animation<TextureRegion> animation;
    SpriteBatch batch;
    private Skin skin;
    float elapsed;
    private int i=0,j=0;
    private Boolean a=true,b=true;
    private Sound sound ;
    final ArrayList<String> tankname = new ArrayList<String>(8);
    final ArrayList<String> tankpower1 = new ArrayList<String>(8);
    final ArrayList<String> tankdistruction1 = new ArrayList<String>(8);
    final ArrayList<String> tankpower2 = new ArrayList<String>(8);
    final ArrayList<String> tankdistruction2 = new ArrayList<String>(8);
    public TankSelect(final MyGdxGame game) {
        this.game = game;
        batch = new SpriteBatch();
        camera = new OrthographicCamera();
        stage = new Stage(new FillViewport(1120.0F, 620.0F));
        this.background = new Texture(Gdx.files.internal("background1/bfts.png"));
        this.backgroundTexture = new TextureRegion(this.background, 0, 0, background.getWidth(), background.getHeight());
        this.camera.setToOrtho(false, background.getWidth(), background.getHeight());
        Gdx.input.setInputProcessor(stage);

        homebutton = new Texture(Gdx.files.internal("buttons/homebutton.png"));
        bbt = new TextureRegion(homebutton);
        bbtt = new TextureRegionDrawable(bbt);
        bt = new ImageButton(bbtt);
        bt.setSize(60,60);
        bt.setPosition(5,560);
        bt.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                sound =Gdx.audio.newSound(Gdx.files.internal("Music/button_toggle.mp3"));
                sound.play();
                game.setScreen(new Menu(game));
            }
        });
        stage.addActor(bt);
        tankname.add(0,"tankname/abrams (3).png");
        tankname.add(1,"tankname/frost (3).png");
        tankname.add(2,"tankname/buratino (3).png");
        tankname.add(3,"tankname/coalition (3).png");
        tankname.add(4,"tankname/dubstep (2).png");
        tankname.add(5,"tankname/atomic (3).png");
        tankname.add(6,"tankname/mark1 (2).png");
        tankname.add(7,"tankname/pinky (2).png");

        tankpower1.add(0,"healthL/65R.png");
        tankpower1.add(1,"healthL/78R.png");
        tankpower1.add(2,"healthL/75R.png");
        tankpower1.add(3,"healthL/77R.png");
        tankpower1.add(4,"healthL/79R.png");
        tankpower1.add(5,"healthL/83R.png");
        tankpower1.add(6,"healthL/80R.png");
        tankpower1.add(7,"healthL/93R.png");

        tankdistruction1.add(0,"healthL/80B.png");
        tankdistruction1.add(0,"healthL/75B.png");
        tankdistruction1.add(0,"healthL/80B.png");
        tankdistruction1.add(0,"healthL/78B.png");
        tankdistruction1.add(0,"healthL/65B.png");
        tankdistruction1.add(0,"healthL/79B.png");
        tankdistruction1.add(0,"healthL/93B.png");
        tankdistruction1.add(0,"healthL/77B.png");

        tankpower2.add(0,"healthR/65R.png");
        tankpower2.add(1,"healthR/78R.png");
        tankpower2.add(2,"healthR/75R.png");
        tankpower2.add(3,"healthR/77R.png");
        tankpower2.add(4,"healthR/79R.png");
        tankpower2.add(5,"healthR/83R.png");
        tankpower2.add(6,"healthR/80R.png");
        tankpower2.add(7,"healthR/93R.png");

        tankdistruction2.add(0,"healthR/80B.png");
        tankdistruction2.add(1,"healthR/75B.png");
        tankdistruction2.add(2,"healthR/80B.png");
        tankdistruction2.add(3,"healthR/78B.png");
        tankdistruction2.add(4,"healthR/65B.png");
        tankdistruction2.add(5,"healthR/79B.png");
        tankdistruction2.add(6,"healthR/93B.png");
        tankdistruction2.add(7,"healthR/77B.png");

        final ArrayList<String> dict = new ArrayList<String>();
        dict.add(0, "tank/Abrams.png"); //800
        dict.add(1, "tank/Frost.png"); //800
        dict.add(2, "tank/Buratino.png"); //750
        dict.add(3, "tank/Coalition.png"); //800
        dict.add(4, "tank/Dubstep_edited_29.png"); //800
        dict.add(5, "tank/Atomic.png");  //800
        dict.add(6, "tank/Mark_I.png"); //800
        dict.add(7, "tank/Pinky_edited.png");  //850

//        this.i=0;
        this.HP = new Texture(Gdx.files.internal("tankname/abramslogo.png"));
        this.health1=new Texture(Gdx.files.internal(tankpower1.get(0)));
        this.health2=new Texture(Gdx.files.internal(tankdistruction1.get(0)));
        this.texturename = new Texture(Gdx.files.internal(tankname.get(0)));
        this.health3=new Texture(Gdx.files.internal(tankpower2.get(0)));
        this.health4=new Texture(Gdx.files.internal(tankdistruction2.get(0)));
        this.texture = new Texture(Gdx.files.internal("tank/Abrams.png"));

        backbutton1 = new Texture(Gdx.files.internal("buttons/backbutton.png"));
        bbt1 = new TextureRegion(backbutton1);
        bbtt1 = new TextureRegionDrawable(bbt1);
        bt1 = new ImageButton(bbtt1);
        bt1.setSize(60,60);
        bt1.setPosition(50,200);
        stage.addActor(bt1);
        bt1.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                sound =Gdx.audio.newSound(Gdx.files.internal("Music/button_toggle.mp3"));
                sound.play();
                i--;
                if(i<-8){i=0;}int p=i;
                if(p<0){p=8+p;} else if(p>0){p=8-p;}
                System.out.println(p);
                if(p==2){HP = new Texture(Gdx.files.internal("tankname/otherlogo.png"));}
                else if(p==7){HP = new Texture(Gdx.files.internal("tankname/otherlogo2.png"));}
                else{HP = new Texture(Gdx.files.internal("tankname/abramslogo.png"));}
                texture = new Texture(Gdx.files.internal(dict.get(p)));
                health1=new Texture(Gdx.files.internal(tankpower1.get(p)));
                health2=new Texture(Gdx.files.internal(tankdistruction1.get(p)));
                texturename = new Texture(Gdx.files.internal(tankname.get(p)));
            }
        });

        backbutton2 = new Texture(Gdx.files.internal("buttons/probutton.png"));
        bbt2 = new TextureRegion(backbutton2);
        bbtt2 = new TextureRegionDrawable(bbt2);
        bt2 = new ImageButton(bbtt2);
        bt2.setSize(60,60);
        bt2.setPosition(370,200);
        stage.addActor(bt2);
        bt2.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                sound =Gdx.audio.newSound(Gdx.files.internal("Music/button_toggle.mp3"));
                sound.play();
                i++;
                if(i>8){i=0;}int p=i;
                if(p>7){p=8-p;}else if(p<0){p=8+p;}
                System.out.println(p);
                if(p==2){HP = new Texture(Gdx.files.internal("tankname/otherlogo.png"));}
                else if(p==7){HP = new Texture(Gdx.files.internal("tankname/otherlogo2.png"));}
                else{HP = new Texture(Gdx.files.internal("tankname/abramslogo.png"));}
                texture = new Texture(Gdx.files.internal(dict.get(p)));
                health1=new Texture(Gdx.files.internal(tankpower1.get(p)));
                health2=new Texture(Gdx.files.internal(tankdistruction1.get(p)));
                texturename = new Texture(Gdx.files.internal(tankname.get(p)));
            }
        });

//        this.j=0;
        final ArrayList<String> dict1 = new ArrayList<String>();
        dict1.add(0, "Rtank/AbramsR.png");
        dict1.add(1, "Rtank/FrostR.png");
        dict1.add(2, "Rtank/BuratinoR.png");
        dict1.add(3, "Rtank/CoalitionR.png");
        dict1.add(4, "Rtank/Dubstep_edited_29R.png");
        dict1.add(5, "Rtank/AtomicR.png");
        dict1.add(6, "Rtank/Mark_IR.png");
        dict1.add(7, "Rtank/Pinky_editedR.png");
        this.HPR = new Texture(Gdx.files.internal("tankname/abramslogo.png"));
        this.texturename1 = new Texture(Gdx.files.internal(tankname.get(0)));
        this.texture1 = new Texture(Gdx.files.internal(dict1.get(0)));

        backbutton3 = new Texture(Gdx.files.internal("buttons/backbutton.png"));
        bbt3 = new TextureRegion(backbutton3);
        bbtt3 = new TextureRegionDrawable(bbt3);
        bt3 = new ImageButton(bbtt3);
        bt3.setSize(60,60);
        bt3.setPosition(690,200);
        stage.addActor(bt3);
        bt3.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                sound =Gdx.audio.newSound(Gdx.files.internal("Music/button_toggle.mp3"));
                sound.play();
                j--;
                if(j<-8){j=0;}int p=j;
                if(p<0){p=8+p;}else if(p>7){p=8-p;}
                System.out.println(p);
                if(p==2){HPR = new Texture(Gdx.files.internal("tankname/otherlogo.png"));}
                else if(p==7){HPR = new Texture(Gdx.files.internal("tankname/otherlogo2.png"));}
                else{HPR = new Texture(Gdx.files.internal("tankname/abramslogo.png"));}
                texture1 = new Texture(Gdx.files.internal(dict1.get(p)));
                health3=new Texture(Gdx.files.internal(tankpower2.get(p)));
                health4=new Texture(Gdx.files.internal(tankdistruction2.get(p)));
                texturename1 = new Texture(Gdx.files.internal(tankname.get(p)));
            }
        });

        backbutton4 = new Texture(Gdx.files.internal("buttons/probutton.png"));
        bbt4 = new TextureRegion(backbutton4);
        bbtt4 = new TextureRegionDrawable(bbt4);
        bt4 = new ImageButton(bbtt4);
        bt4.setSize(60,60);
        bt4.setPosition(1010,200);
        stage.addActor(bt4);
        bt4.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                sound =Gdx.audio.newSound(Gdx.files.internal("Music/button_toggle.mp3"));
                sound.play();
                j++;
                if(j>8){j=0;}int p=j;
                if(p>7){p=8-p;}else if(p<0){p=8+p;}
                System.out.println(p);
                if(p==2){HPR = new Texture(Gdx.files.internal("tankname/otherlogo.png"));}
                else if(p==7){HPR = new Texture(Gdx.files.internal("tankname/otherlogo2.png"));}
                else{HPR = new Texture(Gdx.files.internal("tankname/abramslogo.png"));}
                texture1 = new Texture(Gdx.files.internal(dict1.get(p)));
                health3=new Texture(Gdx.files.internal(tankpower2.get(p)));
                health4=new Texture(Gdx.files.internal(tankdistruction2.get(p)));
                texturename1 = new Texture(Gdx.files.internal(tankname.get(p)));
            }
        });

        skin = new Skin(Gdx.files.internal("skin/glassy-ui.json"));
        Button Playbutton = new TextButton("Play",skin,"small");
        Playbutton.setSize(100,60);
        Playbutton.setPosition(520,80);
        Playbutton.addListener(new ClickListener(){
            public void clicked(InputEvent event,float x, float y){
                sound =Gdx.audio.newSound(Gdx.files.internal("Music/button_toggle.mp3"));
                sound.play();
                game.setScreen(new PlayScreen(game,i,j));}});
        stage.addActor(Playbutton);
    }
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        elapsed += Gdx.graphics.getDeltaTime();
        ScreenUtils.clear(0.0F, 0.0F, 0.0F, 0.0F);
        this.camera.update();
        this.game.batch.setProjectionMatrix(this.camera.combined);
        this.game.batch.begin();
        this.game.batch.draw(this.backgroundTexture, 0.0F, 0.0F, background.getWidth(), background.getHeight());
        this.game.batch.draw(this.HP,110,285,65,65);
        this.game.batch.draw(this.HPR,540,285,65,65);
        this.game.batch.draw(this.texturename,65.0F,330.0F,150,50);
        this.game.batch.draw(this.texturename1,495.0F,330.0F,150,50);
        this.game.batch.draw(this.texture, 60,110,180,200);
        this.game.batch.draw(this.texture1, 480,110,180,200);
        this.game.font.draw(this.game.batch,"Power",20,132);
        this.game.font.draw(this.game.batch,"Distruction",10,92);
        this.game.font.draw(this.game.batch,"Power",648,132);
        this.game.font.draw(this.game.batch,"Distruction",638,92);
        this.game.batch.draw(this.health1,85,110,110,40);
        this.game.batch.draw(this.health2,85,65,110,40);
        this.game.batch.draw(this.health3,520,110,110,40);
        this.game.batch.draw(this.health4,520,65,110,40);
        this.game.batch.end();
        stage.act();
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {batch.dispose();stage.dispose();}

}
