      program somafibonacci
        integer n1,n2,n3,cont,soma,N,i
        write (*, ' (A30) ') 'Digite o numero de termos'
        read (*, '(I2)') N
        soma=2
        n1=1
        n2=1
        
        if (N.eq.1) then
         soma= 1 
        else 
          soma= 2
        end if
                
        do i=3,N,1
           n3= n1 + n2
           soma= soma + n3
           n1= n2
           n2= n3 
        
        end do
        write (*, '(A30,I5)') 'soma=', soma
        read (*, '(I2)') N
      end  
        
        
         
       
