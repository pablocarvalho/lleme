      program P120112Ex3
         implicit none
         integer m1,n1,m2,n2
         parameter (m1=5,n1=5,m2=3,n2=3)
         integer a(m1,n1),b(m2,n2)
         logical encontrei,eDiferente
         
         i=1
         j=1
         encontrei = .false.
         
         while (.not. encontrei .and. i .le. m1-m2+1)
           while (.not. encontrei .and. j .le. n1-n2+1)
             if (eDiferente(b,m2,n2,a,m1,n1,i,j)) then
               encontrei = .true.
             end if
             j=j+1
           end while
           j=1
           i=i+1
         end while
      
      end
      
      logical function eDiferente(mb,m2,n2,ma,m1,n1,l,c)
        implicit none
        integer m2,n2,m1,n1,i,j
        integer mb(m2,n2),ma(m1,n1)
        
        diferente = .false.
        
        i=l
        j=c
        while (.not. diferente .and. i .le. i+m2-1)
          while (.not. diferente .and j .le. j+n2-1)
            if (ma(i,j) .ne. mb(i-l+1,j-c+1)) then
              diferente = .true.
            end if
            j=j+1
          end while
          j=1
          i=i+1
        end while
        eDiferente = .not. diferente    
      end 
