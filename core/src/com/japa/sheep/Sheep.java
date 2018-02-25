package com.japa.sheep;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;


public class Sheep extends Animal{

    static Texture texture = new Texture("sheep.png");
    private boolean fleeing;
    float sheepCounter;
    private boolean returning;
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
        sheepCounter += delta;
        if (!fleeing) {
            wander();
        } else if (fleeing) {
            flee();
        }
        else if(returning){
            returnToHerd();
        }
    }
    public void returnToHerd(){

    }
    public void flee(){
        translate((float).7*sheepCounter,-100);
        setPosition((float)(pos.getx()+.7*sheepCounter), (float)(pos.gety()-sheepCounter));
    }
    public void wander(){
        setPosition(((float)(pos.getx()+2.5*(Math.sin(2.1*6*sheepCounter*Math.random())+.25*Math.sin(36*sheepCounter*Math.random()))*Math.cos(6*sheepCounter*Math.random()))), ((float)(pos.gety()+3*(Math.sin(2.1*6*sheepCounter*Math.random())+.25*Math.sin(36*sheepCounter*Math.random()))*Math.sin(6*sheepCounter*Math.random()))));
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
