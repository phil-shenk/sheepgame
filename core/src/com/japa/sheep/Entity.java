package com.japa.sheep;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Actor;

public abstract class Entity extends Actor{
    Position pos;
    Texture skin;
    public float speed;
    public abstract void tick();

    public abstract Position getPosition();

    public abstract void setPosition();

    public abstract Texture getSkin();

    public abstract void setSkin();
}
