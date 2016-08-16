      program CargaMat
      
      read (1,'', ios) numero
      cont = 0
      lnhs = m
      cols = n
      while (ios .eq. 0 .and. cont .le. m*n+o*p) do
        cont = cont + 1
        if (cont .le. m*n) then
          lnhs = m
          cols = n
          qtq = cont
        else
          lnhs = o
          cols = p
          qtd = cont - (m*n)
        end if
        
        if (mod(cont,lnhs) .ne. 0) then
          i = qtd/lnhs + 1
          j = mod(qtd,lnhs)
        else
          i = qtd/lnhs
          j = cols
        end if
        
        if (cont .le. m*n) then
          m1(i,j) = numero
        else
          m2(i,j) = numero
        end if  
          
        read (1,'',ios) numero
        
      end while
      
      
      
      
      end
