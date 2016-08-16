      program Vetor
        implicit none
        integer alunos,faixas,faixa
        parameter (alunos=50,faixas=4)
        integer cont,i,descobreFaixa,erro
        real notas(alunos),n1,n2,nota,histograma(faixas)
        
        n1=2.0
        n2=8.0
        do i=1,faixas,1
          histograma(i) = 0.0
        end do
        
        cont = 0
        open (unit=1,file='notas.txt',status='unknown')
        read (1,'(F5.2)',iostat=erro) nota
        while (erro .eq. 0 .and. cont .le. alunos) do
        
          if (nota .ge. n1 .and. nota .le. n2) then
            cont = cont + 1
            notas(cont) = nota
            faixa = descobreFaixa(nota,n1,n2,faixas)
            histograma(faixa) = histograma(faixa) + 1
          end if
         
          read (1,'(F5.2)',iostat=erro) nota
        end while
        do i=1,faixas
          write (*,*) histograma(i)/cont
        end do
        pause
        close (unit=1,status='keep')
      end
      
      integer function descobreFaixa(nota,n1,n2,faixas)
        implicit none
        real nota,n1,n2,delta
        integer faixas,faixa
        delta = (n2-n1)/faixas
        faixa = nota/delta+1
        if (faixa .gt. faixas) then
          faixa = faixas
        end if
        descobreFaixa = faixa
      end
        
      
