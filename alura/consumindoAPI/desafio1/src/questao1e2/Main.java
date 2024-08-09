package questao1e2;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main {
    public static void main(String[] args) {

        //String json = "{\"Nome\":\"juju\",\"Idade\":\"19\",\"Cidade\":\"sorocaba\"}";
        String jsonRelaxed = "{\"Nome\":\"juju\",\"Idade\":\"19\"}";

        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .create();

        Pessoa pessoa = gson.fromJson(jsonRelaxed, Pessoa.class);

        System.out.println(pessoa.toString());
    }
}