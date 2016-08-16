      program Volume
        implicit none
        real*8 a,b,c,d,f,x,y,delta1,delta2,volume,x1,y2
        integer n,i,j
      
        f(x,y) = 10.0
        
        a=10.0
        b=20.0
        c=1.0
        d=2.0
        n=10000
      
        delta2= (b-a)/n
        delta1= (d-c)/n
        
        volume=0.0
        do i=0,n-1,1  
          x1 = a+(i*delta2)
          do j=0,n-1,1
            y2 = c+(j*delta1)
            volume = volume+abs(delta1*delta2*f(x1,y2))
          end do
        end do
        write (*,*) volume
        pause
      end
