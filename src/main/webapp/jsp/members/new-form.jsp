<%--회원 등록 폼 조회 JSP--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>   <%--JSP 문서라는 의미로 추가--%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/jsp/members/save.jsp" method="post">
    username: <input type="text" name="username" />
    age: <input type="text" name="age" />
    <button type="submit">전송</button>
</form>
</body>
</html>