import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class MainCoinGeckoAPI {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner sc = new Scanner(System.in);
        String search, currency;

        System.out.println("CoinGecko API");

        System.out.print("Digite qual criptomoeda deseja consultar:\nR: ");
        search = sc.nextLine();

        System.out.print("Qual moeda deseja utilizar para cotação?\nR: ");
        currency = sc.nextLine();

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.coingecko.com/api/v3/simple/price?ids=" + search + "&vs_currencies=" + currency))
                .build();

        HttpResponse<String> response = client
                .send(request,  HttpResponse.BodyHandlers.ofString());

        System.out.println(response.body());
    }
}
