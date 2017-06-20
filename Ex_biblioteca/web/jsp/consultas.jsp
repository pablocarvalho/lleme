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
                            <li><FONT SIZE="+2">Consultas</FONT></li>
                            <OL>
                                <FONT SIZE="+1">
                                <LI><A
                                        HREF="../servlet/SystemController?page=../jsp/consulta/listaMateriais.jsp">Lista
                                        de materiais</A></LI>
                                <LI><A
                                        HREF="../servlet/SystemController?page=../jsp/consulta/listaOperacoes.jsp">Opera&ccedil;&otilde;es
                                        por usu&aacute;rio</A></LI>
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
