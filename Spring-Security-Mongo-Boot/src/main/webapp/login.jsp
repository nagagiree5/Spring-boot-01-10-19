<%@taglib    uri="http://java.sun.com/jsp/jstl/core"    prefix="c"%>
<c:if    test="${!empty   errorMessage}">
<hr color="green">
  Invalid details : ${errorMessage} <br>
  
<hr color="green">
          
   </c:if>      


<!DOCTYPE html>
<html>
<body bgcolor="black" text="red">
<center>

<form  action="login"   method="post">
  <table border=1  bgcolor="black">
    <tr>
      <td>Username</td> <td><input  type="text"  name="username"></td>
    </tr>  
    
    <tr>
      <td>Password</td> <td><input  type="password"  name="password"></td>
    </tr>
    
    <tr>
      <td  colspan="2" align="center">
       <input  type="submit"   value="LOGIN">
      </td> 
    </tr>
  </table>

</form>
</center>
</body>
</html>