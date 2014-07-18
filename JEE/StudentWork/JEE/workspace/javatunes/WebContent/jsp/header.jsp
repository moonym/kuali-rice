<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>

<form method='post' action='<c:url value="/search"></c:url>'>
  <table width='500'>
  <tbody>
    <tr>
      <td width='70'><img src='<c:url value="/images/guitar.gif"></c:url>' width='64' height='62' border='0'/></td>
      <td align='right' width='514'><b><font size='+2'>Welcome to JavaTunes! Your online music store.</font></b></td>
    </tr>
    <tr>
      <td rowspan='2' width='70'><img src='<c:url value="/images/piano.gif"></c:url>' width='63' height='53' border='0'/></td>
      <td align='right' valign='top' width='514'><b><font size='+1'><i><font color='#0000cc'>JavaTunes Keyword CD Database Search</font></i></font></b></td>
    </tr>
    <tr>
      <td align='right' valign='bottom' width='514'><font color='#0000cc'><b>Search Database </b></font><input size='20' type='text' name='keyword'/><br/>
      <input type='submit' name='Submit' value='Search'/></td>
    </tr>
  </tbody>
  </table>
</form>
