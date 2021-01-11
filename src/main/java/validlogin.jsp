<%--
  Created by IntelliJ IDEA.
  User: yseti
  Date: 09/01/2021
  Time: 21:39
  To change this template use File | Settings | File Templates.
--%>

// Here is the page where the user will be able to shop if the login is successful
// Should be replaced by proper html code

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
    <title>JSP + drop down</title>
</head>

<body>
<div align="center">
    <h2>JSP + drop down</h2>
    // 'form' is used to collect user input
    <form action="list" method=""post"> // 'action' specifies where to send the form-data when a form is submitted
    // input elements here?
    Select a product:&nbsp;
    <select name="product">
        // 'c:forEach' is used to iterate through a collection of objects and display values
        // items=collection of items to iterate in the loop (name of attribute?) - must match the name of the corresponding attribute set in the servlet class
        // var=name of the scoped variable holding current item in the iteration
        <c:forEach items="${listCategory}" var="category">
            <option value="${product.id}">${product.description}</option>
        </c:forEach>
    </select>
    <br/><br/>
    <input type="submit" value=""Submit" /> // this will be replaced by the whole checkout process
    </form>
</div>
</body>
</html>

