      program m9_secante
        implicit none
        real*8 e,xi,xi1,xi2,f,fsec,delta,zero
        OPEN(UNIT=1, FILE='M9_Secante.txt', STATUS='UNKNOWN')
        
        e=1.D-4
        xi=1.D0
        xi1=0.D0
        write(1,'(2(1PE14.3E5))') xi,f(xi)
        write(1,'(2(1PE14.3E5))') xi1,f(xi1)
        
        loop
          xi2=fsec(xi,xi1)
          delta=(abs(xi2-xi1))/abs(xi2)
          zero=abs(f(xi2))
          write(1,'(3(1PE14.3E5))') xi2,f(xi2),delta
          xi=xi1
          xi1=xi2
        until (delta.LT.e .and. zero.LT.e)
        
        CLOSE (UNIT=1, STATUS='Keep')
      end
      
      real*8 function fsec(xi,xi1)
        implicit none
        real*8 xi,xi1,f
        fsec=xi1-(f(xi1)*(xi1-xi))/(f(xi1)-f(xi))
      end
      
      real*8 function f(x)
        implicit none
        real*8 x
        f=sqrt(x)-5*exp(-x)
      end