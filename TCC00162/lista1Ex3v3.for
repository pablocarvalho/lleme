       program lista1Ex4v3
        implicit none
        integer a,b,c,aux
        write (*,'(A30)') 'entre com o primeiro numero'
        read (*, '(I5)') a
        write (*,'(A30)') 'entre com o segundo numero'
        read (*, '(I5)') b
        write (*,'(A30)') 'entre com o terceiro numero'
        read (*, '(I5)') c
        if (b.lt.a) then
          aux=a 
          a=b
          b=aux
        end if
        if (c.lt.a) then
          aux=a 
          a=c
          c=aux
        end if
        if (c.lt.b) then
          aux=b 
          b=c
          c=aux
        end if
        write (*,'(3I5)')a,b,c
        pause  
       end
