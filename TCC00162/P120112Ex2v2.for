      program P120112Ex2
      
        real notas(50,2)
        integer i
        open (unit=1,file='notas.txt',status='unknown')
        open (unit=2,file='resultado.txt',status='unknown')
        
        i=1
        read(1,'(I10,F3.1)',iostat=ios) n1,n2
        total = 0.0
        
        while (i.le.50 .and. ios.eq.0) do
          notas(i,1)=n1
          notas(i,2)=n2
          total = total + n2
          i = i + 1
          read(1,'(I10,F3.1)',iostat=ios) n1, n2
        end while
        i = i - 1
        media = total / i
        
        do j=1,i,1
          if (notas(j,2).lt.media) then
            write(2,'(2F4.2)') notas(j,1),notas(j,2)
          end if
        end do
        
        close()
        close()
        
      
      end
