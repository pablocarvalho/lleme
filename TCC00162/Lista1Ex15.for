      program Lista1Ex15
        implicit none
        real imposto,multa,calculaMulta
        integer atraso
            
        open (unit=1, file='resultado.txt')
        write (*,'(A30)') 'Digite o valor do imposto'
        read (*,'(F12.5)') imposto
        write (*,'(A30)') 'Digite o tempo de atraso'
        read (*,'(I2)') atraso
                
        multa = calculaMulta(imposto,atraso)
        imposto = imposto + multa
        write (1,'(2F12.5)') imposto,multa
               
        close (unit=1, status='keep')
      end
          
      real function calculaMulta(i,a)
        implicit none
        real i
        integer a
        if (i .lt. 100.0) then
          calculaMulta = 2.0*a
        else if (i .ge. 100.0 .and. i .le. 500.0) then
          calculaMulta = 4.0*a
        else
          calculaMulta = 8.0*a
        end if
      end
