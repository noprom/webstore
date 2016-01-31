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
      <h1>Shipping</h1>
      <p>Shipping details</p>
    </div>
  </div>
</section>
<section class="container">
  <form:form modelAttribute="order.shippingDetail" class="form-horizontal">
    <fieldset>
      <legend>Shipping Details</legend>
      <div class="form-group">
        <label class="control-label col-lg-2 col-lg-2" for="name"/>Name</label>
        <div class="col-lg-10">
          <form:input id="name" path="name" type="text" class="form-control" />
        </div>
      </div>
      <div class="form-group">
        <label class="control-label col-lg-2 col-lg-2" for="shippingDate" />shipping Date (dd/mm/yyyy)</label>
        <div class="col-lg-10">
          <form:input id="shippingDate" path="shippingDate" type="text" class="form-control" />
        </div>
      </div>
      <div class="form-group">
        <label class="control-label col-lg-2" for="doorNo">Door No</label>
        <div class="col-lg-10">
          <form:input id="doorNo" path="shippingAddress.doorNo" type="text" class="form-control" />
        </div>
      </div>
      <div class="form-group">
        <label class="control-label col-lg-2" for="streetName">StreetName</label>
        <div class="col-lg-10">
          <form:input id="streetName" path="shippingAddress.streetName" type="text" class="form-control" />
        </div>
      </div>
      <div class="form-group">
        <label class="control-label col-lg-2" for="areaName">AreaName</label>
        <div class="col-lg-10">
          <form:input id="areaName" path="shippingAddress.areaName" type="text" class="form-control" />
        </div>
      </div>
      <div class="form-group">
        <label class="control-label col-lg-2" for="state">State</label>
        <div class="col-lg-10">
          <form:input id="state" path="shippingAddress.state" type="text" class="form-control" />
        </div>
      </div>
      <div class="form-group">
        <label class="control-label col-lg-2" for="country">Country</label>
        <div class="col-lg-10">
          <form:input id="country" path="shippingAddress.country" type="text" class="form-control" />
        </div>
      </div>
      <div class="form-group">
        <label class="control-label col-lg-2" for="zipCode">ZipCode</label>
        <div class="col-lg-10">
          <form:input id="zipCode" path="shippingAddress.zipCode" type="text" class="form-control" />
        </div>
      </div>
      <input type="hidden" name="_flowExecutionKey" value="${flowExecutionKey}"/>
      <div class="form-group">
        <div class="col-lg-offset-2 col-lg-10">
          <button id="back" class="btn btn-default" name="_eventId_backToCollectCustomerInfo">back</button>
          <input type="submit" id="btnAdd" class="btn btn-primary" value="Add" name="_eventId_shippingDetailCollected"/>
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