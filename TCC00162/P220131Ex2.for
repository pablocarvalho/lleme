      program P220131Ex2
        implicit none
        integer n,i,j
        parameter (n=5)
        integer mat (n,n)
        
        do i=1,n
          do j=1,n
            if (i .eq. j) then
              mat(i,j)=1
            else if (j .eq. i+1) then
              mat(i,j)=2
            else if (i .eq. j+1) then
              mat(i,j)=3
            else
              mat(i,j)=0
            end if
          end do
        end do
        pause
      end
      
      subroutine histograma (numeros,m,h,n)
        implicit none
        integer m,n,faixa,i,j
        integer h(n)
        real min,max,delta,numeros(m)
        
        min=0.0
        max=100.0
        delta= 100.0/n
        
        do i=1,n
          h(i)=0
        end do
        
        do i=1,m
          faixa=numeros(i)/delta+1
          if (faixa .gt. n) then
            faixa=n
          end if
          do j=faixa,1,-1
            h(i)=h(i)+1
          end do
        end do
      end
      
      integer function somaElementos(vet,n,pos)
        implicit none
        integer n,pos
        integer vet(n)
        if (pos .le. n) then
          somaElementos=vet(pos)+somaElementos(vet,n,pos+1)
        else
          somaElementos=0
        end if
      end
