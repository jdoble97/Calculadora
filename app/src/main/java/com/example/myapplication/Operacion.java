package com.example.myapplication;

public class Operacion {
    private float operador1;
    private float operador2;
    private float memoria;
    private String resultado;
    private String tipo;



    public Operacion(){
        operador1 = 0;
        operador2 = 0;
        resultado = "";
        memoria = 0;
    }

    public float getOperador1() {
        return operador1;
    }

    public void setOperador1(float operador1) {
        this.operador1 = operador1;
    }

    public float getOperador2() {
        return operador2;
    }

    public void setOperador2(float operador2) {
        this.operador2 = operador2;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public float getMemoria() {
        return memoria;
    }

    public void setMemoria(float memoria) {
        this.memoria = memoria;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
