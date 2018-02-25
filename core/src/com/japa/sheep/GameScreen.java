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
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import java.util.ArrayList;

public class GameScreen implements Screen, InputProcessor {
    private OrthographicCamera camera;
    private OrthographicCamera scrollingCamera;
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

    World world;

    private ArrayList<Entity> entities;
    private ArrayList<Animal> herd;

    SheepDog doggo;

    public GameScreen() {
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 256, 512);

        viewport = new FitViewport(256, 512, camera);
        shapeRenderer = new ShapeRenderer();
        batch = new SpriteBatch();

        //2nd camera for scrolling
        //scrollingCamera =new OrthographicCamera(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        scrollingCamera =new OrthographicCamera(256,512);
        scrollingCamera.translate(Gdx.graphics.getWidth()/2,Gdx.graphics.getHeight()/2);
        scrollingCamera.update();

        //map stuff
        map = new TmxMapLoader().load("mapperoni.tmx");
        tileLayer = (TiledMapTileLayer) map.getLayers().get(0);
        mapRenderer = new OrthogonalTiledMapRenderer(map, 1f);


        //box2d stuff
        world = new World(new Vector2(0, -98f), true);

        //stage stuff
        stage = new Stage(viewport);
        //make doggo and add to the list of entities
        entities = new ArrayList<Entity>();
        herd = new ArrayList<Animal>();
        doggo = new SheepDog(new Vector3(100,20,0),12);
        entities.add(doggo);
        //put the doggo on the stage to perform his wonderful acts
        stage.addActor(doggo);

        //creates a sheep
        Sheep bob = new Sheep(new Vector3(150,150,0));
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

        /*
        this.renderer.setView(scrollingCamera);
        this.renderer.render(); // Render tiles
        this.scrollingCamera.translate(SCROLLING_SPEED.X, SCROLLING_SPEED.Y);
        this.scrollingCamera.update();

        this.renderer.setView(camera);
        // Render other stuff
        camera.update();
        */
        mapRenderer.setView(scrollingCamera);
        mapRenderer.render();
        float dy = 30f*delta;
        scrollingCamera.translate(0,dy);
        scrollingCamera.update();

        shapeRenderer.setProjectionMatrix(camera.combined);
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.ellipse(rect.x, rect.y, 10, 10);
        shapeRenderer.end();


        //camera.translate(0,dy);
        //doggo.translate(0,dy);

        //for(Animal a : herd){
           //a.translate(0,dy);
        //}

        //check if u at the top and need to cycle back around

        /*
        if(camera.position.y > 300) {
            camera.position.y = 256;
            System.out.println(camera.position.y);
            camera.position.x += 128;

            doggo.pos.y = 20;//doggo.getRelativePos().y;
            System.out.println("DOG" + doggo.getRelativePos().y + "dogCamRef=" + doggo.cam.position.y);
            System.out.println(doggo.getX() + "pre=" + doggo.pos.x);
            doggo.pos.x += 128;
            System.out.println(doggo.getX() + "=" + doggo.pos.x);
        }
        */

        //should make everything act
        stage.act();
        stage.draw();

        camera.update();
    }

    @Override
    public void resize(int width, int height) {
        camera.update();
        viewport.update(width, height, false);
    }

    public void checkCollisions(){
        for(Entity e : entities){

        }
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
        Vector3 mousePos = new Vector3(screenX, screenY,0);
        //Vector3 center = new Vector3(viewport.getScreenX()/2, viewport.getScreenY()/2,0);
        viewport.unproject(mousePos);

        if (mousePos.x>0 && mousePos.x<256){
            doggo.pos.x =mousePos.x;
        }
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        Vector3 mousePos = new Vector3(screenX, screenY,0);
        //Vector3 center = new Vector3(viewport.getScreenX()/2, viewport.getScreenY()/2,0);

        viewport.unproject(mousePos);

        if (mousePos.x>0 && mousePos.x<256){
            doggo.pos.x =mousePos.x;
        }

        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        //camera.zoom += (float)amount/10f;
        return false;
    }
}
