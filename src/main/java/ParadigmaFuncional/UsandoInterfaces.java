package ParadigmaFuncional;

public class UsandoInterfaces {
    public static void main(String[] args){
        Funcao1 funcao1 = valor -> valor;

        System.out.println(funcao1.gerar("Olá Java"));

    }


}

interface Funcao1{
    String gerar(String valor);
}