      program P120122Ex3
        implicit none
        integer ios,i
        real x,x1,x2,f
        f(x) = 2*(x**3)+cos(x)
        
        open (unit=1,file='intervalos.txt')
        open (unit=2,file='valores.txt')
        read (1,'(2F9.4)', IOSTAT=ios) x1,x2
        while (ios .eq. 0) do
          do i=0,9,1
            write (2,'(F9.4)') f(x1+i*(x2-x1)/10.0)
          end do
          read (1,'(2F9.4)', IOSTAT=ios) x1,x2
        end while
        close (unit=2,status='keep')
        close (unit=1,status='keep')
      end
