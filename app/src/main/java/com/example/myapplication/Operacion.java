package com.example.myapplication;

import java.text.DecimalFormat;

public class Operacion {
    private String operador2;
    private String operador1;
    private float memoria;
    private String resultado;
    private String simbolo;
    private String idioma;

    public Operacion(){
        operador1 = "";
        operador2 = "";
        resultado = "";
        memoria = 0;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public String getOperador1() {
        return operador1;
    }

    public void setOperador1(String operador1) {
        this.operador1 = operador1;
    }

    public String getOperador2() {
        return operador2;
    }

    public void setOperador2(String operador2) {
        this.operador2 = operador2;
    }


    public float getMemoria() {
        return memoria;
    }

    public void setMemoria(float memoria) { this.memoria = memoria;}


    public void setSimbolo(String simbolo){this.simbolo=simbolo;}

/**
 * muestra los contenidos del primer digito1, simbolo, digito2
 * return string
 */
    public String getSimbolo(){
        return this.simbolo;
    }

    public String toString(){
        return this.operador1+" "+this.simbolo+" "+this.operador2+"=";
    }
/**
 * Devuelve un String despues de Realizar suma, resta, multimplicacion
 * return String de resultado
 * */
    public String getOperacion(){
        double operacion;
        String result="";
        if(idioma.equals(",")){
            comaToPunto();
        }
        switch(simbolo){
            case "+":
                operacion = Double.parseDouble(operador1)+Double.parseDouble(operador2);
                result = Double.toString(operacion);
                break;
            case "-":
                operacion = Double.parseDouble(operador1)-Double.parseDouble(operador2);
                result = Double.toString(operacion);
                break;
            case "*":
                operacion = Double.parseDouble(operador1)*Double.parseDouble(operador2);
                result = Double.toString(operacion);
                break;
            case "/":
                operacion = Double.parseDouble(operador1)/Double.parseDouble(operador2);
                result = Double.toString(operacion);
                break;
            case "%":
                operacion = Double.parseDouble(operador1)/100;
                resultado = Double.toString(operacion);

                break;
        }
        return result;
    }
    /**
     * recibo el resultado en String, lo parceo a double,
     * */
    public String getResultado(){
        resultado = getOperacion();
        double numero = Double.parseDouble(resultado);
        double decimal = numero % 1;
        if (decimal>0 || decimal<0){
            if(idioma.equals(",")){
                puntoToComa();
            }
            return resultado;
        }else{
            int temporal = (int)numero;
            resultado = Integer.toString(temporal);
            return resultado;
        }

    }
    public String getResultadoPorcentaje(){
        if(idioma.equals(",")){
            resultado=getResultado();
            puntoToComa();
            return resultado;
        }
        else{
            return resultado;
        }
    }
    /**
     * cambia comas(,) por un puntos en los operadores cuando esta en español
     * */
    public void comaToPunto(){
        operador1 = operador1.replace(",",".");
        operador2 = operador2.replace(",",".");
    }
    /**
     * Cambia puntos por comas
     * */
    public void puntoToComa(){
        resultado = resultado.replace(".",",");
    }
    public void vaciar(){
        operador1 = "";
        operador2 = "";
        simbolo   = "";
    }
}
