<jsp:useBean id="mensagem" class="java.lang.String" scope="session" />
<%// Recupera Usuario
    ic.tcc00175.biblioteca.oldmodel.Usuario usuario = (ic.tcc00175.biblioteca.oldmodel.Usuario) request
            .getSession().getAttribute("usuario");
    if (usuario == null) {
        usuario = new ic.tcc00175.biblioteca.oldmodel.AlunoGraduacao();
    }

    // Recupera material
    ic.tcc00175.biblioteca.oldmodel.Material material = (ic.tcc00175.biblioteca.oldmodel.Material) request
            .getSession().getAttribute("material");
    if (material == null) {
        material = new ic.tcc00175.biblioteca.oldmodel.Livro();
    }

    // Recupera reserva
    ic.tcc00175.biblioteca.oldmodel.Reserva reserva = (ic.tcc00175.biblioteca.oldmodel.Reserva) request
            .getSession().getAttribute("reserva");
    if (reserva == null) {
        reserva = new ic.tcc00175.biblioteca.oldmodel.Reserva();
    }

    // Cria tabela de lista de conteudo
    ic.tcc00175.biblioteca.view.Tabela tabela = (ic.tcc00175.biblioteca.view.Tabela) request
            .getSession().getAttribute("tabela");
    if (tabela == null
            || !tabela.getClass().getName().equals(
            "ic.tcc00175.biblioteca.view.TabelaReserva")) {
        tabela = new ic.tcc00175.biblioteca.view.TabelaReserva(12,
                usuario);
        request.getSession().setAttribute("tabela", tabela);
    } else {
        tabela.setColecao(usuario.getLnkReserva());
    }
    //Cria formulario de cadastro
    ic.tcc00175.biblioteca.view.FormularioReserva formulario = new ic.tcc00175.biblioteca.view.FormularioReserva();

%>
<html>
    <head>
        <title>Projeto de Sistemas de Software, Biblioteca</title>
    </head>
    <body>
        <div align="center">
            <FORM NAME="cadastro"
                  ACTION="../servlet/SystemController?page=../jsp/operacao/reserva.jsp"
                  METHOD="POST" NAME="cadastro">
                <TABLE BORDER="0" CELLPADDING="1" CELLSPACING="2" SUMMARY="">
                    <TR>
                        <td align="CENTER" valign="TOP"><%=tabela.getTabela()%></td>
                        <td valign="TOP"><%=formulario.getFormulario(usuario, material,
                        reserva)%></td>
                    </TR>

                    <TR>
                        <TD>
                            <DIV ALIGN="center"><jsp:include page="../botoesColecao.jsp"
                                         flush="true" /></DIV>
                        </TD>
                        <TD>
                            <DIV ALIGN="center"><script language="JavaScript">
                                function selectUsuario() {
                                    document.cadastro.command.value = "SelUsuario";
                                    document.cadastro.submit();
                                }
                                function limpar() {
                                    document.cadastro.command.value = "NewReserva";
                                    document.cadastro.submit();
                                }
                                function incluir() {
                                    document.cadastro.command.value = "AddReserva";
                                    document.cadastro.submit();
                                }
                                function recuperar() {
                                    document.cadastro.command.value = "GetReserva";
                                    document.cadastro.submit();
                                }
                                function atualizar() {
                                    document.cadastro.command.value = "UpdReserva";
                                    document.cadastro.submit();
                                }
                                function excluir() {
                                    document.cadastro.command.value = "RemReserva";
                                    document.cadastro.submit();
                                }
                                </script> <INPUT TYPE="hidden"
                                                 NAME="command" VALUE="AddReserva" SIZE="1" MAXLENGTH="30"><INPUT
                                                 TYPE="submit" VALUE="Add"> <INPUT TYPE="button" VALUE="Get"
                                                 disabled="disabled" onclick="recuperar();"> <INPUT TYPE="button"
                                                 disabled="disabled" VALUE="Upd" onclick="atualizar();"> <INPUT
                                                 TYPE="button" VALUE="Del" onclick="excluir();"> <INPUT TYPE="button"
                                                 VALUE="New" onclick="limpar();"></DIV>
                        </TD>
                    </TR>
                    <TR>
                        <TD bordercolor="RED">
                            <DIV ALIGN="center"><TEXTAREA NAME="mensagens" COLS="60" ROWS="4"
                                                          WRAP="on" READONLY>Mensagens:&nbsp;<%="\n" + mensagem%></TEXTAREA></DIV>
                        </TD>
                        <TD>(*) Campos de preenchimento obrigat&oacute;rio <br>
                            (C) Chave de recupera&ccedil;&atilde;o</TD>
                    </TR>
                </TABLE>
            </FORM>
        </div>
        <%@ include file="../../html/footer.html"%>
    </body>
</html>
