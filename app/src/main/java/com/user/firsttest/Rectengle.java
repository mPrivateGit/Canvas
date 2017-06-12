package com.user.firsttest;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static java.lang.StrictMath.abs;

public class Rectengle implements Figure, Comparable<Rectengle> {

    private float x;
    private float y;
    private float x1;
    private float y1;

    private int color;

    private Rectengle rectengle;




    Rectengle (float x, float y, float x1, float y1){
        setX(x);
        setY(y);
        setX1(x1);
        setY1(y1);
    }

    // левая точка
    @Override
    public void setX(float x) {
        this.x = x;
    }
    public void setY(float y) {
        this.y = y;
    }
    public float getX() {
        return x;
    }
    public float getY() {
        return y;
    }

    // правая точка
    @Override
    public void setX1(float x1) {
        this.x1 = x1;
    }
    public float getX1() {
        return x1;
    }
    public void setY1(float y1) {
        this.y1 = y1;
    }
    public float getY1() {
        return y1;
    }

    @Override
    public void draw(Canvas canvas) {
        /** Метод, который отрисовывает фигуру */
        Paint paint  = new Paint();
        paint.setColor(getColor());
        canvas.drawRect(x,y,x1,y1,paint);
    }

    @Override
    public float sqare() {
        /** Метод считает площадь фигуры(прямоугольника) по модулю
         * В идеальном мире убрав модуль результат не измениться */
        return (abs(x1 -x)* abs(y1 - y));

        /** К сожалению до сих пор неизвестно почему без модуля метод работает не правильно.
         * Согласно коду координаты х1 и у2 должны быть всегда ниже, но на практике нет
         * Выбрав легкий путь я просто добавил модуль, не разбираясь в деталях*/
    }

    private void  setColor(){
        /** Специальный метод для генерации случайного цвета */
        Random random = new Random();
        color = Color.argb(255, random.nextInt(256), random.nextInt(256), random.nextInt(256));
    }

    @Override
    public int getColor() {
        /** Этот метод просто возвращает цвет используя специальный метод
         * для этого класса setColor(). Не знаю зачем я его делал, просто
         * в интерфейсе этот метод есть и наверно нужно чтобы он был реализован*/
        setColor();
        return color;
    }

    @Override
    public String toString() {
        /** Этот метод очень важен и является ключевым. В коде всей программы
         * с его помощтю можно получить данные о объекте (фигуре) в Log,
         * тем самым позволяя отслеживать и редактировать код*/

        return "Rectengle{" +
                "x=" + x +
                ", y=" + y +
                ", x1=" + x1 +
                ", y1=" + y1 +
                ", color=" + getColor() +
                ", sqare=" + sqare() +
                '}';
    }


    @Override
    public int compareTo(Rectengle o) {
        /** Компоратор реализует условие прикотором сравнивается площадь фигуры
         *  В идальном мире сортировка с помощью этого компоратора должна сортировать
         *  фигуры в массиве от малых к большим только за счет площади фигуры*/
        if (sqare()> o.sqare()) return 1;
        else if (sqare()< o.sqare()) return -1;
        else {
            return 0;
        }
        /** Удивительно, но это работает*/
    }


    public void sort(ArrayList arrayList){
        /**Благодаря нормальному компоратору сртировка работает хорошо
         * Класс ArrayList сам все сортирует с помощью усорвий компоратора*/
        Collections.sort(arrayList);
    }



    public static class RectengleBuilder{
        private float x;
        private float y;
        private float x1;
        private float y1;


        RectengleBuilder(float x) {
            this.x =x;
        }

        public RectengleBuilder setNewX(float x){
            this.x=x;
            return this;
        }
        public RectengleBuilder setNewY(float y){
            this.y=y;
            return this;
        }
        public RectengleBuilder setNewX1(float x1){
            this.x1=x1;
            return this;
        }
        public RectengleBuilder setNewY1(float y1){
            this.y1=y1;
            return this;
        }

        public Rectengle createRectengle(){
            return new Rectengle(x,y,x1,y1);
        }
    }
}
