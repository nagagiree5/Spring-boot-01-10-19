<%@page  isELIgnored="false" %>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>

<c:if test="${message !=null}">

<c:out   value="${message}"/>
</c:if>

<hr>
<form style="border: 2px solid cyan;" action="doUpload" method="post" enctype="multipart/form-data">
	PICK FILE :<input type="file" name="file1">
	<input type="submit" value="UPLOAD">
</form>

<br>

<a href="downLoadPage">Download files</a>