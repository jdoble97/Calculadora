package com.example.myapplication;

public class Operacion {
    private String operador2;
    private String operador1;
    private float memoria;
    private String resultado;
    private String tipo;
    private String simbolo;

    public Operacion(){
        operador1 = "";
        operador2 = "";
        resultado = "";
        memoria = 0;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

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

    public String getOperacion(){
        String result="";
        switch(simbolo){
            case "+":
                double operacion = Double.parseDouble(operador1)+Double.parseDouble(operador2);
                result = Double.toString(operacion);
                break;
            case "-":
                break;
            case "*":
                break;
            case "/":
                break;
            case "%":
                break;
        }
        return result;
    }
    public String getResultado(){
        resultado = getOperacion();
        double numero = Double.parseDouble(resultado);
        double decimal = numero % 1;
        if (decimal>0){
            return resultado;
        }else{
            int temporal = (int)numero;
            resultado = Integer.toString(temporal);
            return resultado;
        }
    }
    public void cambiarComa(){
        operador1 = operador1.replace(",",".");
        operador2 = operador2.replace(",",".");
    }
}
