<%-- 
    Document   : viewBook
    Created on : 17 Aug, 2016, 2:12:15 PM
    Author     : b5wang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>springlab :: springmvc</title>
    </head>
    <body>
        <h1>View Book</h1>
        <h3>Name: ${book.name}</h3>
        <h3>Author: ${book.author}</h3>
        <h3>Language: ${book.language}</h3>
    </body>
</html>
