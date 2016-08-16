      Program NotasAlunos
      
        implicit none
        integer matricula,linha, erro
        real nota,soma,media
        open (unit=1, file='notas.txt', status='unknown')
        read (1,'(I5,F4.1)', IOSTAT = erro) matricula,nota
        linha = 0
        soma = 0
        while (erro .eq. 0 .and. linha .lt. 50)do
          soma = soma + nota
          read (1,'(I5,F4.1)', IOSTAT = erro) matricula,nota
          linha = linha + 1
        end while
        media = soma / linha
        close (unit = 1, status = 'keep')
        
        open (unit=1, file='notas.txt', status='unknown')
        open (unit=2, file='notasreprovado.txt', status='unknown')
        read (1,'(I5,F4.1)', IOSTAT = erro) matricula,nota
        linha = 0
        while (erro .eq. 0 .and. linha .lt. 50)do
          if (nota .lt. media) then
            write (2, '(I5,F4.1)') matricula , nota
          end if
          read (1,'(I5,F4.1)', IOSTAT = erro) matricula , nota
          linha = linha + 1
        end while
        close (unit = 1, status = 'keep')
        close (unit = 2, status = 'keep')
        
      end
