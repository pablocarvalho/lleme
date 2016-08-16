      program RevisaoEx11
      
        integer intervalo 
        
        write
        read () t1_hora
        read () t1_minuto
        read () t1_seg
        write
        read () t2_hora
        read () t2_minuto
        read () t2_seg
        
        intervalo = convHoraParaSeg(t2_hora,t2_minuto,t2_seg)-
     +              convHoraParaSeg(t1_hora,t1_minuto,t1_seg)
        
        horas = intervalo/3600
        minutos = mod(intervalo,3600)/60
        segundos = intervalo-(horas*3600+minutos*60)
      end
      
      integer convHoraParaSeg(hora,minuto,seg)      
        convHoraParaSeg = hora*3600+minuto*60+seg
      end      
        
