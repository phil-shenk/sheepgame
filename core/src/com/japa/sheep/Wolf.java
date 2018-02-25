package com.japa.sheep;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.World;

public class Wolf extends Animal {

    private int waitTime;
    private boolean chasing = false;
    private boolean hasEaten = false;

    public void act(float delta) {
        body.setTransform(pos.x, pos.y,0);
        if (chasing){
            if (hasEaten){
                chasing = false;
                flee();
            }
            if (chasing){
                chase();
            }

            if (pos.x<=5){
                //remove();
            }
        }
        else{
            sit();
            waitTime+=delta;
            System.out.println(delta);
        }




    }


    public Wolf(Vector3 pos, World world){
        super(pos, world);
    }

    @Override
    public void tick() {

    }

    /**
     * after a certain amount of time, wolf will chase/eat a sheep
     */
    public void chase(){
    }

    /**
     * from sheepdog
     */
    public void flee(){
        pos.x -= 5;
    }

    public void sit(){
        if (waitTime==10){
            chasing = true;
        }
    }

    /*public void remove(){

    }*/

    @Override
    public Vector3 getPosition() {
        return pos;
    }

    //@Override
    public void setPosition(float newx, float newy) {
        pos.x = newx;
        pos.y = newy;
    }

    @Override
    public Texture getSkin() {
        return null;
    }

    @Override
    public void setSkin() {

    }
}
