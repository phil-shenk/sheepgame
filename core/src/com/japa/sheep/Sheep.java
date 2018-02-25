package com.japa.sheep;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;


public class Sheep extends Animal{

    static Texture texture = new Texture("sheep.png");

    float sheepCounter;

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
        sheepCounter+=6*delta*Math.random();
        wander();
    }
    public void flee(){

    }
    public void wander(){
        setPosition(((float)(pos.getx()+2.5*(Math.sin(2.1*sheepCounter)+.25*Math.sin(6*sheepCounter))*Math.cos(sheepCounter))), ((float)(pos.gety()+3*(Math.sin(2.1*sheepCounter)+.25*Math.sin(6*sheepCounter))*Math.sin(sheepCounter))));
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
