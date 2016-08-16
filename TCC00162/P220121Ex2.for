      program P220121Ex2
        integer n2,faixas2
        real notas2(n2),hist(faixas2),min2,masx2
        
      
        call histograma(notas2,n2,faixas2,min2,max2,hist2)
      
      
      end
      
      
      subroutine histograma(notas,n,faixas,min,max,hist)
        integer n,faixas
        real notas(n),min,max,hist(faixas)
        
        do i=1,faixas
          hist(i) = 0
        end do
        
        delta = (max - min)/faixas
        do i=1,n,1
        
          faixa = (notas(i) - min)/delta + 1
          if (faixa .gt. faixas) then
            faixa = faixas
          end if
          hist(faixa) = hist(faixa) + 1
        end do
        
        do i=1,faixas,1
          hist(i) = hist(i)/n
        end do
        
      end
