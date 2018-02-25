package com.japa.sheep;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Actor;

public abstract class Entity extends Actor{
    Vector3 pos;
    Vector3 relativePos;
    Texture skin;

    public float speed;
    public abstract void tick();


    public Entity(){
    }

    public Vector3 getPosition()
    {
        return pos;
    }

    public Vector3 getRelativePos(Vector3 refPos){
        return new Vector3(pos).sub(refPos);
    }

    public void setPosition(float newx, float newy)
    {
        pos.x = newx;
        pos.y = newy;
    }

    public void setX(float x){
        pos.x = x;
    }
    public void setY(float y){
        pos.y = y;
    }

    public void translate(float dx, float dy){
        pos.add(dx,dy,0);
    }

    public abstract Texture getSkin();

    public abstract void setSkin();
}
