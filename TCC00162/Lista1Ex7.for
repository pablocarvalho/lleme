      program Lista1Ex7
        implicit none
        integer num, ePrimo, divisor
        write(*,'(A20)')'Digite o numero'
        read(*,'(I20)')num
        divisor=ePrimo(num)
        if(divisor.eq.1)then
          write(*,'(A20)')'E primo' 
        else
          write(*,'(A20,I10)')'Nao primo ', divisor
        end if
        pause  
      end
      integer function ePrimo(numero)
        implicit none
        integer numero, divisor
        if(numero.lt.2)then
          ePrimo=0
        else  
          ePrimo=1
          divisor=2
          if(mod(numero,divisor).eq.0)then
            ePrimo=divisor
          end if
          divisor=divisor+1                  
          while(ePrimo .eq. 1 .and. divisor .le. sqrt(numero*1.0) ) do
            if(mod(numero,divisor).eq.0)then
              ePrimo=divisor
            end if
            divisor=divisor+2
          end while
        end if
      end    
          
            
        
        
             
