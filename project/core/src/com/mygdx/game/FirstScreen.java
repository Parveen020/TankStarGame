package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.ScreenUtils;

public class FirstScreen implements Screen {
    final MyGdxGame game;
    private Texture background;
    SpriteBatch batch;
    Texture texture;
    float elapsed;
    private TextureRegion backgroundTexture;
    Animation<TextureRegion> animation;
    OrthographicCamera camera;
     int i;
     private Sound sound;

    public FirstScreen(MyGdxGame game){
        this.game = game;
        this.background = new Texture(Gdx.files.internal("background1/background.png"));
        this.backgroundTexture = new TextureRegion(this.background, 0, 0, background.getWidth(), background.getHeight());
        this.camera = new OrthographicCamera();
        this.camera.setToOrtho(false, background.getWidth(), background.getHeight());
        i=0;
        i++;
        batch = new SpriteBatch();
        animation = GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal("Loading/load.gif").read());
    }


    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        elapsed += Gdx.graphics.getDeltaTime();
        ScreenUtils.clear(0.0F, 0.0F, 0.0F, 0.0F);
        this.camera.update();;
        this.game.batch.setProjectionMatrix(this.camera.combined);
        this.game.batch.begin();
        this.game.batch.draw(this.backgroundTexture, 0.0F,0.0F,background.getWidth(),background.getHeight());
        this.game.batch.end();
        batch.begin();
        i++;
        batch.draw(animation.getKeyFrame(elapsed),250,50,1020,10);
        batch.end();
        if(i>300){game.setScreen(new Menu(this.game));}
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
    }
}
