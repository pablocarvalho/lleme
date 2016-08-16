      program Lista1Ex5
        implicit none
        real raio, calcdiametro, calccircunferencia, calcarea
        OPEN (UNIT=1, FILE= 'resultado5.txt')
                 
        write (*, '(A20)') ' Digite o raio : '
        read (*, '(F9.5)') raio
                 
        write (1, '(A20,F9.5)') 'Diametro: ',calcdiametro (raio)
        write (1, '(A20,F9.5)') 'Circunferencia: ',calccircunferencia
     +  (raio)
        write (1, '(A20,F9.5)') 'Area: ',calcarea (raio)

      CLOSE (UNIT=1, STATUS='Keep')
      end

      real function calcdiametro (raio)
        implicit none
        real raio
        calcdiametro= 2*raio
      end
          
      real function calccircunferencia (raio)
        implicit none
        real raio, pi
        parameter (pi=3.14159)  
        calccircunferencia= 2*pi*raio
      end   
                
      real function calcarea (raio)
        implicit none
        real raio, pi
        parameter (pi=3.14159)  
        calcarea= pi*(raio**2)
      end
                
                
                
