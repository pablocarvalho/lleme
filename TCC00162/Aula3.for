      program conversao
        implicit none 
        integer horas, minutos, segundos, total
        OPEN(UNIT=1, FILE='aulas.txt', STATUS='UNKNOWN')
        write (*,'(A30)') 'Entre com o total de segundos: '
        read (*,'(I5)') total        
        horas = total / 3600
        minutos = mod(total,3600) / 60
        segundos = mod(mod(total,3600),60)
        write (1,'(A20,I5)') 'Horas: ', horas
        write (1,'(A20,I5)') 'Minutos: ', minutos
        write (1,'(A20,I5)') 'Segundos: ', segundos
        Close (UNIT=1, STATUS='Keep')
      end

