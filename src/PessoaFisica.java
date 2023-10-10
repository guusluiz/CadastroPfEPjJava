import java.time.LocalDate;

public class PessoaFisica extends Pessoa {
    public String cpf;
    public LocalDate dataNasc;

    public float CalcularImposto(float rendimento) {
        if (1500 >= rendimento){
            return  0;
        } else if (rendimento <= 3500) {
            return rendimento * 0.02f;
        } else if (rendimento <= 6000) {
            return rendimento * 0.035f;
        } else {
            return rendimento * 0.05f;
        }
    }
}
