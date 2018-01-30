<%-- 
    Document   : newjsp
    Created on : Sep 24, 2017, 6:59:31 PM
    Author     : Pbyrd
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Confirm Delete</title>
    </head>
    <body>
        <h1>Are you sure you want to delete this product? </h1>
        <p>code: ${code}</p>
        <p>Product Description: ${description}</p>
        <p>Product Price: ${price}</p>


<form action="ProductMate?action=delete" method="POST">
    <input type="hidden" name="code" value="${code}">
    <input type="submit" value="Yes">
</form>
    
        
        <a href="ProductMate?action=viewProducts"><button>NO</button></a>
    
    </body>
</html>
