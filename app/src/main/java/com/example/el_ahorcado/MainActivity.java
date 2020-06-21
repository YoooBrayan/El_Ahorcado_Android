package com.example.el_ahorcado;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.logica.Juego;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    ImageView imagen;
    RelativeLayout contenedor;
    TextView pelicula;
    RelativeLayout contenedorPelicula;
    String[] estados = new String[]{"primero", "segundo", "tercero", "cuarto", "quinto", "sexto", "septimo"};
    int intentos = 1;
    int intentosA = 0;
    int numLetras = 0;
    ArrayList<Character> letrasAcertadas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        contenedorPelicula = (RelativeLayout) findViewById(R.id.contenedorPelicula);

        final Juego juego = new Juego();
        final String peliculaA = juego.inicio();

        final char[] letras = peliculaA.toCharArray();

        int lef = 0;
        int topL = 0;
        String letrass = "";

        for(int i=0; i<letras.length; i++){

            final TextView letra = new TextView(this)   ;
            final RelativeLayout.LayoutParams tp= new RelativeLayout.LayoutParams(75, 75);

            if(lef>920){
                lef = 0;
                topL = topL + 80;
            }

            tp.setMargins(lef, topL, 0, 0);
            letra.setLayoutParams(tp);
            letra.setText(String.valueOf(letras[i]));
            letra.setTextColor(Color.GRAY);
            letra.setId(i);

            if(((int) letras[i]) != 32){
                letra.setBackgroundColor(Color.GRAY);
                if(!(letrass.contains(String.valueOf(letras[i])))){
                    letrass += letras[i];
                    numLetras++;
                }
                System.out.println("- " + letrass);

            }

            contenedorPelicula.addView(letra);
            lef = lef + 85;

        }

        imagen = (ImageView) findViewById(R.id.imageView);

        imagen.setImageResource(R.drawable.primero);

        contenedor = (RelativeLayout) findViewById(R.id.contenedor);


        /*final RelativeLayout relativeLayout = new RelativeLayout(this);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
            RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.MATCH_PARENT
        );

        params.setMargins(15, 1185, 15, 5);
        relativeLayout.setLayoutParams(params);*/
        //setContentView(relativeLayout);

        int le = 0;
        int top = 0;

        for(int i=65; i<91; i++){


            final Button bn = new Button(this);
            final RelativeLayout.LayoutParams bns = new RelativeLayout.LayoutParams(125, 125);

            if(le>920){
                le = 0;
                top = top + 105;
            }

            bns.setMargins(le, top, 0, 0);
            bn.setLayoutParams(bns);
            bn.setText(Character.toString((char) i));
            contenedor.addView(bn);
            le = le + 115;

            bn.setOnClickListener(new View.OnClickListener() {
                @SuppressLint("ResourceType")
                @Override
                public void onClick(View v) {
                    //System.out.println(bn.getText().toString());
                    bn.setEnabled(false);

                    if(!juego.validarLetra(bn.getText().toString(), peliculaA)){

                        intentos++;

                        if(intentos==2){

                            imagen.setImageResource(R.drawable.segundo);

                        }else if(intentos==3){
                            imagen.setImageResource(R.drawable.tercero);
                        }else if(intentos==4){
                            imagen.setImageResource(R.drawable.cuarto);
                        }else if(intentos==5){
                            imagen.setImageResource(R.drawable.quinto);
                        }else if(intentos==6){
                            imagen.setImageResource(R.drawable.sexto);
                        }else{
                            imagen.setImageResource(R.drawable.septimo);
                            try {
                                Thread.sleep(1500);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            imagen.setImageResource(R.drawable.perdiste);
                        }

                    }else{

                        letrasAcertadas.add(bn.getText().toString().charAt(0));
                        intentosA++;

                        contenedorPelicula.removeAllViews();

                        int lef = 0;
                        int topL = 0;

                        for(int i=0; i<letras.length; i++){

                            final TextView letra = new TextView(getApplicationContext());
                            final RelativeLayout.LayoutParams tp= new RelativeLayout.LayoutParams(75, 75);

                            if(lef>920){
                                lef = 0;
                                topL = topL + 80;
                            }

                            tp.setMargins(lef, topL, 0, 0);
                            letra.setLayoutParams(tp);
                            //letra.setTextColor(Color.GRAY);
                            letra.setId(i);

                            for(int j=0; j<intentosA; j++){

                                System.out.println(letras[i] + " --- " + letrasAcertadas.get(j));

                                if(((int) letras[i]) == letrasAcertadas.get(j)){
                                    letra.setText(String.valueOf(letras[i]));
                                    letra.setBackgroundColor(Color.GRAY);
                                    //letra.setBackgroundColor(Color.RED);
                                    letra.setTextColor(Color.BLACK);
                                    letra.setId(1);
                                }else if(((int) letras[i]) == 32){
                                    letra.setBackgroundColor(Color.WHITE);
                                }else if(letra.getId()!=1){
                                    letra.setBackgroundColor(Color.GRAY);
                                }
                            }

                            contenedorPelicula.addView(letra);
                            lef = lef + 85;

                        }

                        if(numLetras==intentosA){
                            imagen.setImageResource(R.drawable.ganaste);
                        }
                    }


                }
            });

        }

        /*Button bn = new Button(this);
        RelativeLayout.LayoutParams bns = new RelativeLayout.LayoutParams(
            RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT
        );

        bns.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        bns.setMargins(0, 55, 0, 0);
        bn.setLayoutParams(bns);
        bn.setText("A");

        Button bn1 = new Button(this);
        RelativeLayout.LayoutParams bns1 = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT
        );

        bns1.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        bns1.setMargins(135, 55, 0, 0);
        bn1.setLayoutParams(bns1);
        bn1.setText("B");

        relativeLayout.addView(bn);
        relativeLayout.addView(bn1);*/

    }

    public static void mostrarfrase(){

    }
 }


