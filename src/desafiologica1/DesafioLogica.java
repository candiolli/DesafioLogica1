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

    private static BufferedReader lerArquivo(String nomeArquivo) throws FileNotFoundException {
        File blacklist = new File(new DesafioLogica().getApplicationPath() + "\\" + nomeArquivo);
        FileReader reader = new FileReader(blacklist);
        return new BufferedReader(reader);
    }
    
    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        BufferedReader bfNumeros = lerArquivo("\\teste.csv");

        List<Linha> linhas = new ArrayList<>();

        String linha = null;
        while ((linha = bfNumeros.readLine()) != null) {
            String numero = linha.split(";")[0];
            String msg = linha.split(";")[1];

            boolean linhaValida = validarLinha(linhas, numero, msg);
            
            if (linhaValida) {
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

        bfNumeros.close();
    }

    private static boolean validarLinha(List<Linha> linhas, String numero, String msg) throws IOException {
        BufferedReader bfBlacklist = lerArquivo("blacklist.csv");
        
        for (Linha linha : linhas) {
            if (linha.getNumero().equals(numero) && linha.getMensagem().equals(msg)){
                return false;
            }
        }
        
        String linha = null;
        while ((linha = bfBlacklist.readLine()) != null) {
            if (linha.equals(numero))
                return false;
        }
        return true;
    }

    private String getApplicationPath() { 
        String url = getClass().getResource(getClass().getSimpleName() + ".class").getPath();  
        File dir = new File(url).getParentFile(); 
        return dir.getAbsolutePath();
    }
}
