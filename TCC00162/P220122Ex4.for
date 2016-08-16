      program P220122Ex4
        implicit none
        integer m,n,v
        parameter (m=3,n=3)
        integer matriz(m,n)
        data matriz/1,2,1,2,3,4,1,2,3/
        call operar(matriz,m,n,1,2,3)
        read (*,'(I1)') v
      end
     
      subroutine operar(matriz,m,n,linha1,linha2,coef)
        implicit none
        integer m,n,j,linha1,linha2,coef
        integer matriz(m,n)
        
        do j=1,n
          matriz(linha1,j) = matriz(linha1,j) + coef*matriz(linha2,j)
        end do
      end
