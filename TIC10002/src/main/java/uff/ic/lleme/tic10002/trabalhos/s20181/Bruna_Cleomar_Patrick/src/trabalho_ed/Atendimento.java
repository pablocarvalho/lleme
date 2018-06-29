package trabalho_ed;

import java.util.Date;
import java.text.SimpleDateFormat;

/* Classe Atendimento representa um Atendimento a um Cliente para tratar uma coleção de Assuntos
 * Um objeto da classe Atendimento é colocado na fila de Atendimentos de acordo com sua prioridade
 * */

public class Atendimento extends ObjetoBase {

	private Cliente cliente;
	private Assuntos assuntosTratados;
	private Date timestampChegada;
	private Date timestampAtendimento;
	private Date timestampEncerramento;
	
	public Atendimento(Cliente cliente) {
		this.assuntosTratados = new Assuntos(10);
		this.cliente = cliente;
	}
	
	//Calcula a prioridade em função da idade, tempo de espera e média das urgências dos assuntos tratados
	public float getPrioridade() {
		Date timestamp = new Date();
		long espera = (timestamp.getTime() - this.timestampChegada.getTime())/(1000*60);
     	return (float) ((this.cliente.getIdade()/65.0 + espera/15.0 + assuntosTratados.getUrgenciaMedia()/10.0)/3.0);
	}

	public Cliente getCliente() {
		return this.cliente;
	}
	
	public Assuntos getAssuntosTratados() {
		return this.assuntosTratados;
	}
	
	public void IncluirAssunto(TipoAssunto tipo, String descricao){
	    Assunto assunto = new Assunto(tipo, descricao);
		this.assuntosTratados.Inserir(assunto);
	}

	public Date getTimestampChegada() {
		return this.timestampChegada;
	}
	
	public void setTimestampChegada() {
		this.timestampChegada = new Date();
	}
	
	public void setTimestampEncerramento() {
		this.timestampEncerramento = new Date();
	}
	
	public void setTimestampAtendimento() {
		this.timestampAtendimento = new Date();
	}
	
	public Date GerarEstatistica(){
		return null;
	
	}

	@Override
	public String getChave() {
		// TODO Auto-generated method stub
		return Float.toString(getPrioridade());
	}
}
