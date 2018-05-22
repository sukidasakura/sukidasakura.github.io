<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Mashencai
  Date: 2018/5/22
  Time: 8:26
  To change this template use File | Settings | File Templates.

  包括一个表单，单击“提交”按钮后，表单提交到/user.html进行处理。
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新增用户</title>
</head>
<body>
    <form method="post" action="<c:url value="/user.html" />"> <!-- 这里最后的这个“/”不可省略！！！-->
        <table>
            <tr>
                <td>用户名：</td>
                <td><input type="text" name="userName" /></td>
            </tr>
            <tr>
                <td>密码：</td>
                <td><input type="text" name="password" /></td>
            </tr>
            <tr>
                <td>姓名：</td>
                <td><input type="text" name="realName" /></td>
            </tr>
            <tr>
                <td colspan="2"><input type="text" name="提交" /></td>
            </tr>
        </table>
    </form>
</body>
</html>