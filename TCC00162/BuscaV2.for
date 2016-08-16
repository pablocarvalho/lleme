      program Busca
        implicit none
        integer tam
        parameter (tam=3)
        integer v(tam),buscaOrdenada
        data v/1,4,2/
        
        call carregarPrecos('precos.txt',
        
        codigoDigitado = -1
        loop
          write (*,*) 'codigo='
          read (*,*) codigoDigitado
          if (codigoDigitado .ne. -1)
            pos=buscaOrdenada(codigos,tam,codigoDigitado)
            write (*,*) precos(pos)
          end if
        until (codigoDigitado .eq. -1)
        
      
      end
      
      subroutine carregarPrecos(arquivo,codigos,precos,tam)
        implicit none
        character arquivo
        open (unit=1,file=arquivo,status='unknown')
        pos = 0
        read (1,'(I5,F5.2)',iostat=erro) codigo,preco
        while (erro .eq. 0 .and. pos .le. tam) do
          pos = pos + 1
          codigos(pos) = codigo
          precos(pos) = preco
          read (1,'(I5,F5.2)',iostat=erro) codigo,preco        
        end while
        close (unit=1,status='keep')
      end
      
      integer function buscaOrdenada(vetor,tam,chave)
        implicit none
        integer tam,pos,posicaoChave
        integer vetor(tam),chave
        posicaoChave = -1
        possoEncontrar = .true.
        pos = 1
        while(pos .le. tam .and. posicaoChave .lt. 0 .and. possoEncontrar) do
          if (vetor(pos) .eq. chave) then
            posicaoChave = pos
          else if (vetor(pos) .gt. chave) then
            possoEncontrar = .false.
          end if
          pos = pos + 1
        end while
        buscaNaoOrdenada = posicaoChave
      end

