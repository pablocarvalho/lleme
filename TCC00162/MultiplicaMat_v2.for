      program MultiplicaMat
        implicit none
        integer m1,n1,m2,n2
        
        read m1,n1,m2,n2
        
      
      
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
      
      
      subroutine multiplica (arquivo1,m1,n1,arquivo2,m2,n2)
        implicit none
        integer m1,n1,m2,n2
        integer a(m1,n1),b(m2,n2),c(m1,n2)
        
        call lerMatriz(arquivo1,a,m1,n1)
        call lerMatriz(arquivo2,b,m2,n2)
        
        do i=1,m1
          do j=1,n2
            c(i,j) = 0
            do k=1,n1
              c(i,j) = c(i,j) + a(i,k)*b(k,j)
            end do
          end do
        end do
        
        call escreverMatriz(c,m1,n2)   
      
      end
      
      subroutine escreverMatriz(mat,m,n)
        implicit none
        integer m,n,i,j
        integer mat(m,n)
        
        open (unit=1,file='matriz.txt',status='unknown')
        do i=1,m
          do j=1,n
            write (1,'(\I10)') c(i,j)
          end do
          write (1,'(/\)')
        end do            
        
        close (unit=1,status='keep')
      end
