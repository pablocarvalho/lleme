      program P120112Ex1
        implicit none
        integer a,b,c,f,mmc,flag
        
        a=13
        b=15
        c=24
        f=2
        mmc=1
        open (unit=1, file='P120112Ex1.txt')
        while (a .ne. 1 .or. b .ne. 1 .or. c .ne. 1) do
          flag=0
          if(mod(a,f) .eq. 0) then
            a = a / f
            flag = 1
          end if
          if(mod(b,f) .eq. 0) then
            b = b / f
            flag = 1
          end if
          if(mod(c,f) .eq. 0) then
            c = c / f
            flag = 1
          end if
          if (flag .eq. 1) then
             mmc = mmc * f
          else
            if (f .eq. 2 ) then
              f = f + 1
            else
              f = f + 2
            end if
          end if
        end while
        write (1, '(I10)') mmc
        close (unit=1, status='keep')
      end
