<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>

<tiles:insert page="/jsp/layout.jsp" flush="true">
	<tiles:put name="title" value="JavaTunes Online Music" />
	<tiles:put name="header" value="/jsp/header.jsp" />
	<tiles:put name="body" type="string" >
		<HR>
		<H2> Today's special </H2>
		<H2> 25% off any your purchase price on purchases of $100 or more</H2>
	</tiles:put>
</tiles:insert>
