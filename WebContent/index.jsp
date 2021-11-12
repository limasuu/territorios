<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="pt-br">
	<head>
		<meta charset="UTF-8">
		<title>Territ�rios</title>
		
		<style type="text/css">
			body{
				display: flex;
				flex-direction: column;
				align-items: center;
			}
			
			main{
				display: flex;
				width: 60%;
				justify-content: space-around;
			}
			
			textarea{	
				width: 250px;
				height: 150px;
				
				padding: 15px;
				resize: none;
			}
		</style>
		
		<script type="text/javascript">
		
			function buscarEstados(){
				
				var ajax= new XMLHttpRequest();
				
				var url= "/territorios/Controlador/estados";
				url+= "?pais=" + document.getElementById("campo-pais").value;
				
				ajax.onreadystatechange= function(){
					if(ajax.readyState == 4 && ajax.status == 200){
						
						var estados= ajax.responseText.split(";");
						var campoEstados= document.getElementById("campo-estado");
																								
						campoEstados.length= 0;
						for(var i=0; i<estados.length; i++)
							if(estados[i].length > 0)
								campoEstados.options[campoEstados.length]= new Option(estados[i]);			
					}		
				};
			
				ajax.open("GET", url, true);
				ajax.send();
			}		
			
			function buscarDados(){
				
				var ajax= new XMLHttpRequest();
				
				var url="/territorios/Controlador/dadosEstado";
				url+="?pais=" + document.getElementById("campo-pais").value;
				url+="&estado=" + document.getElementById("campo-estado").value;
				
				ajax.onreadystatechange= function(){
					if(ajax.readyState == 4 && ajax.status == 200){
						
						var dados= ajax.responseText;
						var campoDados= document.getElementById("campo-dados");
						
						campoDados.value= dados;
					}					
				};
				
				ajax.open("GET", url, true);
				ajax.send();
			}
			
		</script>
	</head>
	<body>
		
		<header>
			<h1>Territ�rios</h1>
		</header>
		
		<main>
		
			<div class="div-pais">
				Pa�s
				<select id="campo-pais" onchange="buscarEstados()">
					<option>Selecione</option>
				
					<c:forEach var="pais" items="${paises}">
						<option value="${pais}">${pais}</option>
					</c:forEach> 
				</select>
			</div>
			
			<div class="div-estado">
				Estado
				<select id="campo-estado" onchange="buscarDados()">
					<option>Selecione</option>
					
					<c:forEach var="estado" items="${estados}">
						<option value="${estado}">${estado}</option>
					</c:forEach>
				</select>
			</div>
			
			<div class="div-dados-estado">
				<textarea id="campo-dados"></textarea>
			</div>
		
		
		</main>
		
	</body>
</html>