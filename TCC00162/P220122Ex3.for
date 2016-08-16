      program P220122Ex3
        implicit none
        integer capac,n,lidos,ios
        parameter(capac=50,n=2)
        real numeros(capac),hist(2*n),num,min,media,max
        lidos = 0
        media = 0
        
        OPEN(UNIT=1, FILE='numeros.txt', STATUS='UNKNOWN')
        read(1,'(F10.5)', IOSTAT = ios) num
        if (ios .eq. 0) then
          min = num
          max = num
        end if
        while (ios .eq. 0 .and. lidos .le. capac) do
          lidos = lidos + 1
          if (num .lt. min) then
            min = num
          end if
          if (num .gt. max) then
            max = num
          end if
          media = media + num
          numeros(lidos) = num
          read(1,'(F10.5)', IOSTAT = ios) num
        end while
        media = media/lidos
        call histograma(numeros,lidos,min,media,max,n,hist)
        media = 0
      end
      
      subroutine histograma(numeros,qtd_num,min,media,max,n,hist)
        implicit none
        integer qtd_num,n,i,faixa
        real numeros(qtd_num),hist(2*n),num,media,min,max,delta
        do i=1,qtd_num
          num = numeros(i)
          if (numeros(i) .lt. media) then
            delta = (media-min)/n
            faixa = ((num-min)/delta)+1
          else
            delta = (max-media)/n
            faixa = ((num-min)/delta)+1
            if (faixa .gt. 2*n) then
              faixa = 2*n
            end if
          end if
          hist(faixa) = hist(faixa)+1
        end do
        do i=1,n
          hist(i) = hist(i)/qtd_num
        end do
      end
