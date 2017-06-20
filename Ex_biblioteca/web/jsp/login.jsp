<jsp:useBean id="autenticacao" class="ic.tcc00175.biblioteca.oldmodel.Autenticacao" scope="session" />
<jsp:useBean id="mensagem" class="java.lang.String" scope="session" />
<html>
    <META HTTP-EQUIV="Content-Type" CONTENT="text/html; charset=iso-8859-1">
    <script language="JavaScript">
        function autoexec() {
            document.formulario.login_username.focus();
        }
    </script>
    <%@ include file="../html/header.html"%>
    <body onload="autoexec();">
        <DIV ALIGN="center">
            <FORM NAME="formulario"
                  ACTION="../servlet/SystemController?page=../jsp/login.jsp"
                  METHOD="POST">
                <TABLE BORDER="2" CELLPADDING="0" CELLSPACING="2" SUMMARY="">
                    <TR>
                        <TH BORDERCOLOR="#FFFFFF" COLSPAN="2">Autenticação de usuário</TH>
                    </TR>
                    <TR>
                        <TD HEIGHT="24" BORDERCOLOR="#FFFFFF">Usuário: (admin)</TD>
                        <TD HEIGHT="24" BORDERCOLOR="#FFFFFF" ALIGN="right">
                            <INPUT type="text" name="login_username" SIZE="22" MAXLENGTH="50" value="<%= autenticacao.getId() == null ? "" : autenticacao.getId()%>">
                        </TD>
                    </TR>
                    <TR>
                        <TD HEIGHT="24" BORDERCOLOR="#FFFFFF">Senha: (admin)</TD>
                        <TD HEIGHT="24" BORDERCOLOR="#FFFFFF" ALIGN="right">
                            <INPUT
                                TYPE="password" NAME="secretkey" SIZE="22" MAXLENGTH="8" cols="30"
                                value="">
                        </TD>
                    </TR>
                    <TR>
                        <TD HEIGHT="24" BORDERCOLOR="#FFFFFF">Nome:</TD>
                        <TD HEIGHT="24" BORDERCOLOR="#FFFFFF" ALIGN="right"><INPUT TYPE="text"
                                                                                   NAME="nome" SIZE="22" MAXLENGTH="8" cols="30" readonly
                                                                                   value="<%= autenticacao.getNome() == null ? "" : autenticacao.getNome()%>"></TD>
                    </TR>
                    <TR>
                        <TD HEIGHT="24" BORDERCOLOR="#FFFFFF"><INPUT TYPE="hidden"
                                                                     NAME="command" value="DoLogin" SIZE="1" MAXLENGTH="20"></TD>
                        <TD HEIGHT="24" BORDERCOLOR="#FFFFFF">
                            <DIV ALIGN="right"><script language="JavaScript">
        function logout() {
            document.formulario.command.value = "DoLogout";
            document.formulario.submit();
        }
                                </script> <input type="button" value="Log Out"
                                                 onclick="logout();"> <input type="submit" value="Log In"></DIV>
                        </TD>
                    </TR>
                    <TR>
                        <TD HEIGHT="24" BORDERCOLOR="#FFFFFF" COLSPAN="2">
                            <DIV ALIGN="center">
                                <textarea cols="30" rows="2" WRAP="on" readonly><%=mensagem%></textarea>
                            </DIV>
                        </TD>
                    </TR>
                </TABLE>
            </FORM>
        </DIV>
        <%@ include file="../html/footer.html"%>

    </body>
</html>
