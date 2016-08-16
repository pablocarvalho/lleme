      program P220071Ex3
        implicit none
        real x1, x2,x, delta, soma, area,a, b, precisao, f
        f(x)= x**2
        a=0
        b=10
        precisao=1000
        
       
        delta=(b-a)/precisao
        x1=a
        x2=a+delta
        
        while (x2.lt.b) do
        
          area= abs ((x2-x1)*f(x1))
          soma= soma + area
          x1= x1 + delta
          x2= x2 + delta
          
        end while
       
        soma= soma+(b-x1)*f(x1) 
        
        write (*, *)  soma
        
        pause
        
      
      
      
      end
