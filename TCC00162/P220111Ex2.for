      program P220111Ex2
        implicit none
        real determinante
        integer dim
        parameter (dim=4)
        real a(dim,dim)
        data a/3.,0.,2.,1.,-1.,2.,0.,1.,5.,0.,-1.,2.,
     +  0.,1.,3.,0./
C       data a/1.0,1.0,3.0,11.0/
        write (*,*) determinante(a,dim)
        pause
      end
     
      subroutine cofator (mat,dim,m,n,cof)
        implicit none
        integer dim,m,n,i,j,lin,col
        real mat(dim,dim),cof(dim-1,dim-1)
        
        do i=1,dim,1
          if (i .ne. m) then
            do j=1,dim,1
              if (j .ne. n) then
                if (i .gt. m) then
                  lin = i - 1
                else
                  lin = i
                end if
                if (j .gt. n) then
                  col = j - 1
                else
                  col = j
                end if
                cof(lin,col) = mat(i,j)
              end if
            end do
          end if
        end do
      end
      
   
      real function determinante(mat,dim)
        implicit none
        integer dim,dim2,i,j
        parameter (dim2=10)
        real mat(dim,dim),cof(dim2,dim2),coef,s,det
        
        s = 0
        if (dim .eq. 1) then
          s = mat(1,1)
        else
          i=1
          do j=1,dim,1
            call cofator(mat,dim,i,j,cof)
            det = determinante(cof,dim-1)
            coef = ((-1)**(i+j))*det
            s = s + coef*mat(i,j)
          end do
        end if
        determinante = s
      end
