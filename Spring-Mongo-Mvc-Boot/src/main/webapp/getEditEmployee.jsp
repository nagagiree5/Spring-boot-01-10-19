<%@taglib    uri="http://www.springframework.org/tags/form"     prefix="form"%>

<!DOCTYPE html>
<html>
<body bgcolor="black" text="red">

<form:form     action="updateEmployee"     method="post"      modelAttribute="e">
<table>
    <tr>
         <td>Fullname : </td>
         <td><form:input    path="fullName" /> </td>
   </tr>
   <tr>
         <td>Email : </td> 
         <td><form:input    path="email" readonly="true" /> </td>
   </tr>
   <tr>
         <td>Experience:</td>
         <td><form:input    path="experience"  /> </td>
   </tr>
    <tr>
       <td> Gender : </td>
       <td>
           <form:radiobutton  path="gender"  value="MALE"  label="Male"/> 
           <form:radiobutton  path="gender"  value="FEMALE"  label="Female"/>      
       </td>
     
   </tr>
   <tr>
         <td>Date of Birth(yyyy.MM.dd): </td>
         <td><form:input    path="dateOfBirth"  /> </td>
   </tr>
   <tr>
         <td colspan="5">
             <input    type="submit"       value="submit">
        </td>             
   </tr>
            
</table>
</form:form>

</body>
</html>