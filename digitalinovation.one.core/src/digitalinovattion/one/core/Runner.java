package digitalinovattion.one.core;

import digitalinovation.one.utils.Calculadora;

//Criando um novo módulo, vc faz para poder protegar
//Você pode exportar porém vc não pode ler o que acontece
public class Runner {
    public static void main(String[] args) {
        Calculadora calculadora = new Calculadora();
        System.out.println(calculadora.sum(4,6));

    }
}
