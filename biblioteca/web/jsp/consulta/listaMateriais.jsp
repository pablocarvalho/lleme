<%// Cria tabela de lista de conteudo
    ic.tcc00175.biblioteca.view.Tabela tabela = (ic.tcc00175.biblioteca.view.Tabela) request
            .getSession().getAttribute("tabela");
    if (tabela == null
            || !tabela.getClass().getName().equals(
            "ic.tcc00175.biblioteca.view.TabelaListaMateriais")) {
        tabela = new ic.tcc00175.biblioteca.view.TabelaListaMateriais(5);
        request.getSession().setAttribute("tabela", tabela);
    }

%>
<html>
    <head>
        <title>Projeto de Sistemas de Software, Biblioteca</title>
    </head>
    <body>
        <div align="center">
            <FORM NAME="cadastro"
                  ACTION="../servlet/SystemController?page=../jsp/consulta/listaMateriais.jsp"
                  METHOD="POST">
                <TABLE BORDER="0" CELLPADDING="1" CELLSPACING="2" SUMMARY="">
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
                <INPUT TYPE="hidden" NAME="command" VALUE="" SIZE="1" MAXLENGTH="30"></FORM>
        </div>
        <%@ include file="../../html/footer.html"%>
    </body>
</html>
