      program MultMat
        
        
        integer a(m,n), b(n,o) c(m,o)
      
        do i=1,m
          do j = 1,o
            c(i,j) = 0
            do k = 1,n
              c(i,j) = c(i,j) + a(i,k)*b(k,j)
            end do
          end do
        end do
      
      end
