package com.user.firsttest;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import java.util.Random;


public class Triangle implements Figure{

    private float x;
    private float y;
    private float threePointForTriangle;

    private int color;

    float [] test = {100,150, 50, 300, 150,300};
    int [] test1 = {243243};

    Triangle(float x, float y, float threePointForTriangle){
        setX(x);
        setY(y);
        setThreePointForTriangle(threePointForTriangle);
    }


    public void setThreePointForTriangle(float threePointForTriangle){
        this.threePointForTriangle = threePointForTriangle;
    }

    public float getThreePointForTriangle(){
        return threePointForTriangle;
    }

    @Override
    public void setX(float x) {
        this.x = x;
    }
    public void setY(float y) {
        this.y = y;
    }
    public void setX1(float x1) {

    }
    public void setY1(float y1) {

    }

    @Override
    public float getX() {
        return x;
    }
    public float getY() {
        return y;
    }
    public float getX1() {
        return 0;
    }
    public float getY1() {
        return 0;
    }


    @Override
    public void draw(Canvas canvas) {
        Paint paint = new Paint();
        paint.getColor();
        canvas.drawVertices(Canvas.VertexMode.TRIANGLE_FAN,0, test, 0, null, 0, test1,
                getColor(), null, 0, 0, paint);
    }

    private void  setColor() {
        /** Специальный метод для генерации случайного цвета */
        Random random = new Random();
        color = Color.argb(255, random.nextInt(256), random.nextInt(256), random.nextInt(256));
    }

    @Override
    public float sqare() {
        return 0;
    }



    @Override
    public int getColor() {
        setColor();
        return color;
    }

}
