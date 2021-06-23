package ParadigmaFuncional.interfacesFuncionais;

import java.util.function.Function;

public class Funcoes {
    public static void main(String[] args) {

        Function<String, String> retornarNomeaoContrario = texto ->  new StringBuilder(texto).reverse().toString();
        Function<String, Integer> retornaroDobroDoValor = texto2 -> Integer.parseInt(texto2) * 2;

        System.out.println(retornaroDobroDoValor.apply("23"));
        System.out.println(retornarNomeaoContrario.apply("Alan Poveda"));

    }


}
