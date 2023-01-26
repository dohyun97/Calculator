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
<form action="UI.html" method="GET" class="resultForm">
<header>
<h1> Student Loan Application</h1>
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
<legend>Calculator</legend>
<table>
<tr>
<td><strong>Monthly payments:</strong></td><td> <strong> ${payment}</strong> </td>
</tr>
<tr>
<td><small>Calculation used principal=${principal}, interest=${interest} and period=${period }</small></td>
</tr>
</table>

 <button type="submit" name="restart" value="true">Re-compute</button>
 </fieldset>
 </article>
  <footer>Copyright EECS 4413Z - All rights reserved</footer> 
</form>
</body>
</html>
