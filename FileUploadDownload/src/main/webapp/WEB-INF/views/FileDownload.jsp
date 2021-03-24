


<%@page  isELIgnored="false" %>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<html>
<body bgcolor="black" text="red">
<c:forEach items="${files}" var="f">
	<a href="doDownload?fileid=${f[0]}"><c:out value="${f[1]}"/></a><br>
</c:forEach>
</body>
</html> 