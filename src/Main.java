import alura.screenmatch.calculos.CalculadoraDeTempo;
import alura.screenmatch.calculos.FiltroRecomendacao;
import alura.screenmatch.modelos.Episodio;
import alura.screenmatch.modelos.Filme;
import alura.screenmatch.modelos.Serie;

public class Main {
    public static void main(String[] args) {

        Filme meuFilme = new Filme();
        meuFilme.setNome("O poderoso chefão");
        meuFilme.setAnoDeLancamento(1970);
        meuFilme.setDuracaoEmMinutos(175);
        meuFilme.avalia(8.0);
        meuFilme.avalia(5.0);
        meuFilme.avalia(10.0);

        Serie lost = new Serie();
        lost.setNome("Lost");
        lost.setAnoDeLancamento(2004);
        lost.setTemporadas(10);
        lost.setEpisodiosPorTemporada(10);
        lost.setMinutosPorEpisodio(55);

        Filme outroFilme = new Filme();
        outroFilme.setNome("Avatar o caminho da agua");
        outroFilme.setAnoDeLancamento(2022);
        outroFilme.setDuracaoEmMinutos(192);

        CalculadoraDeTempo calculadora = new CalculadoraDeTempo();
        calculadora.inclui(meuFilme);
        calculadora.inclui(outroFilme);
        calculadora.inclui(lost);
        System.out.println(calculadora.getTempoTotal());

        FiltroRecomendacao filtro = new FiltroRecomendacao();
        filtro.filtra(meuFilme);

        Episodio episodio = new Episodio();
        episodio.setNumero(1);
        episodio.setSerie(lost);
        episodio.setTotalVisualizacoes(300);
        filtro.filtra(episodio);
    }
}