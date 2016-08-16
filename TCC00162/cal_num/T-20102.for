      program volume
        implicit none 
        real raio, calcVolume   
        
        OPEN(UNIT=1, FILE='aulas.txt', STATUS='UNKNOWN')
        
        write (*,'(A30)') 'Entre com o raio da esfera: '
        
        read (*,'(F3.1)') raio
        
        write (1,'(A20,F10.3)') 'Volume da esfera:  ', calcVolume(raio)


        Close (UNIT=1, STATUS='Keep')
      end
      
      real function calcVolume(raio)
        implicit none
        real raio, PI
        parameter (PI=3.141592653)
        calcVolume = (4.0 / 3.0) * PI * (raio ** 3)
      end

