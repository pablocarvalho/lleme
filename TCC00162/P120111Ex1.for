      program P120111Ex1
        implicit none
        integer n1,n2,d,mmc,divideSePuder,incrementar
        logical consigoDividir
        
        n1=15
        n2=24
        d=2
        mmc=1
        while (n1.ne.1 .or. n2.ne.1) do
          while(consigoDividir(n1,n2,d)) do
            n1 = divideSePuder(n1,d)
            n2 = divideSePuder(n2,d)
            mmc = mmc * d
          end while
          d = incrementar(d)
        
        end while
        write (*,'(I5)') mmc
        pause
      end
      
      integer function incrementar(d)
        implicit none
        integer d
        if (d.eq.2) then
          incrementar = d + 1
        else
          incrementar = d + 2
        endif
      end
      
      logical function consigoDividir(n1,n2,d)
        implicit none
        integer n1,n2,d
        if (mod(n1,d).eq.0 .or. mod(n2,d).eq.0) then
          consigoDividir = .true.
        else
          consigoDividir = .false.
        end if
      end
      
      integer function divideSePuder(n,d)
        implicit none
        integer n,d
        if (mod(n,d).eq.0) then
          divideSePuder = n / d
        else
          divideSePuder = n
        endif
      end
