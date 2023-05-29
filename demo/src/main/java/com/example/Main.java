
package com.example;
import java.util.ArrayList;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        int input = 10;
        fibonacciIterativo(input);
        //fib(input).stream().forEach(integer -> System.out.println(integer));
    }

    public static List<Integer> fib(int input){
        List<Integer> serie = new ArrayList<>();

        for (int i = 0; i < input; i++){
            serie.add(calcularFibonacci(i));
        }

        return serie;
    }

    public static int calcularFibonacci(int n){
        if(n <= 1){
            return n;
        } else {
            return calcularFibonacci(n -1) + calcularFibonacci(n -2);
        }

    }
    public static int fibonacciIterativo(int n ){
        if(n <= 1)
            return n;
        int fibMenor = 0;
        int fibMenor1 = 1;
        int resultado = 0;
        for(int i = 2; i<=n; i++){
            resultado= fibMenor + fibMenor1;
            fibMenor = fibMenor1;
            fibMenor1 = resultado;
        }
        return resultado;
    }
}