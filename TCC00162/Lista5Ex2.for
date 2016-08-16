      program Lista5Ex2
        implicit none
        integer n,x
		n = 97
        open (unit=1, file='resultado.txt')
                
        do x = n-1,2,-1
          if (mod(n,x) .eq. 0) then
            write (1,'(I5)') x
          end if
        end do
        
        close (unit=1, status='keep')
      end
