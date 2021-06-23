package ParadigmaFuncional;

import java.util.function.UnaryOperator;

public class Aula01 {
    public static void main(String[] args){
        int valor = 10; //Intrução
        int resultado = valor * 3;
        System.out.println("O resultado é: " + resultado);

        //Usando o paradigma funcional para o mesmo exemplo

        UnaryOperator<Integer> calcularValorVezes3 = valorN -> valorN*3;
        int valorNovo = 10;
        System.out.println("O resultado é :"+ calcularValorVezes3.apply(10));

    }

}
