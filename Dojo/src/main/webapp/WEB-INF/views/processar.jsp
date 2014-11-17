<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Resultado</title>
    <!-- Bootstrap -->
	<link type="text/css" href="${pageContext.request.contextPath}/resources/css/bootstrap.css" rel="stylesheet"/>
  </head>
  <body>
 	<div class="col-md-3"></div>
    <div class="col-md-5">
	    <h2>Resultado:</h2>
	    <c:if test="${listaPartida.size() == 0}">
	    	Não foi encontrado nenhuma partida neste arquivo
	    </c:if>
	    <c:if test="${listaPartida.size() > 0}">
		    <c:forEach items="${listaPartida}" var="partida">
		    	Partida: ${partida.nome}&nbsp;&nbsp;Início:<fmt:formatDate pattern="dd/MM/yyyy HH:mm:ss" value="${partida.dataInicio}" />
		    	&nbsp;Fim:<fmt:formatDate pattern="dd/MM/yyyy HH:mm:ss" value="${partida.dataFim}" />
		    	<div class="table-responsive">
					<table class="table table-bordered">
						<thead>
							<tr>
								<th>Nome jogador</th>
								<th>Assassinatos</th>
								<th>Mortes</th>
								<th>Arma que mais matou</th>
								<th>Award</th>
							</tr>
						</thead>	
						<c:forEach items="${partida.getListaOrdernada()}" var="detalhe">
							<tbody>
								<tr>
									<td><span class="glyphicon glyphicon-user" aria-hidden="true"></span>&nbsp;
										${detalhe.jogadorVO.nome}</td>
									<td>${detalhe.qtdeAssassinato}</td>
									<td>${detalhe.qtdeMorte}</td>
									<td>${detalhe.getArmaQueMaisMatouPeloJogador()}</td>
									<td>
										<c:if test="${detalhe.qtdeMorte == 0}">
											<img src="${pageContext.request.contextPath}/resources/img/invensivel.JPG"
												style="width: 30px;margin-left: 10px;"/>
										</c:if>
									</td>
								</tr>
							</tbody>
		    			</c:forEach>				
			  		</table>
				</div>
		    </c:forEach>
		    <h3>Legenda:</h3>
		    <img src="${pageContext.request.contextPath}/resources/img/invensivel.JPG" style="width: 30px;"/>:(Terminou a partida sem morrer)
		</c:if>    
	    <br/><br/>
	   	<a href="index.jsp" class="btn btn-primary">Voltar</a>
	</div>    
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
  </body>
</html>