package ParadigmaFuncional.ThreadsNoJava;

import java.util.stream.IntStream;

public class ParaleStreamExemplo {
    public static void main(String[] args) {
        long init = System.currentTimeMillis();
        IntStream.range(1,100000).forEach(num-> fatorial(num)); //Serial
        long fim = System.currentTimeMillis();
        System.out.println("Tempo de execução Serial ::" + (fim-init));

        init = System.currentTimeMillis();
        IntStream.range(1,100000).parallel().forEach(num-> fatorial(num)); //Parallel
        fim = System.currentTimeMillis();
        System.out.println("Tempo de execução Parallel::" + (fim-init));
    }

    public static long fatorial(long num){
        int fat = 1;

        for(long i = 2; i <= num; i++){
            fat*=i;
        }
        return fat;
    }
}
