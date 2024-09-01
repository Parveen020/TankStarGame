package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FillViewport;

public class Menu implements Screen {
    final MyGdxGame game;
    private Texture background;
    private SpriteBatch batch;
    Texture texture;
    private float elapsed;
    private Stage stage;
    private TextureRegion backgroundTexture,button1region, button2region, button3region;
    private Animation<TextureRegion> animation;
    private OrthographicCamera camera;
    private Skin skin;
    int i;
    private Sound sound ;
    public Menu(final MyGdxGame game){
        this.game = game;
        batch = new SpriteBatch();
        stage = new Stage(new FillViewport(1100.0F, 620.0F));
        this.background = new Texture(Gdx.files.internal("background1/blue.jpg"));
        this.backgroundTexture = new TextureRegion(this.background, 0, 0, background.getWidth(), background.getHeight());
        this.camera = new OrthographicCamera();
        this.camera.setToOrtho(false, background.getWidth(), background.getHeight());
        animation = GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal("background1/tnk1.gif").read());
        sound = Gdx.audio.newSound(Gdx.files.internal("Music/song.mp3"));
        sound.play();

        skin = new Skin(Gdx.files.internal("skin/glassy-ui.json"));
        Gdx.input.setInputProcessor(stage);
        Skin mySkin = new Skin(Gdx.files.internal("skin/glassy-ui.json"));
        Button button1 = new TextButton("New Game",mySkin,"small");
        button1.setSize(220,80);
        button1.setPosition(840,400);
        button1.addListener(new ClickListener(){
            public void clicked(InputEvent event,float x, float y){
                sound =Gdx.audio.newSound(Gdx.files.internal("Music/button_toggle.mp3"));
                sound.play();
                game.setScreen(new TankSelect(game));}});
        stage.addActor(button1);

        Button button2=new TextButton("Resume Game",mySkin,"small");
        button2.setSize(220,80);
        button2.setPosition(840,253);
        button2.addListener(new ClickListener(){
            public void clicked(InputEvent event,float x, float y){
                sound =Gdx.audio.newSound(Gdx.files.internal("Music/button_toggle.mp3"));
                sound.play();
                game.setScreen(new ResumeGame(game));}});
        stage.addActor(button2);

        Button button3=new TextButton("Exit",mySkin,"small");
        button3.setSize(220,80);
        button3.setPosition(840,112);
        button3.addListener(new ClickListener(){
            public void clicked(InputEvent event,float x, float y){
                sound =Gdx.audio.newSound(Gdx.files.internal("Music/button_toggle.mp3"));
                sound.play();Gdx.app.exit();}});
        stage.addActor(button3);

        // Text Button
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        elapsed += Gdx.graphics.getDeltaTime();
        ScreenUtils.clear(0.0F, 0.0F, 0.0F, 1.0F);
        this.camera.update();
        this.game.batch.setProjectionMatrix(this.camera.combined);
        this.game.batch.begin();
        this.game.batch.draw(this.backgroundTexture, 0.0F, 0.0F, background.getWidth(), background.getHeight());
        this.game.batch.end();
        stage.act();
        stage.draw();
        batch.begin();
        batch.draw(animation.getKeyFrame(elapsed),0,0,1100,830);
        batch.end();
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
        batch.dispose();
        stage.dispose();
//        button1.dispose();

    }
}
