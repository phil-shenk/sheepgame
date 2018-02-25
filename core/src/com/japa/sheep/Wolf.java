package com.japa.sheep;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Texture;

public class Wolf extends Animal {

    private int waitTime;
    private boolean chasing = false;
    private boolean hasEaten = false;

    public void act(float delta) {
        if (chasing){
            if (hasEaten){
                chasing = false;
                flee();
            }
            if (chasing){
                chase();
            }

            if (pos.getx()<=5){
                //remove();
            }
        }
        else{
            sit();
            waitTime+=delta;
            System.out.println(delta);
        }

    }


    public Wolf(Camera cam){
        super(cam);
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
        pos.setx(pos.getx()-5);
    }

    public void sit(){
        if (waitTime==10){
            chasing = true;
        }
    }

    /*public void remove(){

    }*/

    @Override
    public Position getPosition() {
        return pos.getPosition();
    }

    //@Override
    public void setPosition(float newx, float newy) {
        pos.setPosition(newx, newy);
    }

    @Override
    public Texture getSkin() {
        return null;
    }

    @Override
    public void setSkin() {

    }
}
