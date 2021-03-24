<%@taglib  uri="http://www.springframework.org/tags/form"  prefix="form" %>
<html>
<body bgcolor="black" text="red">

<form:form  action="registerUser"  method="post"  modelAttribute="register">
  <table>
    <tr>
       <td>Fullname : </td>
       <td> <form:input  path="fullName"/> </td>
       <td> <form:errors  path="fullName"/> </td>
    </tr>
    <tr>
       <td>Email : </td>
       <td><form:input   path="email"/> </td>
       <td><form:errors  path="email"/> </td>
    </tr>
    <tr>
       <td> Experience : </td>
       <td> <form:input   path="experience"/> </td>
       <td> <form:errors  path="experience"/> </td>
    </tr>
    <tr>
       <td> Gender : </td>
       <td>
           <form:radiobutton  path="gender"  value="MALE"  label="Male"/> 
           <form:radiobutton  path="gender"  value="FEMALE"  label="Female"/>      
       </td>
       <td> <form:errors  path="gender"/> </td>
    </tr>
    <tr>
       <td>Date of Birth(yyyy.MM.dd): </td>
       <td><form:input  path="dateOfBirth"/> </td>
       <td> <form:errors  path="dateOfBirth"/></td>
    </tr>                
    <tr>
       <td  colspan="3">
          <input  type="submit"   value="submit">
       </td>
    </tr>
  </table>                                  
        
</form:form>

</body>
</html>  





