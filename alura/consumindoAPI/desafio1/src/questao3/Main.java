package questao3;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main {
    public static void main(String[] args) {
        String json = "{\"Title\":\"percy\",\"Author\":\"verissimo\",\"Editora\":{\"id\":\"1234\"}}";

        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .create();

        Livro livro = gson.fromJson(json, Livro.class);

        System.out.println(livro.toString());

    }
}
