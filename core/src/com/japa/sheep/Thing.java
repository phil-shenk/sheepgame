package com.japa.sheep;


import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.World;

public abstract class Thing extends Entity{
    public Thing(Vector3 pos, World world){
        super(pos, world);
    }

}
