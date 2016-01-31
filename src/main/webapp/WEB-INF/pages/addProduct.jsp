<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<section class="container">
    <form:form modelAttribute="newProduct" class="form-horizontal" enctype="multipart/form-data">
        <form:errors path="*" cssClass="alert alert-danger" element="div"/>
        <fieldset>
            <legend>新增商品</legend>
            <div class="form-group">
                <label for="productId" class="control-label col-lg-2">
                    <spring:message code="addProduct.form.productId.label"/>
                </label>
                <div class="col-lg-4">
                    <form:input path="productId" id="productId" type="text" class="form-control"/>
                    <form:errors path="productId" cssClass="text-danger"/>
                </div>
            </div>
            <div class="form-group">
                <label for="name" class="control-label col-lg-2">
                    <spring:message code="addProduct.form.name.label"/>
                </label>
                <div class="col-lg-4">
                    <form:input path="name" id="name" type="text" class="form-control"/>
                    <form:errors path="name" cssClass="text-danger"/>
                </div>
            </div>
            <div class="form-group">
                <label for="unitPrice" class="control-label col-lg-2">
                    <spring:message code="addProduct.form.unitPrice.label"/>
                </label>
                <div class="col-lg-4">
                    <form:input path="unitPrice" id="unitPrice" type="text" class="form-control"/>
                    <form:errors path="unitPrice" cssClass="text-danger"/>
                </div>
            </div>
            <div class="form-group">
                <label for="description" class="control-label col-lg-2">
                    <spring:message code="addProduct.form.description.label"/>
                </label>
                <div class="col-lg-4">
                    <form:textarea path="description" id="description" class="form-control" rows="2"/>
                </div>
            </div>
            <div class="form-group">
                <label for="manufacturer" class="control-label col-lg-2">
                    <spring:message code="addProduct.form.manufacturer.label"/>
                </label>
                <div class="col-lg-4">
                    <form:input path="manufacturer" id="manufacturer" type="text" class="form-control"/>
                </div>
            </div>
            <div class="form-group">
                <label for="category" class="control-label col-lg-2">
                    <spring:message code="addProduct.form.category.label"/>
                </label>
                <div class="col-lg-4">
                    <form:input path="category" id="category" type="text" class="form-control"/>
                </div>
            </div>
            <div class="form-group">
                <label for="unitsInStock" class="control-label col-lg-2">
                    <spring:message code="addProduct.form.unitsInStock.label"/>
                </label>
                <div class="col-lg-4">
                    <form:input path="unitsInStock" id="unitsInStock" type="text" class="form-control"/>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-lg-2" for="productImage">
                    <spring:message code="addProdcut.form.productImage.label"/></label>
                <div class="col-lg-10">
                    <form:input id="productImage" path="productImage" type="file" class="form:input-large" />
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