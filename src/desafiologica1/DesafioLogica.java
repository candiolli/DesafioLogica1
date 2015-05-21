/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desafiologica1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author silascandiolli
 */
public class DesafioLogica {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        File file = new File("c:/teste.csv");
        FileReader reader = new FileReader(file);
        BufferedReader buffer = new BufferedReader(reader);

        List<Linha> linhas = new ArrayList<>();

        String linha = null;
        while ((linha = buffer.readLine()) != null) {
            String numero = linha.split(";")[0];
            String msg = linha.split(";")[1];

            Linha linhaExistente = verificaLinha(linhas, numero, msg);
            
            if (linhaExistente == null) {
                linhas.add(new Linha(numero, msg));
            }
        }
        
        Collections.sort(linhas, new Comparator<Linha>() {
            @Override
            public int compare(Linha o1, Linha o2) {
                Linha l1 = (Linha) o1;
                Linha l2 = (Linha) o2;
                return l1.getNumero().compareTo(l2.getNumero());
            }
        });
        
        for (Linha linha1 : linhas) {
            System.out.println("Número: "+linha1.getNumero() + ", Mensagem: " + linha1.getMensagem());
        }

        buffer.close();
    }

    private static Linha verificaLinha(List<Linha> linhas, String numero, String msg) {
        for (Linha linha : linhas) {
            if (linha.getNumero().equals(numero) && linha.getMensagem().equals(msg)){
                return linha;
            }
        }
        return null;
    }

}
