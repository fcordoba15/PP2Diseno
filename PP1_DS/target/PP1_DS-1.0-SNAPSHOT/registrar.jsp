
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Registro de clientes</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="resgitro.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <h1>Registro de clientes</h1>
        <hr>
        <h2>Por favor ingrese los datos solicitados</h2>
        <nav>
            <form method="GET" action="RegistrarClienteWeb">
                <hr>
                Nombre: <input type="text" placeholder="Nombre" NAME= "NOMBRE" required>
                <br><br>
                <input type="text" placeholder="Primer apellido" NAME= "APELLIDO1" required>
                <br><br>
                <input type="text" placeholder="Segundo apellido" NAME= "APELLIDO2" required>
                <br><br>
                <input type="number" placeholder="Numero de cédula" NAME= "CEDULA" required>
                <br><br>
                <input type="number" placeholder="Numero de teléfono" NAME= "TELEFONO" required>
                <br><br>
                <input type="text" placeholder="Correo electronico" NAME= "CORREO" required>
                <br><br>
                <label> Fecha de nacimiento: </label>
                <input type="number" placeholder="Día (DD)" NAME= "DIA" required>
                <input type="number" placeholder="Mes (MM)" NAME= "MES" required>
                <input type="number" placeholder="Año (AAAA)" NAME= "AÑO" required>
                <br><br>
                <button type="submit">Enviar</button>
                <hr>
            </form>
            <a href="index.html">Volver a pagina principal</a>
        </nav>
    </body>
</html>
