      program sassenfeld
        implicit none
        integer n,i,j
        logical satisfy
        parameter (n=3)
        real*8  mat(n,n+1), sol1(n), sol2(n),precisao
        data mat/3.D0, 1.D0, 3.D0,
     +  0.D0, -1.D0, 1.D0,
     +  1.D0, 0.D0, 2.D0/
        data sol1/3.D0,-1.D0,9.D0/
      
        OPEN(UNIT=1, FILE='sassenfeld.txt', STATUS='UNKNOWN')
        
        IF (satisfy_sassenfeld(mat,n)) THEN
          write(1,*) 'SATISFAZ'
        ELSE
          write(1,*) 'NAO SATISFAZ'
        END IF
        
        do i=1,5
          call gauss_seidel(mat,sol1,sol2,n)
          write (1,'(A10,1PE15.5E2)')'precisao = ',precisao(sol1,sol2,n)
          do j=1,n
            write(1,*) 'x', j, '=', sol2(j)
            sol1(j)=sol2(j)
          end do
          write(1,'(/)')
        end do
        CLOSE (UNIT=1, STATUS='Keep')
      end
      
      real*8 function distancia(sol1,sol2,n)
       implicit none
       integer i,n
       real*8 sol1(n),sol2(n), aux, distancia
       distancia = abs(sol1(1)-sol2(1))
       do i=2,n
         aux = abs(sol1(i)-sol2(i))
         if (aux .gt. distancia) then
           distancia = aux
         end if
        end do
      end 
      
      SUBROUTINE gauss_seidel(mat,sol1,sol2,n)
        implicit none
        integer n,i,j
        real*8 mat(n,n+1),sol1(n),sol2(n)
        do i=1,n
          sol2(i)=0.D0
          do j=1,n
            if (j .LT. i) then
              sol2(i)=sol2(i)-mat(i,j)*sol2(j)
            else
              if (j .EQ. i) then
                sol2(i)=sol2(i)+mat(i,n+1)
              else 
                sol2(i)=sol2(i)-mat(i,j)*sol1(j)
              end if
            end if
          end do
          sol2(i)=sol2(i)/mat(i,i)
        end do
      end
      
      SUBROUTINE permute(mat,n,i,j)
        implicit none
        integer n,i,j,k
        real*8 mat(n,n),aux
        do k=1,n+1
          aux=mat(i,k)
          mat(i,k)=mat(j,k)
          mat(j,k)=aux
        end do
      end
      
      logical function satisfy_sassenfeld(mat,n)
        implicit none
        integer n,i
        real*8 mat(n,n), aux, bi
        satisfy_sassenfeld= .TRUE.
        i=1
        WHILE (i .LE. n) DO
           aux=bi(mat,n,i)
           IF (aux .GE. 1.) THEN
             satisfy_sassenfeld = .FALSE.
           END IF
           write (1,*) 'B', i, '=', bi(mat,n,i)
           i=i+1
        END WHILE
      end
      
      real*8 function bi(mat,n,i)
        implicit none
        integer n,i,j
        real*8 mat(n,n)
        bi=0.
        do j=1,n
          if (j .LT. i) then
            bi=bi+bi(mat,n,j)*abs(mat(i,j))
          else
            if (j .GT. i) then
              bi=bi+abs(mat(i,j))          
            end if
          end if
        end do
        bi=bi/abs(mat(i,i))
      end
