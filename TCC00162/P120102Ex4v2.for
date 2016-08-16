      program P120102Ex4
        implicit none
        integer n,cont
        logical ePerfeito
        n=2
        cont=0
        while(cont.lt.4) do
          if (ePerfeito(n)) then
            write (*,'(I5)') n
            cont = cont +1
          end if
          n = n+1
        end while
        pause
      end
      
      
      logical function ePerfeito(n)
        implicit none
        integer n,i,soma
        soma=0
        do i=n-1,1,-1
          if (mod(n,i).eq.0) then
            soma=soma+i
          end if
        end do
        if (soma.eq.n) then
          ePerfeito=.true.
        else
          ePerfeito=.false.
        end if
      end
