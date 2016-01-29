<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>商品详情</title>
    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="//cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="//cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<section>
    <div class="jumbotron">
        <div class="container">
            <h1>商品详情</h1>
        </div>
    </div>
</section>
<section class="container">
    <div class="row">
        <div class="col-md-5">
            <img src="<c:url value="/static/images/${product.productId}.png"></c:url>" alt="image"  style = "width:100%"/>
        </div>
        <div class="col-md-5">
            <h3>${product.name}</h3>
            <p>${product.description}</p>
            <p><strong>Item code : </strong>
                <span class="label label-warning">${product.productId}</span>
            </p>
            <p><strong>manufacture</strong>: ${product.manufacturer}</p>
            <p><strong>category</strong>: ${product.category}</p>
            <p><strong>Available units in stock</strong>: ${product.unitsInStock}</p>
            <h4>${product.unitPrice} USD</h4>
            <p><a href="<spring:url value="/products" />" class="btn btn-default">
                <span class="glyphicon-hand-left glyphicon"></span> back
            </a></p>
            <p>
                <a href="#" class="btn btn-warning btn-large"> <span
                        class="glyphicon-shopping-cart glyphicon"></span> Order Now
                </a>
            </p>
        </div>
    </div>
</section>
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</body>
</html>