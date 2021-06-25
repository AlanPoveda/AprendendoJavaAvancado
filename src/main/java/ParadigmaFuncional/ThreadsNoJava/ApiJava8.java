package ParadigmaFuncional.ThreadsNoJava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ApiJava8 {

    private static final ExecutorService threadPoll = Executors.newFixedThreadPool(3);
    public static void main(String[] args) {
        Casa casa = new Casa(new Quarto());
        casa.obeterAfazeresDeCasa().forEach( atividade -> threadPoll.execute(()->atividade.realizar()));
        threadPoll.shutdown();




    }
}

class Casa{
    private List<Comodo> comodos;

    Casa(Comodo... comodos){
        this.comodos = Arrays.asList(comodos);
    }

    List<Atividade> obeterAfazeresDeCasa(){
        return this.comodos.stream().map(Comodo::obterAfazeresDoComodo)
                .reduce(new ArrayList<Atividade>(), (pivo, atividades) ->{
                    pivo.addAll(atividades);
                    return pivo;
                });

    }


}

interface Atividade{
    void realizar();
}

abstract class Comodo{
    abstract List<Atividade> obterAfazeresDoComodo();
}


class Quarto extends Comodo{
    @Override
    List<Atividade> obterAfazeresDoComodo(){
        return Arrays.asList(this::arrumarACama, this::varrerOQuarto, this::arrumarGuardaRoupa);

    }

    private void arrumarACama(){
        System.out.println("Arrumar a cama");
    }
    private void varrerOQuarto(){
        System.out.println("Varrer o quarto");
    }
    private void arrumarGuardaRoupa(){
        System.out.println("Arrumar guarda roupa");
    }

}