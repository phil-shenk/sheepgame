package com.japa.sheep;

public class Position {
    private float x;
    private float y;

    //Full Constructor method
    public Position(float x, float y)
    {
        setPosition(x, y);
    }

    //Copy Constructor method
    public Position(Position other)
    {
        this.x = other.x;
        this.y = other.y; //test
    }

    //Get x method
    public float getx()
    {
        return x;
    }

    //Get y method
    public float gety()
    {
        return y;
    }

    //Get y method
    public Position getPosition()
    {
        return this;
    }

    //Set x method
    public void setx(float newx)
    {
        this.x = newx;
    }

    //move
    public void translate(float dx, float dy){
        x += dx;
        y += dy;
    }

    //Set y method
    public void sety(float newy)
    {
        this.y = newy;
    }

    //Set both coordinates
    public void setPosition(float newx, float newy)
    {
        this.x = newx;
        this.y = newy;
    }
}
