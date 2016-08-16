      program leonardonaofoirelacaodedoisnumeros
        implicit none
        integer a,b
        write(*,'(A26)')'Primeiro Numero'
        read(*,'(I4)') a
        write(*,'(A26)')'Segundo Numero'
        read(*,'(I4)') b
        if(a.lt.b)then
          write(*,'(I5,A3,I5)')a,' < ',b
        else if(a.eq.b)then
          write(*,'(I5,A3,I5)')a,' = ',b
        else
          write(*,'(I5,A3,I5)')a,' > ',b
        end if
c       vacilo leo
        pause
      end
      
