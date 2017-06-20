/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uff.ic.lleme.tic10002.trabalhos._20171.wagnerguimaraes;

/**
 *
 * @author Thiago
 */
public class ArvoreB {
    
    //Atributos da Classe ArvoreB
    private NoB raiz; //Atributo do Nó raiz;
    private int ordem; //Ordem da Arvore-B;
    private int nElementos; //Contador para a quantidade de elementos na arvore B;

    //Construtor da Classe ArvoreB
    //Cria um novo nó para a raiz, seta a ordem passada como paâmetro e inicializa
    //o atributo contador de numeros de elementos
    public ArvoreB(int n) {
        this.raiz = new NoB(n);
        this.ordem = n;
        nElementos = 0;
    }  

    //Getters e Setters dos atributos nElementos,ordem e raiz
    public int getnElementos() {
        return nElementos;
    }

    public void setOrdem(int ordem) {
        this.ordem = ordem;
    }

    public int getOrdem() {
        return ordem;
    }

    public NoB getRaiz() {
        return raiz;
    }

    //Metodo de Inserção na ArvoreB
    //parametros: k - chave a ser inserida
    public void insere(int k) {
        //Verifica se a chave a ser inserida existe
        if (BuscaChave(raiz, k) == null) { //só insere se não houver, para evitar duplicação de chaves
            //verifica se a chave está vazia
            if (raiz.n == 0) {
                raiz.chave[0] = k;//seta a chave na primeira posição da raiz
                raiz.n=(raiz.n + 1);
            } else { //caso nao estaja vazia
                NoB r = raiz;
                //verifica se a raiz está cheia
                if (r.n == ordem - 1) {//há necessidade de dividir a raiz
                    NoB s = new NoB(ordem);
                    raiz = s;
                    s.folha = false;
                    s.n=(0);
                    s.filho[0] = r;
                    divideNoB(s, 0, r);//divide nó
                    insereNoBNaoCheio(s, k);//depois de dividir a raiz começa inserindo apartir da raiz

                } else {//caso contrario começa inserindo apartir da raiz
                    insereNoBNaoCheio(r, k);
                }
            }
            nElementos++;//incrementa o numero de elemantos na arvore
        }
    }

    //Método de divisão de nó
    //Parâmetros: x - nó Pai, y - nó Filho e i - índice i que indica que y é o i-ésimo filho de x.
    public void divideNoB(NoB x, int i, NoB y) {
        int t = (int) Math.floor((ordem - 1) / 2);
        //cria nó z
        NoB z = new NoB(ordem);
        z.folha = y.folha;
        z.n = (t);

        //passa as t ultimas chaves de y para z
        for (int j = 0; j < t; j++) {
            if ((ordem - 1) % 2 == 0) {
                z.chave[j] = y.chave[j + t];
            } else {
                z.chave[j] = y.chave[j + t + 1];
            }
            y.n=(y.n - 1);
        }

        //se y nao for folha, pasa os t+1 últimos flhos de y para z
        if (!y.folha) {
            for (int j = 0; j < t + 1; j++) {
                if ((ordem - 1) % 2 == 0) {
                    z.filho[j] = y.filho[j + t];
                } else {
                    z.filho[j] =  y.filho[j + t + 1];
                }

            }
        }

        y.n = (t);//seta a nova quantidade de chaves de y

        //descola os filhos de x uma posição para a direita
        for (int j = x.n; j > i; j--) { 
            x.filho[j + 1] =  x.filho[j];
        }

        x.filho[i + 1] =  z;//seta z como filho de x na posição i+1

        //desloca as chaves de x uma posição para a direita, para podermos subir uma chave de y
        for (int j = x.n; j > i; j--) {
            x.chave[j]= x.chave[j - 1];
        }

        //"sobe" uma chave de y para z
        if ((ordem - 1) % 2 == 0) {
            x.chave[i] = y.chave[t - 1];
            y.n=(y.n - 1);
            
        } else {
            x.chave[i] = y.chave[t];
        }

        //incrementa o numero de chaves de x
        x.n=(x.n + 1);

    }

    //Método para inserir uma chave em um nó não cheio
    //Paâmetros: x - nó a ser inserido, k - chave a ser inserida no nó x
    public void insereNoBNaoCheio(NoB x, int k) {
        int i = x.n - 1;
        //verifica se x é um nó folha
        if (x.folha) {
            //adquire a posição correta para ser inserido a chave
            while (i >= 0 && k < x.chave[i]) 
            {
                x.chave[i + 1] = x.chave[i];
                i--;
            }
            i++;
            x.chave[i] =  k;//insere a chave na posição i
            x.n=(x.n + 1);

        } else {//caso x não for folha
            //adquire a posição correta para ser inserido a chave
            while ((i >= 0 && k < x.chave[i])) 
            {
                i--;
            }
            i++;
            //se o filho i de x estiver cheio, divide o mesmo
            if (x.filho[i].n == ordem - 1) {
                divideNoB(x, i, x.filho[i]);
                if (k > x.chave[i]) {
                    i++;
                }
            }
            //insere a chave no filho i de x
            insereNoBNaoCheio(x.filho[i], k);
        }
        
    }

    //Método de busca de uma chave, retorna um nó onde a chave buscada se encontra
    //Parâmetros: X - nó por onde começar a busca, k - chave a ser buscada
    public NoB BuscaChave(NoB X, int k) {
        int i = 1;
        //procura ate nao estourar o tamanho e ate o valor nao ser maior q o procurado
        while ((i <= X.n) && (k > X.chave[i - 1])) { 
            i++;
        }
        //se o tamanho nao tiver excedido e for o valor procurado..
        if ((i <= X.n) && (k == X.chave[i - 1])) {
            return X;
        }
        //se nao foi é igual, entao foi o tamanho q excedeu. ai procura no filho se nao for folha
        if (X.folha) 
        { //se o no X for folha
            return null;
        } else {
            return (BuscaChave(X.filho[i - 1], k));
        }
    }

    //Método de Remoção de uma determinada chave da arvoreB
    public void Remove(int k) {
        //verifica se a chave a ser removida existe
        if (BuscaChave(this.raiz, k) != null) {
            //N é o nó onde se encontra k
            NoB N = BuscaChave(this.raiz, k);
            int i = 1;

            //adquire a posição correta da chave em N
            while (N.chave[i - 1] < k) 
            {
                i++;
            }

            //se N for folha, remove ela e deve se balancear N
            if (N.folha )
            {
                for (int j = i + 1; j <= N.n; j++) {
                    N.chave[j - 2] = N.chave[j - 1];//desloca chaves quando tem mais de uma
                }
                N.n=(N.n - 1);
                if (N != this.raiz) {
                    Balanceia_Folha(N);//Balanceia N
                }
            } else {//caso contrário(N nao é folha), substitui a chave por seu antecessor e balanceia a folha onde se encontrava o ancecessor
                NoB S = Antecessor(this.raiz, k);//S eh onde se encontra o antecessor de k
                int y = S.chave[S.n - 1];//y é o antecessor de k
                S.n = (S.n - 1);
                N.chave[i - 1] =  y;//substitui a chave por y
                Balanceia_Folha(S);//balanceia S
            }
            nElementos--;//decrementa o numero de elementos na arvoreB
        }
    }

    //Métode de Balancear um nó folha
    //Parâmetros: F - nó Folha a ser balanceada
    private void Balanceia_Folha(NoB F) {
        //verifica se F está cheio
        if (F.n < Math.floor((ordem - 1) / 2)) {
            NoB P = getPai(raiz, F);//P é o pai de F
            int j = 1;

            //adquire a posição de F em P
            while (P.filho[j - 1] != F) {
                j++;
            }

            //verifica se o irmão à esquerda de F não tem chaves para emprestar
            if (j == 1 || (P.filho[j - 2].n) == Math.floor((ordem - 1) / 2)) {
                //verifica se o irmão à direita de F não tem chaves para emprestar
                if (j == P.n + 1 || (P.filho[j].n == Math.floor((ordem - 1) / 2))) {
                    Diminui_Altura(F); //nenhum irmão tem chaves para emprestar eh necessario diminuir a altura
                } else {//caso contrario (tem chaves para emprestar) executa Balanceia_Dir_Esq
                    Balanceia_Dir_Esq(P, j - 1, P.filho[j], F);
                }
            } else {//caso contrario (tem chaves para emprestar) executa Balanceia_Esq_Dir
                Balanceia_Esq_Dir(P, j - 2, P.filho[j-2], F);
            }
        }
    }

    //Método para diminuir a altura
    //Parâmetros: X - nó onde vai ser diminuido a altura
    private void Diminui_Altura(NoB X) {
        int j;
        NoB P = new NoB(ordem);

        //verifica se X é a raiz
        if (X == this.raiz) {
            //verifica se X está vazio
            if (X.n== 0) {
                this.raiz = X.filho[0];//o filho o de x passa a ser raiz
                X.filho[0] = null; // desaloca o filho de x
            }
        } else {//caso contrario(X nao é raiz)
            int t = (int) Math.floor((ordem - 1) / 2);
            //verifica se o numero de chaves de X é menor que o permitido
            if (X.n < t) {
                P = getPai(raiz, X);//P é pai de X
                j = 1;

                //adquire a posicao correta do filho X em P
                while (P.filho[j-1] != X) {
                    j++;
                }

                //junta os nós
                if (j > 1) {
                    Juncao_NoB(getPai(raiz, X), j - 1);
                } else {
                    Juncao_NoB(getPai(raiz, X), j);
                }
                Diminui_Altura(getPai(raiz, X));
            }
        }
    }
    
    //Mótodo de Balancear da esquerda para a direita
    //Parâmetros: P - Nó pai, e - indica que Esq é o e-ésimo filho de P, Esq - Nó da esquerda, Dir - Nó da direita
    private void Balanceia_Esq_Dir(NoB P, int e, NoB Esq, NoB Dir) {
        //Desloca as chave de Dir uma posicao para a direita
        for (int i = 0; i < Dir.n; i++) 
        {
            Dir.chave[i + 1] = Dir.chave[i];
        }

        //Se Dir nao for folha descola seu filhos uma posicao para a direita
        if (!Dir.folha) {//nao foi testado, mas teoricamente funciona
            for (int i = 0; i > Dir.n; i++) 
            {
                Dir.filho[i + 1] = Dir.filho[i];
            }
        }
        
        Dir.n = Dir.n + 1;//Incrementa a quantidades de chaves em Dir
        Dir.chave[0] = P.chave[e];//"desce" uma chave de P para Dir
        P.chave[e] = Esq.chave[Esq.n - 1];//"sobe" uma chave de Esq para P
        Dir.filho[0] = Esq.filho[Esq.n];//Seta o ultimo filho de Esq como primeiro filho de Dir
        Esq.n = Esq.n - 1;//Decrementa a quantidade de chaves em Esq

    }

    //Método de Balancear da direita para a esquerda
    //Parâmetros: P - Nó pai, e - indica que Dir é o e-ésimo filho de P, Dir - Nó da direita, Esq - Nó da esquerda
    private void Balanceia_Dir_Esq(NoB P, int e, NoB Dir, NoB Esq) {

        Esq.n = Esq.n + 1;//Incrementa a quantidade de chaves em Esq
        Esq.chave[Esq.n - 1] = P.chave[e];//"desce" uma chave de P para Esq
        P.chave[e] = Dir.chave[0];//"sobe" uma chave de Dir para P
        
        
        Esq.filho[Esq.n]= Dir.filho[0];//Seta o primeiro filho de Dir como último filho de Esq

        //descola as chaves de Dir uma posição para a esquerda
        for (int j = 1; j < Dir.n; j++) {
            Dir.chave[j - 1] = Dir.chave[j];
        }

        //se Dir nao for folha, desloca todos os filhos de Dir uma posicao a esquerda
        if (!Dir.folha) {//nao foi testado, mas teoricamente funciona
            for (int i = 1; i < Dir.n+1 ; i++) {
                Dir.filho[i - 1] =  Dir.filho[i];
            }
        }

        //descrementa a quantidade de chaves de Dir
        Dir.n  = Dir.n - 1;

    }

    //Método para junção do nó
    //Parâmetros: X - NoB pai, i - posicao do filho de X onde vai ser juntado
    private void Juncao_NoB(NoB X, int i) 
    {
        NoB Y = X.filho[i - 1]; //cria Y
        NoB Z = X.filho[i];//cria Z

        int k = Y.n;
        Y.chave[k] = X.chave[i - 1];//"desce" uma chave de X para X

        //descola as de chaves de Z para Y
        for (int j = 1; j <= Z.n; j++) 
        {
            Y.chave[j + k] =  Z.chave[j - 1];
        }

        //se Z nao for folha, descola seus filhos tbm
        if (!Z.folha) 
        {
            for (int j = 1; j <= Z.n; j++) 
            {
                Y.filho[j + k] = Z.filho[j - 1];
            }
        }

        //seta a quantidades de chaves em Y
        Y.n = Y.n + Z.n+ 1;
        
        X.filho[i] = null;//desaloca o Z setando o filho de X que apontava pra Z pra null

        //descola os filhos e as chaves de X uma para a esquera, para "fechar o buraco"
        for (int j = i; j <= X.n - 1; j++) 
        {//ainda nao
            X.chave[j - 1] =  X.chave[j];
            X.filho[j] =  X.filho[j + 1];
        }

        //decrementa a quantidade de chaves em X
        X.n = X.n - 1;
    }

    //Metodo que retorna o nó onde a chave antecessora de K se encontra
    //Parâmetros: N - Nó onde começa a busca, k - chave a ser buscada
    private NoB Antecessor(NoB N, int k) 
    {
        int i = 1;
        while (i <= N.n && N.chave[i - 1] < k) 
        {
            i++;
        }
        if (N.folha) 
        {
            return N;
        } else 
        {
            return Antecessor(N.filho[i - 1], k);
        }
    }

    //Metodo que retorna o nó pai de N
    //Parâmetros: T - Nó onde começa a busca, N - nó que deve se buscar o pai
    private NoB getPai(NoB T, NoB N) {
        if (this.raiz == N) {
            return null;
        }
        for (int j = 0; j <= T.n; j++) 
        {
            if (T.filho[j] == N) 
            {
                return T;
            }
            if (T.filho[j].folha == false) 
            {
                NoB X = getPai(T.filho[j], N);
                if (X != null) 
                {
                    return X;
                }
            }
        }
        return null;
    }

    //Método para Limpar a arvoreB.
    //Parâmetros: N - Nó onde se deve iniciar a varredura, ordem - NoBva ordem da arvoreB
    public void LimparArvore(NoB N, int ordem) 
    {

        for (int i = 0; i < N.n + 1; i++) 
        {
            if (N.folha == false) 
            {
                LimparArvore(N.filho[i], ordem);
            }
            N.filho[i] = null;
            N.n = 0;
        }

        if (N == this.raiz) {
            this.raiz = new NoB(ordem);
        }
        nElementos = 0;
    }
    
    // Print out the structure of the tree
    void dis(NoB r, int n) 
    {
    if (r != null)    
    {
      for (int i = r.n; i >= 1; i--) 
      {
        dis(r.filho[i],n+4);
        for (int j = 1; j <= n; j++) 
        {
        //System.out.print(" ");
        System.out.println(r.chave[i]);
        }
      }
      dis(r.filho[0], n+4);
     }
  }
}
