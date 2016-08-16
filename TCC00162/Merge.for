      program Merge
        implicit none
        integer n1,n2
        parameter (n1=5,n2=6)
        integer v1(n1),v2(n2),merge(n1+n2)
        
        i=1
        j=1
        k=1
        while (i .le. n1  .or. j .le. n2) do
          if ((i .le. n1 .and. v1(i) .le. v2(j)) .or.
     +        (j .gt. n2)) then
            merge(k) = v1(i)
            i = i +1
          else
            merge(k) = v2(j)
            j = j + 1
          end if
        
          k = k +1
        end do
      
      end 
