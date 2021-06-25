package aula11;

import java.io.IOException;
import java.net.ProxySelector;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class HttpApiJava11 {

    //Aqui cria uma thread que somente vai ter 6 threads no máximo
    static ExecutorService executor = Executors.newFixedThreadPool(6, new ThreadFactory() {
        @Override
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            System.out.println("Nova thread criada: " + (thread.isDaemon() ? "daemon" : "") + "Thread group" + thread.getThreadGroup());
            return thread;
        }
    });



    public static void main(String[] args) throws Exception{
        //fazendoRequisicao();
        connecAkanaiHttp1Client();

    }

    //Fazendo requisição usando o HTTP1, que somente pode receber 6 threads
    private static void connecAkanaiHttp1Client() throws Exception{
        System.out.println("Http 1 example ...");
        try {
            HttpClient httpClient = HttpClient.newBuilder()
                    .version(HttpClient.Version.HTTP_1_1)
                    .proxy(ProxySelector.getDefault())
                    .build();
            //Medir performace, tempo inicial
            long start = System.currentTimeMillis();

            HttpRequest mainRequest = HttpRequest.newBuilder()
                    .uri(URI.create("https://http2.akamai.com/demo/h2_demo_frame.html"))
                    .build();

            //Mandar a requisição
            HttpResponse<String> response = httpClient.send(mainRequest, HttpResponse.BodyHandlers.ofString());

            //Status code
            System.out.println("Staus code: " + response.statusCode());
            //Header
            System.out.println("Header: " + response.headers());
            //Body
            String responseBody = response.body();
            System.out.println(responseBody);



            //Aqui para mostrar que é uma função assincrona
            List<Future<?>> future = new ArrayList<>();

            responseBody
                    .lines()
                    .filter(line -> line.trim().startsWith("<img height="))
                    .map(line -> line.substring(line.indexOf("src=") + 5, line.indexOf("/>")))
                    .forEach(img ->{
                        Future<?> imgfuture = executor.submit(()->{
                            HttpRequest imgRequest = HttpRequest.newBuilder()
                                    .uri(URI.create("https://http2.akamai.com"+img))
                                    .build();

                            try {
                                HttpResponse<String> imageResponse = httpClient.send(imgRequest, HttpResponse.BodyHandlers.ofString());
                                System.out.println("Imagem Carregada "+img+", Status code: "+imageResponse.statusCode());
                            } catch (IOException | InterruptedException e) {
                                System.out.println("Mensagem de erro, que ocorreu durante a requisição da imagem" + img);
                            }
                        });
                        future.add(imgfuture);
                        System.out.println("Submetidas as imagens futuras: "+img);
                    });
            future.forEach(f->{
                try {
                    f.get();
                } catch (InterruptedException | ExecutionException e) {
                    System.out.println("Erro a carregar a imagem do futuro");
                }
            });

            //Finalização da performace, tempo final
            long end = System.currentTimeMillis();
            System.out.println("Tempo de carregamento final: "+(end-start)+" ms ");

        } finally {
            executor.shutdown();
        }
    }

    private static void fazendoRequisicao() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .GET() //metodo get
                .uri(URI.create("https://docs.oracle.com/javase/10/language/"))
                .build();

        HttpClient httpClient = HttpClient.newHttpClient();

        //Aqqui esta pegando a resposta do get e guartando no response
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        //Status code
        System.out.println("Status code: "+ response.statusCode());
        //Headers
        System.out.println("Headers: "+response.headers());
        //Corpo da resposta
        System.out.println(response.body());
    }

}
