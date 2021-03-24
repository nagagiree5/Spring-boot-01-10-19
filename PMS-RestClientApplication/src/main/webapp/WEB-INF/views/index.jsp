<%@taglib    uri="http://java.sun.com/jsp/jstl/core"     prefix="c" %>

<!DOCTYPE html>
<html>
<body bgcolor="black" text="red">

<c:if    test="${str  != null}">
     Msg:: <c:out   value="${str }"/> &nbsp::
</c:if>


<hr color="green">
<a href="addProduct" style="color:#FF0000;">Add product-->></a> <br>
<a href="updateProduct" style="color:#FF0000;">Update Product-->></a> <br> 
<a href="findAllProducts" style="color:#FF0000;">FindAll Products-->></a> <br>
<a href="deleteProduct" style="color:#FF0000;">delete Product-->></a> <br> 
<a href="findProduct" style="color:#FF0000;">findProduct-->></a> <br> 
<hr color="green">


  
</body>
</html>    