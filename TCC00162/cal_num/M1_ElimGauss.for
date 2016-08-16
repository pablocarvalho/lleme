      program M3_ElimGauss
        implicit none
        integer N, i, estrategia/1/
        parameter (N=2)
        integer incog(N)
        real*8 coeficientes(N,N+1), solucao(N)
        data coeficientes/5.D0, 5.D0,
     +              5.D0, 7.5D0,
     +              -2.2778D0, -0.8889D0/
        do i=1,N
          incog(i)=i
        end do
      
        OPEN(UNIT=1, FILE='M1_ElimGauss.txt', STATUS='UNKNOWN')
        
        call imprimir_matriz(coeficientes,N)
        call triangularizar(coeficientes,N,estrategia,incog)
        call imprimir_incog(incog,N)
        call resolver(coeficientes,solucao,N)
        call imprimir_solucao(incog,solucao,N)
        
        Close (UNIT=1, STATUS='Keep')
      end
      
      subroutine triangularizar(matriz,N,estrategia,incog)
        implicit none
        integer N, i, j, k, estrategia
        integer incog(N)
        real*8 matriz(N,N+1), pivot, coef
        do k=1,N
          call maxmizar_pivot(matriz,incog,N,k,estrategia)
          pivot=matriz(k,k)
          do i=k+1,N
              coef=-matriz(i,k)/pivot
              do j=k,N+1
              matriz(i,j)=matriz(i,j)+matriz(k,j)*coef
              end do
              write (1,'(A5,I2,A9,I2,A3,1PE15.5E4,A3,1PE15.5E4)') 
     +        'linha',i,' - linha ',k,' / ',matriz(k,k),' * ',coef
              write (1,'(/\)')
              call imprimir_matriz(matriz,N)
          end do
        end do
      end
          
      subroutine resolver(matriz,solucao,N)
        implicit none
        integer i, j, N
        real*8 matriz(N,N+1), solucao(N)
        do i=N,1,-1
          solucao(i)=matriz(i,N+1)
          do j=N,i+1,-1
            solucao(i)=solucao(i)-matriz(i,j)*solucao(j)
          end do
          solucao(i)=solucao(i)/matriz(i,i)
        end do            
      end
      
      subroutine maxmizar_pivot(matriz,incog,N,k,estrategia)
        implicit none
        integer N, i, j, k, linha, coluna, estrategia, incog(N)
        real*8 matriz(N,N+1)
        linha = k
        coluna = k
        if (estrategia .EQ. 1) then
          do i=k+1,N
            if (abs(matriz(i,k)) .GT. abs(matriz(linha,k))) then
              linha = i
            end if
          end do
        else
          if (estrategia .EQ. 2) then
            do i=k,N
              do j=k,N
                if (abs(matriz(i,j)).GT.abs(matriz(linha,coluna))) then
                  linha = i
                  coluna = j
                end if
              end do
            end do
          end if
        end if
        if ((linha .NE. k) .OR. (coluna .NE. k)) then
          call trocar_pivot(matriz,incog,N,k,linha,coluna)
          call imprimir_matriz(matriz,N)
        end if
      end
      
      subroutine trocar_pivot(matriz,incog,N,k,linha,coluna)
        implicit none
        integer N, i, j, k, linha, coluna, aux2, incog(N)
        real*8 matriz(N,N+1), aux1
        if (linha .NE. k) then
          i=k
          do j=k,N+1
            aux1=matriz(i,j)
            matriz(i,j)=matriz(linha,j)
            matriz(linha,j)=aux1
          end do
          write (1,'(A16,I2,A15,I2)') 'troca da linha ',k,
     +    ' com a linha ',linha
        end if
        if (coluna .NE. K) then
          aux2=incog(k)
          incog(k)=incog(coluna)
          incog(coluna)=aux2
          j=k
          do i=1,N
            aux1=matriz(i,j)
            matriz(i,j)=matriz(i,coluna)
            matriz(i,coluna)=aux1
          end do
          write (1,'(A16,I2,A15,I2)') 'troca da coluna ',k,
     +    ' com a coluna ',coluna
        end if
        if ((linha .NE. k) .OR. (coluna .NE. K)) then
          write (1,'(/\)')
        end if
      end
          
      subroutine imprimir_matriz(matriz,N)
        implicit none
        integer N, i, j
        real*8 matriz(N,N+1)
        do i=1,N
          do j=1,N+1
            write (1,'(\1PE15.5E4)') matriz(i,j)
          end do
          write (1,'(/\)')
        end do
        write (1,'(/)')
      end 
          
      subroutine imprimir_incog(incog,N)
        implicit none
        integer N,incog(N), i
        write (1,'(\A21)') 'Ordem da incognitas: '
        do i=1,N
          if (i .EQ. N) then
            write (1,'(A1,I2)') 'x',incog(i)
          else
            write (1,'(\A1,I2,A2)') 'x',incog(i),', '
          end if
        end do
      end
          
      subroutine imprimir_solucao(incog,solucao,N)
        implicit none
        integer i, N, incog(N)
        real*8 solucao(N)
        write (1,'(A9)') 'Solucao: '
        do i=1,N
          write (1,'(A1,I2,A1,1PE20.11E4)') 'x',incog(i),'=',solucao(i)
        end do
      end
