      program P120102Ex4
         
        num=2
        cont=0
        
        while (cont .lt. 4) do
          if (ePerfeito(num)) then
            write (1,'') num
            cont = cont + 1
          end if
          num = num + 1
        end while
      
      end
      
      integer ePerfeito(n)
        ePerfeito = 1
        div=2
        soma=0
        do div=1,n-1,1
          if (mod(n,div).eq. 0) then
            soma = soma + div
          end if
        end do
        if (soma .eq. n) then
          ePerfeito = 1
        else
          ePerfeito = 0
        end
      end
