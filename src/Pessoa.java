import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Pessoa {
  
    private int codigo;
    private String nome;
    private int idade;
    private String hobby;

    //toString , toda classe tem uma superclasse
    // no java toda classe herda de object 

    @Override
    public String toString() {
        
        return String.format("nome: %s", nome);
    }
}
