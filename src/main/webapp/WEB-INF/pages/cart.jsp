<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>购物车</title>
    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="//cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="//cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <script src="//cdn.bootcss.com/angular.js/1.4.9/angular.min.js"></script>
    <script src="/static/js/controllers.js"></script>
</head>
<body>

<section>
    <div class="jumbotron">
        <div class="container">
            <h1>Cart</h1>
            <p>All the selected products in your cart</p>
        </div>
    </div>
</section>
<section class="container" ng-app="cartApp">
    <div ng-controller="cartCtrl" ng-init="initCartId('${cartId}')">
        <div>
            <a class="btn btn-danger pull-left" ng-click="clearCart()">
                <span class="glyphicon glyphicon-remove-sign"></span> Clear Cart
            </a>
            <a href="#" class="btn btn-success pull-right"> <span class="glyphicon-shopping-cart glyphicon"></span> Check out</a>
            <a href= "<spring:url value="/checkout?cartId=${cartId}"/>" class="btn btn-success pull-right"> <span class="glyphicon-shopping-cart glyphicon"></span> Check out
            </a>

        </div>
        <table class="table table-hover">
            <tr>
                <th>Product</th>
                <th>Unit price</th>
                <th>Qauntity</th>
                <th>Price</th>
                <th>Action</th>
            </tr>
            <tr ng-repeat="item in cart.cartItems">
                <td>{{item.product.productId}}-{{item.product.name}}</td>
                <td>{{item.product.unitPrice}}</td>
                <td>{{item.quantity}}</td>
                <td>{{item.totalPrice}}</td>
                <td><a href="#" class="label label-danger" ng-click="removeFromCart(item.product.productId)"> <span class="glyphicon glyphicon-remove" /></span> Remove
                </a></td>
            </tr> <tr>
            <th></th>
            <th></th>
            <th>Grand Total</th>
            <th>{{cart.grandTotal}}</th>
            <th></th>
        </tr>
        </table>
        <a href="<spring:url value="/products" />" class="btn btn-default">
            <span class="glyphicon-hand-left glyphicon"></span>
            Continue shopping
        </a> </div>
</section>
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</body>
</html>