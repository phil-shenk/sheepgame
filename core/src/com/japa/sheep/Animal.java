package com.japa.sheep;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.World;

public abstract class Animal extends Entity {

    public Animal(Vector3 pos, World world){
        super(pos, world);
    }
    public void act(float delta){
        super.act(delta);
    }

    public float speed;

}
