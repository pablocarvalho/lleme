      program VS20131Ex2
        implicit none
        integer dim
        parameter (dim=3)
        real mat(dim,dim+1),calcular
        data mat/1.,0.,0.,1.,1.,0.,0.,0.,5.,3.,-2.,
     +  2./
        write (*,*) calcular(mat,dim,2)
        pause
      end
      
      
      real function calcular(mat,dim,var)
        implicit none
        integer i,var,dim
        real mat(dim,dim+1),numerador
        numerador = mat(var,dim+1)
        do i=var+1,dim
          numerador = numerador - mat(var,i)*
     +    calcular(mat,dim,i)
        end do
        calcular = numerador / mat(var,var)
      end
