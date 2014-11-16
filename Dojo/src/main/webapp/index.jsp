<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>Index</title>
		<link type="text/css" href="<%=request.getContextPath()%>/resources/css/bootstrap.css" rel="stylesheet" />
	</head>
	<body>
		<div class="col-md-3"></div>
		<div class="col-md-5">
              <div class="panel panel-default">
                  <div class="panel-heading"><h4>Processar Arquivo</h4></div>
                  <div class="panel-body">
                    <form class="form-horizontal"  method="POST" action="processarArquivo" role="form" 
                    	enctype="multipart/form-data">
					  <div class="form-group">
					    <label for="file" class="col-sm-2 control-label">Arquivo</label>
					    <div class="col-sm-10">
					      <input type="file" id="file" name="file" required="">
					    </div>
					  </div>
					  <div class="form-group">
					    <div class="col-sm-offset-2 col-sm-10">
					      <button type="submit" class="btn btn-primary">Processar</button>
					    </div>
					  </div>
					</form>
                  </div><!--/panel-body-->
              </div><!--/panel-->                     
          	</div>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
		<script src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
	</body>
</html>