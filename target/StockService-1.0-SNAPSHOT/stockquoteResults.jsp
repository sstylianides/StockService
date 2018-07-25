<%@ page import="java.text.SimpleDateFormat" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<html>
<head>
    <title>Stock Search Results</title>
    <style>
        table, td, th{
            border: 1px solid black;

        }
        table{
            border-collapse: collapse;
        }
    </style>
</head>
<body>
<table>
    <tr>
        <th>
            Symbol
        </th>
        <th>
            Price
        </th>
        <th>
            Date
        </th>
    </tr>
    <c:forEach items="${quotes}" var="quote">
        <tr>
            <td><c:out value="${quote.getSymbol()}" /></td>
            <td><c:out value="${quote.getValue()}" /></td>
            <td><fmt:formatDate value="${quote.getDate().getTime()}" pattern="MM/dd/yyyy" /></td>
        </tr>
    </c:forEach>
</table>


</body>
</html>
