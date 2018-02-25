package com.japa.sheep;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector3;

public class SheepDog extends Animal {

    static Texture texture = new Texture("sheepdog.png");
    int dogginess;

    public SheepDog(Vector3 pos, int dogginess, Camera cam){
        super(cam);
        //temp:
        this.pos = pos;
        this.dogginess = dogginess;
    }
    @Override
    public void tick() {
    }

    public void act(float delta){
    }

    @Override
    public void draw (Batch batch, float parentAlpha) {
        Color color = getColor();
        batch.setColor(color.r, color.g, color.b, color.a * parentAlpha);
        //batch.draw(region, getX(), getY(), getOriginX(), getOriginY(), getWidth(), getHeight(), getScaleX(), getScaleY(), getRotation());
        batch.draw(texture, pos.x - 32, pos.y);
    }

    /**
     * sheepdog chase wolves
     */
    public void chase(){

    }

    @Override
    public Vector3 getPosition() {
        return null;
    }

    //@Override
    public void setPosition() {

    }

    @Override
    public Texture getSkin() {
        return null;
    }

    @Override
    public void setSkin() {

    }
}
