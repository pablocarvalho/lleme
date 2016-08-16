      program P220072v2
        implicit none
        
        open(unit=1,file='vendas.txt',status='unknown')
        read(1,'???',iostat=erro) codigo,qtd,compra,venda
        while (erro .eq. 0) do
          lucro = lucro+(venda-compra)*qtd
          read(1,'???',iostat=erro) codigo,qtd,compra,venda
        end while
        write (*,*) lucro
        close(unit=1,status='keep')
      end
