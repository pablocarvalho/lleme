/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uff.ic.lleme.tic10002.trabalhos._20171.wagnerguimaraes;

import java.util.ArrayList;


/**
 *
 * @author Wagner
 */
public class ArvoreFilial {

  public NoFilial raiz;
  
	public void inserir(Filial Filial) {
		NoFilial n = new NoFilial(Filial);
		inserirAVL(this.raiz, n);
	}

        //Busca a chave do no no interior da árvore
        public NoFilial buscar(int chave) {
            return buscar(chave,this.raiz);
        }
        
        //Busca a chave no Nó informado, metodo auxiliar da busca.
        private NoFilial buscar (int chave, NoFilial No){
            // Realiza um busca recursiva em busca da chave no interior da arvore
            if (No==null)
                return null;
            if (No.getChave()==chave)
                return No;
            if (No.getChave()>chave)
                return buscar(chave,No.getEsquerda());
            else
                return buscar(chave,No.getDireita());
                
        }
        
        // Busca o saldo em um intervalo de filiais
        public double buscarSaldoFilial ( int cFilial1, int cFilial2){
            
            double Saldo=0;
            
            NoFilial no = new NoFilial();
            
            for (int k=cFilial1; k<=cFilial2;k++){
                no=buscar(k);
                if (no!=null)

                    Saldo+= no.getSaldoAnual();
                
                System.out.printf("\n\nO Saldo da Filial %d acumulado é %f", k, Saldo);
            }
            return Saldo;
                
        }
        
        // Busca o saldo em um intervalo de filiais e de meses
        public double buscarSaldoFilialMes(int cFilial1, int cFilial2, int cAnoMes1, int cAnoMes2) {
            
            double Saldo=0;

            NoFilial no = new NoFilial();
            
            for (int k=cFilial1; k<=cFilial2;k++){
                no=buscar(k);
                if (no!=null){
                    System.out.printf("\n\nO Saldo mensal da Filial %d",k);
                    Saldo+= no.getMeses().BuscaSaldo(cAnoMes1, cAnoMes2);
                }
                
            }
                 
            return Saldo;
            
        }
        
        // Busca o saldo em um intervalo de datas no formato (yymm)
        public double buscarSaldoMes( int cAnoMes1, int cAnoMes2){
            
            return buscarSaldoMes (cAnoMes1,  cAnoMes2, raiz);
        }
        
        // Busca o saldo em um intervalo de dados no formato (yymm) a partir de um nó.
        private double buscarSaldoMes( int cAnoMes1, int cAnoMes2, NoFilial No){
            
            double Saldo=0;
  
            if (No.getEsquerda()!=null){
                
                Saldo+=buscarSaldoMes ( cAnoMes1,  cAnoMes2, No.getEsquerda());
            }
            
            System.out.printf("\nSaldo da Filial %d", No.getChave());
            Saldo += No.getMeses().BuscaSaldo(cAnoMes1, cAnoMes2);
         
            if (No.getDireita()!=null)
                Saldo+=buscarSaldoMes ( cAnoMes1,  cAnoMes2, No.getDireita());
                
            return Saldo;
        }
        
        // Insere um nó na árvoer veriricando seu balanceamento 
	public void inserirAVL(NoFilial aComparar, NoFilial aInserir) {
            double k=0;
            if (aComparar == null) {
                
			this.raiz = aInserir;
		
                } else {

                    if (aInserir.getChave() < aComparar.getChave()) {

                            if (aComparar.getEsquerda() == null) {
                                    aComparar.setEsquerda(aInserir);
                                    aInserir.setPai(aComparar);
                                    verificarBalanceamento(aComparar);

                            } else {
                                    inserirAVL(aComparar.getEsquerda(), aInserir);
                            }

                    } else if (aInserir.getChave() > aComparar.getChave()) {

                            if (aComparar.getDireita() == null) {
                                
                                    aComparar.setDireita(aInserir);
                                    aInserir.setPai(aComparar);
                                    verificarBalanceamento(aComparar);

                            } else {
                                
                                    inserirAVL(aComparar.getDireita(), aInserir);
                            }

                    } else {
                            NoFilial No = new NoFilial();
                            No= buscar (aInserir.getChave(),this.raiz);
                            if (No!=null){
                                aComparar.setSaldoAnual(aInserir.getValorVendido());
                                aComparar.setMeses(aInserir);
                                
                            }
                                
                    }
		}    
	}
        
        // Verifica se existe a possibilidade do balanceamento
	public void verificarBalanceamento(NoFilial atual) {
		setBalanceamento(atual);
		int balanceamento = atual.getBalanceamento();

		if (balanceamento == -2) {

			if (altura(atual.getEsquerda().getEsquerda()) >= altura(atual.getEsquerda().getDireita())) {
				atual = rotacaoDireita(atual);

			} else {
				atual = duplaRotacaoEsquerdaDireita(atual);
			}

		} else if (balanceamento == 2) {

			if (altura(atual.getDireita().getDireita()) >= altura(atual.getDireita().getEsquerda())) {
				atual = rotacaoEsquerda(atual);

			} else {
				atual = duplaRotacaoDireitaEsquerda(atual);
			}
		}

		if (atual.getPai() != null) {
			verificarBalanceamento(atual.getPai());
		} else {
			this.raiz = atual;
		}
	}

        // remove um nó na arvore
	public void remover(int k) {
		removerAVL(this.raiz, k);
	}

        // remove um nó na ÃrvoreAVL
	public void removerAVL(NoFilial atual, int k) {
		if (atual == null) {
			return;

		} else {

			if (atual.getChave() > k) {
				removerAVL(atual.getEsquerda(), k);

			} else if (atual.getChave() < k) {
				removerAVL(atual.getDireita(), k);

			} else if (atual.getChave() == k) {
				removerNoEncontrado(atual);
			}
		}
	}

        //Remove o nó encontrado
	public void removerNoEncontrado(NoFilial aRemover) {
		NoFilial r;

		if (aRemover.getEsquerda() == null || aRemover.getDireita() == null) {

			if (aRemover.getPai() == null) {
				this.raiz = null;
				aRemover = null;
				return;
			}
			r = aRemover;

		} else {
			r = sucessor(aRemover);
			aRemover.setChave(r.getChave());
		}

		NoFilial p;
		if (r.getEsquerda() != null) {
			p = r.getEsquerda();
		} else {
			p = r.getDireita();
		}

		if (p != null) {
			p.setPai(r.getPai());
		}

		if (r.getPai() == null) {
			this.raiz = p;
		} else {
			if (r == r.getPai().getEsquerda()) {
				r.getPai().setEsquerda(p);
			} else {
				r.getPai().setDireita(p);
			}
                        // veririca a possibilidade de balanceamento
			verificarBalanceamento(r.getPai());
		}
		r = null;
	}

        // Faz um rotação à esquerda caso haja necessitade
	public NoFilial rotacaoEsquerda(NoFilial inicial) {

		NoFilial direita = inicial.getDireita();
		direita.setPai(inicial.getPai());

		inicial.setDireita(direita.getEsquerda());

		if (inicial.getDireita() != null) {
			inicial.getDireita().setPai(inicial);
		}

		direita.setEsquerda(inicial);
		inicial.setPai(direita);

		if (direita.getPai() != null) {

			if (direita.getPai().getDireita() == inicial) {
				direita.getPai().setDireita(direita);
			
			} else if (direita.getPai().getEsquerda() == inicial) {
				direita.getPai().setEsquerda(direita);
			}
		}

		setBalanceamento(inicial);
		setBalanceamento(direita);

		return direita;
	}
        
        // Faz um rotação à direita caso haja necessitade
	public NoFilial rotacaoDireita(NoFilial inicial) {

		NoFilial esquerda = inicial.getEsquerda();
		esquerda.setPai(inicial.getPai());

		inicial.setEsquerda(esquerda.getDireita());

		if (inicial.getEsquerda() != null) {
			inicial.getEsquerda().setPai(inicial);
		}

		esquerda.setDireita(inicial);
		inicial.setPai(esquerda);

		if (esquerda.getPai() != null) {

			if (esquerda.getPai().getDireita() == inicial) {
				esquerda.getPai().setDireita(esquerda);
			
			} else if (esquerda.getPai().getEsquerda() == inicial) {
				esquerda.getPai().setEsquerda(esquerda);
			}
		}

		setBalanceamento(inicial);
		setBalanceamento(esquerda);

		return esquerda;
	}

        // Faz um rotação dupla à esquerda caso haja necessitade
	public NoFilial duplaRotacaoEsquerdaDireita(NoFilial inicial) {
		inicial.setEsquerda(rotacaoEsquerda(inicial.getEsquerda()));
		return rotacaoDireita(inicial);
	}
        // Faz um rotação dupla à direita caso haja necessitade
	public NoFilial duplaRotacaoDireitaEsquerda(NoFilial inicial) {
		inicial.setDireita(rotacaoDireita(inicial.getDireita()));
		return rotacaoEsquerda(inicial);
	}
        
        //Acha o nó sucesso da chave informada
	public NoFilial sucessor(NoFilial q) {
		if (q.getDireita() != null) {
			NoFilial r = q.getDireita();
			while (r.getEsquerda() != null) {
				r = r.getEsquerda();
			}
			return r;
		} else {
			NoFilial p = q.getPai();
			while (p != null && q == p.getDireita()) {
				q = p;
				p = q.getPai();
			}
			return p;
		}
	}

	private int altura(NoFilial atual) {
		if (atual == null) {
			return -1;
		}

		if (atual.getEsquerda() == null && atual.getDireita() == null) {
			return 0;
		
		} else if (atual.getEsquerda() == null) {
			return 1 + altura(atual.getDireita());
		
		} else if (atual.getDireita() == null) {
			return 1 + altura(atual.getEsquerda());
		
		} else {
			return 1 + Math.max(altura(atual.getEsquerda()), altura(atual.getDireita()));
		}
	}

	private void setBalanceamento(NoFilial no) {
		no.setBalanceamento(altura(no.getDireita()) - altura(no.getEsquerda()));
	}

	final protected ArrayList<NoFilial> inorder() {
		ArrayList<NoFilial> ret = new ArrayList<NoFilial>();
		inorder(raiz, ret);
		return ret;
	}

	final protected void inorder(NoFilial no, ArrayList<NoFilial> lista) {
		if (no == null) {
			return;
		}
		inorder(no.getEsquerda(), lista);
		lista.add(no);
		inorder(no.getDireita(), lista);
	}


}

