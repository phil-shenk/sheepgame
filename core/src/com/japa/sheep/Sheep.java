package com.japa.sheep;

import com.badlogic.gdx.graphics.Texture;

public class Sheep extends Animal{

    public Sheep(Position pos){
        this.pos = pos;
        skin = new Texture("sheep.png");
    }

    public Sheep(float newx, float newy){
        this.pos = new Position(newx,newy);
        skin = new Texture("sheep.png");
    }

    @Override
    public void tick() {

    }

    public void act(float delta) {
        System.out.println("Bahahaha!");
    }
    public void flee(){

    }
    public void wander(){

    }
    public void die(){

    }
    @Override
    public Position getPosition() {
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
}
