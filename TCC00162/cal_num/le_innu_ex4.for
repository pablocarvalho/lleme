      program le_innu_ex4
        implicit none
        real pi, f, a, b, w, area, x, xi
        integer i
        parameter (pi=3.141592)

        f(x) = cos(x)

        OPEN(UNIT=1, FILE='le_innu_ex4.txt', STATUS='UNKNOWN')
        a=0.
        b=pi/2.
        w=pi/2./4.
        area=0.
        xi=0.
      
        do i=0,4-2,2
          area = area + w/3.*(f(xi+i*w)+4.*f(xi+(i+1.)*w)+f(xi+(i+2.)*w))    
        end do
        write (1,'(1PE20.10E2)') area
      
      area=0.
      do i=0,4-1,1
        area = area + w/2.*(f(xi+i*w)+f(xi+(i+1.)*w))    
      end do
      write (1,'(1PE20.10E2)') area
      
      Close (UNIT=1, STATUS='Keep')
      end
