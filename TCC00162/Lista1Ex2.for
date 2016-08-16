      program Lista1ex2
        implicit none
        integer a,b
        write (*,'(A20)') 'Digite um numero: '
        Read (*,'(I3)') a
        write (*,'(A20)') 'Digite outro numero: '
        read (*,'(I3)') b
        call testa (a,b)
        call testa (10,15)
        call testa (a,15)
        call testa (2*a,3*b+4)
      end
      
      Subroutine testa (c,d)
        implicit none
        integer c,d
        open (unit=1,file='exercicio.txt')
        if (c .eq. d) then
          write (1, '(A20)') ' Sao iguais '
        else if (c .gt. d) then
          write (1,'(A20)') 'c maior do que d'
        else
          write (1,'(A20)') 'c e menor do que d'
        end if
        close (unit=1,status='keep')
        
      end
        
        
