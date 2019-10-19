package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView cajaOperaciones;
    private TextView cajaRecogida;
    private String Resultado="varResultado";
    private Operacion operaciones = new Operacion();
    private float Memoria;
    private boolean decimal= true;
    private String lenguaje;
    private Button punto;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cajaOperaciones= (TextView) findViewById(R.id.txCajaOperaciones);
        cajaRecogida=(TextView) findViewById(R.id.txCajaRecogida);
        punto = findViewById(R.id.btPunto);
        lenguaje = punto.getText().toString();
        operaciones.setIdioma(lenguaje);

    }

    public void operaciones(View click){
        switch (click.getId()){
            case R.id.btPorcentaje:
                //mostrarResultado("Porcentaje");
                break;
            case R.id.btSuma:
                tipoOperacion("+");
                //deberiamos volcar el resultado de la operacion en la variable resultado


                break;
            case R.id.btResta:
                tipoOperacion("-");


                break;
            case R.id.btMultiplicar:
                tipoOperacion("*");


                break;
            case R.id.btDivision:
                tipoOperacion("/");


                break;
            case R.id.btCambiar:
                cajaOperaciones.setText("-"+cajaRecogida.getText().toString());
                cajaRecogida.setText("");
                //deberiamos volcar el resultado de la operacion en la variable resultado


                break;
            case R.id.btIgual:

                break;
        }
    }
/**
 * realiza las operaciones en la clase y muestra la operacion en las cajas
 * ademas pone la la variable de coma en false
 * */
    public void hacerOperacion(View v){
        if(!cajaRecogida.getText().toString().isEmpty()){
            operaciones.setOperador2(cajaRecogida.getText().toString());
            cajaOperaciones.setText(operaciones.toString());
            cajaRecogida.setText(operaciones.getResultado());
        }


    }

    public void limpiarCajas(View click){
        cajaRecogida.setText(null);
        cajaOperaciones.setText(null);
    }

    public void ingresarNumeros(View click){
        /*deberiamos crear un array con las operaciones y seguire
          realizando los calculos con un array de numeros para calclularlos
        */

            switch (click.getId()){

                case R.id.bt0:
                    setRecogida("0");
                    break;
                case R.id.bt1:
                    setRecogida("1");
                    break;
                case R.id.bt2:
                    setRecogida("2");
                    break;
                case R.id.bt3:
                    setRecogida("3");
                    break;
                case R.id.bt4:
                    setRecogida("4");
                    break;
                case R.id.bt5:
                    setRecogida("5");
                    break;
                case R.id.bt6:
                    setRecogida("6");
                    break;
                case R.id.bt7:
                    setRecogida("7");
                    break;
                case R.id.bt8:
                    setRecogida("8");
                    break;
                case R.id.bt9:
                    setRecogida("9");
                    break;
                case R.id.btPunto:
                    if(decimal){
                        setRecogida(",");
                        decimal = false;
                    }

                    break;
            }

    }

    public void setRecogida(String valor){
        cajaRecogida.setText(cajaRecogida.getText().toString()+valor);
    }

    public void accionesBotonesM(View click) {
        switch (click.getId()){
            //establecemos los valores en memoria
            case R.id.btMemoriaClear:
                operaciones.setMemoria(0);
                break;
            case R.id.btMsuma:
                float sumMemoria= Float.parseFloat(cajaRecogida.getText().toString())+ operaciones.getMemoria();
                operaciones.setMemoria(sumMemoria);
                break;
            case R.id.btMresta:
                float restMemoria= Float.parseFloat(cajaRecogida.getText().toString())- operaciones.getMemoria();
                operaciones.setMemoria(restMemoria);
                cajaOperaciones.setText("M+");

                break;
            case R.id.btMmostar:
                cajaRecogida.setText(String.valueOf(operaciones.getMemoria()));
                break;
        }
    }

    public void tipoOperacion(String simbolo){
        if((operaciones.getOperador1()).equals("")){
            if(!cajaRecogida.getText().toString().isEmpty()){
                operaciones.setOperador1(cajaRecogida.getText().toString());
                operaciones.setSimbolo(simbolo);
                this.decimal=true;
            }
        }else{
            operaciones.setSimbolo(simbolo);
        }
        cajaOperaciones.setText(operaciones.getOperador1()+operaciones.getSimbolo());
        cajaRecogida.setText("");
    }


}
