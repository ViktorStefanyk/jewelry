<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<c:url value="/resources/css/bootstrap-theme.css" />" rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/css/bootstrap.css" />" rel="stylesheet" type="text/css" />
<title>Add new Product</title>
</head>
<body>

<spring:url value="/save" var="saveUrl" />

<section class="container">
	<form:form modelAttribute="newProduct" method="POST" action="${saveUrl }" enctype="multipart/form-data" class="form-horizontal" accept-charset="UTF-8">
		<fieldset>
			<legend>Добавить новый товар в БД</legend>
				
				<div class="form-group">
					<label class="control-label col-lg-4" for="productName">Название товара:</label>
						<div class="col-lg-4">
							<form:input id="productName" path="productName" type="text" class="form-control mx-sm-3"/>
						</div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-lg-4" for="productDescription">Описание товара:</label>
						<div class="col-lg-4">
							<form:textarea id="productDescription" path="productDescription" type="text" class="form-control mx-sm-3" rows="3"/>
						</div>
				</div>
				
			
				<div class="form-group">
					<label class="control-label col-lg-4" for="productGemstone">Драгоценные камни:</label>
						<div class="col-lg-4">
							<form:select id="productGemstone" path="productGemstone" type="text" class="form-control mx-sm-3">
								<form:options items="${newGemstone}" itemValue="gemstoneId" itemLabel="gemstoneName"/>
							</form:select>
						</div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-lg-4" for="productPrice">Цена товара:</label>
						<div class="col-lg-4">
							<form:input id="productPrice" path="productPrice" type="text" class="form-control mx-sm-3" required="required"/>
						</div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-lg-4" for="gemstone">Категория:</label>
						<div class="col-lg-4">
							<form:select id="gemstone" path="productCategory" type="text" class="form-control mx-sm-3">
								<form:options items="${newCategory}" itemValue="categoryId" itemLabel="categoryName"/>
							</form:select>
						</div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-lg-4" for="productMaterial">Материал:</label>
						<div class="col-lg-4">
							<form:select id="productMaterial" path="productMaterial" type="text" class="form-control mx-sm-3">
								<form:options items="${newMaterial}" itemValue="materialId" itemLabel="materialName"/>
							</form:select>
						</div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-lg-4" for="productWeight">Вес изделия:</label>
						<div class="col-lg-4">
							<form:input id="productWeight" path="productWeight" type="text" class="form-control mx-sm-3" required="required"/>
						</div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-lg-4" for="productType">Тип:</label>
						<div class="col-lg-4">
							<form:select id="productType" path="productType" type="text" class="form-control mx-sm-3">
								<form:options items="${newType}" itemValue="typeId" itemLabel="typeName"/>
							</form:select>
						</div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-lg-4" for="productType">Пол:</label>
						<div class="col-lg-4">
							<form:select id="productGender" path="productGender" type="text" class="form-control mx-sm-3">
								<form:options items="${newGender}" itemValue="genderId" itemLabel="genderName"/>
							</form:select>
						</div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-lg-4" for="productRingSize">Размеры колец:</label>
						<div class="col-lg-4">
							<c:forEach items="${newProduct.productRingSizes }" var="size" varStatus="status">
								<form:hidden path="productRingSizes[${status.index}].ringSizeId"/>
								<form:checkbox path="productRingSizes[${status.index}].ringSizeFlag" label="${size.ringSize}"/>
							</c:forEach>
						</div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-lg-4" for="productChainsSize">Размеры цепоцек:</label>
						<div class="col-lg-4">
							<c:forEach items="${newProduct.productChainsSizes }" var="size" varStatus="status">
								<form:hidden path="productChainsSizes[${status.index}].chainsSizeId"/>
								<form:checkbox path="productChainsSizes[${status.index}].chainsSizeFlag" label="${size.chainsSize}" />
							</c:forEach>
						</div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-lg-4" for="productPendantSizes">Размеры подвесок:</label>
						<div class="col-lg-4">
							<c:forEach items="${newProduct.productPendantSizes }" var="size" varStatus="status">
								<form:hidden path="productPendantSizes[${status.index}].pendantSizeId"/>
								<form:checkbox path="productPendantSizes[${status.index}].pendantSizeFlag" label="${size.pendantSize}" />
							</c:forEach>
						</div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-lg-4" for="productMainImage">Загрузить главную фотографию:</label>
						<div class="col-lg-4">
							<form:input id="productMainImage" path="productMainImage" type="file" class="form-control mx-sm-3"  />
						</div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-lg-4" for="productAdditionalImages">Загрузить дополнительные фотографии фотографии:</label>
						<div class="col-lg-4">
							<form:input id="productAdditionalImages" path="productAdditionalImages" type="file" class="form-control mx-sm-3" multiple="multiple" />
						</div>
				</div>
				
				<div class="form-group">
					<div class="col-lg-offset-2 col-lg-10">
						<input type="submit" id="btnAdd" class="btn btn-primary" value ="Add"/>
					</div>
				</div>
				
		</fieldset>
	</form:form>
	<div>
		<a href=" <spring:url value= "/" /> " ><button class="btn btn-primary" >Назад</button></a>
	</div>
</section>
</body>
</html>