package com.japa.sheep;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Texture;

public class Coin extends Thing {

    public Coin(Camera cam){
        super(cam);
    }
    @Override
    public void tick() {

    }

    public void act(){
        /**
         * if collides w/ dog,
         */
    }
    @Override
    public Texture getSkin() {
        return null;
    }

    @Override
    public void setSkin() {

    }
}
