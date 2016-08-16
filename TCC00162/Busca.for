      program Busca
        implicit none
        integer mat,N
        parameter(N=50)
        integer matriculas(N)
        real notas(N,2)
        
        
        
        cont = 1
        open
        read (ios) matriculas(cont),notas(cont,1),notas(cont,2)
        while (ios .eq.0 .and. cont .le. N) do
        
          cont = cont + 1
          if (cont .le. N) then
            read (ios) matriculas(cont),notas(cont,1),notas(cont,2)
          end if
        end
        cont = cont - 1
        close
        
        
        
        write (*)
        read (*) mat
        mat=567
        write (1,'(F4.2)') media(mat,cont,matriculas,notas)
        
      
      
      end
      
      real function media (chave,tamanho,vetor,notas)
        implicit none
        integer fim, chave, tamanho, vetor(tamanho)
        posicao = -1
        fim = 0
        i = 1
        while (i .le. tamanho .and. fim .eq. 0) do
          if (vetor(i) .eq. chave) then
             fim = 1
             posicao = i
          else if (vetor(i) .gt. chave) then
             fim = 1
          end if
          i=i+1
        end while
        
        if (posicao .ne. -1) then
          media = (notas(posicao,1) + notas(posicao,2))/2
        end if
      
      end
