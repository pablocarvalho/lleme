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
public class ServicoAtendimento {
    
       
   private HeapEsperaAtendimento esperaAtendimento;
   private Atendimento atendimentoAtual;
   private TipoAssunto tabelaTiposDeAssunto[];
   private Cliente[] clientesDB;
   private HashAssuntos historicoDiarioDeAssuntos;   
   
   private final static int NUM_DE_TIPOS_DE_ASSUNTO = 10;
   
    
   public ServicoAtendimento() {
       esperaAtendimento = new HeapEsperaAtendimento();
       atendimentoAtual = null;
       tabelaTiposDeAssunto = CriadorDataset.criarTiposDeAssunto(NUM_DE_TIPOS_DE_ASSUNTO);
       clientesDB = CriadorDataset.criarClientes(50);
       historicoDiarioDeAssuntos = new HashAssuntos(NUM_DE_TIPOS_DE_ASSUNTO);
       
       
   }
    
   
    
   public void recepcionar(){
       Atendimento novo = CriadorDataset.gerarAtendimento(clientesDB,tabelaTiposDeAssunto);
       
       float urgencias=0.0f;
       for (Assunto assunto : novo.getAssunto()) {
           urgencias += tabelaTiposDeAssunto[assunto.getTipo()].getUrgencia();
       }
       float prioridade = (novo.getCliente().getIdade() / 65) + (urgencias/novo.getAssunto().length)/10;
       
       esperaAtendimento.adicionar(novo, prioridade);
   }
   
   public void atender(){
       atendimentoAtual = esperaAtendimento.obterAtendimento();
   }
   
   public void encerrar(){
       Assunto[] assuntos = atendimentoAtual.getAssunto();
       int duracaoTotal = 0;
       for (Assunto assunto : assuntos) {
           int duracao = 1 + (int)(Math.random() * 15);
           assunto.setDuracao(duracao);
           duracaoTotal += duracao;           
           historicoDiarioDeAssuntos.inserir(assunto);
       }       
       atendimentoAtual = null;
       
   }
   
   public void gerarEstatistica(){
       System.out.println("Estatística do dia:");
       System.out.println("assunto\ttempo médio");
       for (TipoAssunto tipoAssunto : tabelaTiposDeAssunto) {
           String saida = tipoAssunto.getTítulo()+"\t";
           
           Assunto[] assuntos = historicoDiarioDeAssuntos.obterAssuntosPorTipo(tipoAssunto);
           
           float soma = 0.0f;
           int contador = 0;
           for (Assunto assunto : assuntos) {
               if(assunto != null){
                   soma += assunto.getDuracao();
                   contador++;
               }
           }
           float media = soma/contador;
           
           saida += Float.toString(media);
           System.out.println(saida);           
           
       }
       System.out.println("Fim da estatística");
   }
       
}
