<html>
<body>


<% 
   int a=3; 
   a+=2;
   
   String nome=request.getParameter("nome");
   
   
   session.setAttribute("username",nome); 
   

%>

Ciao <%= nome %>


<form action="ora" method="post" >
<input type="text" name="nome" />

<input type="submit"/>
</form>


</body>

</html>