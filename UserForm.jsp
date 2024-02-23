<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.um.model.User"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<title>USER MANAGEMENT SYSTEM</title>
</head>
<body>
<nav class="navbar navbar-expand-lg bg-body-tertiary">
  <div class="container-fluid">
    <a class="navbar-brand">USER MANAGEMENT SYSTEM</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="<%=request.getContextPath()%>/list">Users</a>
        </li>
       </ul>
      </div>
     </div>
   </nav>
    <c:if test="${list==null}">
    <form action="insert" method="post">
    </c:if>
    <c:if test="${list!=null}">
    <form action="update" method="post">
    </c:if>
    
    <h2 align="center">
    <c:if test="${list==null}">
    ADD USER
    </c:if>
    <c:if test="${list!=null}">
    EDIT USER
     </c:if>
    </h2>
   
   <div class="mb-3 container">
  <input type="hidden" id="exampleFormControlInput5" class="form-control" value="${list.id}" placeholder="Enter Your Name" name="id" style="width:300px" >
  </div>
  
  <div class="mb-3 container">
  <label for="exampleFormControlInput1" class="form-label">Name:</label>
  <input type="text" id="exampleFormControlInput1" class="form-control" value="${list.name}" placeholder="Enter Your Name" name="name" style="width:300px" >
</div>
  
  <div class="mb-3 container">
  <label for="exampleFormControlInput2" class="form-label">Email:</label>
  <input type="email" id="exampleFormControlInput2" class="form-control"value="${list.email}"  placeholder="Enter Your Email" name="email" style="width:300px" >
</div>
    
   <div class="mb-3 container">
   <label for="exampleFormControlInput3" class="form-label">City:</label>
   <input type="text" id="exampleFormControlInput3" class="form-control" value="${list.city}"  placeholder="Enter Your City" name="city" style="width:300px" >
   </div>     
      
   <div class="mb-3 container">
     <input type="submit" value="save" class="btn btn-success" style="width:150px">
     </div>    
         
    
              
</body>
</html>