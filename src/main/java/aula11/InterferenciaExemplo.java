package aula11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.stream.Collectors;

//Aplicando relases
public class InterferenciaExemplo {
    public static void main(String[] args) throws IOException {
        var url = new URL("https://docs.oracle.com/javase/10/language/");
        var urlConnection = url.openConnection();
        var bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

        System.out.println(bufferedReader.lines().collect(Collectors.joining()).replaceAll(">", ">\n"));
    }

    //Quando não usar var
    //Fora de classe
    //Como forma de parâmentro
    //Não pode utilizar em variáveis não inicializadas


}
