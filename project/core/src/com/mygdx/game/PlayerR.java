package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMapImageLayer;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.Vector2;

public class PlayerR extends Sprite implements InputProcessor{
    private Vector2 velocity = new Vector2();
    private Sound sound;
    private float speed = 1000*2, gravity = 60*1.8f;
    Boolean collisionY;
    private TiledMapTileLayer collisionLayer;

    public PlayerR(Sprite sprite) {
        super(sprite);
//        this.collisionLayer = collisionLayer;
    }

    public void draw(Batch spriteBatch) {
        update(Gdx.graphics.getDeltaTime());
        super.draw(spriteBatch);
    }

    private void update(float deltaTime) {
        velocity.x = gravity * deltaTime;
    }

    @Override
    public boolean keyDown(int keycode) {
        switch (keycode){
            case Input.Keys.L:
                float oldx = getX(), oldy = getY();
                velocity.x =-speed;
                setPosition(oldx+2 , oldy);
                break;
            case Input.Keys.J:
                float oldX = getX(), oldY = getY();
                velocity.x = +speed;
                setPosition(oldX-2,oldY);
                break;
        }
        return true;

    }

    @Override
    public boolean keyUp(int keycode) {
        switch (keycode){
            case Input.Keys.L:
            case Input.Keys.J:
                velocity.x=0;
        }
        return true;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(float amountX, float amountY) {
        return false;
    }
}
