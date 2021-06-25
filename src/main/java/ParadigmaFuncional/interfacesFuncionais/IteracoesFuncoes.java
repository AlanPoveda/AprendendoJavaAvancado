package ParadigmaFuncional.interfacesFuncionais;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IteracoesFuncoes {
    public static void main(String[] args) {
        String[] nomes = {"Alan", "Natalia", "Hernando", "Gabriela"};
        Integer[] numeros = {1,2,3,4,5};

        imprimirNomesFiltrados(nomes);
        ImprimirODoborDosNumeros(numeros);
        mosrtandoProfissoes();

    }

    public static void imprimirNomesFiltrados(String... nomes){
        //Forma de verbosa de ser feita
        String nomesparaImprimir="";
        for(int i = 0 ; nomes.length > i; i++){
            if (nomes[i].equals("Hernando")){
                nomesparaImprimir+= nomes[i];
            }
        }
        System.out.println("Nome usando for: "+nomesparaImprimir);

        //Forma avançada de fazer, e mais completa
        String nomesMelhorForma =
                Stream.of(nomes)
                .filter(nome -> nome.equals("Gabriela"))
                .collect(Collectors.joining());

        System.out.println("Nomes usando Stream: "+ nomesMelhorForma);

        //Forma Com o for
        System.out.println("Imprimido pelo For");
        for (int y = 0 ; y < nomes.length; y++){
            System.out.println(nomes[y]);
        }

        //Mostrar todos os nomes usando stream, como se estivesse percorrendo a array
        System.out.println("Imprimido pelo Stream");
        Stream.of(nomes).forEach(System.out::println);

    }
    //Imprimir o dobro do número da lista
    public static void ImprimirODoborDosNumeros(Integer[] numeros){
        System.out.println("Imprimindo usando o for: ");
        for(Integer num: numeros){
            System.out.println(num*2);
        }


        System.out.println("Imprimindo usando Stream");
        //Dessa forma usou map para percorrer, e ainda executou uma funçõa, depois cri
        Stream.of(numeros).map(num->num*2).forEach(System.out::println);

    }
    //Forma de fazer a Stream sem precisar chamar em si a stream
    public static void mosrtandoProfissoes(){
        List<String> listaProfisoes = new ArrayList<>();
        listaProfisoes.add("Densevolvedor");
        listaProfisoes.add("Testador");
        listaProfisoes.add("Gerente de projeto");
        listaProfisoes.add("Gerente de qualidade");

        //Filter vai mostrar
        listaProfisoes.stream().filter(profissoes -> profissoes.startsWith("Gerente")).forEach(System.out::println);

    }

}
