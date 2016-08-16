      program P220092Ex1
      
        cont=0
        pocos=20
        media=0
        while (cont .le. pocos) do
          loop
            read (*,'()') prof,custoP,custoR,taxaP,taxaR
            if (prof .lt. 0) then
              valido = .false.
            else
              valido = .true.
            end if
          until (valido)
          cont=cont+1
          custoTotP = custoTarefa(porf,custoP,taxaP)
          custoTotR = custoTarefa(porf,custoR,taxaR)
          custoTot = custoTotP + custoTotR
          write ()
          media = media + custoTot
        end while
        media = media/cont
      end
      
      real function custoTarefa(prof,valor,taxa)
        implicit none
        real prof,valor,taxa
        integer cont
        custoTotal=0
        
        do i=0,prof,1
          if ((prof-i) .gt. 1) then
            custoTrecho=valor*(1+taxa)**i
          else
            fracao=prof-i
            custoTrecho=fracao*valor*(1+taxa)**i
          end if
          custoTotal=custoTotal+custoTrecho
        end 
        custoTarefa=custoTotal
      end
