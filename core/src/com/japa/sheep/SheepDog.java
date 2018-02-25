package com.japa.sheep;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;

public class SheepDog extends Animal {

    static Texture texture = new Texture("sheepdog.png");
    int dogginess;

    public SheepDog(Position pos, int dogginess){
        //skin = texture;
        //temp:
        this.pos = pos;
        skin = new Texture("sheepdog.png");
        this.dogginess = dogginess;
    }
    @Override
    public void tick() {
        System.out.println("ticc?");
    }

    public void act(float delta){
        System.out.println("hea?");
    }

    @Override
    public void draw (Batch batch, float parentAlpha) {
        Color color = getColor();
        batch.setColor(color.r, color.g, color.b, color.a * parentAlpha);
        //batch.draw(region, getX(), getY(), getOriginX(), getOriginY(), getWidth(), getHeight(), getScaleX(), getScaleY(), getRotation());
        batch.draw(skin, pos.getx(), pos.gety());
    }

    /**
     * sheepdog chase wolves
     */
    public void chase(){

    }

    @Override
    public Position getPosition() {
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
