      program P120122Ex2
        implicit none
        integer ios
        real n1,n2,n3,media
        real mediaAprovados, mediaReprovados
        real contaAprovados, contaReprovados
        
        open (unit=1,file='notas.txt')
        open (unit=2,file='medias.txt')
        read (1,'(3F5.2)', IOSTAT=ios) n1,n2,n3
        mediaAprovados = 0
        mediaReprovados = 0
        contaAprovados = 0
        contaReprovados = 0
        while (ios .eq. 0) do
          media = (n1+n2+n3)/3.0
          if (media .ge. 7.0) then
            mediaAprovados = mediaAprovados + media
            contaAprovados = contaAprovados + 1
          else
            mediaReprovados = mediaReprovados + media
            contaReprovados = contaReprovados + 1
          end if
          read (1,'(3F5.2)', IOSTAT=ios) n1,n2,n3
        end while
        mediaAprovados = mediaAprovados / contaAprovados
        mediaReprovados = mediaReprovados / contaReprovados
        write (2,'(2F5.2)') mediaAprovados,mediaReprovados
        close (unit=2,status='keep')
        close (unit=1,status='keep')
      end
