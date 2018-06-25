/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhoed;

/**
 *
 * @author pablomoreira
 */
class HashAssuntos {
    
    private Assunto[][] tabelaHash;
    private final static int TOTAL_DE_UM_TIPO = 100;

    public HashAssuntos(int tipoAssuntoTotal) {
         tabelaHash = new Assunto[tipoAssuntoTotal][TOTAL_DE_UM_TIPO];
    }
    
    public void inserir(Assunto assunto){
        
        for( int i = 0; i < TOTAL_DE_UM_TIPO; i++){
            if(tabelaHash[assunto.getTipo()][i] == null)
            {
                tabelaHash[assunto.getTipo()][i]=assunto;
                break;
            }           
            
        }
        
    }
    
    public Assunto[] obterAssuntosPorTipo(TipoAssunto tipo){
        return tabelaHash[tipo.getTipo()];
    }
    
    
    
    
    
}
