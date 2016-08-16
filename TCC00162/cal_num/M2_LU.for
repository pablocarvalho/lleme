      program M3_LU
        implicit none
        integer N, i, j, k
        parameter (N=3)
        integer eq(N)
        real*8 matriz(N,N),solucao1(N),solucao2(N),B1(N),B2(N)
        real*8 pivot, coef
        data matriz/1.D0,2.D0,0.5D0,
     +    4.D0,5.D0,-3.D0,
     +    3.D0,4.D0,-2.D0/
        data B1/18.D0,24.D0,-11.5D0/
        
        do i=1,N
          eq(i)=i
        end do
      
        OPEN(UNIT=1, FILE='M2_LU.txt', STATUS='UNKNOWN')
        call imprime_matriz(matriz,N)
        
        do k=1,N
          call maxmizar_pivot(matriz,N,eq,k)
          pivot=matriz(k,k)
          do i=k+1,N
            coef=-matriz(i,k)/pivot
            do j=k,N
              matriz(i,j)=matriz(i,j)+matriz(k,j)*coef
            end do
            matriz(i,k)=-coef
            write (1,'(A5,I2,A9,I2,A3,1PE15.5D4,A3,1PE15.5D4)') 
     +      'linha',i,' - linha ',k,' / ',matriz(k,k),' * ',coef
            write (1,'(/\)')
            call imprime_matriz(matriz,N)
          end do
        end do
        
        call imprime_matriz_L(matriz,N)
        call imprime_matriz_R(matriz,N)
        call imprime_trocas(eq,N)
        call aplicar_trocas(B1,B2,eq,N)
        call resolver_ly_b(matriz,solucao1,B2,N)
        call imprime_solucao(solucao1,N)
        call resolver_ux_y(matriz,solucao2,solucao1,N)
        call imprime_solucao(solucao2,N)
        Close (UNIT=1, STATUS='Keep')
      end
          
      subroutine resolver_ly_b(matriz,solucao,B,N)
        implicit none
        integer i, j, N
        real*8 matriz(N,N), B(N), solucao(N)
        do i=1,N
          solucao(i)=B(i)
          do j=1,i-1
            solucao(i)=solucao(i)-matriz(i,j)*solucao(j)
          end do
        end do            
      end
      
      subroutine resolver_ux_y(matriz,solucao,B,N)
        implicit none
        integer i, j, N
        real*8 matriz(N,N), B(N), solucao(N)
        do i=N,1,-1
          solucao(i)=B(i)
          do j=N,i+1,-1
            solucao(i)=solucao(i)-matriz(i,j)*solucao(j)
          end do
          solucao(i)=solucao(i)/matriz(i,i)
        end do            
      end
      
      subroutine maxmizar_pivot(matriz,N,eq,k)
        implicit none
        integer N, i, k, linha, eq(N)
        real*8 matriz(N,N)
        linha = k
        do i=k+1,N
          if (abs(matriz(i,k)) .GT. abs(matriz(linha,k))) then
            linha = i
          end if
        end do
        if (linha .NE. k) then
          call troca_pivot(matriz,N,eq,k,linha)
          call imprime_matriz(matriz,N)
        end if
      end
      
      subroutine troca_pivot(matriz,N,eq,k,linha)
        implicit none
        integer N, i, j, k, linha, eq(N), aux2
        real*8 matriz(N,N), aux1
        if (linha .NE. k) then
          i=k
          do j=1,N
            aux1=matriz(i,j)
            matriz(i,j)=matriz(linha,j)
            matriz(linha,j)=aux1
          end do
          aux2 = eq(k)
          eq(k) = eq(linha)
          eq(linha) = aux2
          write (1,'(A16,I2,A15,I2)') 'troca da linha ',k,
     +    ' com a linha ',linha
        end if
        if (linha .NE. k) then
          write (1,'(/\)')
        end if
      end
      
      subroutine aplicar_trocas(B1,B2,eq,N)
        implicit none
        integer i,N,eq(N)
        real*8 B1(N), B2(N)
        do i=1,N
          B2(i)=B1(eq(i))
        end do
      end
      
      subroutine imprime_matriz(matriz,N)
        implicit none
        integer N, i, j
        real*8 matriz(N,N+1)
        do i=1,N
          do j=1,N
            write (1,'(\1PE15.5D4)') matriz(i,j)
          end do
          write (1,'(/\)')
        end do
        write (1,'(/)')
      end 
          
      subroutine imprime_solucao(solucao,N)
        implicit none
        integer i, N
        real*8 solucao(N)
        write (1,'(A9)') 'Solucao: '
        do i=1,N
          write (1,'(A1,I2,A1,1PE20.11D4)') 'x',i,'=',solucao(i)
        end do
      end

      subroutine imprime_matriz_L(matriz,N)
        implicit none
        integer N, i, j
        real*8 matriz(N,N+1)
        write (1,'(A9)') 'Matriz L'
        do i=1,N
          do j=1,N
            if (i .GT. j) then
              write (1,'(\1PE15.5D4)') matriz(i,j)
            else
              if (i .EQ. j) then
                write (1,'(\1PE15.5D4)') 1.0
              else
                write (1,'(\1PE15.5D4)') 0.0
              end if
            end if
          end do
          write (1,'(/\)')
        end do
        write (1,'(/)')
      end 
      
      subroutine imprime_matriz_R(matriz,N)
        implicit none
        integer N, i, j
        real*8 matriz(N,N+1)
        write (1,'(A9)') 'Matriz R'
        do i=1,N
          do j=1,N
            if (i .LE. j) then
              write (1,'(\1PE15.5D4)') matriz(i,j)
            else
              write (1,'(\1PE15.5D4)') 0.0
            end if
          end do
          write (1,'(/\)')
        end do
        write (1,'(/)')
      end 

      subroutine imprime_trocas(eq,N)
        implicit none
        integer N,eq(N), i
        write (1,'(\A26)') 'Ordem final das equacoes: '
        do i=1,N
          if (i .EQ. N) then
            write (1,'(A7,I2)') 'equacao',eq(i)
          else
            write (1,'(\A7,I2,A2)') 'equacao',eq(i),', '
          end if
        end do
        write (1,'(/)')
      end
