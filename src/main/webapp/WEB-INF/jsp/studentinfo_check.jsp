<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page language="java" import="java.util.*" %>
<html>
<head>
    <title>学生登録 Beans - 確認画面 JSP</title>
</head>
<body>
    <h1>学生登録 Beans - 確認画面 JSP</h1>
    <p>学生が登録されました。</p>
    <p>現在の登録数: <%= request.getAttribute("studentCount") %>件</p>
    <a href="<%= request.getContextPath() %>/studentinfo_input.html">続けて学生を登録する</a><br>
    <a href="<%= request.getContextPath() %>/StudentInfoServlet?action=view">登録されている学生一覧を表示</a>
</body>
</html>
