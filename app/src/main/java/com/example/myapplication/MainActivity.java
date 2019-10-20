package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView cajaOperaciones;
    private TextView cajaRecogida;
    private String Resultado = "varResultado";
    private Operacion operaciones = new Operacion();
    private boolean decimal = true;
    private String lenguaje;
    private Button punto;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cajaOperaciones = (TextView) findViewById(R.id.txCajaOperaciones);
        cajaRecogida = (TextView) findViewById(R.id.txCajaRecogida);
        punto = findViewById(R.id.btPunto);
        lenguaje = punto.getText().toString();
        operaciones.setIdioma(lenguaje);
    }

    /**
     *Función asignada a los onclick de los botones que sirve para mostrar dicho boton en
     * la pantalla
     */
    public void ingresarNumeros(View click) {
        switch (click.getId()) {

            case R.id.bt0:
                recogerNumeros("0");
                break;
            case R.id.bt1:
                recogerNumeros("1");
                break;
            case R.id.bt2:
                recogerNumeros("2");
                break;
            case R.id.bt3:
                recogerNumeros("3");
                break;
            case R.id.bt4:
                recogerNumeros("4");
                break;
            case R.id.bt5:
                recogerNumeros("5");
                break;
            case R.id.bt6:
                recogerNumeros("6");
                break;
            case R.id.bt7:
                recogerNumeros("7");
                break;
            case R.id.bt8:
                recogerNumeros("8");
                break;
            case R.id.bt9:
                recogerNumeros("9");
                break;
            case R.id.btPunto:
                if (decimal && !cajaRecogida.getText().toString().isEmpty()) {
                    recogerNumeros(lenguaje);
                    decimal = false;
                }
                break;
        }

    }

    /**
     * Función onclick asignada a los botones de estos simbolos  de definir el tipo de operación
     * que se va a hacer
     * @param click
     */
    public void operaciones(View click) {
        switch (click.getId()) {
            case R.id.btSuma:
                tipoOperacion("+");
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

        }
    }

    /**
     * realiza las operaciones en la clase y muestra la operacion en las cajas
     * ademas pone la la variable de coma en false
     */
    public void hacerOperacion(View v) {
        if (!cajaRecogida.getText().toString().isEmpty() && !operaciones.getOperador1().isEmpty()) {
            operaciones.setOperador2(cajaRecogida.getText().toString());
            cajaOperaciones.setText(operaciones.getResultado());
            cajaRecogida.setText("");
            operaciones.vaciar();
            decimal = true;

        }
    }

    /**
     * Función encargada de vaciar los textviews
     * @param click
     */
    public void limpiarCajas(View click) {
        cajaRecogida.setText("");
        cajaOperaciones.setText("");
        decimal = true;
        operaciones.vaciar();
    }

    /**
     * Función encargada de mostrar en pantalla los numeros o coma que se están pulsando
     * @param valor
     */
    public void recogerNumeros(String valor) {
        cajaRecogida.setText(cajaRecogida.getText().toString() + valor);
    }

    /**
     * Función onclick encargada de darle funciones a los botones M.
     * @param click
     */
    public void accionesBotonesM(View click) {
        double operacionesMemoria = 0d;
        if (!cajaRecogida.getText().toString().isEmpty()) {
            String temporal = cajaRecogida.getText().toString();
            temporal = temporal.replace(",",".");
            operacionesMemoria = Double.parseDouble(temporal);
        }
        switch (click.getId()) {
            //establecemos los valores en memoria
            case R.id.btMemoriaClear:
                operaciones.setMemoria("0");
                limpiarCajas(click);
                break;
            case R.id.btMsuma:
                if(!cajaRecogida.getText().toString().isEmpty()){
                    operacionesMemoria=operacionesMemoria+Double.parseDouble(operaciones.getMemoria().
                            replace(",","."));
                    operaciones.setMemoria(String.valueOf(operacionesMemoria));
                    limpiarCajas(click);
                }
                break;
            case R.id.btMresta:
                if(!cajaRecogida.getText().toString().isEmpty()){
                    operacionesMemoria=Double.parseDouble(operaciones.getMemoria()
                            .replace(",","."))-operacionesMemoria;
                    operaciones.setMemoria(String.valueOf(operacionesMemoria));
                    limpiarCajas(click);
                }
                break;
            case R.id.btMmostar:
                    cajaOperaciones.setText(operaciones.getMemoria());
                break;
        }
    }

    /**
     * Función encargada de cambiar el contenido de la caja operaciones y el tipo de operación
     * que se va a hacer
     * @param simbolo
     */
    public void tipoOperacion(String simbolo) {
        if ((operaciones.getOperador1()).equals("")) {
            if (!cajaRecogida.getText().toString().isEmpty()) {
                operaciones.setOperador1(cajaRecogida.getText().toString());
                operaciones.setSimbolo(simbolo);
                this.decimal = true;
                cajaOperaciones.setText(operaciones.getOperador1() + operaciones.getSimbolo());
                cajaRecogida.setText("");
            }
        } else {
            operaciones.setSimbolo(simbolo);
            cajaOperaciones.setText(operaciones.getOperador1() + operaciones.getSimbolo());
            cajaRecogida.setText("");
        }
    }

    /**
     * Función onclick que se encarga de cambiar el signo del numero
     * @param view
     */
    public void cambiarSigno(View view) {
        String numeroSigno = cajaRecogida.getText().toString();
        if (!cajaRecogida.getText().toString().isEmpty()) {
            if ('-' != numeroSigno.charAt(0) && '+' == numeroSigno.charAt(0)) {
                numeroSigno = numeroSigno.replace("+", "-");
            } else if ('+' != numeroSigno.charAt(0) && '-' == numeroSigno.charAt(0)) {
                numeroSigno = numeroSigno.replace("-", "+");
            } else {
                numeroSigno = '-' + cajaRecogida.getText().toString();
            }
        }
        cajaRecogida.setText(numeroSigno);
    }

    /**
     * Funcion onclick asignada al boton % que hace justo esta operación
     * @param v
     */
    public void porcentajeOperacion(View v) {
        if (!cajaRecogida.getText().toString().isEmpty()) {
            operaciones.setSimbolo("%");
            operaciones.setOperador1(cajaRecogida.getText().toString());
            cajaOperaciones.setText(operaciones.getResultado());
            cajaRecogida.setText("");
        }
        operaciones.vaciar();
    }
}
