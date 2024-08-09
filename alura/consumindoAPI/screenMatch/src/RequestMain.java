import br.com.alura.models.Movie;
import br.com.alura.models.OMBDbTitle;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;
import com.google.gson.GsonBuilder;

public class RequestMain {
    public static void main(String[] args) throws IOException, InterruptedException {

        String apikey = "1e4cf23f";
        Scanner sc = new Scanner(System.in);
        System.out.print("Qual filme deseja buscar?\nR:");
        String search = sc.nextLine();
        if (search.contains(" ")) {
            search = search.replaceAll(" ", "+");
        }

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://www.omdbapi.com/?t=" + search + "&apikey=" + apikey))
                .build();

        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());
        //System.out.println(response.body());

        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE) // lower case == upper case
                .create();

        OMBDbTitle myOmdbTitle = gson.fromJson(response.body(), OMBDbTitle.class);
        System.out.println(myOmdbTitle);
        System.out.println("other test");
        System.out.println(response.body());

        //Movie omdbMovie = new Movie(myOmdbTitle);
    }
}
