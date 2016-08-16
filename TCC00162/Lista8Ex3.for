      program Lista1Ex3
        implicit none
        integer m
        parameter (m=3)
        integer matriz1(m,m)
      
        call inicializa(matriz1,m)
      
        write (*,'(A20)') 'dfsdf'
      
      end
      
      subroutine inicializa(matriz,n)
        integer n
        
        do i=1,n,1
          do j=1,n,1
             if (i .eq. j) then
               matriz(i,j) = 1
             else
               matriz (i,j) = 0
             end if
          end do
        end do
      
      end
