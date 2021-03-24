<%@taglib    uri="http://java.sun.com/jsp/jstl/core"    prefix="c"%>
<!DOCTYPE html>
<html>
<body bgcolor="black" text="red">
<a href="getRegisterPage">Register-->></a> <br> <br>
<table  border="1">
    <tr>
        <th>FullName</th>  <th>Email</th> <th>Experience </th><th>DateOfBirth </th> <th>Gender </th> <th> Actions </th>
   </tr>  
   <c:if    test="${!empty   employees}">
            <c:forEach     items="${employees}"    var="emp">
                     <tr>
                          <td><c:out  value="${emp.fullName}"/></td>
                          <td><c:out  value="${emp.email}"/></td>
                          <td><c:out  value="${emp.experience}"/></td>
                          <td><c:out  value="${emp.dateOfBirth}"/></td>
                          <td><c:out  value="${emp.gender}"/></td>
                          <td>
                                 <a    href="editEmployeePage?email=${emp.email}">Edit </a>
                                 &nbsp; &nbsp; &nbsp;
                                 <a    href="deleteEmployee?email=${emp.email}"> Delete </a>
                         </td>
                   </tr>
            </c:forEach>
   </c:if>      
   </table>                                                                                     
             
</body>
</html>  