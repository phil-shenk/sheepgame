package com.japa.sheep;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector3;
public class Coin extends Thing {
    static Texture texture = new Texture("coin.jpg");
    public Coin(Vector3 pos){
        this.pos = pos;
    }
    @Override
    public void tick() {

    }

    public void act(float delta){
        /**
         * if collides w/ dog,
         */
        //else{
            translate(0, -70f*delta);
        //}
    }
    @Override
    public Texture getSkin() {
        return null;
    }

    @Override
    public void setSkin() {

    }
    public void draw (Batch batch, float parentAlpha) {
        Color color = getColor();
        batch.setColor(color.r, color.g, color.b, color.a * parentAlpha);
        //batch.draw(region, getX(), getY(), getOriginX(), getOriginY(), getWidth(), getHeight(), getScaleX(), getScaleY(), getRotation());
        batch.draw(texture, pos.x, pos.y);
    }
}
