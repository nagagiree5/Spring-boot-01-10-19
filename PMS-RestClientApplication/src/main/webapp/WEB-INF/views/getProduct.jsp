<%@taglib    uri="http://java.sun.com/jsp/jstl/core"    prefix="c"%>
<!DOCTYPE html>
<html>
<body bgcolor="black" text="red">

<table  border="1">
    <tr>
        <th>ProductId</th>  <th>ProductName</th> <th>Price </th><th>Manufacturer </th> 
   </tr>  
   <c:if    test="${!empty   pr}">
            
                     <tr>
                          <td><c:out  value="${pr.productId}"/></td>
                          <td><c:out  value="${pr.productName}"/></td>
                          <td><c:out  value="${pr.price}"/></td>
                        
                          <td><c:out  value="${pr.manufacturer}"/></td>
                     
                   </tr>

   </c:if>      
   </table>                                                                                     
             
</body>
</html>    
