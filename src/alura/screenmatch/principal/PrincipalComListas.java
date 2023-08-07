package alura.screenmatch.principal;

import alura.screenmatch.modelos.Filme;
import alura.screenmatch.modelos.Serie;
import alura.screenmatch.modelos.Titulo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.LinkedList;


public class PrincipalComListas {
    public static void main(String[] args) {
        Filme meuFilme = new Filme("O poderoso chefão", 1970);
        Serie lost = new Serie("Lost",2004);
        Filme outroFilme = new Filme("Avatar o caminho da agua", 2022);

        //ArrayList<Titulo> lista = new ArrayList<>();
        List<Titulo> lista = new LinkedList<>();
        lista.add(meuFilme);
        lista.add(outroFilme);
        lista.add(lost);

        System.out.println("Antes de ordenar: "+lista);
        Collections.sort(lista);// Para funcionar precisa de um comparable implementado na classe, aqui no caso "Titulo"
        System.out.println("Depois da ordenação por nome: "+lista);
        lista.sort(Comparator.comparing(Titulo::getAnoDeLancamento));
        System.out.println("Organizado pelo ano: "+lista+"\n");

        for (Titulo item:lista) {
            System.out.println(item);
          //if(item instaceof Filme filme){ //a partir do java 14 da pra declarar a variavel no proprio instanceof
            if(item instanceof Filme){
                Filme filme = (Filme) item;
                System.out.println("Classificação "+ filme.getClassificacao());
            }
        }

    }
}
