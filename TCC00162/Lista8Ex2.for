      program Lista8Ex2
      
      
      end
      
      
      real function traco(matriz,n)
        i=1
        traco = 0 
        do i=1,n
          traco = traco + matriz(i,i)
        end do
      end
