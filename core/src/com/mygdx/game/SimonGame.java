package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

public class SimonGame extends ApplicationAdapter {
	private OrthographicCamera cam;
	private ShapeRenderer sr;
	private Vector3 pos;
	private Rectangle YELLOW;
	private Rectangle BLUE;
	private Rectangle RED;
	private Rectangle GREEN;

	@Override
	public void create() {
		cam = new OrthographicCamera();
		sr = new ShapeRenderer();
		pos = new Vector3(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2, 0);
		cam.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
	}
	@Override
	public void render() {
		//logic
		cam.update();
		if(YELLOW.contains(pos.x, pos.y)) {

		    cam.unproject(pos);
        }
		//drawing
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear((GL20.GL_COLOR_BUFFER_BIT));
        sr.begin(ShapeRenderer.ShapeType.Filled);
        sr.setColor(Color.YELLOW);
        sr.rect(0, 0,Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2);
        YELLOW = new Rectangle(0, 0, Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2);
        sr.setColor(Color.BLUE);
        sr.rect(Gdx.graphics.getWidth() / 2, 0, Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2);
		BLUE = new Rectangle(Gdx.graphics.getWidth() / 2, 0, Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2);
        sr.setColor(Color.RED);
        sr.rect(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2, Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2);
		RED = new Rectangle(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2, Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2);
        sr.setColor(Color.GREEN);
        sr.rect(0, Gdx.graphics.getHeight() / 2, Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2);
		GREEN = new Rectangle(0, Gdx.graphics.getHeight() / 2, Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2);
        //flashes
		private void yellowFlash() {
			sr.setColor(Color.)
		}
		sr.end();

	}
	@Override
	public void dispose() {
        sr.dispose();
	}
}
