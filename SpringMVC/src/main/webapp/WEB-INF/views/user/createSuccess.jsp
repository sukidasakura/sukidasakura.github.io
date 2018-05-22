<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%--
  Created by IntelliJ IDEA.
  User: Mashencai
  Date: 2018/5/22
  Time: 9:04
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<html>
<head>
    <title>用户创建成功</title>
</head>
<body>
    恭喜，用户${user.userName}创建成功。 <!-- 访问Model中的属性 -->
<!--由于UserController#createUser()通过@ModelAttribute("user")将User对象放到模型中，
    所以createSuccess.jsp可以通过${user.userName}访问模型中的数据-->
</body>
</html>
