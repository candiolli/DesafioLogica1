/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desafiologica1;

/**
 *
 * @author silascandiolli
 */
public class Linha {

    private String numero;
    private String mensagem;

    public Linha() {}
    
    public Linha(String numero, String mensagem) {
        this.numero = numero;
        this.mensagem = mensagem;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    @Override
    public boolean equals(Object obj) {
        final boolean equals = super.equals(obj);
        
        if (!equals)
            return ((Linha) obj).getNumero().equals(((Linha) this).getNumero());
        
        return equals;
    }

    
    
}
