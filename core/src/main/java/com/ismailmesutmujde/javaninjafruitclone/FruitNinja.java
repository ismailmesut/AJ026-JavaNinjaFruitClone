package com.ismailmesutmujde.javaninjafruitclone;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.utils.TimeUtils;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class FruitNinja extends ApplicationAdapter implements InputProcessor {

    SpriteBatch batch;
    Texture background;
    Texture apple;
    Texture bill;
    Texture cherry;
    Texture ruby;
    BitmapFont font;
    FreeTypeFontGenerator fontGen;

    int lives = 4;
    int score = 0;

    private double currentTime;
    private double gameoverTime = -1.0f;


    @Override
    public void create () {
        batch = new SpriteBatch();
        background = new Texture("ninjabackground.png");
        apple = new Texture("apple.png");
        cherry = new Texture("cherry.png");
        ruby = new Texture("ruby.png");
        bill = new Texture("bill.png");


        Gdx.input.setInputProcessor(this);

        fontGen = new FreeTypeFontGenerator(Gdx.files.internal("robotobold.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter params = new FreeTypeFontGenerator.FreeTypeFontParameter();
        params.color = Color.WHITE;
        params.size = 40;
        params.characters = "0123456789 ScreCutoplay:.+-";
        font = fontGen.generateFont(params);
    }

    @Override
    public void render () {
        batch.begin();
        batch.draw(background,0,0, Gdx.graphics.getWidth(),Gdx.graphics.getHeight());

        double newTime = TimeUtils.millis()/1000.0;
        System.out.println("newTime : " + newTime);

        double frameTime = Math.min(newTime -currentTime, 0.3);
        System.out.println("frameTime : " + frameTime);

        float deltaTime = (float) frameTime;
        System.out.println("deltaTime : " + deltaTime);

        currentTime = newTime;

        if (lives <= 0 && gameoverTime ==0f) {
            // game over
            gameoverTime = currentTime;
        }
        if (lives > 0) {
            // game mode
            for (int i = 0; i < lives; i++) {
                batch.draw(apple,i*30f+20f, Gdx.graphics.getHeight()-25f,25f,25f);
            }
        }
        font.draw(batch,"Score: 0",30,40);
        font.draw(batch,"Cut to play", Gdx.graphics.getWidth()*0.5f, Gdx.graphics.getHeight()*0.5f);
        batch.end();
    }

    @Override
    public void dispose () {
        batch.dispose();
        font.dispose();
        fontGen.dispose();
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
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
    public boolean touchCancelled(int screenX, int screenY, int pointer, int button) {
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
