<jsp:useBean id="mensagem" class="java.lang.String" scope="session" />
<%
    ic.tcc00175.biblioteca.view.Tabela tabela = (ic.tcc00175.biblioteca.view.Tabela) request.getSession().getAttribute("tabela");
    if (tabela == null
            || !tabela.getClass().getName().equals(
            "ic.tcc00175.biblioteca.view.TabelaUsuario")) {
        tabela = new ic.tcc00175.biblioteca.view.TabelaUsuario(12);
        request.getSession().setAttribute("tabela", tabela);
    }
    ic.tcc00175.biblioteca.oldmodel.Usuario usuario = (ic.tcc00175.biblioteca.oldmodel.Usuario) request.getSession().getAttribute("usuario");
    if (usuario == null) {
        usuario = new ic.tcc00175.biblioteca.oldmodel.AlunoGraduacao();
    }
    ic.tcc00175.biblioteca.view.FormularioUsuario formulario = new ic.tcc00175.biblioteca.view.FormularioUsuario();

%>
<html>
    <head>
        <title>Projeto de Sistemas de Software, Biblioteca</title>
    </head>
    <body>
        <div align="center">
            <FORM NAME="cadastro"
                  ACTION="../servlet/SystemController?page=../jsp/cadastro/cadUsuario.jsp"
                  METHOD="POST" NAME="cadastro">
                <TABLE BORDER="0" CELLPADDING="1" CELLSPACING="2" SUMMARY="">
                    <TR>
                        <td align="CENTER" valign="TOP"><%=tabela.getTabela()%></td>
                        <td valign="TOP"><%=formulario.getFormulario(usuario)%></td>
                    </TR>

                    <TR>
                        <TD>
                            <DIV ALIGN="center"><jsp:include page="../botoesColecao.jsp"
                                         flush="true" /></DIV>
                        </TD>
                        <TD>
                            <DIV ALIGN="center"><script language="JavaScript">
                                function limpar() {
                                    document.cadastro.command.value = "NewUsuario";
                                    document.cadastro.submit();
                                }
                                function incluir() {
                                    document.cadastro.command.value = "AddUsuario";
                                    document.cadastro.submit();
                                }
                                function recuperar() {
                                    document.cadastro.command.value = "GetUsuario";
                                    document.cadastro.submit();
                                }
                                function atualizar() {
                                    document.cadastro.command.value = "UpdUsuario";
                                    document.cadastro.submit();
                                }
                                function excluir() {
                                    document.cadastro.command.value = "RemUsuario";
                                    document.cadastro.submit();
                                }
                                </script> <INPUT TYPE="hidden"
                                                 NAME="command" VALUE="AddUsuario" SIZE="1" MAXLENGTH="30"><INPUT
                                                 TYPE="submit" VALUE="Add"> <INPUT TYPE="button" VALUE="Get"
                                                 onclick="recuperar();"> <INPUT TYPE="button" VALUE="Upd"
                                                 onclick="atualizar();"> <INPUT TYPE="button" VALUE="Del"
                                                 onclick="excluir();"> <INPUT TYPE="button" VALUE="New"
                                                 onclick="limpar();"></DIV>
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
