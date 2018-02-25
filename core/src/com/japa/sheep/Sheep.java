package com.japa.sheep;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;


public class Sheep extends Animal{

    static Texture texture = new Texture("sheep.png");

    public Sheep(Position pos){
        this.pos = pos;
    }

    public Sheep(float newx, float newy){
        this.pos = new Position(newx,newy);
    }

    @Override
    public void tick() {

    }

    public void act(float delta) {
        System.out.println("Bahahaha!");
        //uyguyv
    }
    public void flee(){

    }
    public void wander(){

    }
    public void die(){

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

    @Override
    public void draw (Batch batch, float parentAlpha) {
        Color color = getColor();
        batch.setColor(color.r, color.g, color.b, color.a * parentAlpha);
        //batch.draw(region, getX(), getY(), getOriginX(), getOriginY(), getWidth(), getHeight(), getScaleX(), getScaleY(), getRotation());
        batch.draw(texture, pos.getx(), pos.gety());
    }
}
