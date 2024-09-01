package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.IsometricTiledMapRenderer;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.DragListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import sun.jvm.hotspot.HelloWorld;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

public class PlayScreen implements Screen {
    private final MyGdxGame game;
    private TiledMap map;
    private OrthogonalTiledMapRenderer pam;
    private OrthographicCamera camera;
    private Texture vs,l_logo,r_logo,l_health,r_health;
    private TextureRegion bbt;
    private TextureRegionDrawable bbtt;
    private ImageButton bt;
    private Sound sound;
    private Stage stage = new Stage();

    private PlayerL playerl;
    private PlayerR playerR;
    final ArrayList<String> L_health = new ArrayList<String>(6);
    final ArrayList<String> R_health = new ArrayList<String>(6);
    final ArrayList<String> dict = new ArrayList<String>();
    final ArrayList<String> dict1 = new ArrayList<String>();
    private int p,q;
    private HelloWorld world;
    private Timer timer;
    private int second;

    ArrayList<Bullets> bullets ;
    private Button firebutton1,firebutton2;


    public PlayScreen(final MyGdxGame game,int i,int j) {
        this.game = game;
        if(i<0){this.p=8+i;}else{this.p=i;}
        if(j<0){this.q=8+j;}else{this.q=j;}

        bullets = new ArrayList<Bullets>();
        map = new TmxMapLoader().load("Maps/fb1.tmx");
        pam = new OrthogonalTiledMapRenderer(map);
        camera = new OrthographicCamera();
        vs = new Texture("lifelogos/VS.png");
        l_logo = new Texture("lifelogos/playerlogo.png");
        r_logo = new Texture("lifelogos/playerlogo.png");

        L_health.add(0,"lifelogos/lifelogo.png");
        L_health.add(1,"lifelogos/lifelogo1.png");
        L_health.add(2,"lifelogos/lifelogo2.png");
        L_health.add(3,"lifelogos/lifelog03.png");
        L_health.add(4,"lifelogos/lifelogo4.png");
        L_health.add(5,"lifelogos/lifelogo5.png");

        R_health.add(0,"lifelogos/lifelogo.png");
        R_health.add(1,"lifelogos/lifelogo2.1.png");
        R_health.add(2,"lifelogos/lifelogo2.2.png");
        R_health.add(3,"lifelogos/lifelogo2.3.png");
        R_health.add(4,"lifelogos/lifelogo2.4.png");
        R_health.add(5,"lifelogos/lifelogo5.png");

        l_health = new Texture(L_health.get(5));
        r_health = new Texture(R_health.get(5));
        dict.add(0, "tank/Abrams.png"); //800
        dict.add(1, "tank/Frost.png"); //800
        dict.add(2, "tank/Buratino.png"); //750
        dict.add(3, "tank/Coalition.png"); //800
        dict.add(4, "tank/Dubstep_edited_29.png"); //800
        dict.add(5, "tank/Atomic.png");  //800
        dict.add(6, "tank/Mark_I.png"); //800
        dict.add(7, "tank/Pinky_edited.png");  //850

        dict1.add(0, "Rtank/AbramsR.png");
        dict1.add(1, "Rtank/FrostR.png");
        dict1.add(2, "Rtank/BuratinoR.png");
        dict1.add(3, "Rtank/CoalitionR.png");
        dict1.add(4, "Rtank/Dubstep_edited_29R.png");
        dict1.add(5, "Rtank/AtomicR.png");
        dict1.add(6, "Rtank/Mark_IR.png");
        dict1.add(7, "Rtank/Pinky_editedR.png");


    }

    @Override
    public void show() {
        playerl = new PlayerL(new Sprite(new Texture(dict.get(p))));
        playerl.setSize(50,50);
        playerl.setPosition(120,308);
        playerR = new PlayerR(new Sprite(new Texture(dict1.get(q))));
        playerR.setSize(50,50);
        playerR.setPosition(1550,308);
    }


    public void updatePosition(float dl){
    }

    @Override
    public void render(float delta) {
        updatePosition(delta);
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_STENCIL_VALUE_MASK);

        camera.setToOrtho(false,1760,1100);
        camera.update();
        pam.setView(camera);
        pam.render();

        if(Gdx.input.isKeyJustPressed(Input.Keys.W)){
            bullets.add(new Bullets(this.game,playerl.getX(), playerl.getY()-140));
        }
        else if(Gdx.input.isKeyJustPressed(Input.Keys.I)){
            bullets.add(new Bullets(this.game,playerR.getX(), playerR.getY()-140));}

        ArrayList<Bullets> bullettoremovee = new ArrayList<Bullets>();
        for(Bullets bullet : bullets){
            bullet.update(delta);
            if(bullet.remove){
                bullettoremovee.remove(bullet);}}
        bullets.removeAll((bullettoremovee));

        pam.getBatch().begin();
        pam.getBatch().draw(this.vs,840,960,100,100);
        pam.getBatch().draw(this.l_health,500,980,300,70);
        pam.getBatch().draw(this.l_logo,420,960,100,100);
        pam.getBatch().draw(this.r_health,980,980,300,70);
        pam.getBatch().draw(this.r_logo,1260,960,100,100);
        playerl.draw(pam.getBatch());
        playerR.draw(pam.getBatch());

        for(Bullets bullet : bullets){
            bullet.render (game.batch);}

        Gdx.input.setInputProcessor(playerl);
        Gdx.input.setInputProcessor(playerR);
        pam.getBatch().end();


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
    public void dispose() {
        pam.dispose();
        playerl.getTexture().dispose();
        playerR.getTexture().dispose();
    }
}
