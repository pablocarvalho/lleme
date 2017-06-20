<script language="JavaScript">
    function next() {
        document.cadastro.command.value = "Next";
        document.cadastro.submit();
    }
    function back() {
        document.cadastro.command.value = "Back";
        document.cadastro.submit();
    }
    function begin() {
        document.cadastro.command.value = "Begin";
        document.cadastro.submit();
    }
    function end() {
        document.cadastro.command.value = "End";
        document.cadastro.submit();
    }
</script>
<INPUT TYPE="button" VALUE="  <<  " onclick="begin();">
<INPUT TYPE="button" VALUE="  <  " onclick="back();">
<INPUT TYPE="button" VALUE="  >  " onclick="next();">
<INPUT TYPE="button" VALUE="  >>  " onclick="end();">
