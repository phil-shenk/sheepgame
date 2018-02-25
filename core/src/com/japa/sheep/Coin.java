package com.japa.sheep;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;
public class Coin extends Thing {
    static Texture texture = new Texture("coin.jpg");
    public Coin(Vector3 pos){

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
