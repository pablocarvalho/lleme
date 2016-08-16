      program M3_GaussSeidel
        implicit none
        integer n,i,j
        logical satisfy_sassenfeld
        parameter (n=3)
        real*8  mat(n,n+1),sol1(n),sol2(n),distancia,zero(n)
        data mat/5.D0, 3.D0, 3.D0,
     +           1.D0, 4.D0, 3.D0,
     +           1.D0, 1.D0, 6.D0, 
     +           5.D0, 6.D0, 0.D0/
        data sol1/0.D0, 0.D0, 0.D0/
        data zero/0.D0, 0.D0, 0.D0/
             
        OPEN(UNIT=1, FILE='M3_GaussS.txt', STATUS='UNKNOWN')
        
        IF (satisfy_sassenfeld(mat,n)) THEN
          write(1,*) 'SATISFAZ'
        ELSE
          write(1,*) 'NAO SATISFAZ'
        END IF
        
        write(1,'(/\)')
        write(1,'(\A14)') ' '
        do j=1,n
            write(1,'(\A1,I2.2,A1,1PE10.3E2,A2)') 'x',j,'=',sol1(j),
     +        '; '
        end do
        write(1,'(/\)')
          
        do i=1,30
          call gauss_seidel(mat,sol1,sol2,n)
          write (1,'(\A2,1PE10.3E2,A2)') 'd=',
     +    distancia(sol1,sol2,n)/distancia(sol2,zero,n),'; '
          do j=1,n
            write(1,'(\A1,I2.2,A1,1PE10.3E2,A2)') 'x',j,'=',sol2(j),
     +        '; '
            sol1(j)=sol2(j)
          end do
          write(1,'(/\)')
        end do
        CLOSE (UNIT=1, STATUS='Keep')
      end
      
      real*8 function distancia(sol1,sol2,n)
       implicit none
       integer i,n
       real*8 sol1(n),sol2(n), aux
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
            if (i .GT. j) then
              sol2(i)=sol2(i)-mat(i,j)*sol2(j)
            else
              if (i .EQ. j) then
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
        real*8 mat(n,n+1),aux
        do k=1,n+1
          aux=mat(i,k)
          mat(i,k)=mat(j,k)
          mat(j,k)=aux
        end do
      end
      
      logical function satisfy_sassenfeld(mat,n)
        implicit none
        integer n,i
        real*8 mat(n,n+1), beta_i
        satisfy_sassenfeld= .TRUE.
        i=1
        do i=1,n
           if (beta_i(mat,n,i) .GE. 1.) then
             satisfy_sassenfeld = .FALSE.
           end if
           write (1,'(A4,I2,A1,1PE15.5E2)') 'Beta',i,'=',beta_i(mat,n,i)
        end do
      end
      
      real*8 function beta_i(mat,n,i)
        implicit none
        integer n,i,j
        real*8 mat(n,n+1)
        beta_i=0.
        do j=1,n
          if (j .LT. i) then
            beta_i=beta_i+beta_i(mat,n,j)*abs(mat(i,j))
          else
            if (j .GT. i) then
              beta_i=beta_i+abs(mat(i,j))          
            end if
          end if
        end do
        beta_i=beta_i/abs(mat(i,i))
      end
