package alura.screenmatch.modelos;

import alura.screenmatch.excecao.ConversaoDeAnoException;

public class Titulo implements Comparable<Titulo>{
    private String nome;
    private int anoDeLancamento;
    private boolean incluidoNoPlano;
    private double somaDasAvaliacoes;
    private int totalDeAvaliacoes;
    private int duracaoEmMinutos;

    public Titulo(String nome, int anoDeLancamento ){
        this.nome = nome;
        this.anoDeLancamento = anoDeLancamento;
    }

    public Titulo(TituloOmdb tituloOmdb) {
        this.nome = tituloOmdb.title();
        if(tituloOmdb.year().length()>4) {
            throw new ConversaoDeAnoException("Não pude converter o ano, pois tem mais de 4 caracteres.");
        }
        this.anoDeLancamento = Integer.valueOf(tituloOmdb.year());
        this.duracaoEmMinutos = Integer.valueOf(tituloOmdb.runtime().substring(0,3));
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getNome() {
        return nome;
    }
    public void setAnoDeLancamento(int anoDeLancamento) {
        this.anoDeLancamento = anoDeLancamento;
    }
    public int getAnoDeLancamento() {
        return anoDeLancamento;
    }
    public boolean getIncluidoNoPlano() {
        return incluidoNoPlano;
    }
    public void setIncluidoNoPlano(boolean incluidoNoPlano) {
        this.incluidoNoPlano = incluidoNoPlano;
    }
    public int getTotalDeAvaliacoes() {
        return totalDeAvaliacoes;
    }
    public void setDuracaoEmMinutos(int duracaoEmMinutos) {
        this.duracaoEmMinutos = duracaoEmMinutos;
    }
    public int getDuracaoEmMinutos() {
        return duracaoEmMinutos;
    }
    public void ExibeFichaTecnica(){
        System.out.println("Nome do filme: "+ this.nome);
        System.out.println("Ano de lançamento: "+ this.anoDeLancamento);
        System.out.println("Duração: "+ getDuracaoEmMinutos());
    }

    public void avalia(Double nota){
        somaDasAvaliacoes += nota;
        totalDeAvaliacoes++;
    }
    public double pegaMedia(){
        return somaDasAvaliacoes/totalDeAvaliacoes;
    }

    @Override
    public int compareTo(Titulo outroTitulo) {
        return this.getNome().compareTo(outroTitulo.getNome());
    }

    @Override
    public String toString() {
        return "(Nome= "+ nome +
                ", Ano de lancamento= "+ anoDeLancamento+
                ", Duração= "+ duracaoEmMinutos+"mins)\n" ;
    }
}
