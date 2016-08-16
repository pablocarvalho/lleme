      program LeInpol1
        implicit none
        real*8 pol,zero_fp
        
        integer N
        parameter (N=6)
        real*8 tab(N,2)
        data tab/0.2D0,0.34D0,0.4D0,0.52D0,0.6D0,0.72D0,
     +           0.16D0,0.22D0,0.27D0,0.29D0,0.32D0,0.37D0/

        OPEN(UNIT=1, FILE='le_inpol_ex1.txt', STATUS='UNKNOWN')
        call writeDifDiv(tab,N)
        write (1,*) pol(tab,N,3,2,0.47D0)
c        write (1,*) pol(tab,N,3,3,105.D0)
c        write (1,*) zero_fp(60.D0,105.D0)
        Close (UNIT=1, STATUS='Keep')
      end
      
      real*8 function difDiv(tab,N,i,j)
        implicit none
        integer N,i,j
        real*8 tab(N,2)
        if (i .EQ. j) then
          difDiv=tab(i,2)
        else
          difDiv=(difDiv(tab,N,i+1,j)-difDiv(tab,N,i,j-1))/
     +    (tab(j,1)-tab(i,1))
        end if
      end
  
      subroutine writeDifDiv(tab,N)
        integer N,i,j
        real*8 tab(N,2)
        do i=1,N
          write (1,'(\1PE15.5E2)') tab(i,1)
          j=0
          do while (i+j .LE. N)
            write (1,'(\1PE15.5E2)') difDiv(tab,N,i,i+j)
            j=j+1
          end do
          write (1,'(/)')
        end do
      end

      real*8 function pol(tab,N,inicio,grau,x)
        implicit none
        integer N,i,j,inicio,grau
        real*8 tab(N,2), parc, x, difDiv

        pol=0.D0
        do i=inicio,inicio+grau
          parc = difDiv(tab,N,inicio,i)
          do j=inicio,i-1
            parc = parc * (x - tab(j,1))
          end do
          pol = pol + parc
        end do
      end

      real*8 function f(x)
        implicit none
        integer N
        parameter (N=7)
        real*8 tab(N,2),x,pol
        data tab/0.D0,10.D0,30.D0,60.D0,90.D0,120.D0,140.D0,0.D0, 
     +  8.D0,27.D0,58.D0,100.D0,145.D0,160.D0/

        f=pol(tab,N,3,3,x)-80.D0
      end 
      
      real*8 function xi(a,b)
        implicit none
        real*8 a,b,f
        xi=(a*f(b)-b*f(a))/(f(b)-f(a))
      end
      
      subroutine div(a,b)
        implicit none
        real*8 a,b,c,f,xi
        c=xi(a,b)
        if ((f(c)*f(a)) .GE. 0.) then
          a=c
        else
          b=c
        end if
      end
      
      real*8 function zero_fp(a,b)
        implicit none
        real*8 a,b,c,x1,x2,xi,f
        x1=xi(a,b)
        call div(a,b)
        x2=xi(a,b)
        do while ((abs(x2-x1)/abs(x2) .GT. 1.D-4) .OR. 
     +  (f(xi(a,b)) .GT. 1.D-4))
          x1=x2
          call div(a,b)
          x2=xi(a,b)
        end do
        zero_fp=xi(a,b)
      end
