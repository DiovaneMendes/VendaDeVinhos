import br.com.vinhos.DTO.HistoricoDTO;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Spike {
    public static void main(String[] args) {

        Gson gson = new Gson();

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("http://www.mocky.io/v2/598b16861100004905515ec7")
                .build();

        try {
            Response response = client.newCall(request).execute();

            Type listaHistoricoType = new TypeToken<ArrayList<HistoricoDTO>>(){}.getType();

            List<HistoricoDTO> lista = gson.fromJson(response.body().string(), listaHistoricoType);

            lista.forEach(System.out::println);

        } catch (IOException e) {
            e.getMessage();
        }
    }
}
