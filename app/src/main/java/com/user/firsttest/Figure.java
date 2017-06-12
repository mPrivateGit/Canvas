package com.user.firsttest;

import android.graphics.Canvas;



public interface Figure {

    void setX(float x);
    void setY(float y);
    void setX1(float x1);
    void setY1(float y1);

    float getX();
    float getY();
    float getX1();
    float getY1();

    void draw(Canvas canvas);

    float sqare();
    int getColor();



}
