      program Lista2Ex9
        implicit none
        
        
        
        tn=1
        tn1=1
        soma=tn+tn1
        n=3
        while (n .le. termos) do
          tn2=tn+tn1
          soma=soma+tn2
          tn=tn1
          tn1=tn2
          n=n+1
        end while      
      
      
      
      
      end
