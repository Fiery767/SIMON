package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector3;

public class SimonGame extends ApplicationAdapter {
	private OrthographicCamera cam;
	private ShapeRenderer sr;
	private Vector3 pos;
	public void create() {
		cam = new OrthographicCamera();
		sr = new ShapeRenderer();
		pos = new Vector3(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2, 0);
		cam.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
	}
	public void render() {
		//logic
		cam.update();
		//drawing
	}
	public void dispose() {

	}
}
