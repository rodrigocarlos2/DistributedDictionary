import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by ricardo on 30/03/2017.
 */
public class Peers {
    int id;
    ArrayList <String> lista_palavras = new ArrayList <String>();
    ArrayList <String> lista_significados = new ArrayList<String>();
    int[] vizinhos;

    public Peers(int id){

        this.id = id;
    }

    public int procurarPalavra(String palavra){

        for(int i = 0; i<lista_palavras.size(); i++){
            if(lista_palavras.get(i).equalsIgnoreCase(palavra)){
                return i;
            }
        }
        return -1;
    }

    public String getSignificado(int index) {

        return lista_significados.get(index);
    }

    public void caregarPalavras(String s){
        if (s!=null)
            lista_palavras.add(s);
    }

    public void caregarSignificados(String s){
        if (s!=null)
            lista_significados.add(s);
    }

    public void impressor(){
        for(int i = 0; i < lista_palavras.size(); i++){
            System.out.println(lista_palavras.get(i));
        }
    }

    public void setVizinhos(int qunt){

        vizinhos = new int[qunt];
    }

}
