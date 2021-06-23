package ParadigmaFuncional;

import java.util.Arrays;

public class ComposicoesDeFuncoes {
    //Funções receber duas funções
    public static void main(String[] args){

        int[] valores = {1,2,3,4};

        //Paradigmas funcional
        Arrays.stream(valores)
                .filter(numero->numero%2==0)
                .map(numero->numero*2)
                .forEach(System.out::println);

        //Paradigma interativo
        for (int i = 0; valores.length > i; i++){
            int valor = 0;
            if (valores[i]%2==0){
                valor = valores[i]*2;
                if(valor != 0){
                    System.out.println(valor);
                }
            }
        }
    }



}
