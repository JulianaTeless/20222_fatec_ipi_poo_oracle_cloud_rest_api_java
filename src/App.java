import java.io.FileInputStream;
//import java.net.URL5;
import java.util.Properties;

public class App {
    public static void main(String[] args) throws Exception {
        Properties properties = new Properties();
        properties.load(new FileInputStream("src/app.properties"));
        String URL = properties.getProperty("URL");
        PessoaService service = new PessoaService(URL);
        service.listar();
    }
}
