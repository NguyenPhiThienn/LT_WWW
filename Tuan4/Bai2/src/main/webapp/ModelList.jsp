<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Product List</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <style>
        .product-box{
            width: 160px; height: 240px; border: 1px solid #ccc;
            padding: 10px; margin: 10px; float: left; text-align: center;
            box-shadow: 1px 1px 5px #aaa; border-radius: 5px;
        }
        .product-img{
            width: 100px; height: 120px; margin-bottom: 5px;
        }
        .product-name{
            font-weight: bold; margin-bottom: 5px;
        }
        .product-price{
            color: #d00; margin-bottom: 5px;
        }
        .clear{ clear: both; }
    </style>
</head>
<body>
<p>
    <a href="${pageContext.request.contextPath}/ShoppingCart.jsp">View Cart</a>
</p>

<c:forEach items="${ds}" var="sp">
    <div class="product-box">
        <form method="POST" action="${pageContext.request.contextPath}/CartController">
            <div class="product-name">${sp.model}</div>
            <img src="${pageContext.request.contextPath}${sp.imgURL}" class="product-img" alt="${sp.model}"/><br/>
            <div class="product-price">Price: $${sp.price}</div>

            Quantity: <input type="number" name="quantity" value="1" min="1" step="1"/><br/><br/>

            <!-- Chỉ cần gửi id -->
            <input type="hidden" name="id" value="${sp.id}"/>
            <input type="hidden" name="action" value="add"/>

            <input type="submit" value="Add to Cart"/>
        </form>
    </div>
</c:forEach>

<div class="clear"></div>
</body>
</html>