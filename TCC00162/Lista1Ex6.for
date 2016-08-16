      program Lista1Ex6
        implicit none
        integer numero
        
        OPEN(UNIT=1, FILE='aulas.txt', STATUS='UNKNOWN')
        write (*,'(A20)') 'digite o numero'
        read (*,'(I5)') numero
        if (mod(numero,2) .eq. 0) then
          write (*, '(A10)') 'par'
        else
          write (*,'(A10)') 'impar'
        end if
        read (*,'(I5)') numero
        Close (UNIT=1, STATUS='Keep')
      end
