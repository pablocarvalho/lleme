      program P120112Ex1
        implicit none
        integer mmc, n(3), d
        n(1)=13
        n(2) = 15
        n(3) = 24
        d = 2
        mmc = 1
        while (houverDiferenteUm(n,3).eq.1) do
          
          while (hoverDivisivel(n,3,d)) do
            dividirQuemPuder(n,3,d)
            mmc = mmc * d
          end while
          if (d.eq.2)then
            d = d +1
          else
            d = d + 2
          end if
        end while
        write (*,'(I5)') mmc
        pause
      end
      
      integer function houverDiferenteUm(n,t,d)
      
        achou = 0
        while (achou.eq.0) do
          if (n(i).eq.1) then
            achou = 1
          end if
         
      
      end
      

