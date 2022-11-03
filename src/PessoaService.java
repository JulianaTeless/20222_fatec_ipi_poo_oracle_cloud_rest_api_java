import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
//import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.*;
import org.json.JSONArray;
import org.json.JSONObject;

//import java.util.logging.FileHandler;
import lombok.RequiredArgsConstructor;
import lombok.var;

@RequiredArgsConstructor// gerar construtor para inicializar variaveis
public class PessoaService {
    
    private  HttpClient client = HttpClient.newHttpClient(); //cliente http, variavel de referencia
    private final String url;//constante

   
    public List<Pessoa> listar(){
      List <Pessoa> pessoas = new ArrayList<Pessoa>();
      try{
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();

       var response = client.send(request, BodyHandlers.ofString()); //manipulador de corpo de resposta com o conteúdo de uma Striong
       //envia a requisição
      // System.out.println(response.body());

       JSONObject raiz = new JSONObject(response.body());
       // itens é um objeto json, e iremos armazena-lo, mais propriamente, iremos armazenar o corpo desse objeto

      // Como representar a lista de itens?

      // qual o nome do array que é um objeto JSON?
      JSONArray items = raiz.getJSONArray("items");

      //JSONObject primeiro = items.getJSONObject(0);
      

       for(int i=0 ; i< items.length() ; i++){
        JSONObject lista = items.getJSONObject(i);
        String nome = lista.getString("nome");
        int idade = lista.getInt("idade");
        String hobby = lista.getString("hobby");
        //System.out.printf("Nome: %s, Idade: %d, Hobby: %s \n", nome, idade,hobby);
        Pessoa p = new  Pessoa();
        p.setNome(nome);
        p.setIdade(idade);
        p.setHobby(hobby);
        //System.out.println(p);
        //Pessoa@78564a85
       // System.out.println("********************");
       pessoas.add(p);
       }
       
      //empacotar e ganhar métodos para manipular 
       //System.out.println(raiz);
       //JSONArray items = raiz.getJSONArray("items");
       //JSONObject primeiro = items.getJSONObject(0);
       //System.out.println(primeiro);
       //String nome = primeiro.getString("nome");
        //System.out.println(nome);

        //como pegar apenas a string nome ?


    }  
      catch(Exception e){
        System.out.println(e.getMessage());
        e.printStackTrace();
      } return pessoas;
    }
   
}
