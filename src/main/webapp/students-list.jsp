<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Library Management Application</title>
</head>
<body>
<center>
    <h1>Library Management</h1>
    <h2>
        <a href="new">Add New Student</a>
        <a href="list" style="margin-left: 40px">List All Students</a>
        <a href="books"style="margin-left: 40px">List All Books</a>
    </h2>
</center>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List of Students</h2></caption>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Age</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="student" items="${listOfStudents}">
            <tr>
                <td><c:out value="${student.id}" /></td>
                <td><c:out value="${student.name}" /></td>
                <td><c:out value="${student.email}" /></td>
                <td><c:out value="${student.age}" /></td>
                <td>
                    <a href="edit?id=<c:out value='${student.id}' />">Edit</a>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="delete?id=<c:out value='${student.id}' />">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>