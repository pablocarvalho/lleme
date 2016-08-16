      program P220122Ex2
        implicit none
        integer n,somatorio
        write (*,'(I10)') somatorio(3)
        read (*,'(I10)') n
      end
      
      integer function somatorio(n)
        implicit none
        integer n
        if (n .gt. 1) then
          somatorio = (2**n+3) + somatorio(n-1)
        else
          somatorio = 2+3
        end if
      end
