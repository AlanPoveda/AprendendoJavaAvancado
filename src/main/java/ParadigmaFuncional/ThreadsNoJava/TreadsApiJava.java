package ParadigmaFuncional.ThreadsNoJava;

public class TreadsApiJava {
    public static void main(String[] args) {
        GeradorPdf iniciarGeradorPdf = new GeradorPdf();
        BarradeCarregamento iniciarBarraDeCarregamento = new BarradeCarregamento(iniciarGeradorPdf);

        iniciarGeradorPdf.start();
        iniciarBarraDeCarregamento.start();

    }
}

class GeradorPdf extends Thread{
    @Override
    public void run(){
        try{
            System.out.println("Iniciar gerador de PDF");
            Thread.sleep(5000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }System.out.println("Gerar PDF");
    }


}

class BarradeCarregamento extends Thread{
    private Thread iniciarGeradorPdf;

    public BarradeCarregamento(Thread iniciarGeradorPdf){
        this.iniciarGeradorPdf = iniciarGeradorPdf;

    }


    @Override
    public void run(){
        while(true){
            try{
                Thread.sleep(500);

                if(!iniciarGeradorPdf.isAlive()){
                    break;
                }
                System.out.println("Carregando...");

            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}