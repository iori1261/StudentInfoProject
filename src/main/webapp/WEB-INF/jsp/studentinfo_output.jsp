<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page language="java" import="java.util.*" %>
<html>
<head>
    <title>学生登録 Beans - 出力画面 JSP</title>
</head>
<body>
    <h1>学生登録 Beans - 出力画面 JSP</h1>
    <table border="1">
        <tr>
            <th>学生番号</th>
            <th>氏名</th>
            <th>学年</th>
        </tr>
        <%
            List<model.StudentInfoBean> students = (List<model.StudentInfoBean>) request.getAttribute("studentRecords");
            for(model.StudentInfoBean student : students) {
        %>
        <tr>
            <td><%= student.getStudentNo() %></td>
            <td><%= student.getName() %></td>
            <td><%= student.getYear() %></td>
        </tr>
        <% } %>
    </table>
    <a href="<%= request.getContextPath() %>/studentinfo_input.html">戻る</a><br>
    <a href="<%= request.getContextPath() %>/studentinfo_input.html">続けて学生を登録する</a>
</body>
</html>
