     program Lista1Ex14
	   implicit none
	   integer n,i,eprimo
	   
	   n=23
	   do i=1,n,2
	     if (ePrimo(i) .eq. 1) then
		   write (1,'(I3)') i
		 end if
	   end do
	 end
	 
	 integer function ePrimo(n)
	   implicit none
	   integer n, i
       if (n .lt. 2) then
         primo = 0
       else
         i = 2
         primo = 1
         while (i .lt. sqrt(n) .and.  primo .eq. 1) do
           if (mod(n,i) .eq. 0) then
             primo = 0
           end if
           i = i + 1
         end while
       end if
	 end
