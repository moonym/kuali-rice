<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>

<%-- Using optional extended eTunes definition below
   <tiles:insert definition="main.layout" flush="true"> 
--%> 

   <tiles:insert definition="eTunes.layout" flush="true"> 

	<tiles:put name="body" type="string" >
		<HR>
		<H2> Today's special </H2>
		<H2> 25% off any your purchase price on purchases of $100 or more</H2>
	</tiles:put>

</tiles:insert>