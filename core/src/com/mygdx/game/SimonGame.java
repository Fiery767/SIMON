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
		pos = new Vector3(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), 0);
		cam.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
	}
	@Override
	public void render() {
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
		sr.end();
		//logic
		cam.update();
		if(Gdx.input.isTouched()) {
			pos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
			cam.update();
		}
		if(YELLOW.contains(pos.x, pos.y)) {
			yellowFlash();
			pos.set(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), 0);
		    cam.unproject(pos);
        }
		if(BLUE.contains(pos.x, pos.y)) {
			blueFlash();
			cam.unproject(pos);
		}
		if(RED.contains(pos.x, pos.y)) {
			redFlash();
			cam.unproject(pos);
		}
		if(GREEN.contains(pos.x, pos.y)) {
			greenFlash();
			cam.unproject(pos);
		}
	}
	@Override
	public void dispose() {
        sr.dispose();
	}

	//flashes
	private void yellowFlash() {
		Gdx.gl.glClearColor(1, 1, 0, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		sr.begin(ShapeRenderer.ShapeType.Filled);
		sr.setColor(Color.GOLD);
		sr.rect(0, 0,Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2);
		sr.end();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		Gdx.gl.glClearColor(1, 1, 0, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		sr.begin(ShapeRenderer.ShapeType.Filled);
		sr.setColor(Color.YELLOW);
		sr.rect(0, 0,Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2);
		sr.end();
	}
	private void blueFlash() {
		sr.begin(ShapeRenderer.ShapeType.Filled);
		sr.setColor(Color.TEAL);
		sr.rect(Gdx.graphics.getWidth() / 2, 0, Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2);
		sr.end();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		sr.begin(ShapeRenderer.ShapeType.Filled);
		sr.setColor(Color.BLUE);
		sr.rect(Gdx.graphics.getWidth() / 2, 0, Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2);
		sr.end();
	}
	private void redFlash() {
		sr.begin(ShapeRenderer.ShapeType.Filled);
		sr.setColor(Color.PINK);
		sr.rect(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2, Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2);
		sr.end();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		sr.begin(ShapeRenderer.ShapeType.Filled);
		sr.setColor(Color.RED);
		sr.rect(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2, Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2);
		sr.end();
	}
	private void greenFlash() {
		sr.begin(ShapeRenderer.ShapeType.Filled);
		sr.setColor(Color.LIME);
		sr.rect(0, Gdx.graphics.getHeight() / 2, Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2);
		sr.end();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		sr.begin(ShapeRenderer.ShapeType.Filled);
		sr.setColor(Color.GREEN);
		sr.rect(0, Gdx.graphics.getHeight() / 2, Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2);
		sr.end();
	}
}
