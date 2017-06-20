package uff.ic.lleme.tic10002.trabalhos._20171.leandromiranda;

import java.io.InvalidObjectException;

import javax.swing.JOptionPane;

import uff.ic.lleme.tic10002.trabalhos._20171.leandromiranda.ListaDinamicaDeVenda.NoLista;
import uff.ic.lleme.tic10002.trabalhos._20171.leandromiranda.Venda;

public class ArvoreVenda  {

	protected No raiz = null;
	protected int quantidadeNos = 0;
	protected String tipo;

	public ArvoreVenda() {

	}

	public ArvoreVenda(String tipo) {
		this.tipo = tipo;
	}

	public static String visite(No no) {
		if (no != null)
			return no.getConteudoComTipo();
		else
			return null;
	}

	public static String em_ordem2(No no) {
		String resultado = ",";
		if (no != null) {
			resultado = em_ordem2(no.getEsquerda());
			resultado += visite(no);
			resultado += em_ordem2(no.getDireita());
		}
		return resultado;
	}

	public No getRaiz() {
		return raiz;
	}

	public int getQuantidadeNos() {
		return quantidadeNos;
	}

	public String getTipo() {
		return tipo;
	}

	 public class No {

		private String tipo;
		private Venda conteudo = null;
		private ListaDinamicaDeVenda vendas;
		private No pai = null;
		private No esquerda = null;
		private No direita = null;

		private No() throws InvalidObjectException {
			JOptionPane.showMessageDialog(null,"Venda desconhecida.");
			throw new InvalidObjectException("Venda desconhecida.");
		}

		public No(Venda venda, String tipo) throws InvalidObjectException {
			if (ehValido(venda)) {
				this.conteudo = venda;
				this.tipo = tipo;
				vendas = new ListaDinamicaDeVenda(tipo);
			} else{
				JOptionPane.showMessageDialog(null,"Venda desconhecido ou sem identificacao.");
				throw new InvalidObjectException(
						"Venda desconhecido ou sem identificacao.");
			}
		}

		private boolean ehValido(Venda venda) {
			return venda != null; // && venda.getChave() != null;
		}

		public Venda getConteudo() {
			return conteudo;
		}

		public void setVendas(Venda conteudoNovo) {
			vendas.incluir(conteudoNovo);
		}

		public ListaDinamicaDeVenda getVenda() {
			return vendas;
		}

		public String getConteudoComTipo() {
			return conteudo.getChave(tipo);
		}

	
		public No direita() {
			return getDireita();
		}

		public No esquerda() {
			return getEsquerda();
		}

		public No pai() {
			return pai;
		}


		No conectar(No filho) {
			if (filho != null)
				if (getConteudo().compararInstancia(filho.getConteudo(), tipo) > 0)
					if (getEsquerda() == null) {
						setEsquerda(filho);
						filho.pai = this;
						return filho;
					} else
						return null; // direita.conectar(filho);
				else if (getConteudo().compararInstancia(filho.getConteudo(),
						tipo) < 0)
					if (getDireita() == null) {
						setDireita(filho);
						filho.pai = this;
						return filho;
					} else
						return null; // esquerda.conectar(filho);
			return null;
		}

		public No getDireita() {
			return direita;
		}

		public void setDireita(No direita) {
			this.direita = direita;
		}

		public No getEsquerda() {
			return esquerda;
		}

		public void setEsquerda(No esquerda) {
			this.esquerda = esquerda;
		}

	}

	//

	public No buscar(String valor) {
		return buscar(raiz, valor);
	}

	
	
	private No buscar(No noCorrente, String valor) {
		if (noCorrente != null)
			if (noCorrente.getConteudo().compararChave(valor,tipo) == 0) {
				return noCorrente;
			} else if (noCorrente.getConteudo().compararChave(valor,tipo) < 0)
				return buscar(noCorrente.getDireita(), valor);
			else if (noCorrente.getConteudo().compararChave(valor,tipo) > 0)
				return buscar(noCorrente.getEsquerda(), valor);
			else {
				return null;
			}
		return null;
	}

	public void incluirLista(ListaDinamicaDeVenda lista)
			throws InvalidObjectException {
		NoLista l1 = lista.cabeca;
		while (l1 != null) {
			incluir((Venda) l1.conteudo);
			l1 = l1.proximo;
		}

	}

	public No incluir(Venda empregado) throws InvalidObjectException {

		if (raiz == null) {
			raiz = new No(empregado, tipo);
			quantidadeNos = 1;
			return raiz;
		}
		return incluir(raiz, new No(empregado, tipo));
	}

	private No incluir(No noCorrente, No novoNo) throws InvalidObjectException {
		if (noCorrente.getConteudo().compararInstancia(novoNo.getConteudo(),
				tipo) == 0) {
			if(tipo!= "cod_vendedor")
				noCorrente.setVendas(novoNo.getConteudo());
			return noCorrente;

		} else if (noCorrente.getConteudo().compararInstancia(
				novoNo.getConteudo(), tipo) > 0)
			if (noCorrente.getEsquerda() == null) {
				No resultado = noCorrente.conectar(novoNo);
				quantidadeNos++;
				return resultado;
			} else
				return incluir(noCorrente.getEsquerda(), novoNo);
		else if (noCorrente.getConteudo().compararInstancia(
				novoNo.getConteudo(), tipo) < 0)
			if (noCorrente.getDireita() == null) {
				No resultado = noCorrente.conectar(novoNo);
				quantidadeNos++;
				return resultado;
			} else
				return incluir(noCorrente.getDireita(), novoNo);
		else
			return null;
	}

	
	public No excluir(String valor) {
		No excluido;
		No pai = null;
		No paiExcluido;
		excluido = buscar(valor);
		pai = excluido;
		if (excluido != null) {
			paiExcluido = excluido;
			if ((excluido.esquerda() != null) && (excluido.direita() != null)) {
				pai = excluido;
				excluido = excluido.direita();
				/* acha o imediatamente maior */
				while (excluido.esquerda() != null) {
					// substituir = excluido;
					paiExcluido = excluido;
					excluido = excluido.esquerda();
				}

				/* troca o valor do no?? a ser retirado pelo imediatamente maior */
				pai.conteudo = excluido.conteudo;
				// excluido = null;

				if ((excluido.direita() != null)
						&& (excluido.esquerda() == null)) {
					/* so?? tem o filho esq */
					if (paiExcluido.esquerda() == excluido)
						paiExcluido.setEsquerda(excluido.getDireita());
					else
						paiExcluido.setDireita(excluido.getDireita());
				}

				excluido = null;

			}

			else if ((excluido.direita() != null)
					&& (excluido.esquerda() == null)) {
				/* so?? tem o filho esq */
				if (excluido.pai.esquerda() == excluido)
					excluido.pai.setEsquerda(excluido.getDireita());
				else
					excluido.pai.setDireita(excluido.getDireita());

				excluido = null;
			} else if ((excluido.direita() == null)
					&& (excluido.esquerda() != null)) {
				if (excluido.pai.esquerda() == excluido)
					excluido.pai.setEsquerda(excluido.getEsquerda());
				else
					excluido.pai.setDireita(excluido.getEsquerda());

				excluido = null;
			} else
				pai = null;

			// excluido = null;
			return paiExcluido;

		} else
			return null;

	}

	/*algoritmo de busca em arvores do intervalo de valores*/
	public void printIntervalo(No noLocal, int i1, int i2,
			ListaDinamicaDeVenda listaOrigemArvore) {

		if (noLocal == null) {
			return;
		}

		if (i1 < Integer.parseInt(noLocal.conteudo.getFilial())) {
			printIntervalo(noLocal.getEsquerda(), i1, i2, listaOrigemArvore);
		}

		if (i1 <= Integer.parseInt(noLocal.conteudo.getFilial())
				&& i2 >= Integer.parseInt(noLocal.conteudo.getFilial())) {
			listaOrigemArvore.incluir(noLocal.getConteudo());
			if (noLocal.getVenda().getTAMANHO() > 0) {
				NoLista no = noLocal.getVenda().cabeca;
				while (no != null) {
					listaOrigemArvore.incluir(no.conteudo);
					no = no.proximo;
				}

			}

		}

		
		if (i2 > Integer.parseInt(noLocal.conteudo.getFilial())) {
			printIntervalo(noLocal.getDireita(), i1, i2, listaOrigemArvore);
		}
	}

}

