package alura.screenmatch.modelos;

import alura.screenmatch.calculos.Classificavel;

public class Filme extends Titulo implements Classificavel {

    public Filme(String nome, int anoDeLancamento){
        super(nome, anoDeLancamento);
    }
    private String diretor;
    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }
    public String getDiretor() {
        return diretor;
    }
    @Override
    public int getClassificacao(){
        return (int) pegaMedia() /2;
    }
    @Override
    public String toString() {
        return "Filme: "+getNome()+"("+getAnoDeLancamento()+")";
    }

}
