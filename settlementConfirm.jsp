<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./css/style.css">
<link rel="stylesheet" type="text/css" href="./css/cartAndSettlement.css">
<title>決済確認画面</title>
</head>
<body>
<!-- header.jspで書かれている内容を持ってくる -->
<jsp:include page="header.jsp" />
<script src="./js/mocha.js"></script>
<div id="contents">
<h1>決済確認画面</h1>
<!--     宛先情報がある場合 -->
<s:if test="destinationInfoDTOList != null && destinationInfoDTOList.size()>0">

<div class="info">
  宛先情報を選択してください。
</div>
  <s:form id="form">
<!--   テーブル作成 枠 -->
	<table class="table">
	<thead>
	<tr>
	  <th><s:label value="#"/></th>
	  <th><s:label value="姓"/></th>
	  <th><s:label value="名"/></th>
	  <th><s:label value="ふりがな"/></th>
	  <th><s:label value="住所"/></th>
	  <th><s:label value="電話番号"/></th>
	  <th><s:label value="メールアドレス"/></th>
	</tr>
	</thead>
	<tbody>
<!-- 	情報 -->
	<s:iterator value="destinationInfoDTOList" status="st">
	<tr>
	  <td>
		<s:if test="#st.index == 0">
		  <input type="radio" name="id" checked="checked" value="<s:property value='id'/>"/>
		</s:if>
		<s:else>
		  <input type="radio" name="id" value="<s:property value='id'/>"/>
		</s:else>
	  </td>
	  <td>
		  <s:property value="FamilyName"/><br>
	  </td>
	  <td>
		  <s:property value="FirstName"/><br>
	  </td>

	  <td>
		  <s:property value="FamilyNameKana" /><span> </span><s:property value="FirstNameKana" /><br>
	  </td>
	  <td>
		  <s:property value="UserAddress" />
	  </td>
	  <td>
		  <s:property value="TelNumber"/>
	  </td>
	  <td>
		  <s:property value="Email"/>
	  </td>
	</s:iterator>
	</tbody>
	</table>
<!-- 決済、削除ボタン作成 -->
	<div class="submit_btn_box">
	  <s:submit value="決済" class="submit_btn" onClick="setAction('SettlementCompleteAction')" />
	</div>
	<div class="submit_btn_box">
	  <s:submit value="削除" class="submit_btn" onClick="setAction('DeleteDestinationAction')" /></div>
  </s:form>
</s:if>

<s:else>
<div class="info">
宛先情報がありません。
</div>
</s:else>
<!-- 新規宛先登録ボタン作成 -->
<div class="submit_btn_box">
  <s:form action="CreateDestinationAction">
    <s:submit value="新規宛先登録" class="submit_btn" />
  </s:form>
</div>

</div>
</body>
</html>