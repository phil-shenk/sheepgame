package com.japa.sheep;

public class Position {
    private float x;
    private float y;

    //Full Constructor method
    public Position(float x, float y)
    {
        setPos(x, y);
    }

    //Copy Constructor method
    public Position(Position other)
    {
        this.x = other.x;
        this.y = other.y; //tset
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

    //Set x method
    public void setx(float newx)
    {
        this.x = newx;
    }

    //Set y method
    public void sety(float newy)
    {
        this.y = newy;
    }

    //Set both coordinates
    public void setPos(float newx, float newy)
    {
        this.x = newx;
        this.y = newy;
    }
}
