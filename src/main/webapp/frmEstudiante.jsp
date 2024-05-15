<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet"
              href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
    </head>
    <body style="padding-top: 2rem">
        <div class="container">
            <div class="card">
                <div class="card-content">
                    <h4>
                        <c:if test="${estudiante.id == 0}">Nuevo</c:if> 
                        <c:if test="${estudiante.id != 0}">Editar</c:if> 
                            Registro
                        </h4>
                        <form action="inicio" method="post" style="margin-top: 3rem"> 
                            <input type="hidden" name="id" value="${estudiante.id}" /> 
                        <div class="input-field">
                            <input id="nombres" type="text" class="validate" value="${estudiante.nombres}">
                            <label for="nombres" >Nombres</label>
                        </div>

                        <div class="input-field" style="margin-top: 2rem">
                            <input id="apellidos" name="nombres" type="text" class="validate" value="${estudiante.apellidos}">
                            <label for="apellidos" >Apellidos</label>
                        </div>

                        <div class="input-field" style="margin-top: 2rem">
                            <input id="seminarios" name="apellidos" type="text" class="validate" value="${estudiante.seminario}">
                            <label for="seminario" >Seminario</label>
                        </div>

                        <label style="margin-top: 2rem">
                            <input type="checkbox" name="confirmacion"  value="true" <c:if test="${estudiante.confirmacion}">checked</c:if>  />
                                <span>Confirmacion</span>
                            </label>

                            <div style="display: flex">
                                <div class="input-field" style="margin-top: 2rem; display: flex">
                                    <input id="fecha" type="date" name="fecha" class="validate" value="${estudiante.fecha}">
                                <label for="fecha" >Fecha Inscripcion</label>
                            </div>
                        </div>


                        <input type="submit" class="waves-effect waves-light btn" />

                    </form>
                </div> 
            </div>


        </div>




        <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>

    </body>
</html>
