package ParadigmaFuncional.interfacesFuncionais;

import java.util.function.Supplier;

//Supridores eles não recebem parâmetro e retornam o que especificar no generics
public class SupliersApi {
    public static void main(String[] args) {
        //Sem parâmetro, pode usar a arrow function () -> newPessoa()  nesse caso
        Supplier<Pessoa> suplies = () -> new Pessoa();
        System.out.println(suplies.get());

        //Outra forma de fazer
        Supplier<Pessoa> suplies2 = Pessoa::new;
        System.out.println(suplies2.get());
    }
}

class Pessoa{
    private String nome;
    private Integer idade;

    public Pessoa(){
        nome = "Alan";
        idade = 25;
    }

    //Sem isto ele não vai mostrar a string se der o System.out.println()
    @Override
    public String toString(){
        return String.format(" O nome da pessoa é: %s, e idade %d ", nome, idade);
    }


}

