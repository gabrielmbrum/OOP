import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class MainGoogleBooksAPI {
    public static void main(String[] args) throws IOException, InterruptedException {
        String API_KEY = "AIzaSyBNWXhLh3Z-GNPGkx9hWYqo_taZnpcPC3c";
        Scanner sc = new Scanner(System.in);
        System.out.println("\tGoogle Books API");

        System.out.print("Digite o nome do livro que deseja buscar\nR: ");
        String search = sc.nextLine();

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://www.googleapis.com/books/v1/volumes?q=" + search + "&key=" + API_KEY))
                .build();

        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.body());

    }
}