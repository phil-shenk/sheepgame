package com.japa.sheep;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.World;


public class Sheep extends Animal{

    static Texture texture = new Texture("sheep.png");
    private boolean fleeing = false;
    float sheepCounter;
    private boolean returning = false;
    public Sheep(Vector3 pos, World world){
        super(pos, world);
    }

    public Sheep(float newx, float newy, World world){
        super(new Vector3(newx, newy, 0), world);
    }

    @Override
    public void tick() {

    }

    public void act(float delta) {
        hitbox.x = pos.x;
        hitbox.y = pos.y;
        //body.setTransform(pos.x, pos.y,0);
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
        if(pos.y < 200){
            if(70 > pos.x){
                translate((float)(delta*80), (float)(delta*80));
            }
            if(pos.x > 186){
                translate((float)(delta*80), -(float)(delta*80));
            }
        }
        else if(70 > pos.x){
            translate((float)(delta*60), (float)(delta*120*Math.random()));
            translate((float)(delta*60), (float)(delta*120*Math.random()));
        }
        else if(pos.x > 186){
            translate(-(float)(delta*60), (float)(delta*120*Math.random()));
            translate(-(float)(delta*60), -(float)(delta*120*Math.random()));
        }
        else {
            returning = false;
            wander(delta);
        }

    }
    public void flee(float delta){
        translate(0,-70f*delta);
    }
    public void wander(float delta){
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
            if( 30  > pos.x  || pos.x > 226){
                fleeing = true;
            }
            else if ( pos.y < 200 || pos.y>512){
                fleeing = true;
            }
            else{
                double x = Math.random();
                if( x < 0.00009){
                    fleeing = true;
                }
                return fleeing;
            }
        }

        return fleeing;
    }
}
