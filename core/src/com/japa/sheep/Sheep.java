package com.japa.sheep;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector3;


public class Sheep extends Animal{

    static Texture texture = new Texture("sheep.png");
    private boolean fleeing = false;
    float sheepCounter;
    private boolean returning = false;
    public Sheep(Vector3 pos){
        this.pos = pos;
    }

    public Sheep(float newx, float newy){
        pos = new Vector3(newx,newy,0);
    }

    @Override
    public void tick() {

    }

    public void act(float delta) {

        sheepCounter += delta;
        inHerd();
        if (!fleeing) {
            wander(delta);
            //returnToHerd(delta);
        } else if (fleeing) {
            flee(delta);
        }
        else if(returning){
            returnToHerd(delta);
        }

    }
    public void returnToHerd(float delta){
        System.out.println("bacc to herd");
        if(pos.y < 200){
            if(70 < pos.x){
                translate((float)(sheepCounter*50), (float)(sheepCounter*30));
            }
            if(pos.x > 186){
                translate((float)(sheepCounter*50), -(float)(sheepCounter*30));
            }
        }
        else {
            returning = false;
            wander(delta);
        }

    }
    public void flee(float delta){
        System.out.println("yeargH!");
        translate(0,-70f*delta);
    }
    public void wander(float delta){
        System.out.println("wanderoni");
        System.out.println(pos.x);
        translate((float)(delta*Math.random()*120), (float)(delta*Math.random()*200));
        translate(-(float)(delta*Math.random()*120), -(float)(delta*Math.random()*200));
        //setPosition(((float)(pos.x+2.5*(Math.sin(2.1*6*sheepCounter*Math.random())+.25*Math.sin(36*sheepCounter*Math.random()))*Math.cos(6*sheepCounter*Math.random()))), ((float)(pos.y+3*(Math.sin(2.1*6*sheepCounter*Math.random())+.25*Math.sin(36*sheepCounter*Math.random()))*Math.sin(6*sheepCounter*Math.random()))));
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
            if( 50  > pos.x  || pos.x > 206){
                System.out.println(pos.x);
                fleeing = true;
            }
            else if ( pos.y < 200){
                fleeing = true;
            }

        }

        return fleeing;
    }
}
