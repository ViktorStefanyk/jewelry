<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet" type="text/css" />
<%-- <link href="<c:url value="/resources/css/header.css" />" rel="stylesheet" type="text/css" /> --%>
<link href="<c:url value="/resources/css/maincontent.css" />" rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/css/bootstrap-theme.css" />" rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/css/bootstrap.css" />" rel="stylesheet" type="text/css" />
<script src="<c:url value="/resources/js/bootstrap.js" />"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Магазин ювелирных изделий</title>
</head>
<body>
	<div class="wrapper">
		<div class="header">
			<nav class="navbar navbar-inverse">
				<div class="container-fluid">
					<div class="navbar-header">
     					<a class="navbar-brand" href=" <spring:url value= "/all" /> ">
     						<span class="icon-bar"></span>
            				<span class="icon-bar"></span>
           					<span class="icon-bar"></span>
     						<span class="icon-bar"><img src=" <c:url value="/resources/images/brand/brand.jpg"></c:url> " width="23.39666" height="16.6666" class="d-inline-block align-top" alt="Жемчужинка""></span>
     					Жемчужинка</a>
    				</div>
    				<ul class="nav navbar-nav">
      					<li><a ></a></li>
      					<li><a href="#">Доставка и оплата</a></li>
      					<li><a href="#">Контакты</a></li>
      					<li><a href=" <spring:url value= "/add" /> ">Добавить новый товар</a></li>
    				</ul>
					<ul class="nav navbar-nav navbar-right">
     					<li>
     						<a href="#"><span class="glyphicon glyphicon-user"></span> Sign Up</a>
     					</li>
      					<li>
      						<a href="#"><span class="glyphicon glyphicon-log-in"></span> Login</a>
      					</li>
    				</ul>
				</div>
			</nav>
			<div class="container">
				<div class="jumbotron">
					<p>Тут будет реклама магазина</p>
				</div>
			</div>
			<div class="container">
				<div class="row">
					<div class="col-lg-12">
						<div class="col-lg-3 col-md-3 col-sm-3 pull-left">
							<div class="dropdown">
								<button style="width: 90%;" class="btn btn-default dropdown-toggle" type="button"
									id="menu1" data-toggle="dropdown">
									<span style="font-size: 20px;" class="glyphicon glyphicon-align-justify"></span>
									<span style="font-size: 20px;">Каталог товаров</span>
									<span class="caret"></span>
								</button>
								<ul style="width: 90%;" class="dropdown-menu" role="menu" aria-labelledby="menu1">
									<li role="presentation"><a role="menuitem" tabindex="-1"
										href=" <spring:url value= "/all/ring" /> ">Кольца</a></li>
									<li role="presentation"><a role="menuitem" tabindex="-1"
										href=" <spring:url value= "/all/earrings" /> ">Серьги</a></li>
									<li role="presentation"><a role="menuitem" tabindex="-1"
										href=" <spring:url value= "/all/pendants" /> ">Подвески</a></li>
									<li role="presentation"><a role="menuitem" tabindex="-1"
										href=" <spring:url value= "/all/chains" /> ">Цепочки</a></li>
								</ul>
							</div>
						</div>
						<div class="col-lg-6 col-md-6 col-sm-6 pull-left">
							<form>
								<div class="input-group">
									<input type="text" class="form-control"
										placeholder="Поиск товаров" name="search">
									<div class="input-group-btn">
										<button style="font-size: 20px;" class="btn btn-default"
											type="submit">
											<i class="glyphicon glyphicon-search"></i>
										</button>
									</div>
								</div>
							</form>
						</div>

						<!-- 					Basket -->
						<div class="col-lg-2 col-md-2 col-sm-2 vcenter pull-right">
							<span style="font-size: 20px;"
								class="glyphicon glyphicon-shopping-cart"></span> <a
								style="font-size: 20px;" href="#">КОРЗИНА</a>
						</div>
					</div>
				</div>
			</div>
		</div>
		<br>	
		<div class="content">
			<div class="container">
				<div class="row">
				<c:forEach items="${products}" var="product">
					<div class="col-xs-8 col-sm-6 col-md-4 col-lg-3">
						<div class="thumbnail">
						<a href="#">
							<img alt="${product.productName}" src=" <c:url value="/resources/images/${product.productId}/${product.productImageName}"></c:url> "></a>
								<div class="caption">
									 <h3>${product.productName}</h3>
									 <p>
									 	<a href="#" class="btn btn-default" role="button">Подробнее</a>
										<a href="#" class="btn btn-primary pull-right" role="button">Купить</a>
									 </p>
								</div>
						</div>
					</div>
				</c:forEach>
				</div>
			</div>
		</div>
		<div class="footer">2017 &copy; Jewelry</div>
	</div>
</body>
</html>