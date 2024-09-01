package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class MyGdxGame extends Game {
	public SpriteBatch batch;
	public BitmapFont font;
	private Viewport screenPort;
	private Sound sound;



	public MyGdxGame(){
	}

	@Override
	public void create() {
		this.batch = new SpriteBatch();
		this.font = new BitmapFont();
		this.screenPort = new ScreenViewport();
		this.setScreen(new FirstScreen(this));
	}

	@Override
	public void render() {
		super.render();
	}

	@Override
	public void dispose() {
		this.batch.dispose();
		this.font.dispose();
	}
}
