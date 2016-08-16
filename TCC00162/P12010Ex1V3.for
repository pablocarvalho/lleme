      program VolumeReservatorio
        implicit none
        real Va,Vb,Vq,Qa,Qb,Ra,Rb,Rt,Ft,Qf
      write(*,'(A30)')'Digite o volume de A'
      read(*,'(F8.1)')Va
      write(*,'(A30)')'Digite o volume de B'
      read(*,'(F8.1)')Vb
      write(*,'(A30)')'Digite o volume de Q'
      read(*,'(F8.1)')Vq
      Qa = Va*0.8
      Qb = Vb*0.9
      if(Qa.ge.Vq)then
        Ra = Vq
      else
        Ra = Qa
      end if
      Ft = Vq - Qa
      if(Qb.ge.Ft)then
        Rb = Ft
      else
        Rb = Qb
      end if
      Rt = Ra+Rb
      Qf = Vq-Rt
      write(*,'(A30,F8.1)')'Quantidade retirada de A = ',Ra
      write(*,'(A30,F8.1)')'Quantidade retirada de B = ',Rb
      if(Qf.eq.0)then
        write(*,'(A30)')'Completo'
      else
        write(*,'(A30,F8.1)')'o que falta = ',Qf
      end if
      pause
      end
      
        
