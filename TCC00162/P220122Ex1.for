      program P220122Ex1
        implicit none
        integer n,o,busca
        parameter (n=8)
        integer numeros(n)
        data numeros/11,22,33,44,46,55,66,77/
        write (*,'(I5)') busca(numeros,n,1,55)
        read (*,'(I5)') o
      end
      
      integer function busca(numeros,n,inicio,chave)
        integer n,inicio,chave
        integer numeros(n)
        if (inicio .le. n ) then
          if (numeros(inicio) .eq. chave) then
            busca = inicio
          else
            busca = busca(numeros,n,inicio+1,chave)
          end if
        else
          busca = -1
        end if
      end
