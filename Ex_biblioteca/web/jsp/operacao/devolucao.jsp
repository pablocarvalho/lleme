<jsp:useBean id="mensagem" class="java.lang.String" scope="session" />
<%// Recupera Usuario
    ic.tcc00175.biblioteca.oldmodel.Usuario usuario = (ic.tcc00175.biblioteca.oldmodel.Usuario) request.getSession().getAttribute("usuario");
    if (usuario == null) {
        usuario = new ic.tcc00175.biblioteca.oldmodel.AlunoGraduacao();
    }

    // Recupera material
    ic.tcc00175.biblioteca.oldmodel.Material material = (ic.tcc00175.biblioteca.oldmodel.Material) request.getSession().getAttribute("material");
    if (material == null) {
        material = new ic.tcc00175.biblioteca.oldmodel.Livro();
    }

    //Recupera exemplar
    ic.tcc00175.biblioteca.oldmodel.Exemplar exemplar = (ic.tcc00175.biblioteca.oldmodel.Exemplar) request.getSession().getAttribute("exemplar");
    if (exemplar == null) {
        exemplar = new ic.tcc00175.biblioteca.oldmodel.Exemplar();
    }

    // Recupera emprestimo
    ic.tcc00175.biblioteca.oldmodel.Emprestimo emprestimo = (ic.tcc00175.biblioteca.oldmodel.Emprestimo) request.getSession().getAttribute("emprestimo");
    if (emprestimo == null) {
        emprestimo = new ic.tcc00175.biblioteca.oldmodel.Emprestimo();
    }

    // Cria tabela de lista de conteudo
    ic.tcc00175.biblioteca.view.Tabela tabela = (ic.tcc00175.biblioteca.view.Tabela) request.getSession().getAttribute("tabela");
    if (tabela == null
            || !tabela.getClass().getName().equals(
            "ic.tcc00175.biblioteca.view.TabelaEmprestimo")) {
        tabela = new ic.tcc00175.biblioteca.view.TabelaEmprestimo(12,
                usuario);
        request.getSession().setAttribute("tabela", tabela);
    } else {
        tabela.setColecao(usuario.getLnkEmprestimo());
    }
    //Cria formulario de cadastro
    ic.tcc00175.biblioteca.view.FormularioDevolucao formulario = new ic.tcc00175.biblioteca.view.FormularioDevolucao();

%>
<html>
    <head>
        <title>Projeto de Sistemas de Software, Biblioteca</title>
    </head>
    <body>
        <div align="center">
            <FORM NAME="cadastro"
                  ACTION="../servlet/SystemController?page=../jsp/operacao/devolucao.jsp"
                  METHOD="POST" NAME="cadastro">
                <TABLE BORDER="0" CELLPADDING="1" CELLSPACING="2" SUMMARY="">
                    <TR>
                        <td align="CENTER" valign="TOP"><%=tabela.getTabela()%></td>
                        <td valign="TOP"><%=formulario.getFormulario(usuario, material)%></td>
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
                                function selectMaterial() {
                                    document.cadastro.command.value = "SelMaterial";
                                    document.cadastro.submit();
                                }
                                function incluir() {
                                    document.cadastro.command.value = "AddDevolucao";
                                    document.cadastro.submit();
                                }
                                </script> <INPUT TYPE="hidden"
                                                 NAME="command" VALUE="AddDevolucao" SIZE="1" MAXLENGTH="30"><INPUT
                                                 TYPE="submit" VALUE="Devolver"></DIV>
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
