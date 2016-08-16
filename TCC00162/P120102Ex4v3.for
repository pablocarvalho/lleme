      program P120102Ex4
        implicit none
        integer n,cont
        logical ePerfeito
        n=2
        cont = 0
        while(cont.lt.5)do
          if (ePerfeito(n)) then
            cont = cont + 1
            write (*,'(I5)') n
          end if
          n=n+1
        end while   
        pause
      end
      
      logical function ePerfeito(n)
        implicit none
        integer n,divisor,soma
        divisor = 1
        soma = 0
        do divisor=n-1,1,-1
          if (mod(n,divisor).eq.0) then
            soma = soma + divisor
          end if
        end do
        if (soma .eq. n) then
          ePerfeito = .true.
        else
          ePerfeito = .false.
        end if
      end 
