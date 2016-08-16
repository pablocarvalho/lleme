      program Lista1Ex3
        implicit none
        integer a,b,c, maior, menor
        open (unit=1, file='resultado.txt')
		write (*, '(A20)') 'Digite o numero a'
		read (*, '(I5)') a
		write (*, '(A20)') 'Digite o numero b'
		read (*, '(I5)') b
		write (*, '(A20)') 'Digite o numero c'
		read (*, '(I5)') c
		write (*, '(A20)') 'Digite o numero d'
		read (*, '(I5)') d

C     Inicio da logica do programa		
		maior = a
		if (b .gt. maior) then
		  maior = b
		end if
		if (c .gt. maior) then
		  maior = c
		end if
		if (d .gt. maior) then
		  maior = d
		end  if
		
		menor = a
		if (b .lt. menor) then
		  menor = b
		end if
		if (c .lt. menor) then
		  menor = c
		end if
		if (d .lt. menor) then
		  menor = d
		end  if
		
        close (unit=1, status='keep')      
      end
