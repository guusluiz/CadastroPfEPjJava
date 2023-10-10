import java.time.LocalDate;

public class PessoaJuridica extends Pessoa {
    public String cnpj ;
    public String razaoSocial;

    public float CalcularImposto(float rendimento){
        if (rendimento <= 3000){
            return  rendimento *0.03f;
        } else if (rendimento <= 6000) {
            return rendimento * 0.05f;
        } else if (rendimento <= 10000) {
            return rendimento * 0.07f;
        } else {
            return rendimento * 0.09f;
        }
    }
}
