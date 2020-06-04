<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,model.*"%>
<%
List<Star> list=(List<Star>)request.getAttribute("list");
String today=(String)request.getAttribute("today");
String hour=(String)request.getAttribute("hour");
String min=(String)request.getAttribute("min");
String lat=(String)request.getAttribute("lat");
String lng=(String)request.getAttribute("lng");
%>

<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8"/>
<meta name="viewport" content="width=device-width,initial-scale=1">
<title>StarApp</title>
<link rel="stylesheet" type="text/css" href="https://yui.yahooapis.com/3.5.0/build/cssreset/cssreset-min.css">
<style>
#container{
	width:80%;
	margin:0 auto;
}
.starBox{
	padding-bottom:20px;
	border-bottom:1px solid #aaa;
}
.imageBox img{
	display:block;
	width:100%;
}
</style>
</head>
<body>
<div id="container">
<h1>東京で見られる現在の星座</h1>
<table border="1">
<tr><th>日付</th><td><%=today %></td></tr>
<tr><th>時刻</th><td><%=hour %>時<%=min %>分</td></tr>
<tr><th>緯度</th><td><%=lat %></td></tr>
<tr><th>経度</th><td><%=lng %></td></tr>
</table>
<%if(list != null && list.size()>0){ %>

<%for(Star s:list){ %>

<div class="starBox">
<h2><%=s.getJpName() %>(<%=s.getEnName() %>)</h2>
<div class="imageBox">
<img src="<%=s.getStarImage() %>">
</div>
<h3>[由来]</h3>
<p><%=s.getOrigin() %></p>
</div>
<%} %>
<%} %>
</div>
</body>
</html>