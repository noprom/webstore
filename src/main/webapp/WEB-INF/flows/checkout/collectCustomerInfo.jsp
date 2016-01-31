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
      <h1>Customer</h1>
      <p>Customer details</p>
    </div>
  </div>
</section>
<section class="container">
  <form:form modelAttribute="order.customer" class="form-horizontal">
  <fieldset>
    <legend>Customer Details</legend>
    <div class="form-group">
      <label class="control-label col-lg-2 col-lg-2" for="customerId" />Customer Id</label>
      <div class="col-lg-10">
        <form:input id="customerId" path="customerId" type="text" class="form-control" />
      </div>
    </div>
    <!--  Similarly, add input tags for the remaining fields of the
    customer domain object. I have skipped those tags here -->
    <div class="form-group">
      <label class="control-label col-lg-2 col-lg-2" for="customerId" />Customer Id</label>
      <div class="col-lg-10">
        <form:input id="customerId" path="customerId" type="text" class="form-control" />
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-lg-2 col-lg-2" for="name" />Name</label>
      <div class="col-lg-10">
        <form:input id="name" path="name" type="text" class="form-control" />
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-lg-2 col-lg-2" for="customerId" />ShippingAddress</label>
      <div class="col-lg-10">
        <form:input id="shippingAddress" path="shippingAddress" type="text" class="form-control" />
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-lg-2 col-lg-2" for="customerId" />PhoneNumber</label>
      <div class="col-lg-10">
        <form:input id="phoneNumber" path="phoneNumber" type="text" class="form-control" />
      </div>
    </div>
    <input type="hidden" name="_flowExecutionKey" value="${flowExecutionKey}"/>
    <div class="form-group">
      <div class="col-lg-offset-2 col-lg-10">
        <input type="submit" id="btnAdd" class="btn btn-primary" value="Add" name="_eventId_customerInfoCollected" />
        <button id="btnCancel" class="btn btn-default" name="_eventId_cancel">Cancel</button>
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