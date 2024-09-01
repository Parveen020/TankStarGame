package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.zip.Deflater;

public class Bullets {
    private final MyGdxGame game;
    private Sound sound;
    private static final int speed =500;
    private static Texture bullettexture;

    float x,y;
    public boolean remove = false;

    public Bullets(final MyGdxGame game,float x,float y) {
        this.game = game;
        this.x = x;
        this.y = y;

        if (bullettexture == null && this.x<840) {
            bullettexture = new Texture("tankgun/bullet.png");}
        else if (bullettexture == null && this.x>840) {
            bullettexture = new Texture("tankgun/bullet1.png");}

    }

    public void update(float deltaTime){
        if(this.x<840){
            x += speed*deltaTime;
            if(x< Gdx.graphics.getWidth()){
                remove=true;}}
        else if(this.x>840){
            x -= speed*deltaTime;
            if(x< Gdx.graphics.getWidth()){
                remove=true;}}
    }

    public void render(SpriteBatch batch){
        batch.begin();
        batch.draw(bullettexture,x,y);
        batch.end();
    }

}
