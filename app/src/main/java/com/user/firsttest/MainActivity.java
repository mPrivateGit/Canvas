package com.user.firsttest;

import android.graphics.Canvas;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Random;


public class MainActivity extends AppCompatActivity {

    PlaceView placeView;
    ArrayList<Figure> figures;


    private int howMany = 7;


    private int riseX;
    private int riseY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        figures = new ArrayList<>();
        placeView = (PlaceView) findViewById(R.id.placeView);
        findViewById(R.id.btnGenerate).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generate();
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    private void generate() {
        float maxX = placeView.getWidth();
        float maxY = placeView.getHeight();



        Random random = new Random();

        for (int i =0; i<howMany; i++){
            int q = random.nextInt(2);


            if (q == 3) {
                Rectengle rectengle = new Rectengle(generateRandomMaxX(), generateRandomMaxY(),
                        riseX, riseY);
                if (figures.size()<howMany) figures.add(i, rectengle);
                else figures.set(i, rectengle);

                rectengle.sort(figures);
            }

            if (q == 0){
                Triangle triangle = new Triangle(generateRandomMaxX(),generateRandomMaxY(),
                        ((generateRandomMaxX()+generateRandomMaxY())/2));
                figures.add(triangle);

                //figures.add(triangle);
            }
        }

        int scoreRectengle = 0;
        int scoreTriangle = 0;

        for (int i = 0; i<figures.size(); i++){
            if (figures.get(i) instanceof Rectengle) {
                scoreRectengle++;
                //Log.d("Sort: ", figures.get(i).toString());  //для проверки в лог
            } else if (figures.get(i) instanceof Triangle) {
                scoreTriangle++;
            }
        }


        /** Показывает колличество треугольников **/
        Log.d("Треугольников: " + scoreTriangle, "s");


        /** Показывает колличество прямоугольников **/
        Log.d("Прямоугольников: " + scoreRectengle, "d");


        /** Координаты сгенерированной фигуры **/
        // Log.d("Send Erorr: ", figures.get(индекс фигуры).toString());


        /** Коонвертация объекта в Джсон **/
        // Log.d("Json: ", jSon(figures.get(0)));


        /** Коонвертация Джсон обратно в объект **/
        // Log.d("Convet/to/Figure: ", jsonToRectangle(jSon(figures.get(0))).toString());


        placeView.setFigures(figures);
        placeView.invalidate();
    }

    private int generateRandomMaxX(){
        Random rand = new Random();
        int q = rand.nextInt(placeView.getWidth());
        contolCordinatesX(q);
        return q;
    }

    private void contolCordinatesX(int q){
        Random random = new Random(q);
        riseX = random.nextInt(placeView.getWidth());
    }



    private int generateRandomMaxY(){
        Random rand = new Random();
        int z = rand.nextInt(placeView.getHeight());
        contolCordinatesY(z);
        return z;
    }

    private void contolCordinatesY(int z){
        Random random = new Random(z);
        riseY = random.nextInt(placeView.getHeight());
    }

    /** Метод конвертирует данные о фигуре в Джсон */
    private String jSon (Figure rectengle){
        Gson gson = new Gson();
        return  gson.toJson(rectengle);
    }

    /** Метод конвертирует данные из Джсона в фигуру (объект) */
    private Rectengle jsonToRectangle(String json){
        GsonBuilder builder = new GsonBuilder();
        Gson gson2 = builder.create();

        Rectengle r = gson2.fromJson(json, Rectengle.class);

        return r;
    }

    public static class Builder{


    }
}
