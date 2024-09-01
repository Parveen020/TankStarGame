package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import static jdk.jfr.internal.consumer.EventLog.update;

public class PlayerL extends Sprite implements InputProcessor {

    private final Vector2 velocity = new Vector2();
    Sound sound;
    private float speed = 1000 * 2, gravity = 60 * 1.8f;

    public PlayerL(Sprite sprite) {
        super(sprite);
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
            case Input.Keys.D:
                float old_x = getX(), old_y = getY();
                velocity.x =-speed;
                setPosition(old_x+2 , old_y);
                break;
            case Input.Keys.A:
                float old_X = getX(), old_Y = getY();
                velocity.x = +speed;
                setPosition(old_X-2,old_Y);
                break;
        }
        return true;
    }

    @Override
    public boolean keyUp(int keycode) {
        switch (keycode){
            case Input.Keys.A:
            case Input.Keys.D:
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