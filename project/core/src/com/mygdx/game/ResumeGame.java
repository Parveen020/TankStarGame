package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FillViewport;

public class ResumeGame implements Screen {
    final MyGdxGame game;
    private Texture background,homebutton;
    private TextureRegion backgroundTexture,bbt;
    private TextureRegionDrawable bbtt;
    private ImageButton bt;
    private Sound sound;
    private SpriteBatch batch;
    private OrthographicCamera camera;
    private Stage stage;
    float elapsed;



    public ResumeGame(final MyGdxGame game){
        this.game = game;
        batch = new SpriteBatch();
        camera = new OrthographicCamera();
        stage = new Stage(new FillViewport(1120.0F, 620.0F));
        this.background = new Texture(Gdx.files.internal("background1/resume.png"));
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
