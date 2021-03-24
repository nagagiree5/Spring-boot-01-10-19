<%@taglib    uri="http://java.sun.com/jsp/jstl/core"     prefix="c" %>

<!DOCTYPE html>
<html>
<body bgcolor="black" text="red">
<c:if    test="${message  != null}">
       <h2> <c:out   value="${message }"/> </h2>
</c:if>
<hr>
  <center>
           <a    href="getEmployeePage">Register-->></a>  <br> <br>
            <a   href="listEmployees">ListOfEmployees--></a>
  </center>
  
</body>
</html>