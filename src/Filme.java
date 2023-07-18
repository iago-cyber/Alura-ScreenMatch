public class Filme {
    String nome;
    int anoDeLancamento;
    boolean incluidoNoPlano;
    double somaDasAvaliacoes;
    int totalDeAvaliacoes;
    int duracaoEmMinutos;
    String diretor;

    void ExibeFichaTecnica(){
        System.out.println("Nome do filme: "+nome);
        System.out.println("Ano de lançamento: "+anoDeLancamento);
        System.out.println("Duração: "+ duracaoEmMinutos);
    }

    void avalia(Double nota){
        somaDasAvaliacoes += nota;
        totalDeAvaliacoes++;
    }
    double pegaMedia(){
        return somaDasAvaliacoes/totalDeAvaliacoes;
    }
}
