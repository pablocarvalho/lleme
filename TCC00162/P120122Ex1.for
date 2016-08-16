      program P120122Ex1
        implicit none
        integer*4 n,ePalindromo
        
        n = 123566321
        write (*,'(I2)') ePalindromo(n)
        read (*,'(I2)') n
      end
      
      integer*4 function ePalindromo(n)
        implicit none
        integer*4 n,digitos,digE,digD
        
        ePalindromo = 1
        while (n .gt. 9 .and. ePalindromo .eq. 1) do
          digitos = log10(n*1.0)+1
          digE = n / (10**(digitos-1)) 
          digD = mod(n,10)
          if (digE .ne. digD) then
            ePalindromo = 0
          else
            n = mod(n/10,10**(digitos-2))
          end if
        end while
      end
        
        
        
      
      
