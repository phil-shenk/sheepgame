package com.japa.sheep;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Actor;

public abstract class Entity extends Actor{
    Position pos;
    Texture skin;
    public float speed;
    public abstract void tick();

    public Position getPosition()
    {
        return pos;
    }

    public void setPosition(float newx, float newy)
    {
        pos.setPosition(newx, newy);
    }

    public void setX(float x){
        pos.setx(x);
    }
    public void setY(float y){
        pos.sety(y);
    }

    public void translate(float dx, float dy){
        pos.translate(dx,dy);
    }

    public abstract Texture getSkin();

    public abstract void setSkin();
}
