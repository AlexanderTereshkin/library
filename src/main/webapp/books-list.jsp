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
        <caption><h2>List of Books</h2></caption>
        <tr>
            <th>ID</th>
            <th>Author</th>
            <th>Title</th>
            <th>Who takes book</th>
        </tr>
        <c:forEach var="book" items="${listOfBooks}">
            <tr>
                <td><c:out value="${book.id}" /></td>
                <td><c:out value="${book.author}" /></td>
                <td><c:out value="${book.title}" /></td>
                <td><c:out value="${book.getStudent().getName()}" /></td>
            </tr>
        </c:forEach>
    </table>
</div>
<center>
    <h2>
        <a href="new-book">Add New Book</a>
    </h2>
</center>
</body>
</html>