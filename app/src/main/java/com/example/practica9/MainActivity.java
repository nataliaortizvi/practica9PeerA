package com.example.practica9;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import com.google.gson.Gson;
import java.util.Date;
import java.text.SimpleDateFormat;

import com.example.practica9.model.Comida;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button imgSandia, imgPapas, imgQbano, imgPerro;
    UDPConnection udp;
    int num= 1,y=65;

    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //referenciar
        imgSandia = findViewById(R.id.imgSandia);
        imgPapas = findViewById(R.id.imgPapas);
        imgQbano = findViewById(R.id.imgQbano);
        imgPerro = findViewById(R.id.imgPerro);

        udp = new UDPConnection();
        udp.start();

        imgSandia.setOnClickListener(this);
        imgPapas.setOnClickListener(this);
        imgQbano.setOnClickListener(this);
        imgPerro.setOnClickListener(this);



    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){

            case R.id.imgSandia:

                Log.e("nummmm",""+num);
                Date date = new Date();
                SimpleDateFormat sdf;
                sdf = new SimpleDateFormat("HH:mm:ss");
                String fecha= sdf.format(date);

                Gson gson1 = new Gson();
                Comida food1 = new Comida("sandia",num,y, fecha);
                String json1 = gson1.toJson(food1);

                num +=1;
                y += 150;

                udp.sendMessage(json1);

                break;
            case R.id.imgPapas:

                Log.e("nummmm",""+num);
                Date date2 = new Date();
                SimpleDateFormat sdf2;
                sdf = new SimpleDateFormat("HH:mm:ss");
                String fecha2= sdf.format(date2);

                Gson gson2 = new Gson();
                Comida food2 = new Comida("papas",num,y,fecha2);
                String json2 = gson2.toJson(food2);

                udp.sendMessage(json2);

                num +=1;
                y += 150;

                break;
            case R.id.imgQbano:

                Log.e("nummmm",""+num);
                Date date3 = new Date();
                SimpleDateFormat sdf3;
                sdf = new SimpleDateFormat("HH:mm:ss");
                String fecha3= sdf.format(date3);
                Gson gson3 = new Gson();
                Comida food3 = new Comida("qbano",num,y,fecha3);
                String json3 = gson3.toJson(food3);

                udp.sendMessage(json3);
                num +=1;
                y += 150;

                break;
            case R.id.imgPerro:

                Log.e("nummmm",""+num);
                Date date4 = new Date();
                SimpleDateFormat sdf4;
                sdf = new SimpleDateFormat("HH:mm:ss");
                String fecha4= sdf.format(date4);
                Gson gson4 = new Gson();
                Comida food4 = new Comida("perro",num,y,fecha4);
                String json4 = gson4.toJson(food4);

                udp.sendMessage(json4);

                num +=1;
                y += 150;

                break;
        }
    }
}