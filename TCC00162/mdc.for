      program mdc
        integer mdc
        write (*,*) mdc(42,24)
        pause
      end
      
      
      integer function mdc(x,y)
        integer x, y
        mdc = mod(x,y)
        while (mdc .ne. 0) do
          x = y
          y = mdc
          mdc = mod(x,y)
        end while
        mdc = y
      end

