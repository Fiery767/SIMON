package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.DelayAction;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class SimonGame extends ApplicationAdapter {
	private Stage stage;
	boolean waiting;
	ImageButton yellowButton;
	ImageButton blueButton;
	ImageButton redButton;
	ImageButton greenButton;
	ArrayList<Integer> sequence;
	Timer delayTimer;

	@Override
	public void create() {
		stage = new Stage(new ScreenViewport());
		Gdx.input.setInputProcessor(stage);
		waiting = false;
		delayTimer = new Timer();
		delayTimer.start();
		//Yellow Button
		Skin ySkin = new Skin(Gdx.files.internal("skin/clean-crispy-ui.json"));
		yellowButton = new ImageButton(ySkin);
		yellowButton.setSize(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2);
		yellowButton.getStyle().imageUp = new TextureRegionDrawable(new Texture(Gdx.files.internal("yellow.jpg")));
		yellowButton.getStyle().imageDown = new TextureRegionDrawable(new Texture(Gdx.files.internal("yellowflash.png")));
		yellowButton.setPosition(0, 0);
		yellowButton.addListener(new ClickListener());
		stage.addActor(yellowButton);
		//Blue Button
		Skin bSkin = new Skin(Gdx.files.internal("skin/clean-crispy-ui.json"));
		blueButton = new ImageButton(bSkin);
		blueButton.setSize(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2);
		blueButton.getStyle().imageUp = new TextureRegionDrawable(new Texture(Gdx.files.internal("blue.jpg")));
		blueButton.getStyle().imageDown = new TextureRegionDrawable(new Texture(Gdx.files.internal("blueflash.png")));
		blueButton.setPosition(Gdx.graphics.getWidth() / 2, 0);
		blueButton.addListener(new ClickListener());
		stage.addActor(blueButton);
		//Red Button
		Skin rSkin = new Skin(Gdx.files.internal("skin/clean-crispy-ui.json"));
		redButton = new ImageButton(rSkin);
		redButton.setSize(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2);
		redButton.getStyle().imageUp = new TextureRegionDrawable(new Texture(Gdx.files.internal("red.jpg")));
		redButton.getStyle().imageDown = new TextureRegionDrawable(new Texture(Gdx.files.internal("redflash.jpg")));
		redButton.setPosition(0, Gdx.graphics.getHeight() / 2);
		redButton.addListener(new ClickListener());
		stage.addActor(redButton);
		//Green Button
		Skin gSkin = new Skin(Gdx.files.internal("skin/clean-crispy-ui.json"));
		greenButton = new ImageButton(gSkin);
		greenButton.setSize(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2);
		greenButton.getStyle().imageUp = new TextureRegionDrawable(new Texture(Gdx.files.internal("green.png")));
		greenButton.getStyle().imageDown = new TextureRegionDrawable(new Texture(Gdx.files.internal("greenflash.png")));
		greenButton.setPosition(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2);
		greenButton.addListener(new ClickListener());
		stage.addActor(greenButton);

		//game loop variables
		sequence = new ArrayList<Integer>();
	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stage.act();
		stage.draw();
		if (!waiting) {
			sequence.add((int)(Math.random() * 4) + 1);
			for (Integer flash : sequence) {
				if (flash == 1) {
					yellowFlash();
					try {
						Thread.sleep(1000);
					}
					catch(InterruptedException e) {
						System.out.println("error");
					}
				}
				else if (flash == 2) {
					blueFlash();
					try {
						Thread.sleep(1000);
					}
					catch(InterruptedException e) {
						System.out.println("error");
					}
				}
				else if (flash == 3) {
					redFlash();
					try {
						Thread.sleep(1000);
					}
					catch(InterruptedException e) {
						System.out.println("error");
					}
				}
				else if (flash == 4) {
					greenFlash();
					try {
						Thread.sleep(1000);
					}
					catch(InterruptedException e) {
						System.out.println("error");
					}
				}
				else {
					System.out.println("Error");
				}
				waiting = true;
			}

		}
	}

	private void yellowFlash() {
		yellowButton.getStyle().imageUp = new TextureRegionDrawable(new Texture(Gdx.files.internal("yellowflash.png")));
		delayTimer.delay(1000);
		/*try {
			Thread.sleep(1000);
		}
		catch(InterruptedException e) {
			System.out.println("error");
		}*/
		yellowButton.getStyle().imageUp = new TextureRegionDrawable(new Texture(Gdx.files.internal("yellow.jpg")));
	}
	private void blueFlash() {
		blueButton.getStyle().imageUp = new TextureRegionDrawable(new Texture(Gdx.files.internal("blueflash.png")));
		delayTimer.delay(1000);
		/*try {
			Thread.sleep(1000);
		}
		catch(InterruptedException e) {
			System.out.println("error");
		}*/
		blueButton.getStyle().imageUp = new TextureRegionDrawable(new Texture(Gdx.files.internal("blue.jpg")));
	}
	private void redFlash() {
		redButton.getStyle().imageUp = new TextureRegionDrawable(new Texture(Gdx.files.internal("redflash.jpg")));
		delayTimer.delay(1000);
		/*try {
			Thread.sleep(1000);
		}
		catch(InterruptedException e) {
			System.out.println("error");
		}*/
		redButton.getStyle().imageUp = new TextureRegionDrawable(new Texture(Gdx.files.internal("red.jpg")));
	}
	private void greenFlash() {
		greenButton.getStyle().imageUp = new TextureRegionDrawable(new Texture(Gdx.files.internal("greenflash.png")));
		delayTimer.delay(1000);
		/*try {
			Thread.sleep(1000);
		}
		catch(InterruptedException e) {
			System.out.println("error");
		}*/
		greenButton.getStyle().imageUp = new TextureRegionDrawable(new Texture(Gdx.files.internal("green.png")));
	}
}

