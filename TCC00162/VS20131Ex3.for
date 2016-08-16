      program VS20131Ex3
        implicit none
        integer dim,dim2,tam1,tam2,i
        parameter (dim=100,dim2=1000)
        integer pedido(dim,3),codigos(dim2)
        integer carregaProdutos,carregaPedido,
     +  buscaPreco
        real precos(dim2),valor
        
        tam1 = carregaProdutos(codigos,precos,dim2,
     +  'produtos.txt')
        tam2 = carregaPedido(pedido,dim,'pedido.txt')
        valor = 0
        do i=1,tam2
          valor = valor + pedido(i,3)*
     +    buscaPreco(codigos,precos,tam1,pedido(i,2))
        end do
        write (*,*) valor
      end

      integer function carregaPedido(pedido,dim,
     +arquivo)
        implicit none
        character*11 arquivo
        integer dim
        integer pedido(dim,3),cont,codigo,
     +  produto,qtd,erro
        
        open (unit=1,file=arquivo,status='unknown')
        read (1,'(I5,F5.2)',iostat=erro) codigo,
     +  produto,qtd
        cont = 0
        while (erro .eq. 0 .and. cont .lt. dim) do
          cont = cont + 1
          pedido(cont,1) = codigo
          pedido(cont,2) = produto
          pedido(cont,3) = qtd
          read (1,'(I5,F5.2)',iostat=erro) codigo,
     +    produto,qtd
        end while
        close (unit=1,status='keep')
        carregaPedido = cont
      end
      
            
      integer function carregaProdutos(codigos,precos,
     +dim,arquivo)
        implicit none
        character*11 arquivo
        integer dim,cont,codigos(dim),codigo,erro
        real precos(dim),preco
        
        open (unit=1,file=arquivo,status='unknown')
        read (1,'(I5,F5.2)',iostat=erro) codigo,preco
        cont = 0
        while (erro .eq. 0 .and. cont .lt. dim) do
          cont = cont + 1
          codigos(cont) = codigo
          precos(cont) = preco
          read (1,'(I5,F5.2)',iostat=erro) codigo,preco
        end while
        close (unit=1,status='keep')
        carregaProdutos = cont
      end
      
      real function buscaPreco(codigos,precos,dim,
     +chave)
        implicit none
        integer dim,codigos(dim),i,chave
        real precos(dim)
        logical achei
        achei = .false.
        buscaPreco = -1.0
        i=1
        while (.not. achei .and. i .le. dim) do
          if (codigos(i) .eq. chave) then
            achei = .true.
            buscaPreco = precos(i)
          end if
          i = i + 1
        end while
      end
      
