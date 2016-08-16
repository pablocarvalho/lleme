      program Lista5Ex4
       implicit none
       real a,b,f,x
       integer i
       f(x) = x**3 - x**2 + x - 1
              
       a=2.0
       b=9.0
      
           
       open (unit=1,file='resultado.txt')
       do x=a,b,(b-a)/10
         
         write (1,'(F10.5)') f(x)
       end do
       close (unit=1,status='keep')
           
      end
