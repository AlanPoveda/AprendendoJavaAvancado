package ParadigmaFuncional.interfacesFuncionais;

public class FuncaoAltaOrdem {
    //psvm ja faz o static main
    public static void main(String[] args) {
        //O quer sera feito quando for retornado o valor
        Calculo SOMA = (a,b) -> a+b;
        Calculo SUBTRACAO = (a,b) -> a-b;
        Calculo MULTIPLPICACAO = (a,b) -> a*b;
        Calculo DIVISAO = (a,b) -> a/b;

        System.out.println(executarOperacao(SOMA, 1, 4 ));
        System.out.println(executarOperacao(SUBTRACAO, 1, 4 ));
        System.out.println(executarOperacao(MULTIPLPICACAO, 1, 4 ));
        System.out.println(executarOperacao(DIVISAO, 4, 2 ));

    }

    //Aqui esta sendo chamado o calculo como parâmetro, como se fosse uma função. Função de alta ordem
    public static int executarOperacao(Calculo parametro, int a, int b){
        return parametro.calcular(a, b);

    }

}
//Funçao para retornar como parâmetro para outra função
@FunctionalInterface
interface Calculo{
    public int calcular(int a, int b);
}