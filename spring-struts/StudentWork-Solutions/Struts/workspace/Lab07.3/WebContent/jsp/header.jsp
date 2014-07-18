<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html:form method='post' action='/search'>
  <table width='500'>
  <tbody>

    <tr>
     <td width='70'>
      <html:img page='/images/guitar.gif' width='64' height='62' border='0'/>
     </td>
     <td align='right' width='514'><b><font size='+2'>
       Welcome to JavaTunes! Your online music store.
     </font></b></td>
    </tr>

    <tr>
      <td rowspan='2' width='70'>
       <html:img page='/images/piano.gif' width='63' height='53' border='0'/>
      </td>
      <td align='right' valign='top' width='514'>
	<b><font size='+1'><i><font color='#0000cc'>
	   JavaTunes Keyword CD Database Search
      </font></i></font></b></td>
    </tr>

    <tr><td align='right' valign='bottom' width='514'>
	<font color='#0000cc'><b>Search Database </b></font>
        <html:text size='20' property='keyword'/><br/>
             <!-- define searchArtist field -->
        <html:select property="searchArtist">
	    <html:options collection="artistLabels" property="value" 
	                  labelProperty="label"/>
	</html:select>
        <html:submit>
	      <bean:message key="headerForm.button.search"/>
	</html:submit>
    </td></tr>

    <tr><td colspan="3" align="right" valign="top" >
        <html:messages id="error" message="false"
		       header="errors.header" footer="errors.footer">
            <li><c:out value="${error}"/></li>
        </html:messages>
    </td></tr>    

  </tbody>
  </table>
</html:form>
