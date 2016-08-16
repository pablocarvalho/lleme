      program Lista1Ex1
        implicit none
        
        integer a,b
        
        open (unit=1, file='aulas.txt', status='unknown')
        write (*, '(A30)') 'primeiro numero'
        read (*,'(I4)') a
        write (*, '(A30)') 'segundo numero'
        read (*,'(I4)') b
        
        write (*,'(A7,I10)') 'soma = ',a + b
        write (*,'(A10,I10)') 'diferanca = ',a - b
        write (*,'(I10)') a * b
        write (*,'(I10)') a / b
        write (*,'(I10)') a ** b
        write (*,'(I10)') mod(a,b)
        
        pause
      
        close (unit=1, status='keep')
      end
