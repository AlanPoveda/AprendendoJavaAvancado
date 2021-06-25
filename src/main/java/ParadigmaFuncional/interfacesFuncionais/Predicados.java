package ParadigmaFuncional.interfacesFuncionais;

import java.util.function.Predicate;

public class Predicados {
    public static void main(String[] args) {
        Predicate<String>  estaVazio = valor -> valor.isEmpty();
        System.out.println(estaVazio.test(""));
        System.out.println(estaVazio.test("Alan Poveda"));

        //Outra forma de implementar
        Predicate<String> estaVazio2 = String::isEmpty;
        System.out.println(estaVazio2.test(""));
        System.out.println(estaVazio2.test("Alan Poveda"));

    }

}
