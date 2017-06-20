<html>
    <%@ include file="../html/header.html"%>
    <body>
        <br>
        <br>
        <DIV ALIGN="center">
            <TABLE BORDER="0" CELLPADDING="1" CELLSPACING="2" SUMMARY="">
                <TR>
                    <TD><FONT SIZE="+1">
                        <ul>
                            <li><FONT SIZE="+2">Menu Principal</FONT></li>
                            <OL>
                                <LI><A HREF="cadastros.jsp">Cadastros</A></LI>
                                <LI><A
                                        HREF="../servlet/SystemController?page=../jsp/operacao/reserva.jsp">Reserva</A></LI>
                                <LI><A
                                        HREF="../servlet/SystemController?page=../jsp/operacao/emprestimo.jsp">Empr&eacute;stimo</A></LI>
                                <LI><A
                                        HREF="../servlet/SystemController?page=../jsp/operacao/devolucao.jsp">Devolu&ccedil;&atilde;o</A></LI>
                                <LI><A HREF="consultas.jsp">Consultas</A></LI>
                                <LI><A HREF="../servlet/SystemController?page=../jsp/login.jsp">Login</A></LI>
                            </OL>
                        </ul>
                        </FONT></TD>
                </TR>
            </TABLE>
        </DIV>
        <%@ include file="../html/footer.html"%>
    </body>
</html>
