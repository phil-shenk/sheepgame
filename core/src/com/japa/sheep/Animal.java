package com.japa.sheep;


import com.badlogic.gdx.graphics.Camera;

public abstract class Animal extends Entity {

    public Animal(Camera cam){
        super(cam);
    }

    public float speed;

}
