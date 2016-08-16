      program listaEx3
        
        implicit none
        integer numero1, numero2, numero3, extra
        
        OPEN(UNIT=1, FILE='aulas.txt', STATUS='UNKNOWN')
        write (*,'(A20)')'digite tres numeros'
        read (*,'(I3) ') numero1
        read (*,'(I3) ') numero2
        read (*,'(I3) ') numero3
        if (numero1 .gt. numero2) then
            extra = numero1 
            numero1 = numero2
            numero2 = extra
        endif
        if (numero1.gt.numero3) then
            extra = numero1
            numero1 = numero3
            numero3 = extra
        endif
        if (numero2.gt.numero3) then
            extra = numero2
            numero2 = numero3
            numero3 = extra
        endif
        write (*,'(2I5)') numero3,numero1
        read (*,'(I3) ')       
        Close (UNIT=1, STATUS='Keep')
    
      end
