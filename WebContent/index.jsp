<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="pt-br">
	<head>
		<meta charset="UTF-8">
		<title>Territórios</title>
	</head>
	<body>
		
		<header>
			<h1>Territórios</h1>
		</header>
		
		<main>
		
			<div class="div-pais">
				<select id="pais">
					<c:forEach var="pais" items="${paises}">
						<option value="${pais}">${pais}</option>
					</c:forEach> 
				</select>
			</div>
			
			<div class="div-estado">
			
			</div>
			
			<div class="div-cidade">
			
			</div>
		
		
		</main>
		
	</body>
</html>