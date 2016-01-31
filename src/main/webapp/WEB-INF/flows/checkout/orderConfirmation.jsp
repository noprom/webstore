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
      <h1>Order</h1>
      <p>Order Confirmation</p>
    </div>
  </div>
</section>
<div class="container">
  <div class="row">
    <form:form modelAttribute="order" class="form-horizontal">
    <input type="hidden" name="_flowExecutionKey" value="${flowExecutionKey}" />
    <div class="well col-xs-10 col-sm-10 col-md-6 col-xs-offset-1 col-sm-offset-1 col-md-offset-3">
      <div class="text-center">
        <h1>Receipt</h1>
      </div>
      <div class="row">
        <div class="col-xs-6 col-sm-6 col-md-6">
          <address>
            <strong>Shipping Address</strong> <br>
              ${order.shippingDetail.name}<br>
              ${order.shippingDetail.shippingDate}<br>
              ${order.shippingDetail.shippingAddress.doorNo}<br>
              ${order.shippingDetail.shippingAddress.streetName}<br>
              ${order.shippingDetail.shippingAddress.areaName}<br>
              ${order.shippingDetail.shippingAddress.state}<br>
              ${order.shippingDetail.shippingAddress.country}<br>
              ${order.shippingDetail.shippingAddress.zipCode}<br>
              <button id="back" class="btn btn-default" name="_eventId_backToCollectShippingDetail">back</button>
              <button type="submit" class="btn btn-success" name="_eventId_orderConfirmed">Confirm   <span class="glyphicon glyphicon-chevron-right"></span></button>
                 <button id="btnCancel" class="btn btn-default" name="_eventId_cancel">Cancel</button>
          </address>
         </div>
         </div>
      </div>
    </form:form>
  </div>
</div>
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</body>
</html>