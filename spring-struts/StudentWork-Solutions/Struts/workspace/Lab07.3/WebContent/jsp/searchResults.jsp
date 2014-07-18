<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>

<tiles:insert definition="main.layout" flush="true"> 
	<tiles:put name="title" value="JavaTunes Search Results" />
	<tiles:put name="body" value="/jsp/searchResultsContent.jsp"/>
</tiles:insert>
