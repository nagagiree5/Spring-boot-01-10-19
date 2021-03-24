<%@taglib    uri="http://java.sun.com/jsp/jstl/core"    prefix="c"%>
<!DOCTYPE html>
<html>
<body bgcolor="black" text="red">

<table  border="1">
 <c:if    test="${!empty passengers}">
    <tr>
        <th>PassengerId</th>  <th>FullName</th><th>Email </th><th>Age </th><th>SeatNumber </th> <th>Gender </th>
   </tr>  
  
            <c:forEach     items="${passengers}"    var="p">
                     <tr>
                          <td><c:out  value="${p.passengerId}"/></td>
                          <td><c:out  value="${p.firstName}"/> <c:out  value="${p.lastName}"/></td>
                        
                          <td><c:out  value="${p.emailId}"/></td>
                           <td><c:out  value="${p.age}"/></td>
                          <td><c:out  value="${p.seatNumber}"/></td>
                          <td><c:out  value="${p.gender}"/></td>
                         
                   </tr>
            </c:forEach>
  </table> 
  
   <c:if    test="${previous}"> 
   <a    href="getPassengers?pageNor=${currentPageNor -1}">Prev </a>
    </c:if>
    
   &nbsp; &nbsp; &nbsp;  &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;  &nbsp; &nbsp; &nbsp;  &nbsp; &nbsp; &nbsp;  &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;  &nbsp; &nbsp; &nbsp;
   &nbsp; &nbsp; &nbsp;  &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;  &nbsp; &nbsp; &nbsp;  &nbsp; &nbsp; &nbsp;  &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;  &nbsp; &nbsp; &nbsp;
   &nbsp; &nbsp; &nbsp;  &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;  &nbsp; &nbsp; &nbsp;  &nbsp; &nbsp; &nbsp;  &nbsp; &nbsp; &nbsp; 
       <c:if    test="${next}"> 
   <a    href="getPassengers?pageNor=${currentPageNor +1}">Next </a>
    </c:if>                
            
            
            
</c:if>      
                                                                                                                    
</body>
</html>  