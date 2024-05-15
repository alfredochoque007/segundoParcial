<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@page contentType="text/html" pageEncoding="UTF-8" %>
        <!DOCTYPE html>
        <html>

        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>JSP Page</title>
            <link rel="stylesheet"
                href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">

        </head>

        <body style="margin-top: 2rem">

            <div class="container">
                <div class="card">
                    <div class="card-content">
                        <h5>Segundo Parcial</h5>
                        <p>Luis Alfredo Choque Canaviri</p>
                        <p>9941300 L.P.</p>
                    </div>
                </div>
                
                <h4 class="h6 center-align" style="margin-top: 3rem">Registro Dia del Internet</h4>
                <p><a href="inicio?action=add" class="waves-effect waves-light btn">Nuevo</a></p>

                <div class="card">
                    <div class="card-content">
                        <table class="striped">
                            <tr>
                                <th>ID</th>
                                <th>NOMBRES</th>
                                <th>APELLIDOS</th>
                                <th>SEMINARIO</th>
                                <th>CONFIRMACION</th>
                                <th>FECHA</th>
                                <th></th>
                                <th></th>
                            </tr>
                            <c:forEach var="item" items="${estudiantes}">
                                <tr>
                                    <td>${item.id}</td>
                                    <td>${item.nombres}</td>
                                    <td>${item.apellidos}</td>
                                    <td>${item.seminario}</td>
                                    <td>
                                        <label>
                                            <input type="checkbox" name="confirmado" class="filled-in" <c:if
                                                test="${item.confirmacion}">checked
                                            </c:if> />
                                             <span></span>
                                        </label>
                                    </td>
                                    <td>${item.fecha}</td>
                                    <td><a href="inicio?action=edit&id=${item.id}">Editar</a></td>
                                    <td><a href="inicio?action=delete&id=${item.id}"
                                            onclick="return(confirm('Esta Seguro'))">Eliminar</a></td>
                                </tr>
                            </c:forEach>
                        </table>

                    </div>
                </div>

            </div>
            <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>

        </body>

        </html>