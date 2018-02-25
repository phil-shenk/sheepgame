package com.japa.sheep;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Texture;

public class Wolf extends Animal {

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
