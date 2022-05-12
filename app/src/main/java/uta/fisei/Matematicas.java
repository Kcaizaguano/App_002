package uta.fisei;

public class Matematicas {

    public long Potencia (int base, int potencia){
        long resultado = 1;
        for (int i=1; i <= potencia; i++){
            resultado *= base;
        }
         return  resultado;
    }

    public static  int sumar(int a, int b){
        return  a +b;
    }


}
