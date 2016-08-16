      program MultiplicaMat
        implicit none
        integer m1,n1,m2,n2,i,j,k
        parameter (m1=3,n1=3,m2=3,n2=3)
        real a(m1,n1),b(m2,n2),c(m1,n2)
      
        call lerMatriz('matriza.txt',a,m1,n1)
        call lerMatriz('matrizb.txt',b,m2,n2)
      
        do i=1,m1,1
          do j=1,n2,1
            c(i,j) = 0
            do k=1,n1,1
              c(i,j) = c(i,j) + a(i,k)*b(k,j)
            end do      
          end do
        end do
        
        call escreverMatriz('matrizz.txt',c,m1,n2)
      
      end
      
      subroutine escreverMatriz(arquivo,mat,m,n)
        implicit none
        character*11 arquivo
        integer i,j,m,n
        integer mat(m,n)
        
        do i=1,m
          do j=1,n
            write (1,*) mat(i,j)
          end do
          pular linha
        end do
        
      end
      
      subroutine lerMatriz(arquivo,mat,m,n)
        implicit none
        character*11 arquivo
        integer i,j,m,n,erro,cont,numero
        integer mat(m,n)
        open (unit=1,file=arquivo,status='unknown')
        read (1,'(I5)',iostat=erro) numero
        cont=0
        while (erro .eq. 0) do
          i = cont/n+1
          j = mod(cont,n)+1
          mat(i,j) = numero
          read (1,'(I5)',iostat=erro) numero
          cont=cont+1
        end while
        close (unit=1,status='keep')
      end 
