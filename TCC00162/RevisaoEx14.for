      program RevisaoEx14
        implicit none
        integer num
        
        open (unit=1,file='resultado.txt')
        num = 12321
        
        digE = num/10000
        digD = mod(num,10)
        
        if (digE .eq. digD) then
          num = (mod(num,10000)-digD)/10
          digE = num/100
          digD = mod(num,10)
          if (digE .eq. digD) then
          
          else
          
          end if
        else
          write (1,'(A20)') 'Nao sao palindromos'
        end if
        
        close (unit=1,status='keep')
      end
