<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>

<tiles:insert page="/jsp/layout.jsp" flush="true">
	<tiles:put name="title" value="JavaTunes Search Results" />
	<tiles:put name="header" value="/jsp/header.jsp" />
	<tiles:put name="body" value="/jsp/searchResultsContent.jsp"/>
</tiles:insert>
