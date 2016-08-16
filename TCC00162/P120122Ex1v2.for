      program P120122Ex1v2
        implicit none
        integer numero,digitos,de,dd
        integer ePalindromo
        
        numero = 4551754
        
        ePalindromo=1
        digitos = log10(numero*1.0)+1
        while (digitos .gt. 1 .and. ePalindromo .eq. 1) do
          de = numero / (10**(digitos-1))
          dd = mod(numero,10)
          if (de .ne. dd) then
            ePalindromo = 0
          end if
          numero = numero / 10
          numero = numero - de*(10**(digitos-2))
          digitos = log10(numero*1.0)+1
        end while
        write(*,'(I4)') ePalindromo
        pause
      end
