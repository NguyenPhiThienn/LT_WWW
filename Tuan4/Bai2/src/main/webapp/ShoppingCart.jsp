<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 27/09/2025
  Time: 5:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Shopping Cart</title>
</head>
<body>
<p>
    <a href="${pageContext.request.contextPath}/DSSP">Product List</a>
</p>
<table width="100%" border="1" cellspacing="0" cellpadding="5">
    <tr bgcolor="#CCCCCC">
        <th>Model Description</th>
        <th>Quantity</th>
        <th>Unit Price</th>
        <th>Total</th>
    </tr>

    <c:if test="${cart.lineItemCount == 0}">
        <tr>
            <td colspan="4">Cart is currently empty</td>
        </tr>
    </c:if>

    <c:forEach var="cartItem" items="${cart.cartItems}" varStatus="counter">
        <tr>
            <td>
                <b>${cartItem.partNumber}</b><br/>
                    ${cartItem.modelDescription}
            </td>
            <td>
                <form method="POST" action="${pageContext.request.contextPath}/CartController">
                    <input type="hidden" name="itemIndex" value="${counter.index + 1}" />
                    <input type="number" name="quantity" value="${cartItem.quantity}" min="1" step="1" />
                    <input type="submit" name="action" value="update"/>
                    <input type="submit" name="action" value="delete"/>
                </form>
            </td>
            <td>$${cartItem.unitCost}</td>
            <td>$${cartItem.totalCost}</td>
        </tr>
    </c:forEach>

    <tr>
        <td colspan="2"></td>
        <td><b>Subtotal:</b></td>
        <td><b>$${cart.orderTotal}</b></td>
    </tr>
</table>
</body>
</html>
