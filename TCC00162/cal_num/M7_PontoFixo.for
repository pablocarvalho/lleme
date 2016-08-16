      program m5_bissecao
        implicit none
        real*8 e,xi,xi1,f,fnr
        OPEN(UNIT=1, FILE='M7_PontoFixo.txt', STATUS='UNKNOWN')
        
        e=1.D-2
        xi1=0.1D0
        
        loop
          xi=xi1
          xi1=fnr(xi)
          write(1,'(5(1PE14.3E5))') xi1,f(xi1),abs(xi1-xi)/abs(xi1)
        until ((abs(xi1-xi)/abs(xi1).LT.e).and.(abs(f(xi1)).LT.e))
        
        CLOSE (UNIT=1, STATUS='Keep')
      end
      
      real*8 function fnr(x)
        implicit none
        real*8 x
        fnr=2*x-17*(x**2)
      end
      
      real*8 function fpf(x)
        implicit none
        real*8 x
        fpf=13*x**2
      end
      
      real*8 function f(x)
        implicit none
        real*8 x
        f=17-1/x
      end