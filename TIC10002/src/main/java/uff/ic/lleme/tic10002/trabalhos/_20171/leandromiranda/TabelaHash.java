package uff.ic.lleme.tic10002.trabalhos._20171.leandromiranda;

import java.io.InvalidObjectException;

import javax.swing.JOptionPane;

import uff.ic.lleme.tic10002.trabalhos._20171.leandromiranda.Venda;

public class TabelaHash {

	/* varia entre 1900 e 2100 */
	private final int TAMANHO_ANO = 201;
	private final int TAMANHO_MES = 13;
	private final int ANO_HASH = 1900;
	private final int MES_HASH = 12;
	final int MES = 0;
	final int ANO = 1;
	private final String tipo = "ano_mes";

	ListaDinamicaDeVenda[][] tabela;

	public TabelaHash() {
		tabela = new ListaDinamicaDeVenda[TAMANHO_MES][TAMANHO_ANO];
	}

	private Integer[] parse(String key) throws InvalidObjectException {
		String[] chaves = key.split("/");

		if (chaves.length != 2) {
			JOptionPane.showMessageDialog(null,
					"Tá errado o tamanho/formato da chave.");
			throw new InvalidObjectException("Tá errado o tamanho da chave.");
		}

		Integer[] chavesInteiras = new Integer[2];
		for (int i = 0; i < chavesInteiras.length; i++)
			chavesInteiras[i] = Integer.parseInt(chaves[i]);

		return chavesInteiras;

	}

	private Integer[] funcaoDeDispersao(int key1, int key2) {

		Integer fxy[] = new Integer[2];

		fxy[MES] = (key1 % MES_HASH);
		fxy[ANO] = (key2 % ANO_HASH);

		return fxy;
	}

	public ListaDinamicaDeVenda getValue(String key)
			throws InvalidObjectException {

		Integer[] chavesInteiras = parse(key);

		if (tabela[chavesInteiras[0]][chavesInteiras[1]] == null) {
			JOptionPane.showMessageDialog(null, "não existe na tabela.");
			throw new InvalidObjectException("não existe na tabela.");
		} else
			return tabela[chavesInteiras[0]][chavesInteiras[1]];

	}

	public void put(String key, Venda venda) throws InvalidObjectException {

		Integer[] chavesInteiras = parse(key);

		chavesInteiras = funcaoDeDispersao(chavesInteiras[0], chavesInteiras[1]);

		try {
			tabela[chavesInteiras[0]][chavesInteiras[1]] = new ListaDinamicaDeVenda();
			tabela[chavesInteiras[0]][chavesInteiras[1]].incluir(venda);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Tem nos valores da entrada da tabela");
			throw new InvalidObjectException("Tem nos valores da entrada da tabela");
		}
		
	}

	public void remover(String key) throws InvalidObjectException {
		Integer[] chavesInteiras = parse(key);
		chavesInteiras = funcaoDeDispersao(chavesInteiras[0], chavesInteiras[1]);
		ListaDinamicaDeVenda aux = tabela[chavesInteiras[0]][chavesInteiras[1]];
		aux.setTipo(tipo);

		aux.excluir(key);
		tabela[chavesInteiras[0]][chavesInteiras[1]] = aux;

	}

	public void buscar(String key) throws InvalidObjectException {
		Integer[] chavesInteiras = parse(key);
		chavesInteiras = funcaoDeDispersao(chavesInteiras[0], chavesInteiras[1]);
		ListaDinamicaDeVenda aux = tabela[chavesInteiras[0]][chavesInteiras[1]];
		if (aux != null) {
			aux.setTipo(tipo);
			Venda vendinha = aux.buscar(key);
			if (vendinha != null)
				JOptionPane.showMessageDialog(null, "Tem na base de dados");
			else
				JOptionPane.showMessageDialog(null, "Não tem na base de dados");
			tabela[chavesInteiras[0]][chavesInteiras[1]] = aux;
		} else
			JOptionPane.showMessageDialog(null, "Não tem na base de dados");

	}

	public void printIntervalo(String anoMesInicial, String anoMesFinal,
			ListaDinamicaDeVenda listaLetraB) throws InvalidObjectException {

		Integer[] chavesInteirasInicioDatas = parse(anoMesInicial);
		Integer[] chavesInteirasFimDatas = parse(anoMesFinal);

		Integer[] chavesInteirasInicioDatasDispersao = funcaoDeDispersao(
				chavesInteirasInicioDatas[MES], chavesInteirasInicioDatas[ANO]);
		Integer[] chavesInteirasFimDatasDispersao = funcaoDeDispersao(
				chavesInteirasFimDatas[MES], chavesInteirasFimDatas[ANO]);

		if (chavesInteirasInicioDatas[1] > chavesInteirasFimDatas[1]) {
			JOptionPane.showMessageDialog(null,
					"erro na entrada do ano das datas.");
			throw new InvalidObjectException(
					"erro na entrada do ano das datas.");

		} else if (chavesInteirasInicioDatas[1] < chavesInteirasFimDatas[1]) {
			// dividido em três etapas
			// 1 parte
			ListaDinamicaDeVenda listaAuxiliar = new ListaDinamicaDeVenda();
			int iInicial;
			for (iInicial = chavesInteirasInicioDatasDispersao[MES]; iInicial < TAMANHO_MES; iInicial++) {
				listaAuxiliar = tabela[iInicial][chavesInteirasInicioDatasDispersao[ANO]];
				if (listaAuxiliar != null)
					for (int j = 0; j < listaAuxiliar.getTAMANHO(); j++) {
						listaLetraB.incluir(listaAuxiliar.get(j));
					}
			}

			int jInicial = chavesInteirasInicioDatasDispersao[ANO] + 1;

			// 2 parte
			while (jInicial < chavesInteirasFimDatasDispersao[ANO]) {

				for (int i = 1; i < TAMANHO_MES; i++) {
					listaAuxiliar = tabela[i][jInicial];
					if (listaAuxiliar != null)
						for (int j = 0; j < listaAuxiliar.getTAMANHO(); j++) {
							listaLetraB.incluir(listaAuxiliar.get(j));
						}
				}

				jInicial++;
			}

			// 3 parte

			for (int mes = 1; mes <= chavesInteirasFimDatasDispersao[MES]; mes++) {
				listaAuxiliar = tabela[mes][chavesInteirasFimDatasDispersao[ANO]];
				if (listaAuxiliar != null)
					for (int j = 0; j < listaAuxiliar.getTAMANHO(); j++) {
						listaLetraB.incluir(listaAuxiliar.get(j));
					}
			}

		} else {
			ListaDinamicaDeVenda listaAuxiliar = new ListaDinamicaDeVenda();
			for (int j = chavesInteirasInicioDatasDispersao[MES]; j <= chavesInteirasFimDatasDispersao[MES]; j++) {
				listaAuxiliar = tabela[j][chavesInteirasFimDatasDispersao[ANO]];
				if (listaAuxiliar != null)
					for (int i = 0; i < listaAuxiliar.getTAMANHO(); i++) {
						listaLetraB.incluir(listaAuxiliar.get(i));
					}
			}
		}

	}

}
