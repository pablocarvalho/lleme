      program RevisaoEx3
        implicit none
        
        write(*,'' ) 'mensagem'
        read(*,' ') nota1
        write(*,'' ) 'mensagem'
        read(*,' ') nota2
        
        media = (nota1 + nota2)/2.0
        
        if (nota1.ge.3.0 .and. nota2.ge.3.0 .and media.ge.5.0) then
          write (1,'') 'aprovado',media
        else
          write(*,'' ) 'nota 3'
          read(*,' ') nota3
          media = (maior(nota1,nota2) + nota3)/2
          if (media .gt. 5.0) then
            write(1,'') 'aprovado',media
          else
            write(1,'') 'reprovado',medias
          end if
         
      end
      
      real function maior(n1,n2)
        implicit none
        real n1,n2
        if (n1 .gt. n2) then
          maior = n1
        else
          maior = n2
        end if
      end

