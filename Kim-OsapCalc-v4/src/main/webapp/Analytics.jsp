<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="StyleSheet" href="res/mc.css" type="text/css" title="cse4413" media="screen, print"/>
<title>Insert title here</title>
</head>
<body>
<form action="Analytics.jsp" method="GET" class="resultForm">
<header>
<h1> Maximum Principal</h1>
</header>
<section>
<nav>
<a href="">Home</a>
<a href="">About</a>
</nav>
</section>
<BR />
<article>
<fieldset>
<legend>Admin</legend>
<table>
<tr>
<td><strong>Maximum Loan Requested</strong></td><td> <strong> ${ML}</strong> </td>
</tr>
<tr>
<td><small>Maximum principal=${mPrincipal}</small></td>
</tr>

</table>

 <button type="submit" name="restart" value="true">Refresh</button>
 </fieldset>
 </article>
  <footer>Copyright EECS 4413Z - All rights reserved</footer> 
</form>

</body>
</html>
