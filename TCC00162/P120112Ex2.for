      program P120112Ex2
        implicit none
        integer matricula, qtd, ios
        real nota, media
        qtd = 0
        media = 0 
        open(unit=1, file='notas.txt')
        read(1,'(I5,F4.2)', IOSTAT = ios) matricula, nota
        while(ios .eq. 0) do
          media = media + nota
          qtd = qtd + 1
          read(1,'(I5,F4.2)', IOSTAT = ios) matricula, nota
        end while
        media = media / qtd
        close(1,status='keep')
                
        open(unit=1, file='notas.txt')
        open(unit=2, file='notasInferiores.txt')
        read(1,'(I5,F4.2)', IOSTAT = ios) matricula, nota
        while(ios .eq. 0) do
          if (nota .lt. media) then
            write(2,'(I5,F6.2)') matricula, nota
          end if
          read(1,'(I5,F4.2)', IOSTAT = ios) matricula, nota
        end while
        close(1,status='keep')
        close(2,status='keep')      
      end
