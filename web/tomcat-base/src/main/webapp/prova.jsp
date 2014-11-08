<html>
<head><title>First JSP</title></head>
<body>
  Ciao
  <%
  
    double num = Math.random();
    if (num > 0.5) {
  %>
      <h2>You'll have a luck day!</h2><p>(<%= num %>)</p>
  <%
    } else {
  %>
      <h2>Well, life goes on ... </h2><p>(<%= num %>)</p>
  <%
    }
  %>
</body>
</html>