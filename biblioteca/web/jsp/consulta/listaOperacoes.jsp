<%// Recupera Usuario
                        ic.tcc00175.biblioteca.oldmodel.Usuario usuario = (ic.tcc00175.biblioteca.oldmodel.Usuario) request
                                        .getSession().getAttribute("usuario");
                        if (usuario == null)
                                usuario = new ic.tcc00175.biblioteca.oldmodel.AlunoGraduacao();

                        // Cria tabela de lista de conteudo
                        ic.tcc00175.biblioteca.view.Tabela tabela = (ic.tcc00175.biblioteca.view.Tabela) request
                                        .getSession().getAttribute("tabela");
                        if (tabela == null
                                        || !tabela.getClass().getName().equals(
                                                        "ic.tcc00175.biblioteca.view.TabelaListaOperacoes")) {
                                tabela = new ic.tcc00175.biblioteca.view.TabelaListaOperacoes(
                                                15, usuario);
                                request.getSession().setAttribute("tabela", tabela);
                        } else
                                tabela.setColecao(usuario.getLnkOperacao());

%>
<html>
    <head>
        <title>Projeto de Sistemas de Software, Biblioteca</title>
    </head>
    <body>
        <div align="center">
            <FORM NAME="cadastro"
                  ACTION="../servlet/SystemController?page=../jsp/consulta/listaOperacoes.jsp"
                  METHOD="POST">
                <TABLE BORDER="0" CELLPADDING="1" CELLSPACING="2" SUMMARY="">
                    <TR>
                        <td align="RIGHT" valign="TOP">Usu&aacute;rios: <%=(new ic.tcc00175.biblioteca.view.TabelaUsuario())
							.getDropDown(usuario)%></td>
                    </TR>
                    <TR>
                        <td align="CENTER" valign="TOP"><%=tabela.getTabela()%></td>
                    </TR>

                    <TR>
                        <TD>
                            <DIV ALIGN="center"><jsp:include page="../botoesColecao.jsp"
                                         flush="true" /></DIV>
                        </TD>
                    </TR>
                </TABLE>
                <INPUT TYPE="hidden" NAME="command" VALUE="SelUsuario" SIZE="1"
                       MAXLENGTH="30"></FORM>
        </div>
        <script language="JavaScript">
            function selectUsuario() {
                document.cadastro.command.value = "SelUsuario";
                document.cadastro.submit();
            }
        </script>
        <%@ include file="../../html/footer.html"%>
    </body>
</html>
