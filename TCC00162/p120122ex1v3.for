      program ex1v3
      implicit none
      
      integer pa,num,dgtdir,dgtesq,ndigitos
      write(*,'(A30)')'escreva um numero'
      read(*,'(I8)') num
      pa=1
      
      while(ndigitos(num) .gt. 1 .and. pa .eq. 1)do
        dgtdir=mod(num,10)
        dgtesq=num/10**(ndigitos(num)-1)
        if (dgtdir .ne. dgtesq)then
          pa=0
        end if 
        num=num/10
        num=num-(dgtesq*10**(ndigitos(num)-1)) 
          
      end while
      write(*,'(I5)')pa
      pause
      end
      

      integer function ndigitos(n)
       integer n,x
        if (n .eq. 0)then
          ndigitos=0
        else 
          x=log10(n*1.0)
          x=x+1
          ndigitos=x
        end if
      end          
