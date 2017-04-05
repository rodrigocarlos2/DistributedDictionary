import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by ricardo on 30/03/2017.
 */



public class Main {

    static Peers[] p;
    static int TTL=15;

    public static void main(String[] args){


        p = new Peers[7];
        String[] vetorPalavras = new String[1];

        for(int i = 0; i < p.length; i++){
            p[i] = new Peers(i);
            vetorPalavras = Leitor.read("src/arquivos/arq_"+i +".txt").split("[&\n]");

            for(int j = 0; j < vetorPalavras.length; j++){
                if(j % 2 == 0)
                    p[i].caregarPalavras( vetorPalavras[j] );
                else
                    p[i].caregarSignificados(vetorPalavras[j]);
            }

        }

        p[0].setVizinhos(2);
        p[1].setVizinhos(3);
        p[2].setVizinhos(3);
        p[3].setVizinhos(3);
        p[4].setVizinhos(3);
        p[5].setVizinhos(3);
        p[6].setVizinhos(2);

        p[0].vizinhos[0] = 1;
        p[0].vizinhos[1] = 2;
        p[1].vizinhos[0] = 0;
        p[1].vizinhos[1] = 3;
        p[1].vizinhos[2] = 4;
        p[2].vizinhos[0] = 0;
        p[2].vizinhos[1] = 5;
        p[2].vizinhos[2] = 6;
        p[3].vizinhos[0] = 1;
        p[3].vizinhos[1] = 4;
        p[3].vizinhos[2] = 6;
        p[4].vizinhos[0] = 1;
        p[4].vizinhos[1] = 3;
        p[4].vizinhos[2] = 5;
        p[5].vizinhos[0] = 2;
        p[5].vizinhos[1] = 4;
        p[5].vizinhos[2] = 6;
        p[6].vizinhos[0] = 2;
        p[6].vizinhos[1] = 5;

        /*
        if ( p[p[0].vizinhos[0]].esta_ativo ){
            JOptionPane.showMessageDialog(null, "o vizin "+p[0].vizinhos[0]+" eh ativo");
        }
        if ( p[p[0].vizinhos[1]].esta_ativo ){
            JOptionPane.showMessageDialog(null, "o vizin "+p[0].vizinhos[1]+" eh ativo");
        }

        for (int i = 0; i < p.length; i ++) {
            JOptionPane.showMessageDialog(null, "Quantidade de Vizinho do Peer "
                    +i +": " +p[ i ].vizinhos.length);
        }
        */
        String palavra = "";

        while( ! palavra.equalsIgnoreCase("-1") ) {

            palavra = JOptionPane.showInputDialog(null, "Digite sua palavra: ");
            System.out.println("Sua palavra foi: " + palavra);

            int i = 0, j = 0;
            while (i != -1) {

                int indiceRetornado = p[j].procurarPalavra(palavra);

                if (indiceRetornado != -1) {
                    JOptionPane.showMessageDialog(null, "Peer " + p[j].id + ":  " + p[j].getSignificado(indiceRetornado));
                    break;
                } else {
                    if(TTL > 0){
                        j = funcaoAleatoria(p[i]);
                        TTL--;
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Essa palavra não existe no dicionario");
                        break;
                    }
                }

                i = j;
            }
        }
    }

    static int funcaoAleatoria(Peers peer) {

        //ArrayList<Integer> vetorAtivos = new ArrayList<Integer>();
        System.out.println("rais "+peer.id);
        ArrayList<Integer> vetorID = new ArrayList<>();

        for (int i = 0; i < peer.vizinhos.length; i++) {
            vetorID.add( peer.vizinhos[i] );
        }
        /*
        for (int i = 0; i < vetorAtivos.size(); i++) {

                System.out.println(">: " + vetorAtivos.get(i));
        }*/


        // funcao aleatoria com os valores do vetorID

        Collections.shuffle (vetorID) ;

        // pega-se o indice 0.

            return (( Integer ) vetorID.get ( 0 ));

    }

}
