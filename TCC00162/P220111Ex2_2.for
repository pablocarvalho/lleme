      program P220111Ex2_2
      
      
      
      
      
      end
      
      real function determinante(mat,n)
        implicit none
        integer n
        real mat(n,n),cofatora(n-1,n-1)
        
        if (n .eq. 1) then
          determinante = mat(1,1)
        else
          i=1    
          do j=1,n
            coef = (-1)**(i+j)*mat(i,j)
            call extraiCofatora(mat,n,i,j,cofatora)
            s = s + coef*determinante(cofatora,n-1)
          end
        end
      end
      
      subroutine extraiCofatora(mat,n,i,j,cofatora)
        implicit none
        
        do x=1,n
          if (x .ne. i) then
            do y=1,n
              if (y .ne. j) then
                if (x .gt. i) then 
                  linha = x - 1
                else
                  linha = x
                end if
                if (y .gt. j) then
                  coluna = y - 1
                else
                  coluna = y
                end if
                cofatora(linha,coluna) = mat(x,y)
              end if
            end do
          end if
        end do
      end
      
      logical function ePalindromo(n)
        implicit none
        integer n
        if (n .lt. 10) then
          ePalindromo = .true.
        else
          dig = log10(n)
          dd = mod(n,10)
          de = n / (10**dig)
          centro = n - de*(10**dig)
          centro = centro / 10
          
          if (de .eq. dd .and. ePalindromo(centro)) then
            ePalindromo = .true.
          else
            ePalindromo = .false.
          end if
      end
      
      end
