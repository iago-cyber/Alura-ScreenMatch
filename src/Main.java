import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Filme meuFilme = new Filme();

        meuFilme.nome = "O poderoso chefão";
        meuFilme.anoDeLancamento = 1970;
        meuFilme.duracaoEmMinutos = 180;

        meuFilme.ExibeFichaTecnica();

        meuFilme.avalia(8.0);
        meuFilme.avalia(5.0);
        meuFilme.avalia(10.0);

    }
}