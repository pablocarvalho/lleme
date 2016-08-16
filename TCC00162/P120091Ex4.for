     program P120091Ex4
	   implicit none
	   
	   N=30
	   open (unit=1,file='resultado.txt')
	   open (unit=2,file='notas.txt')
	   read (2,'(F6.1)', IOSTAT=ios) nota
	   media1 = 0
	   aluno = 1
	   while (aluno .le. N/2 .and. ios .eq. 0) do
		 media1 = media1 + nota
		 aluno = aluno + 1
		 read (2,'(F6.1)') nota
	   end while
	   media1 = media1 / (N/2)
	   write (1,'(A20,F6.1)') 'Media dos meninos: ',media1 
	  
	   media2 = 0
	   while (aluno .le. N .and. ios .eq. 0) do
		 media2 = media2 + nota
		 aluno = aluno + 1
		 read (2,'(F6.1)') nota
	   end while
	   media2 = media2 / (N/2)
	   write (1,'(A20,F6.1)') 'Media dos meninas: ',media2 
	   
	   if (media1 .gt. media2) then
	     write...
	   else if (media2 .gt. media1) then
	     write...
	   else
	     write
	   end if
	   
	   close (unit=2,status='keep')
	   close (unit=1, status='keep')
	 end
	 
	 
