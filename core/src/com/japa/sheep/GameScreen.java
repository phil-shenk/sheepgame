package com.japa.sheep;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import java.util.ArrayList;

public class GameScreen implements Screen, InputProcessor {
    private OrthographicCamera camera;
    private SpriteBatch batch;
    private ShapeRenderer shapeRenderer;
    private Rectangle rect;
    private FitViewport viewport;

    private Stage stage;

    private ArrayList<Entity> entities;

    public GameScreen() {


        camera = new OrthographicCamera();
        camera.setToOrtho(true, 800, 400);
        viewport = new FitViewport(800, 400, camera);
        shapeRenderer = new ShapeRenderer();
        batch = new SpriteBatch();

        //stage stuff
        stage = new Stage(viewport);
        //make doggo and add to the list of entities
        entities = new ArrayList<Entity>();
        SheepDog doggo = new SheepDog(new Position(100,100),12);
        entities.add(doggo);
        Sheep bob = new Sheep(new Position(150,150));
        //put the doggo on the stage to perform his wonderful acts
        stage.addActor(doggo);

        rect = new Rectangle();
        rect.x = 20;
        rect.y = 20;
        rect.width = 100;
        rect.height = 100;
        Gdx.input.setInputProcessor(this);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, (float)(Math.random() * 0.1), 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        camera.update();

        shapeRenderer.setProjectionMatrix(camera.combined);
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.ellipse(rect.x, rect.y, 10, 10);
        shapeRenderer.end();



        //should make everything act
        stage.act();
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        shapeRenderer.dispose();
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
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        rect.x = screenX;
        rect.y = screenY;

        entities.get(0).setPosition(screenX, screenY);
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        rect.x = screenX;
        rect.y = screenY;

        entities.get(0).setPosition(screenX, screenY);
        return false;
    }



    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
