package alura.screenmatch.principal;

import alura.screenmatch.excecao.ConversaoDeAnoException;
import alura.screenmatch.modelos.Titulo;
import alura.screenmatch.modelos.TituloOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrincipalComBusca {
    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner scanner = new Scanner(System.in);
        String busca = "";
        List<Titulo> titulos = new ArrayList<>();
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();

        while(!busca.equalsIgnoreCase("sair")) {
            System.out.println("Qual filme deseja pesquisar?");
            busca = scanner.nextLine();
            if(busca.equalsIgnoreCase("sair")){
                break;
            }
            String endereco = "http://www.omdbapi.com/?t=" + busca.replace(" ", "+") + "&apikey=807deb21";
            System.out.println(endereco);

            try {
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(endereco))
                        .build();
                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
                String json = response.body();
                System.out.println(json);

                TituloOmdb tituloOmdb = gson.fromJson(json, TituloOmdb.class);
                System.out.println(tituloOmdb);

                Titulo titulo = new Titulo(tituloOmdb);
                System.out.println("Titulo convertido:\n");
                System.out.println(titulo);

                titulos.add(titulo);

            } catch (NumberFormatException e) {
                System.out.println("Erro!");
                System.out.println(e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("Algum erro de argumento na busca, verifique o endereço.");
            } catch (ConversaoDeAnoException e) {
                System.out.println(e.getMessage());
            }

        }
        System.out.println(titulos);
        FileWriter escrita = new FileWriter("filmes.json");
        escrita.write(gson.toJson(titulos));
        escrita.close();
        System.out.println("O programa finalizou!");

    }
}
