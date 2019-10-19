package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView cajaOperaciones;
    private TextView cajaResultado;
    private String Resultado="varResultado";
    private Operacion operaciones = new Operacion();
    private float Memoria;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cajaOperaciones= (TextView) findViewById(R.id.txCajaOperaciones);
        cajaResultado=(TextView) findViewById(R.id.tvCajaResultado);
    }

    public void operaciones(View click){
        switch (click.getId()){
            case R.id.btPorcentaje:
                mostrarResultado("Porcentaje");
                break;
            case R.id.btSuma:
                if((operaciones.getOperador1()).equals("")){
                    operaciones.setOperador1(cajaResultado.getText().toString());
                    operaciones.setTipo("suma");
                    operaciones.setSimbolo("+");
                }else{
                    operaciones.setTipo("suma");
                    operaciones.setSimbolo("+");
                }
                cajaOperaciones.setText(operaciones.getOperador1()+operaciones.getSimbolo());
                cajaResultado.setText("");
                //deberiamos volcar el resultado de la operacion en la variable resultado


                break;
            case R.id.btResta:
                cajaOperaciones.setText(cajaResultado.getText().toString()+" - ");
                cajaResultado.setText("");
                operaciones.setTipo("resta");
                //deberiamos volcar el resultado de la operacion en la variable resultado


                break;
            case R.id.btMultiplicar:
                cajaOperaciones.setText(cajaResultado.getText().toString()+" x ");
                cajaResultado.setText("");
                operaciones.setTipo("multiplicacion");
                //deberiamos volcar el resultado de la operacion en la variable resultado


                break;
            case R.id.btDivision:
                cajaOperaciones.setText(cajaResultado.getText().toString()+" / ");
                cajaResultado.setText("");
                operaciones.setTipo("division");
                //deberiamos volcar el resultado de la operacion en la variable resultado


                break;
            case R.id.btCambiar:
                cajaOperaciones.setText("-"+cajaResultado.getText().toString());
                cajaResultado.setText("");
                //deberiamos volcar el resultado de la operacion en la variable resultado


                break;
            case R.id.btIgual:

                break;
        }
    }

    public void hacerOperacion(View v){
        operaciones.setOperador2(cajaResultado.getText().toString());
        int prueba = Integer.parseInt(operaciones.getOperador1())+
                Integer.parseInt(operaciones.getOperador2());
        cajaOperaciones.setText(operaciones.toString());
        cajaResultado.setText(operaciones.getOperacion());
    }

    public void limpiarCajas(View click){
        cajaResultado.setText(null);
        cajaOperaciones.setText(null);
    }

    public void mostrarResultado(String resultado){
        cajaOperaciones.setText(cajaOperaciones.getText().toString()+cajaResultado.getText().toString());
        cajaResultado.setText(resultado);
    }

    public void ingresarNumeros(View click){
        /*deberiamos crear un array con las operaciones y seguire
          realizando los calculos con un array de numeros para calclularlos
        */
        if(cajaResultado.getText().equals(this.Resultado)){
            cajaResultado.setText("0");
            cajaOperaciones.setText("0");
        }
        switch (click.getId()){
            case R.id.bt0:
                cajaResultado.setText(cajaResultado.getText().toString()+"0");
                break;
            case R.id.bt1:
                cajaResultado.setText(cajaResultado.getText().toString()+"1");
                break;
            case R.id.bt2:
                cajaResultado.setText(cajaResultado.getText().toString()+"2");
                break;
            case R.id.bt3:
                cajaResultado.setText(cajaResultado.getText().toString()+"3");
                break;
            case R.id.bt4:
                cajaResultado.setText(cajaResultado.getText().toString()+"4");
                break;
            case R.id.bt5:
                cajaResultado.setText(cajaResultado.getText().toString()+"5");
                break;
            case R.id.bt6:
                cajaResultado.setText(cajaResultado.getText().toString()+"6");
                break;
            case R.id.bt7:
                cajaResultado.setText(cajaResultado.getText().toString()+"7");
                break;
            case R.id.bt8:
                cajaResultado.setText(cajaResultado.getText().toString()+"8");
                break;
            case R.id.bt9:
                cajaResultado.setText(cajaResultado.getText().toString()+"9");
                break;
            case R.id.btPunto:
                cajaResultado.setText(cajaResultado.getText().toString()+",");
                break;
        }
    }

    public void accionesBotonesM(View click) {
        switch (click.getId()){
            //establecemos los valores en memoria
            case R.id.btMemoriaClear:
                operaciones.setMemoria(0);
                break;
            case R.id.btMsuma:
                float sumMemoria= Float.parseFloat(cajaResultado.getText().toString())+ operaciones.getMemoria();
                operaciones.setMemoria(sumMemoria);
                break;
            case R.id.btMresta:
                float restMemoria= Float.parseFloat(cajaResultado.getText().toString())- operaciones.getMemoria();
                operaciones.setMemoria(restMemoria);
                cajaOperaciones.setText("M+");

                break;
            case R.id.btMmostar:
                cajaResultado.setText(String.valueOf(operaciones.getMemoria()));
                break;
        }
    }

    public void comprobarSignos(){

    }
    public void sumar(){

    }
}
