package com.japa.sheep;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.MapRenderer;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapImageLayer;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Array;
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

    //map stuff
    private OrthogonalTiledMapRenderer mapRenderer;
    private TiledMapImageLayer imageLayer;
    private TiledMapTileLayer tileLayer;
    private TiledMap map;

    //beautiful stage
    private Stage stage;

    private ArrayList<Entity> entities;
    private ArrayList<Animal> herd;

    SheepDog doggo;

    public GameScreen() {
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 400);

        viewport = new FitViewport(800, 400, camera);
        shapeRenderer = new ShapeRenderer();
        batch = new SpriteBatch();

        //map stuff
        map = new TmxMapLoader().load("mapperoni.tmx");
        tileLayer = (TiledMapTileLayer) map.getLayers().get(0);
        mapRenderer = new OrthogonalTiledMapRenderer(map, 1f);

        //stage stuff
        stage = new Stage(viewport);
        //make doggo and add to the list of entities
        entities = new ArrayList<Entity>();
        herd = new ArrayList<Animal>();
        doggo = new SheepDog(new Position(100,100),12);
        entities.add(doggo);
        //put the doggo on the stage to perform his wonderful acts
        stage.addActor(doggo);

        //creates a sheep
        Sheep bob = new Sheep(new Position(150,150));
        entities.add(bob);
        stage.addActor(bob);
        //throw him in the herd as well
        herd.add(bob);

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
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


        shapeRenderer.setProjectionMatrix(camera.combined);
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.ellipse(rect.x, rect.y, 10, 10);
        shapeRenderer.end();

        mapRenderer.setView(camera);
        mapRenderer.render();

        float dy = 100f*delta;
        camera.translate(0,dy);
        doggo.translate(0,dy);
        for(Animal a : herd){
            a.translate(0,dy);
        }

        //should make everything act
        stage.act();
        stage.draw();

        camera.update();
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);
    }

    @Override
    public void pause() {
        System.out.println("PAUSED");
    }

    @Override
    public void resume() {
        System.out.println("RESUMING");
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
        switch(character){
        case ' ':
            System.out.println(character);
            pause();
            break;
        default:
            System.out.println(character);
            break;

        }
        return false;

    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) { return false;}

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        rect.x = screenX;
        rect.y = screenY;
        //camera.position.x = screenX;
        //camera.position.y = screenY;
        //camera.update();
        System.out.println(screenX+", "+screenY);
        doggo.setX(screenX);

        //entities.get(0).setPosition(screenX, screenY);
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        rect.x = screenX;
        rect.y = screenY;
        //camera.position.x = screenX;
        //camera.position.y = screenY;
        //Vector3 mousePos = new Vector3(screenX, screenY,0);
        //Vector3 center = new Vector3(viewport.getScreenX()/2, viewport.getScreenY()/2,0);
        //camera.unproject(mousePos);
        //entities.get(0).setPosition(mousePos.x, mousePos.y);
        //camera.translate(mousePos.sub(center).scl(0.4f));
        ////camera.translate(screenX-(viewport.getScreenWidth()/2), screenY-(viewport.getScreenHeight()/2));
        ////camera.update();
        ////entities.get(0).setPosition(screenX, screenY);
        return false;
    }

    @Override
    public boolean scrolled(int amount) {

        camera.zoom += (float)amount/10f;
        return false;
    }
}
