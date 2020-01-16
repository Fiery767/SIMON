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
import com.badlogic.gdx.scenes.scene2d.ui.Button;

import java.util.concurrent.TimeUnit;

public class SimonGame extends ApplicationAdapter {
	private OrthographicCamera cam;
	private ShapeRenderer sr;
	private Vector3 pos;
	private Rectangle YELLOW;
	private Rectangle BLUE;
	private Rectangle RED;
	private Rectangle GREEN;
	private Button YellowButton;

	@Override
	public void create() {
		cam = new OrthographicCamera();
		sr = new ShapeRenderer();
		pos = new Vector3(0, 0, 0);
		cam.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		YELLOW = new Rectangle(0, 0,Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2);
		YellowButton = new Button();
		BLUE = new Rectangle(Gdx.graphics.getWidth() / 2, 0, Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2);
		RED = new Rectangle(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2, Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2);
		GREEN = new Rectangle(0, Gdx.graphics.getHeight() / 2, Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2);
		reset();
	}
	@Override
	public void render() {
		//drawing

		//logic
		if(Gdx.input.isTouched()) {
			pos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
			cam.update();
		}
		if(pos.x <= (Gdx.graphics.getWidth() / 2) && pos.y <= (Gdx.graphics.getHeight() / 2)) {
			if(Gdx.input.isTouched()) {
				yellowFlash();
				cam.update();
			}
		}
		/*
		if(YELLOW.contains(pos.x, pos.y)) {
			yellowFlash();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException ex) {

				Thread.currentThread().interrupt();
			}
			pos.set(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), 0);
		    cam.unproject(pos);
		    reset();
        }
        */
		if(BLUE.contains(pos.x, pos.y)) {
			blueFlash();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException ex) {

				Thread.currentThread().interrupt();
			}
			pos.set(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), 0);
			cam.unproject(pos);
			reset();
		}
		if(RED.contains(pos.x, pos.y)) {
			redFlash();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException ex) {

				Thread.currentThread().interrupt();
			}
			pos.set(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), 0);
			cam.unproject(pos);
			reset();
		}
		if(GREEN.contains(pos.x, pos.y)) {
			greenFlash();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException ex) {

				Thread.currentThread().interrupt();
			}
			pos.set(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), 0);
			cam.unproject(pos);
			reset();
		}
		cam.update();
	}
	@Override
	public void dispose() {
        sr.dispose();
	}
	//initial setup
	private void reset() {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear((GL20.GL_COLOR_BUFFER_BIT));
		sr.begin(ShapeRenderer.ShapeType.Filled);
		sr.setColor(Color.YELLOW);
		sr.rect(0, 0,Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2);
		sr.setColor(Color.BLUE);
		sr.rect(Gdx.graphics.getWidth() / 2, 0, Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2);
		sr.setColor(Color.RED);
		sr.rect(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2, Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2);
		sr.setColor(Color.GREEN);
		sr.rect(0, Gdx.graphics.getHeight() / 2, Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2);
		sr.end();
	}
	//flashes
	private void yellowFlash() {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		sr.begin(ShapeRenderer.ShapeType.Filled);
		sr.setColor(Color.GOLD);
		sr.rect(0, 0,Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2);
		sr.end();
		cam.update();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException ex) {

			Thread.currentThread().interrupt();
		}
		reset();
	}
	private void blueFlash() {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		sr.begin(ShapeRenderer.ShapeType.Filled);
		sr.setColor(Color.TEAL);
		sr.rect(Gdx.graphics.getWidth() / 2, 0, Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2);
		sr.end();
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		sr.begin(ShapeRenderer.ShapeType.Filled);
		sr.setColor(Color.BLUE);
		sr.rect(Gdx.graphics.getWidth() / 2, 0, Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2);
		sr.end();
	}
	private void redFlash() {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		sr.begin(ShapeRenderer.ShapeType.Filled);
		sr.setColor(Color.PINK);
		sr.rect(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2, Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2);
		sr.end();
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		sr.begin(ShapeRenderer.ShapeType.Filled);
		sr.setColor(Color.RED);
		sr.rect(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2, Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2);
		sr.end();
	}
	private void greenFlash() {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		sr.begin(ShapeRenderer.ShapeType.Filled);
		sr.setColor(Color.LIME);
		sr.rect(0, Gdx.graphics.getHeight() / 2, Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2);
		sr.end();
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		sr.begin(ShapeRenderer.ShapeType.Filled);
		sr.setColor(Color.GREEN);
		sr.rect(0, Gdx.graphics.getHeight() / 2, Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2);
		sr.end();
	}
}
