package br.com.vinhos.Component;


import br.com.vinhos.DTO.ClienteDTO;
import br.com.vinhos.DTO.HistoricoDTO;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@Component
public abstract class RequestAPI {
    private static Gson gson = new Gson();
    private static OkHttpClient client = new OkHttpClient();

    public static List<HistoricoDTO> historico(){
        Request request = retornoRequest("http://www.mocky.io/v2/598b16861100004905515ec7");

        try {
            Response response = client.newCall(request).execute();

            Type listaHistoricoType = new TypeToken<ArrayList<HistoricoDTO>>(){}.getType();

            return gson.fromJson(response.body().string(), listaHistoricoType);

        } catch (IOException e) {
            e.getMessage();
        }

        return new ArrayList<>();
    }

    public static List<ClienteDTO> cliente(){
        Request request = retornoRequest("http://www.mocky.io/v2/598b16291100004705515ec5");

        try {
            Response response = client.newCall(request).execute();

            Type listaClienteType = new TypeToken<ArrayList<ClienteDTO>>(){}.getType();

            return gson.fromJson(response.body().string(), listaClienteType);

        } catch (IOException e) {
            e.getMessage();
        }

        return new ArrayList<>();
    }

    public static Request retornoRequest(String url){
        return new Request.Builder()
                .url(url)
                .build();
    }
}
