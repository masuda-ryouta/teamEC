<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./css/style.css">
<!-- 3秒後にHomeActionに自動遷移 -->
<meta http-equiv="refresh" content="3; URL='HomeAction">
<title>決済完了画面</title>
</head>
<body>
<!-- header.jspで書かれている内容を持ってくる -->
<jsp:include page="header.jsp"/>
  <div id="contents">
    <h1>決済完了</h1>
  <div class="success">
  決済が完了しました。
  </div>
  </div>
</body>
</html>