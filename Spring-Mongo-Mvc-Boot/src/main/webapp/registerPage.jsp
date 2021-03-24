<!DOCTYPE html>
<html>
<body bgcolor="black" text="red">
<form    action="getRegister"       method="post">
      <table>
          <tr>
              <td>Fullname : </td>
              <td><input   type="text"    name="fullName"> </td>
          </tr>
          <tr>
               <td>Email : </td> 
               <td> <input   type="text"    name="email"> </td>
          </tr>
          <tr>
               <td> Experience : </td>
               <td> <input   type="text"    name="experience"> </td>
          </tr>

          <tr>
               <td> Gender : </td> 
               <td><input type="radio" name="gender" value="MALE"> Male
               <input type="radio" name="gender" value="FEMALE"> Female </td>
          </tr>

          <tr>
               <td>Date of Birth(yyyy.MM.dd): </td>
               </td>  <td> <input   type="text"    name="dateOfBirth"> </td>
          </tr>

          <tr>
               <td  colspan="5">   <input   type="submit"    value="submit"> </td>
          </tr>
      </table>
</form>  
</body>
</html>