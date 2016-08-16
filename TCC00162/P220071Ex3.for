      program P220071Ex3
      implicit none
       real a,x1,x2,delta,area,areat,f,x,b
       integer n,i
       f(x)=x**2+3*x+5    
      write(*,'(A30),') 'Escreva o intervalo a'
      read(*,'(F5.1),') a
      write(*,'(A30),') 'Escreva o intervalo b'
      read(*,'(F5.1),') b
      write(*,'(A30)') 'Escreva a precisao'
      read(*,'(I5)') n
      delta=(b-a)/(10**n)
      i=0
      areat=0
      x2=a+((i+1)*delta)
      while(x2.le.b) do
       x1=a+(i*delta) 
       x2=a+((i+1)*delta)
       area=abs((x2-x1)*f(x1))
       areat=areat+area
       i=i+1 
      end while 
      if(x2.gt.b .and. x1.lt.b) then
       x2=b
       area=(x2-x1)*f(x1)
       areat=areat+area
      end if 
      write(*,*) areat
      
      Pause
      end
