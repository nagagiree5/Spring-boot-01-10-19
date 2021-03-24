<%@taglib  uri="http://java.sun.com/jsp/jstl/core"    prefix="c"%>
<html>
<body  bgcolor="light-grey">
    <c:if  test="${errorMessage  ne null}">
          <h2  style="border: 2px  solid  cyan; color: red; width: 200px;">
             <c:out  value="${errorMessage}"/>
          </h2>   
    </c:if>         

<form   action="doLogin"    method="post">
  <table   background="yellow">
     <tr>
        <td> Username </td> <td> <input  type="text"   name="username"> </td>
     </tr>
     <tr>
         <td> Password </td> <td> <input  type="password"   name="password"> </td>
     </tr>
     <tr>
         <td  colspan="2"   align="center">
            <input  type="submit"    value="Sign In">
         </td>
      </tr>   
  </table>

</form>

</body>
</html>
