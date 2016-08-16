      program Vetor
        implicit none
        integer faixas,faixa,i,erro,descobreFaixa
        parameter (faixas=4)
        real histograma(faixas),n1,n2,nota
      
        n1=3.0
        n2=7.0
        
        do i=1,faixas,1
          histograma(i) = 0.0
        end do
        
        open (unit=1,file='notas.txt',status='unknown')
        read (1,'(F5.2)',iostat=erro) nota
        soma = 0
        while (erro .eq. 0) do
      
          if (nota .ge. n1 .and. nota .le. n2) then
            soma = soma + 1
            faixa = descobreFaixa(nota,n1,n2,faixas)
            histograma(faixa) = histograma(faixa) + 1
          end if
        

          read (1,'(F5.2)',iostat=erro) nota      
        end while
        
        do i=1,faixas,1
          write (*,*) histograma(i)/soma
        end do
        close (unit=1,status='keep')
        pause
      end
      
      integer function descobreFaixa(nota,n1,n2,faixas)
        implicit none
        integer faixas,faixa
        real nota,n1,n2,delta
        
        delta = (n2-n1)/faixas
        faixa = (nota-n1)/delta+1
        if (faixa .gt. faixas) then
          faixa = faixas
        end if
        descobreFaixa = faixa
      end
