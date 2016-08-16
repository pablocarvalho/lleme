      program Busca
        implicit none
        integer tam
        parameter (tam=9)
        integer numeros(tam),chave,busca
        
        data numeros/12,34,105,1,5,23,77,89,39/
        
        chave = 24
        write (*,*) busca(numeros,tam,chave)
        pause
          
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
      
