<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="model.*" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Liste Soft</title>
<link rel="stylesheet" type="text/css" href="css/newStyle.css">
</head>
<body>
	<div class="container">
		<form>
		<!-- Add the class to the unordered list -->
			<ul class="todo-list">
  				<%
  				for(Software soft : Application.getInstance().getListSoftware() ){
  				%>
  					<li>
    					<%=soft.getName()%>, <%=soft.getVersion()%>, <%=soft.getLicence()%>
  					</li>

  				<%
  				} 
  				%>
			</ul>
			<form method="get" action="./Controller" class="add-todo-form">
				<br>
				Modify a Software :
				<br>
	  			Name : 
	  			<select name="soft_texte" id="todo-select" class="select-todo">
			        <option value="">--Please choose an name--</option>
			        <%
			        for(Software soft : Application.getInstance().getListSoftware() ){
			        %>
			            <option value="<%=soft.getName()%>"><%=soft.getName()%></option>
			        <% } %>
			    </select>
	  			<br>
	  			Version : <input type="text" name="soft_ver" />
	  			<br>
	  			Licence : <input type="text" name="soft_lic" />
	  			
				<input type="submit" name="action" value="updateList" />
				<br>
  			</form>
		</form>
		
		
	
		<!-- Add class and style to the add todo form -->
		<form method="get" action="./Controller" class="add-todo-form">
			<br>
  			Add a new Software : 
  			<br>
  			Name : <input type="text" name="soft_texte" />
  			<br>
  			Version : <input type="text" name="soft_ver" />
  			<br>
  			Licence : <input type="text" name="soft_lic" />
  						
  			<input type="submit" name="action" value="addSoft" /> 
		</form>
		
		
		
		
		<%-- Delete Software --%>
		<form method= "get" action= "./Controller" class="form-delete-todo">
		    <label for="todo-select" class="label-select-todo">Select a Software to delete:</label>
		    <select name="soft_delete" id="todo-select" class="select-todo">
		        <option value="">--Please choose an option--</option>
		        <%
		        for(Software soft : Application.getInstance().getListSoftware() ){
		        %>
		            <option value="<%=soft.getName()%>"><%=soft.getName()%></option>
		        <% } %>
		    </select>
		    <input type="Submit" name="action" value="Delete" class="btn-delete-todo" />
		</form>
	

	</div>


</body>
</html>