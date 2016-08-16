      program P120102Ex1
      
        va=100
        vb=150
        v=80
        vi=v
        reservaA = 0.2*va
        reservaB = 0.1*vb
        
        qa=0
        qb=0
        
        disponivelA = va-reservaA
        disponivelB = vb-reservaB
        
        if (v .gt. disponivelA) then
          qa = disponivelA
        else
          qa = v
        end if
        falta = v - qa
        v = falta
        
        if (v .gt. disponivelB) then
          qb = disponivelB
        else
          qb = v
        end if
        
        falta = vi - qa - qb
        
        write () qa,qb,falta
        
        
        
        if (falta .gt. disponivelB)m 
        
        
      
      
      end
