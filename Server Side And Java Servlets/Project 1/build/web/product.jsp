<%-- 
    Document   : product
    Created on : Sep 24, 2017, 6:55:07 PM
    Author     : Pbyrd
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Product</title>
    </head>
    <body>
        <h1>Product</h1>
        <br>
        <i> You must enter a description for the product.</i><br>
        <b style="color:red;font-size: 30px;">${MSG}</b>
        <br>
<form action="ProductMate?action=add_product" method="POST">
<table>
<tr><td>Product Code:</td><td>:</td><td><input type="text" name="code" size="10"></td></tr>
<tr><td>Product Description</td><td>:</td><td><input type="text" name="description" size="25" ></td></tr>
<tr><td>Product Price</td><td>:</td><td><input type="text" name="price" size="15"></td></tr>
</table>
<br>
 
  
  <input type="submit" value="Insert Product">
  </form>
  <a href="ProductMate?action=viewProducts"><button>View Products</button></a>
</body>
</html>
