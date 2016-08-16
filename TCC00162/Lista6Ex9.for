      program Lista6Ex9
        implicit none
        real n1,n2,n3,n4,n5,media
        integer ios
        open (unit=1,file='numeros.txt')
        open (unit=2,file='media.txt')
        read (1,'(5F5.2)', IOSTAT=ios) n1, n2, n3, n4, n5
        while (ios .eq. 0) do
          media = (n1+n2+n3+n4+n5)/5
          write (2,'(F6.2/)') media
          read (1,'(5F5.2)', IOSTAT=ios) n1, n2, n3, n4, n5
        end while
        close (unit=2,status='keep')
        close (unit=1,status='keep')
      end
