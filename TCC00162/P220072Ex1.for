      program P220072Ex1
        implicit none
        integer codigo,qtd
        real compra,venda,soma,lucro
        
        open (unit=1,file='vendas.txt',status='unknown')
        read (1,'(2I5,2F5.2)',iostat=erro) codigo,qtd,compra,venda
        soma = 0
        while (erro .eq. 0) do
          lucro = qtd * (venda-compra)
          soma = soma + lucro
          read (1,'(2I5,2F5.2)',iostat=erro) codigo,qtd,compra,venda
        end while
        write (*,*) soma
        close (unit=1,status='keep')
      end
