      program Lista3Ex8
        integer codigo,qtd
        real valorEmEstoquePeca,valorEstoque,preco
        open(unit=1,file='estoque.txt',status='uknown')
        read(1,'',iostat=erro) codigo,qtd,preco
        while (erro .eq. 0) do
          valorEstoque = valorEstoque + valorEmEstoquePeca(qtd,preco)
          read(1,'',iostat=erro) codigo,qtd,preco
        end while
        close(unit=1,status='keep')
      
      
      end
      
      real function valorEmEstoquePeca(qtd,precoUnitario)
        implicit none
        real precoUnitario
        integer qtd
        valorEmEstoquePeca = qtd * precoUnitario
      end
