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

import java.sql.Time;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class SimonGame extends ApplicationAdapter {
    //Game variables
    private Stage stage;
    boolean waiting;
    ImageButton yellowButton;
    ImageButton blueButton;
    ImageButton redButton;
    ImageButton greenButton;
    TextureRegionDrawable yellow;
    TextureRegionDrawable yBright;
    TextureRegionDrawable blue;
    TextureRegionDrawable bBright;
    TextureRegionDrawable red;
    TextureRegionDrawable rBright;
    TextureRegionDrawable green;
    TextureRegionDrawable gBright;
    ArrayList<Integer> sequence;
    Integer clicked;
    Integer step;

    @Override
    /**
     * Create method provided by libGDX library. Executes once, at startup, to initialize the game state.
     * @author Melody Wang
     * @param none
     * @return void
     */
    public void create() {
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);
        waiting = false;
        //Yellow Button
        Skin ySkin = new Skin(Gdx.files.internal("skin/clean-crispy-ui.json"));
        yellowButton = new ImageButton(ySkin);
        yellowButton.setSize(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2);
        yellow = new TextureRegionDrawable(new Texture(Gdx.files.internal("yellow.jpg")));
        yBright = new TextureRegionDrawable(new Texture(Gdx.files.internal("yellowflash.png")));
        yellowButton.getStyle().imageUp = yellow;
        yellowButton.getStyle().imageDown = yBright;
        yellowButton.setPosition(0, 0);
        yellowButton.addListener(new ClickListener());
        stage.addActor(yellowButton);
        //Blue Button
        Skin bSkin = new Skin(Gdx.files.internal("skin/clean-crispy-ui.json"));
        blueButton = new ImageButton(bSkin);
        blueButton.setSize(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2);
        blue = new TextureRegionDrawable(new Texture(Gdx.files.internal("blue.jpg")));
        bBright = new TextureRegionDrawable(new Texture(Gdx.files.internal("blueflash.png")));
        blueButton.getStyle().imageUp = blue;
        blueButton.getStyle().imageDown = bBright;
        blueButton.setPosition(Gdx.graphics.getWidth() / 2, 0);
        blueButton.addListener(new ClickListener());
        stage.addActor(blueButton);
        //Red Button
        Skin rSkin = new Skin(Gdx.files.internal("skin/clean-crispy-ui.json"));
        redButton = new ImageButton(rSkin);
        redButton.setSize(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2);
        red = new TextureRegionDrawable(new Texture(Gdx.files.internal("red.jpg")));
        rBright = new TextureRegionDrawable(new Texture(Gdx.files.internal("redflash.jpg")));
        redButton.getStyle().imageUp = red;
        redButton.getStyle().imageDown = rBright;
        redButton.setPosition(0, Gdx.graphics.getHeight() / 2);
        redButton.addListener(new ClickListener());
        stage.addActor(redButton);
        //Green Button
        Skin gSkin = new Skin(Gdx.files.internal("skin/clean-crispy-ui.json"));
        greenButton = new ImageButton(gSkin);
        greenButton.setSize(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2);
        green = new TextureRegionDrawable(new Texture(Gdx.files.internal("green.png")));
        gBright = new TextureRegionDrawable(new Texture(Gdx.files.internal("greenflash.png")));
        greenButton.getStyle().imageUp = green;
        greenButton.getStyle().imageDown = gBright;
        greenButton.setPosition(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2);
        greenButton.addListener(new ClickListener());
        stage.addActor(greenButton);

        //game intro
        System.out.println("Welcome to SIMON!");
        System.out.println("Press any button to begin.");
        //game loop variables
        sequence = new ArrayList<Integer>();
        step = 0;
        clicked = 0;
    }

    @Override
    /**
     * Render method provided by libGDX library: constantly executing to render changes in the game,
     * draw new frames, etc.
     * @author Melody Wang
     * @param none
     * @return void
     */
    public void render() {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act();
        stage.draw();
        //loop to play the pattern by calling flash methods
        if (!waiting) {
            sequence.add((int) (Math.random() * 4) + 1);
            System.out.println("First button: " + sequence.get(0));
            for (Integer flash : sequence) {
                if (flash == 1) {
                    try {
                        yellowFlash();
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        System.out.println("error");
                    }
                } else if (flash == 2) {
                    try {
                        blueFlash();
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        System.out.println("error");
                    }
                } else if (flash == 3) {
                    try {
                        redFlash();
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        System.out.println("error");
                    }
                } else if (flash == 4) {
                    try {
                        greenFlash();
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        System.out.println("error");
                    }
                } else {
                    System.out.println("Error");
                }
            }
            waiting = true;
            //line to help with debug
            System.out.println("Waiting");
            clicked = 0;
        }
        //loop to get user input and check that the player has pressed the correct buttons
        //known bug: doesn't wait for user input, just runs through the loop
        //UNKNOWN how to fix
        else if (waiting) {
            if (yellowButton.isPressed()) {
                yellowFlash();
                clicked = 1;
            } else if (blueButton.isPressed()) {
                blueFlash();
                clicked = 2;
            } else if (redButton.isPressed()) {
                redFlash();
                clicked = 3;
            } else if (greenButton.isPressed()) {
                greenFlash();
                clicked = 4;
            }
            if (clicked == sequence.get(step)) {
                step += 1;
                if (step == sequence.size()) {
                    waiting = false;
                }
            } else {
                System.out.println("Game over!");
                waiting = false;
            }
            //deprecated code: original attempt at checking for correct user input
            /*for (Integer flash : sequence) {
                if (yellowButton.isPressed()) {
                    clicked = 1;
                }
                else if (blueButton.isPressed()) {
                    clicked = 2;
                }
                else if (redButton.isPressed()) {
                    clicked = 3;
                } else if (greenButton.isPressed()) {
                    clicked = 4;
                }
                if (clicked != flash) {
                    System.out.println("Game over!");
                    waiting = false;
                    stage.clear();
                }
            }
            waiting = false;
        }*/
        }
    }

    /**
     * Method to change the colour of the yellow button, giving the appearance that it has "flashed".
     *
     * @param none
     * @return void
     * @author Melody Wang
     */
    private void yellowFlash() {
        try {
            yellowButton.remove();
            yellowButton.getStyle().imageUp = yBright;
            yellowButton.setStyle(yellowButton.getStyle());
            stage.addActor(yellowButton);
            System.out.println("entering sleep");
            TimeUnit.SECONDS.sleep(1);
            System.out.println("exiting sleep");
            yellowButton.remove();
            yellowButton.getStyle().imageUp = yellow;
            yellowButton.setStyle(yellowButton.getStyle());
            stage.addActor(yellowButton);
        } catch (InterruptedException e) {
            System.out.println("error");
        }
    }

    /**
     * Method to change the colour of the blue button, giving the appearance that it has "flashed".
     *
     * @param none
     * @return void
     * @author Melody Wang
     */
    private void blueFlash() {
        try {
            blueButton.remove();
            blueButton.getStyle().imageUp = bBright;
            blueButton.setStyle(blueButton.getStyle());
            System.out.println("entering sleep");
            stage.addActor(blueButton);
            TimeUnit.SECONDS.sleep(1);
            System.out.println("exiting sleep");
            blueButton.remove();
            blueButton.getStyle().imageUp = blue;
            blueButton.setStyle(blueButton.getStyle());
            stage.addActor(blueButton);
        } catch (InterruptedException e) {
            System.out.println("error");
        }
    }

    /**
     * Method to change the colour of the red button, giving the appearance that it has "flashed".
     *
     * @param none
     * @return void
     * @author Melody Wang
     */
    private void redFlash() {
        try {
            redButton.remove();
            redButton.getStyle().imageUp = rBright;
            redButton.setStyle(redButton.getStyle());
            System.out.println("entering sleep");
            stage.addActor(redButton);
            TimeUnit.SECONDS.sleep(1);
            System.out.println("exiting sleep");
            redButton.remove();
            redButton.getStyle().imageUp = red;
            redButton.setStyle(redButton.getStyle());
            stage.addActor(redButton);
        } catch (InterruptedException e) {
            System.out.println("error");
        }
    }

    /**
     * Method to change the colour of the green button, giving the appearance that it has "flashed".
     *
     * @param none
     * @return void
     * @author Melody Wang
     */
    private void greenFlash() {
        try {
            greenButton.remove();
            greenButton.getStyle().imageUp = gBright;
            greenButton.setStyle(greenButton.getStyle());
            stage.addActor(greenButton);
            System.out.println("entering sleep");
            TimeUnit.SECONDS.sleep(1);
            System.out.println("exiting sleep");
            greenButton.remove();
            greenButton.getStyle().imageUp = green;
            greenButton.setStyle(greenButton.getStyle());
            stage.addActor(greenButton);
        } catch (InterruptedException e) {
            System.out.println("error");
        }
    }
}


