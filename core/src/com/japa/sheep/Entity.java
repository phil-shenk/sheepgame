package com.japa.sheep;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.scenes.scene2d.Actor;


public abstract class Entity extends Actor{
    Vector3 pos;
    float width=64;
    float height=64;
    Vector3 relativePos;
    Texture skin;
    Body body;
    BodyDef bodyDef;
    Rectangle hitbox;

    public float speed;
    public abstract void tick();


    public Entity(Vector3 pos, World world){
        this.pos = pos;
        //set up box2D stuff
        bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        bodyDef.position.set(pos.x+width/2, pos.y+height/2);
        body = world.createBody(bodyDef);
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(width, height);
        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;
        fixtureDef.density = 1f;
        Fixture fixture = body.createFixture(fixtureDef);
        shape.dispose();
        System.out.println(body.getFixtureList().get(0).getShape().getRadius());

        hitbox = new Rectangle(pos.x+(width/2), pos.y+(height/2), width, height);

    }

    //THIS ISNT ACTUALLY CALLED, maybe it should be but im just putting the setTransofmr ininto the aeactas of aefjsk djkdjvdhlzf
    public void act(float delta){
        System.out.println("THIS ISNT ACTUALLY CALLED");
        body.setTransform(pos.x, pos.y,0);

    }

    public Vector3 getPosition()
    {
        return pos;
    }

    public Vector3 getRelativePos(Vector3 refPos){
        return new Vector3(pos).sub(refPos);
    }

    public void collidedWith(Entity e){

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

    public void translate(float dx, float dy, float dz){
        pos.add(dx,dy,dz);
    }

    public abstract Texture getSkin();

    public abstract void setSkin();
}
