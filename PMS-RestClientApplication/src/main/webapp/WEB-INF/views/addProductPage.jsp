<%@taglib  uri="http://www.springframework.org/tags/form"  prefix="form" %>
<html>
<body bgcolor="black" text="red">

<form:form  action="save"  method="post"  modelAttribute="product">
  <table>
    <tr>
       <td>Product Id : </td>
       <td> <form:input  path="productId"/> </td>
      
    </tr>
    <tr>
       <td>Product Name: </td>
       <td><form:input   path="productName"/> </td>
    
    </tr>
    <tr>
       <td> Price : </td>
       <td> <form:input   path="price"/> </td>  
      
    </tr>

    <tr>
       <td>Manufacturer : </td>
       <td><form:input  path="manufacturer"/> </td>
     
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




