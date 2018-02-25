package com.japa.sheep;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.viewport.FitViewport;

import static com.japa.sheep.GameScreen.viewportHeight;
import static com.japa.sheep.GameScreen.viewportWidth;

public class Sheep extends Animal{

    static Texture texture = new Texture("sheep.png");
    private boolean fleeing = false;
    float sheepCounter;
    private boolean returning = false;
    private boolean wandering = true;
    Vector3 target = null;
    public Sheep(Vector3 pos, World world){
        super(pos, world);
    }

    public Sheep(float newx, float newy, World world){
        super(new Vector3(newx, newy, 0), world);
    }

    @Override
    public void tick() {

    }

    public void collidedWithDoggo(){
        System.out.print("RETURNING IS NOW TRUE");
        returning = true;

        target = new Vector3(((float)Math.random()*viewportWidth*0.4f+viewportWidth*0.3f), 0.75f*viewportHeight, 0);
        System.out.println("set target to "+target);
        fleeing = false;
        wandering = false;
    }

    public void act(float delta) {
        hitbox.x = pos.x;
        hitbox.y = pos.y;
        //body.setTransform(pos.x, pos.y,0);
        sheepCounter += delta;
        inHerd();
        if (wandering) {
            wander(delta);
            //returnToHerd(delta);
        } else if (fleeing) {
            flee(delta);
        }
        else if(returning){
            returnToHerd(delta);
        }
        else{
            wander(delta);
        }

    }
    public void returnToHerd(float delta){

        //Vector3 target = new Vector3(0,0.75f*viewportHeight,0);
        System.out.println("Targ:"+target);
        Vector3 dir = new Vector3(target).sub(pos);
        System.out.println("Targpostsub:"+target);

        if(dir.len()<10){
            returning = false;
            wandering = true;
            fleeing = false;
        }

        System.out.println("DIR:"+dir);
        dir.setLength(1f);
        System.out.println("UNITDIR:"+dir);
        //dir.rotate(((float)Math.random()*100f-50f),0,0,1);
        System.out.println("PRESPOS:"+pos);
        pos.add(dir);
        System.out.println("POStPOS:"+pos);

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
    public void inHerd(){
        if(!returning){
            if( (int)(viewportWidth*.2)  > pos.x  || pos.x > (int)(viewportWidth*.8)){
                //System.out.println("not returning, outside herd area (x)");
                fleeing = true;
            }
            else if ( pos.y < (int)(viewportHeight*.4) || pos.y> (int)(viewportHeight*.99)){
                //System.out.println("not returning, outside herd area (y)");
                fleeing = true;
            }
            else{
                //System.out.println("not returning, in the herd area");
                double x = Math.random();
                if( x < 0.00009){
                    fleeing = true;
                }
            }
        }
        if(fleeing){
            wandering = false;
        }
    }
}
