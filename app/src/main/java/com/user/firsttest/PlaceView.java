package com.user.firsttest;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;


import java.util.ArrayList;


public class PlaceView extends View  {

    private ArrayList<Figure> figures;


    private float x;
    private float y;


    private String sDown;


    public PlaceView(Context context) {
        super(context);
    }

    public PlaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PlaceView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setFigures(ArrayList<Figure> figures) {
        this.figures = figures;
    }



    // Достает фигуры из массива
    @Override
    protected void onDraw(Canvas canvas) {

        if (figures == null) return;
        for (int i=0;i<figures.size();i++) {
            try {
                figures.get(i).draw(canvas);
            }
            catch (NullPointerException e){
                Log.d("NullPointerException: ", "Тут фигуры нет, нечего рисовать. Канвас (с)");
            }
        }
    }



    @Override
    public boolean onTouchEvent(MotionEvent event) {  // TODO !!!!

        try {
            for (int i = 0; i < figures.size(); i++) {


                /** Это координаты фигуры
                 *  Здесь координаты двух точек */

                // Верхняя точка
                int xF = (int) figures.get(i).getX();
                int yF = (int) figures.get(i).getY();

                // Нижняя точка
                int x1F = (int) figures.get(i).getX1();
                int y1F = (int) figures.get(i).getY1();

                int xMax, xMin, yMax, yMin;

                if (xF > x1F) {
                    xMax = xF;
                    xMin = x1F;
                } else {
                    xMax = x1F;
                    xMin = xF;
                }

                if (yF > y1F) {
                    yMax = yF;
                    yMin = y1F;
                } else {
                    yMax = y1F;
                    yMin = yF;
                }


                // Координаты нажатия
                x = event.getX();
                y = event.getY();


                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN: // нажатие
                        sDown = "Down: " + (int) x + "," + (int) y;
                        try {
                            if (xMin <= x & yMin <= y & xMax >= x & yMax >= y) {
                                Log.d("ziga: ", "eeee!");
                            }
                            break;
                        } catch (NullPointerException e) {
                            Log.d("NullPointerException: ", "Это ошибка при сравнении фигуры " +
                                    " с нажатием:  ....Фигур нет, ждем...");
                        }
                }
            }
            Log.d("Event: ", sDown); // Координаты нажатия на экран
        }
        catch (NullPointerException e) {
            Log.d("NullPointerException: ", "Это ошибка вне логики сравнения фигуры" +
                    " с нажатием:    ....Фигур нет, ждем...");
        }



       // Log.d("cor X: ", xF + "," + yF) ;
       // Log.d("cor Y: ", x1F + "," + y1F) ;
        return false;
    }

}
