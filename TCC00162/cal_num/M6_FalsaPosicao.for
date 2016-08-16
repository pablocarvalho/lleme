      program m5_bissecao
        implicit none
        real*8 a,b,e,xi,xi1,f,xi_fp
        OPEN(UNIT=1, FILE='M6_FalsaPosicao.txt', STATUS='UNKNOWN')
        
        a=2
        b=3
        e=1.D-4
        xi1=xi_fp(a,b)
        
        write(1,'(5(1PE14.3E5))') a,b,xi1,f(xi1),abs(xi1-xi)/abs(xi1)
        loop
          call quebra(a,b)
          xi=xi1
          xi1=xi_fp(a,b)
          write(1,'(5(1PE13.3E5))') a,b,xi1,f(xi1),abs(xi1-xi)/abs(xi1)
        until ((abs(xi1-xi)/abs(xi1) .LT. e) .AND. (abs(f(xi1)) .LT. e))
        
        CLOSE (UNIT=1, STATUS='Keep')
      end
      
      real*8 function f(x)
        implicit none
        real*8 x
        f=x**3-9*x+3
      end
       
      real*8 function xi_fp(a,b)
        implicit none
        real*8 a,b,f
        xi_fp=(a*f(b)-b*f(a))/(f(b)-f(a))
      end
       
      real*8 function xi_bs(a,b)
        implicit none
        real*8 a,b
        xi_bs=(a+b)/2
      end
       
      subroutine quebra(a,b)
        implicit none
        real*8 a,b,c,f,xi_fp
        c=xi_fp(a,b)
        if ((f(c)*f(a)) .GE. 0.) then
          a=c
        else
          b=c
        end if
      end