      program P120121Ex3
        implicit none
        real num1, num2
        character oper, resposta
                
        open(unit=1,file='resultado.txt')
        write (*, '(A30)') 'Deseja realizar operacao'
        read (*, '(A3)') resposta
                
        while (resposta .ne. 'nao') do
           write (*, '(A30)') 'Informe primeiro numero'
           read (*, '(F10.4)') num1
                     
           write (*, '(A30)') 'Informe operacao'
           read (*, '(A1)') oper
           while (oper .ne. '+' .and. oper .ne. '-' .and. oper .ne. '*'
     +        .and. oper .ne. '/') do
           write (*, '(A30)') 'Informe operacao'
           read (*, '(A1)') oper
           end while
                
           write (*, '(A30)') 'Informe segundo numero'
           read (*, '(F10.4)') num2
                
           if (oper .eq. '+') then
             write (*, '(F6.4,A1,F6.4,A1,F6.4)') num1,oper,num2,'=',
     +       num1+num2
           end if
                
           if (oper .eq. '-') then
             write (*, '(F6.4,A1,F6.4,A1,F6.4)') num1,oper,num2,'=',
     +       num1-num2
           end if
                
           if (oper .eq. '*') then
             write (*, '(F6.4,A1,F6.4,A1,F6.4)') num1,oper,num2,'=',
     +       num1*num2
           end if
                
           if (oper .eq. '/') then
             write (*, '(F6.4,A1,F6.4,A1,F6.4)') num1,oper,num2,'=',
     +       num1/num2
           end if
           write (*, '(A30)') 'Deseja realizar operacao'
           read (*, '(A3)') resposta
         end while
        close(unit=1,status='keep')
      end
