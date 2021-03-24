<%@taglib    uri="http://java.sun.com/jsp/jstl/core"     prefix="c" %>

<!DOCTYPE html>
<html>
<body bgcolor="black" text="red">

<c:if    test="${message  != null}">
       <h2> <c:out   value="${message }"/> </h2>
</c:if>

<center>
<hr>
<a href="getRegisterPage" style="color:#FF0000;">Register-->></a> <br> <br>
<a href="listOfEmployees" style="color:#FF0000;">ListOfEmployees-->></a>
<hr>
</center> 

  
</body>
</html>       