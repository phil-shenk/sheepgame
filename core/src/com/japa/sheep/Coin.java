package com.japa.sheep;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Texture;

public class Coin extends Thing {

    public Coin(){

    }
    @Override
    public void tick() {

    }

    public void act(float delta){
        /**
         * if collides w/ dog,
         */
        //else{
            translate(0, -delta);
        //}
    }
    @Override
    public Texture getSkin() {
        return null;
    }

    @Override
    public void setSkin() {

    }
}
