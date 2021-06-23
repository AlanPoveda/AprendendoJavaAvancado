package ParadigmaFuncional.interfacesFuncionais;

import java.util.function.Consumer;

public class Consumidores {
    public static void main(String[] args) {
        //Usando consumers

        Consumer<String> imprimirUmaFrase = System.out::println;
        //necessário ter um accept
        imprimirUmaFrase.accept("Olá como estas?");



    }

}
