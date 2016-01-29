<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>网上商城</title>
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
            <h1>商品</h1>
            <p>新增商品</p>
        </div>
    </div>
</section>
<section class="container">
    <form:form modelAttribute="newProduct" class="form-horizontal" enctype="multipart/form-data">
        <fieldset>
            <legend>新增商品</legend>
            <div class="form-group">
                <label for="productId" class="control-label col-lg-2">
                    <spring:message code="addProduct.form.productId.label"/>
                </label>
                <div class="col-lg-4">
                    <form:input path="productId" id="productId" type="text" class="form-control"/>
                </div>
            </div>
            <div class="form-group">
                <label for="name" class="control-label col-lg-2">商品名</label>
                <div class="col-lg-4">
                    <form:input path="name" id="name" type="text" class="form-control"/>
                </div>
            </div>
            <div class="form-group">
                <label for="unitPrice" class="control-label col-lg-2">价格</label>
                <div class="col-lg-4">
                    <form:input path="unitPrice" id="unitPrice" type="text" class="form-control"/>
                </div>
            </div>
            <div class="form-group">
                <label for="description" class="control-label col-lg-2">描述</label>
                <div class="col-lg-4">
                    <form:textarea path="description" id="description" class="form-control" rows="2"/>
                </div>
            </div>
            <div class="form-group">
                <label for="manufacturer" class="control-label col-lg-2">制造商</label>
                <div class="col-lg-4">
                    <form:input path="manufacturer" id="manufacturer" type="text" class="form-control"/>
                </div>
            </div>
            <div class="form-group">
                <label for="category" class="control-label col-lg-2">分类</label>
                <div class="col-lg-4">
                    <form:input path="category" id="category" type="text" class="form-control"/>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-lg-2" for="productImage">
                    <spring:message code="addProdcut.form.productImage.label"/></label>
                <div class="col-lg-10">
                    <form:input id="productImage" path="productImage" type="file"
                                class="form:input-large" />
                </div>
            </div>
            <div class="form-group">
                <div class="col-lg-10 col-lg-offset-2">
                    <input type="submit" id="btnAdd" class="btn btn-primary"/>
                </div>
            </div>
        </fieldset>
    </form:form>
</section>
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</body>
</html>