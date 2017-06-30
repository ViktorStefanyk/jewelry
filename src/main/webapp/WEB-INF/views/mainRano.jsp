<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/css/header.css" />" rel="stylesheet" type="text/css" />
<title>Магазин ювелирных изделий</title>
</head>
<body>
	<div class="main-wrapper">
		<div class="header">
		</div>
		<div class="container">
			<c:forEach items="${products }" var="product">
			<div class="col">
			
				<div class="thumbnail">
					<img alt="${product.productName}" src=" <c:url value="/resources/images/${product.productId}/${product.productImageName}"></c:url> ">
				</div>
			</div>
			</c:forEach>
		</div>
		<div class="footer">
			2017 &copy; Jewelry
		</div>
	</div>

</body>
</html>