package com.japa.sheep;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector3;


public class Sheep extends Animal{

    static Texture texture = new Texture("sheep.png");
    private boolean fleeing;
    float sheepCounter;
    private boolean returning;
    public Sheep(Vector3 pos, Camera cam){
        super(cam);
        this.pos = pos;
    }

    public Sheep(float newx, float newy, Camera cam){
        super(cam);
        this.pos = new Vector3(newx,newy,0);
    }

    @Override
    public void tick() {

    }

    public void act(float delta) {

        sheepCounter += delta;
        inHerd();
        if (!fleeing) {
            wander();
        } else if (fleeing) {

            flee(delta);
        }
        else if(returning){
            returnToHerd(delta);
        }

    }
    public void returnToHerd(float delta){
        if(getRelativePos().y < 200){
            if(70 < getRelativePos().x){
                translate((float)(sheepCounter*50), (float)(sheepCounter*30));
            }
            if(getRelativePos().x > 186){
                translate((float)(sheepCounter*50), -(float)(sheepCounter*30));
            }
        }
        else {
            returning = false;
            wander();
        }

    }
    public void flee(float delta){
        translate((float).7*delta,-100);
    }
    public void wander(){
        setPosition(((float)(pos.x+2.5*(Math.sin(2.1*6*sheepCounter*Math.random())+.25*Math.sin(36*sheepCounter*Math.random()))*Math.cos(6*sheepCounter*Math.random()))), ((float)(pos.y+3*(Math.sin(2.1*6*sheepCounter*Math.random())+.25*Math.sin(36*sheepCounter*Math.random()))*Math.sin(6*sheepCounter*Math.random()))));
    }
    public void die(){

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

    @Override
    public void draw (Batch batch, float parentAlpha) {
        Color color = getColor();
        batch.setColor(color.r, color.g, color.b, color.a * parentAlpha);
        //batch.draw(region, getX(), getY(), getOriginX(), getOriginY(), getWidth(), getHeight(), getScaleX(), getScaleY(), getRotation());
        batch.draw(texture, pos.x, pos.y);
    }
    public boolean inHerd(){
        if(!returning){
            if( 90 < getRelativePos().x  || getRelativePos().x < 166){
                fleeing = true;
            }
            else if ( getRelativePos().y < 60){
                fleeing = true;
            }
        }

        return fleeing;
    }
}
