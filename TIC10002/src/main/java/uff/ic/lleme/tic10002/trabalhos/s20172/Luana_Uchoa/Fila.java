package controleTrafego;

public class Fila <T> {
	
	int tamanho = 0;
	protected No <T> lista = null;

	public static class No <T> {
		public T objeto;
		public No <T> proximo = null;

		public No (T objeto) {this. objeto = objeto;}
	}
	
	public boolean vazia() {
		return this.lista == null;
	}
	
	public void enfileira(T obj) {
		if (this.lista == null) {
			this.lista = new No <T> (obj);
		} else {
			No <T> aux = this. lista;
			while (aux. proximo != null) {
				aux = aux. proximo;
			}
			aux. proximo = new No <T> (obj);
		}
		tamanho++;
	}
	
	public T desenfileira() {
		if(lista != null) {
			No<T> aux = lista;
			lista = lista.proximo;
			tamanho--;
			return aux.objeto;
		}else
			return null;
	}

}
