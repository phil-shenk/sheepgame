package com.japa.sheep;

import com.badlogic.gdx.graphics.Texture;

public abstract class Entity {
    Position pos;
    Texture skin;

    public abstract void tick();

    public abstract Position getPosition();

    public abstract void setPosition();

    public abstract Texture getSkin();

    public abstract void setSkin();
}
