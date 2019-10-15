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
    <c:if test="${book != null}">
    <form action="update" method="post">
        </c:if>
        <c:if test="${book == null}">
        <form action="insert" method="post">
            </c:if>
            <table border="1" cellpadding="5">
                <caption>
                    <h2>
                        <c:if test="${book != null}">
                            Edit Book
                        </c:if>
                        <c:if test="${book == null}">
                            Add New Book
                        </c:if>
                    </h2>
                </caption>
                <c:if test="${book != null}">
                    <input type="hidden" name="id" value="<c:out value='${book.id}' />" />
                </c:if>
                <tr>
                    <th>Title of book: </th>
                    <td>
                        <input type="text" name="title" size="45"
                               value="<c:out value='${book.title}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Author of book: </th>
                    <td>
                        <input type="text" name="author" size="45"
                               value="<c:out value='${book.author}' />"
                        />
                    </td>
                </tr>
                    <td colspan="2" align="center">
                        <input type="submit" value="Save" />
                    </td>
                </tr>
            </table>
        </form>
</div>
</body>
</html>