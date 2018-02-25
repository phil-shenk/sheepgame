package com.japa.sheep;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.sun.corba.se.spi.orbutil.proxy.CompositeInvocationHandler;

public abstract class Entity extends Actor{
    Vector3 pos;
    Vector3 relativePos;
    Texture skin;
    Camera cam;

    public float speed;
    public abstract void tick();


    public Entity(Camera cam){
        this.cam = cam;
    }

    public Vector3 getPosition()
    {
        return pos;
    }

    public Vector3 getRelativePos(){
        return pos.sub(cam.position);
    }
    public Vector3 getRelativePos(Vector3 refPos){
        return pos.sub(refPos);
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
        System.out.println(pos.x+"old");
        pos.add(dx,dy,0);
        System.out.println(pos.x);
    }

    public abstract Texture getSkin();

    public abstract void setSkin();
}
