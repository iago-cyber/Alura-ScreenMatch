import alura.screenmatch.modelos.Filme;

public class Main {
    public static void main(String[] args) {

        Filme meuFilme = new Filme();

        meuFilme.setNome("O poderoso chefão");
        meuFilme.setAnoDeLancamento(1970);
        meuFilme.setDuracaoEmMinutos(180);

        meuFilme.ExibeFichaTecnica();

        meuFilme.avalia(8.0);
        meuFilme.avalia(5.0);
        meuFilme.avalia(10.0);

    }
}