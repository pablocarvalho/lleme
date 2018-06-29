package trabalho_ed;

import java.text.SimpleDateFormat;
import java.util.Date;

/* A classe Atendimentos representa a fila de Atendimentos enfileirados por prioridade.
 * Herda de MaxHeap, mas tem uma implementação específica do método remover, que solicita reorganização do heap antes da remoção de um item.
 * Esta reorganização é necessária p/ que eventuais mudanças de prioridade em função do tempo possam ser contabilizadas.
 * */


public class Atendimentos  {
	TiposAssuntos tiposAssuntos;
	Estatisticas estatisticas;
	MaxHeap fila;
	
	public Atendimentos(int maxsize, Estatisticas estatisticas) {
		this.fila = new MaxHeap(maxsize);
		this.estatisticas = estatisticas;
		this.tiposAssuntos = new TiposAssuntos(System.getProperty("user.dir") + "\\data\\TipoAssunto.txt");
		// TODO Auto-generated constructor stub
	}
	
	public TiposAssuntos getTiposAssuntos() {
		return this.tiposAssuntos;
	}

	public void Recepcionar(Atendimento atendimento)  {
		atendimento.setTimestampChegada();
		System.out.println("Cliente tem prioridade " + atendimento.getPrioridade());
		
		try {
			this.fila.inserir(atendimento);	
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	public Atendimento Atender() {
		//Remove o próximo item do heap
		Atendimento atendimento = this.fila.remover();
		atendimento.setTimestampAtendimento();
		System.out.println("Próximo cliente-> Nome: " + atendimento.getCliente().getNome() + ", idade: "  + atendimento.getCliente().getIdade());
		return atendimento;
	}

	public void Encerrar(Atendimento atendimento) {
		System.out.println("");
		System.out.println("Encerrando atendimento para cliente nome:'" + atendimento.getCliente().getNome() +  
				"', idade: " + atendimento.getCliente().getIdade() + ", prioridade: " + atendimento.getPrioridade());
	    
		//Busca o objeto Estatística do dia
		EstatisticaDia estatDia = this.estatisticas.Buscar(atendimento.getTimestampChegada());
		
		for(int i = 0; i< atendimento.getAssuntosTratados().getTamanho(); i++) {
	    	Assunto a = (Assunto)atendimento.getAssuntosTratados().get(i);
	    	System.out.println("Descrição Assunto " + i + ": " + a.getDescricao() + ", Providência:" + a.getProvidencias());
	    	
	    	//atualiza as estatísticas
	    	estatDia.getEstatistica().AtualizarMetrica(atendimento.getTimestampChegada(), a.getChave(), a.getDuracaoAtendimento());
	    }
	    System.out.println("");

	    //Define timestamp de encerramento
	    atendimento.setTimestampEncerramento();
	}
}
