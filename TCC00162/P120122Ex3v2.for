      program P120122Ex3
        implicit none
        integer erro
        real x1, x2
        open (unit=1, file='intervalos.txt', status='unknown')
        read (1,'(2F8.4)',iostat=erro) x1,x2
        while (erro.eq.0)do
          call plotarDezValores(x1,x2)        
          read (1,'(2F8.4)',iostat=erro) x1,x2
        end while
        close (unit=1, status='keep')
      end
      
      subroutine plotarDezValores(x1,x2)
        implicit none
        real x1,x2,f,x,delta
        integer i
        f(x) = 2*(x**3)+cos(x)
        
        delta = (x2-x1)/10.0
        x = x1
        do i=0,9
          write (*,'(2F8.4)') x1+i*delta, f(x+i*delta)
        end do
      end
      
      
      
      
      
