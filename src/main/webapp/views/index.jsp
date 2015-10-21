<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<body>
<h2>Hello World!</h2>
<h2>I'm working!!!</h2>
<table>
    <thead>
    <tr>
        <th>id</th>
        <th>External id</th>
        <th>Message</th>
        <th>Owner</th>
        <th>Data Coding</th>
    </tr>
    </thead>
    <tbody>
<c:forEach items="${list}" var="row">
    <%--
    private String id;
    private String extId;
    private Integer ownerId;
    private String messageText;
    private Integer dataCoding;
    --%>

    <tr>
        <td><c:out value="${row.id}"/></td>
        <td><c:out value="${row.extId}"/></td>
        <td><c:out value="${row.messageText}"/></td>
        <td><c:out value="${row.ownerId}"/></td>
        <td><c:out value="${row.dataCoding}"/></td>
    </tr>
</c:forEach>
    </tbody>
</table>
</body>
</html>
