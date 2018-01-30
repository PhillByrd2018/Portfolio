<%-- 
    Document   : newjsp
    Created on : Sep 24, 2017, 8:01:26 PM
    Author     : Pbyrd
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
<head>
    <title>Products</title>
</head>
<body>
<h1>Products</h1>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<table style="border:solid">
  <tr valign="bottom">
    <td align="left"><b>Code</b></td>
    <td align="left"><b>Description</b></td>
    <td align="left"><b>Price</b></td>
    <td align="left">Edit</td>
    <td align="left">Remove</td>
  </tr>
  
    <c:forEach var="c" items="${ProductsList}">
    <tr>
         <td>${c.getCode()}</td>
         <td>${c.getDescription()}</td>
         <td>${c.getPrice()}</td>
        <td>
            <a href="ProductMate?action=edit_Products&code=${c.getCode()}&description=${c.getDescription()}&price=${c.getPrice()}"><button>EDIT</button></a>
        </td>
        <td>
            <a href="ProductMate?action=delete_Product&code=${c.getCode()}&description=${c.getDescription()}&price=${c.getPrice()}"><button>DELETE</button></a>
        </td>
    </tr>
    </c:forEach>
    
</table>
       
      
  



 <form action="<%= response.encodeURL("product.jsp")%>" method="post">
  <input type="submit" name="add" value="Add Product">
</form> 
  
 
</body>
</html>