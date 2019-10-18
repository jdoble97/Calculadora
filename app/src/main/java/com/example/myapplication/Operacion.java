package com.example.myapplication;

public class Operacion {
    private String operador2;
    private String operador1;
    private float memoria;
    private String resultado;
    private String tipo;
    private String simboloOpreacion;

    public Operacion(){
        operador1 = "";
        operador2 = "";
        resultado = "";
        memoria = 0;
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

    public void setSimboloOpreacion(String temp){this.simboloOpreacion="temp";}

    public String toString(){

        return this.operador1+" "+this.simboloOpreacion+" "+this.operador2;
    }
}
