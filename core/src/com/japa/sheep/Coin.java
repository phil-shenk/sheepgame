package com.japa.sheep;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.World;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector3;
public class Coin extends Thing {

    public Coin(Vector3 pos, World world) {
        super(pos, world);
    }
    static Texture texture = new Texture("coin.jpg");

    @Override
    public void tick() {

    }

    public void act(float delta){
        hitbox.x = pos.x;
        hitbox.y = pos.y;
        /**
         * if collides w/ dog,
         */
        //else{
            translate(0, -100f*delta);
        //}
    }
    @Override
    public void collidedWith(Entity e){
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
