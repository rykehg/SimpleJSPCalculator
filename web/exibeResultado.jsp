<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Calculadora</title>
    </head>
    <body>
        <h3>Henrique Hessel Gaeta - ADS - Matutino</h3>
        <br>        
        <h1>O resultado é: </h1>
        <%= request.getAttribute("resultado").toString() %>
    </body>
</html>
