import br.com.vinhos.DTO.ClienteDTO;
import br.com.vinhos.DTO.HistoricoDTO;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class Spike {
    public static void main(String[] args) {

        HttpClient client = HttpClient.newHttpClient();

//        HttpRequest request = HttpRequest.newBuilder()
//                .uri(URI.create("http://www.mocky.io/v2/598b16291100004705515ec5"))
//                .GET()
//                .build();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://www.mocky.io/v2/598b16861100004905515ec7"))
                .GET()
                .build();

        HttpResponse<String> response = null;

        Gson gson = new Gson();

        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());

//            Type listaClienteType = new TypeToken<ArrayList<ClienteDTO>>(){}.getType();
//
//            List<ClienteDTO> lista = gson.fromJson(response.body(), listaClienteType);
//
//            lista.forEach(System.out::println);

            Type listaHistoricoType = new TypeToken<ArrayList<HistoricoDTO>>(){}.getType();

            List<HistoricoDTO> lista = gson.fromJson(response.body(), listaHistoricoType);

            lista.forEach(System.out::println);

        } catch (IOException e) {
            e.getMessage();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
