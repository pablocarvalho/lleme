      program M10_NewtonSiNL
        implicit none
        integer N
        parameter (N=2)
        real*8 jac(N,N),sol(N),solAnt(n),y(n),F(N),zero(N),distance,
     +    error1, error2, e/1.D-2/
        data sol/1.D0, 1.D0/
        data zero/0.D0, 0.D0/
       
        OPEN(UNIT=1, FILE='M10_NewtonSiNL.txt', STATUS='UNKNOWN')
        write (1,'(2(1PE11.3E2))') sol(1), sol(2)
        loop
          call saveSol(N,solAnt,sol)
          call jacobiano(N,jac,sol)
          call mF(N,F,sol)
          call solve(N,jac,y,F)
          call add(N,sol,y)
          error1 = distance(N,sol,solAnt)/distance(N,sol,zero)
          error2 = distance(N,F,zero)
          write (1,'(7(1PE11.3E2))') sol(1), sol(2), error1, y(1), y(2),
     +      -F(1), -F(2)
        until (error1 .LT. e .AND. error2 .LT. e)
        Close (UNIT=1, STATUS='Keep')
      end
     
      subroutine saveSol(n,x,y)
        implicit none
        integer n,i
        real*8 x(n),y(n)
        do i=1,n
          x(i) = y(i)
        end do
      end
     
      real*8 function distance(n,x,y)
        implicit none
        integer n,i
        real*8 x(n),y(n)
        distance = 0.D0
        do i=1,n
          if (abs(x(i)-y(i)) .GT. distance) then
            distance = abs(x(i)-y(i))
          end if
        end do
      end
      
      subroutine add(n,X,Y)
        implicit none
        integer n,i
        real*8 X(n),Y(n)
        do i=1,n
          x(i) = x(i) + y(i)
        end do
      end 
      
      subroutine solve(n,A,X,B)
        implicit none
        integer n
        real*8 A(n,n),B(n),X(n)
        x(1)=(b(1)*a(2,2)-b(2)*a(1,2))/(a(1,1)*a(2,2)-a(2,1)*a(1,2))
        x(2)=(b(2)*a(1,1)-b(1)*a(2,1))/(a(1,1)*a(2,2)-a(2,1)*a(1,2))
      end
      
      subroutine jacobiano(n,jac,xy)
        implicit none
        integer n
        real*8 jac(n,n),xy(n),df1_dx,df1_dy,df2_dx,df2_dy
        jac(1,1)=df1_dx(xy(1),xy(2))
        jac(1,2)=df1_dy(xy(1),xy(2))
        jac(2,1)=df2_dx(xy(1),xy(2))
        jac(2,2)=df2_dy(xy(1),xy(2))
      end
      
      subroutine mF(n,F,X)
        implicit none
        integer n
        real*8 F(n),X(n),f1,f2
        F(1)=-f1(X(1),X(2))
        F(2)=-f2(X(1),X(2))
      end
      
      real*8 function f1(x,y)
        implicit none
        real*8 x,y
        f1 = 2*(x**3)-y-1
      end
      
      real*8 function f2(x,y)
        implicit none
        real*8 x,y
        f2 = (x**2)-y-1
      end
      
      
      real*8 function df1_dx(x,y)
        implicit none
        real*8 x,y
        df1_dx = 6*x**2
      end
      
      real*8 function df1_dy(x,y)
        implicit none
        real*8 x,y
        df1_dy = -1
      end
      
      real*8 function df2_dx(x,y)
        implicit none
        real*8 x,y
        df2_dx = 2*x
      end
      
      real*8 function df2_dy(x,y)
        implicit none
        real*8 x,y
        df2_dy = -1
      end
