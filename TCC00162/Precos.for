      program Precos
        implicit none
        integer tam
        parameter (tam=50)
        integer codigos(tam),precos(tam)
        character arquivo
        
        arquivo = 'precos.txt'
        call carregarPrecos(arquivo,codigos,precos,tam)
        
        loop
          write (*,*) 'numero?'
          read (*,*) codigo
          if (codigo .ne. -1) then
            pos = busca(codigos,tam,codigo)
            if (pos .gt. 0) then
              preco = precos(pos)
              write (*,*) preco
            end if
          end if
        until (codigo .ne. -1)
      end
      
      subroutine carregarPrecos(arquivo,codigos,precos,tam)
        implicit none
        integer tam
        integer codigos(tam),precos(tam)
        character arquivo
        open (unit=1,file=arquivo,status='unknown')
        read (1,'(I5,F5.2)',iostats=erro) codigo,preco
        pos = 0
        while (erro .eq. 0 .and. pos .le. tam) do
          pos = pos + 1
          codigos(pos) = codigo
          precos(pos) = preco
          read (1,'(I5,F5.2)',iostats=erro) codigo,preco
        end while
        close (unit=1,status='keep')
      end 
      
      integer function busca(numeros,tam,chave)
        implicit none
        integer tam
        integer numeros(tam),chave,achou,pos
        pos = 1
        achou = -1
        while (achou .lt. 0 .and. pos .le. tam) do
          if (numeros(pos) .eq. chave) then
            achou = pos
          end if
          pos = pos + 1
        end while
        busca = achou
      end
