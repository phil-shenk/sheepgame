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

    public abstract Texture getSkin();

    public abstract void setSkin();
}
