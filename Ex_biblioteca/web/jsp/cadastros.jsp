<%@page session="false"%>
<html>
    <%@ include file="../html/header.html"%>
    <body>
        <br>
        <br>
        <DIV ALIGN="center">
            <TABLE BORDER="0" CELLPADDING="1" CELLSPACING="2" SUMMARY="">
                <TR>
                    <TD>
                        <ul>
                            <li><FONT SIZE="+2">Cadastros</FONT></li>
                            <OL>
                                <FONT SIZE="+1">
                                <LI><A
                                        HREF="../servlet/SystemController?page=../jsp/cadastro/cadUsuario.jsp">Cadastro
                                        de Usuário</A></LI>
                                </FONT>
                            </OL>
                        </ul>
                    </TD>
                </TR>
            </TABLE>
        </DIV>
        <%@ include file="../html/footer.html"%>
    </body>
</html>
