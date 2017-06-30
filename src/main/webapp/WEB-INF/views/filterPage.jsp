<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/css/maincontent.css" />" rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/css/bootstrap-theme.css" />" rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/css/bootstrap.css" />" rel="stylesheet" type="text/css" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Каталог товаров</title>
</head>
<body>
	<div class="wrapper">
		<div class="header">
			<nav class="navbar navbar-inverse bg-primary">
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
								<c:forEach items="${categories }" var="category">
									<li role="presentation">
										<a role="menuitem" tabindex="-1" href=" <spring:url value= "/all/${category.categoryLink }" /> ">
										${category.categoryName }
										</a>
									</li>
								</c:forEach>
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
				
				
				<div class="col-lg-3 col-md-3">
				<form>
				
					<div class="panel panel-primary">
						<div class="panel-heading">Цена</div>
						<div class="panel-body">
							<div class="form-group row">
								<label>
								<div class="col-xs-5">
    								<input class="form-control" id="ex1" type="text" value="${productMinPrice }" name="minprice">
  								</div>
  								<div class="col-xs-5">
    								<input class="form-control" id="ex2" type="text" value="${productMaxPrice }" name="maxprice">
  								</div> грн.
  								</label>
							</div>
						</div>
					</div>
					
					<div class="panel panel-primary">
						<div class="panel-heading">Для кого</div>
  						<div class="panel-body">
  							<c:forEach items="${genders}" var="gender">
  								<c:set var="selectedGenderIds" value="${productGender}" />
  								<c:set var="currentGenderId" value="${gender.genderId}" /> 												
  								
  							<div class="checkbox">
  								<label for="${gender.genderLink}">
  									<input type="checkbox" id="${gender.genderLink}" name="gender" style="float:inherit;" value="${gender.genderId}" 
  									<c:if test="${fn:contains(selectedGenderIds, currentGenderId)}">checked="checked"</c:if>
  									  />
  									${gender.genderName}
  								</label>
  								<span style="margin-right: 20px" class="badge pull-right">${gender.quantityGender }</span>
  							</div>
  							</c:forEach>	
  						</div>
					</div>
					
					
					<div class="panel panel-primary">
						<div class="panel-heading">Драгоценные камни</div>
  						<div class="panel-body">
  							<c:forEach items="${gemstones}" var="gemstone">
  								<c:set var="selectedGemstoneIds" value="${productGemstones}" />
  								<c:set var="currentGemstoneId" value="${gemstone.gemstoneId}" /> 												
  								
  							<div class="checkbox">
  								<label for="${gemstone.gemstoneLink}">
  									<input type="checkbox" id="${gemstone.gemstoneLink}" name="gemstones" style="float:inherit;" value="${gemstone.gemstoneId}" 
  									<c:if test="${fn:contains(selectedGemstoneIds, currentGemstoneId) }">checked="checked"</c:if>
  										
  									
  									  />
  									${gemstone.gemstoneName}
  								</label>
  								<span style="margin-right: 20px" class="badge pull-right">${gemstone.gemstoneQuantiry }</span>
  							</div>
  							
  							</c:forEach>	
  						</div>
					</div>
					
					<div class="panel panel-primary">
						<div class="panel-heading">Материал изделия</div>
  						<div class="panel-body">
  							<c:forEach items="${materials}" var="material">
  								<c:set var="selectedMaterialIds" value="${productMaterial}" />
  								<c:set var="currentMaterialId" value="${material.materialId}" />
  							<div class="checkbox">
  								<label for="${material.materialLink }">
  									<input type="checkbox" id="${material.materialLink }" name="materials" style="float:inherit;" value="${material.materialId}" 
  									<c:if test="${fn:contains(selectedMaterialIds, currentMaterialId)}">checked="checked"</c:if>   />${material.materialName}
  								</label>
  								<span style="margin-right: 20px" class="badge pull-right">${material.materialQuantity }</span>
  							</div>
  							</c:forEach>	
  						</div>
					</div>
					
					<div class="panel panel-primary">
						<div class="panel-heading">Тип изделия</div>
  						<div class="panel-body">
  							<c:forEach items="${types}" var="type">
  								<c:set var="selectedTypeIds" value="${productType}" />
  								<c:set var="currentTypeId" value="${type.typeId }" />
  							<div class="checkbox">
  								<label for="${type.typeLink }">
  									<input type="checkbox" id="${type.typeLink }" name="types" style="float:inherit;" value="${type.typeId}"
  									<c:if test="${fn:contains(selectedTypeIds, currentTypeId)}">checked="checked"</c:if>
  									/>${type.typeName}
  								</label>
  								<span style="margin-right: 20px" class="badge pull-right">${type.typeQuantity }</span>
  							</div>
  							</c:forEach>	
  						</div>
					</div>
					
					<c:set var="category" value="${productCategory}" />
					<c:if test="${category=='ring'}">
					
					<div class="panel panel-primary">
						<div class="panel-heading">Размер изделия ring</div>
  						<div class="panel-body">
  							<c:forEach items="${ringSizes}" var="ringSize">
  								<c:set var="selectedSizeIds" value="${productSizeRing}" />
  								<c:set var="currentSizeId" value="${ringSize.ringSizeId }" />
  							<div class="checkbox">
  								<label for="${ringSize.ringSize}">
  									<input type="checkbox" id="${ringSize.ringSize}" name="sizering" style="float:inherit;" value="${ringSize.ringSizeId}"
  									<c:if test="${fn:contains(selectedSizeIds, currentSizeId)}">checked="checked"</c:if>
  									/>${ringSize.ringSize}
  								</label>
  								<span style="margin-right: 20px" class="badge pull-right">${ringSize.quantityRingSize}</span>
  							</div>
  							</c:forEach>	
  						</div>
					</div>
					
					</c:if>
					
					<c:if test="${category=='chains'}">
					<div class="panel panel-primary">
						<div class="panel-heading">Размер изделия chains</div>
  						<div class="panel-body">
  							<c:forEach items="${chainsSizes}" var="chainsSize">
  								<c:set var="selectedChainsIds" value="${productSizeChains}" />
  								<c:set var="currentSizeId" value="${chainsSize.chainsSizeId }" />
  							<div class="checkbox">
  								<label for="${chainsSize.chainsSize}">
  									<input type="checkbox" id="${chainsSize.chainsSize}" name="sizechains" style="float:inherit;" value="${chainsSize.chainsSizeId}"
  									<c:if test="${fn:contains(selectedChainsIds, currentSizeId)}">checked="checked"</c:if>
  									/>${chainsSize.chainsSize}
  								</label>
  								<span style="margin-right: 20px" class="badge pull-right">${chainsSize.quantityChainsSize}</span>
  							</div>
  							</c:forEach>	
  						</div>
					</div>
					</c:if>
					
					<c:if test="${category=='pendants'}">
					<div class="panel panel-primary">
						<div class="panel-heading">Размер изделия pendants</div>
  						<div class="panel-body">
  							<c:forEach items="${pendantSizes}" var="pendantSize">
  								<c:set var="selectedPendantIds" value="${productSizePendant}" />
  								<c:set var="currentPendantId" value="${pendantSize.pendantSizeId }" />
  							<div class="checkbox">
  								<label for="${pendantSize.pendantSize}">
  									<input type="checkbox" id="${pendantSize.pendantSize}" name="sizependant" style="float:inherit;" value="${pendantSize.pendantSizeId}"
  									<c:if test="${fn:contains(selectedPendantIds, currentPendantId)}">checked="checked"</c:if>
  									/>${pendantSize.pendantSize}
  								</label>
  								<span style="margin-right: 20px" class="badge pull-right">${pendantSize.quantityPendantSize}</span>
  							</div>
  							</c:forEach>	
  						</div>
					</div>
					</c:if>
				
					<input style="width: 30%;" type="submit" class="btn btn-primary center-block" value="OK"/>
					
				</form>
				</div>
				
				
				
				<div class="col-lg-9 col-md-9">
					<c:forEach items="${products}" var="product">
					<div class="col-xs-6 col-sm-6 col-md-4 col-lg-4">
						<div class="thumbnail">
						<a href="#">
							<img alt="${product.productName}" src=" <c:url value="/resources/images/${product.productId}/${product.productImageName}"></c:url> "></a>
								<div class="caption">
									 <h3>${product.productName}</h3>
									 <h4>${product.productPrice } грн</h4>
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
		<br>
		<div class="footer">2017 &copy; Sale shoes</div>
	</div>
</body>
</html>