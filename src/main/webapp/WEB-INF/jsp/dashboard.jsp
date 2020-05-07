<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<head>
    <meta charset="UTF-8">
    <title>HPlus</title>
    <link rel="stylesheet" href="/css/style.css" type="text/css"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>

<body>

<header>
    <%@ include file="shared/navigation_bar.jsp"%>
</header>

<b>Dashboard</b>

<section id="result" class="result">
    <div class="container">
        <form action="/displayDashboard" method="get">
            <input type="submit" value="result">
        </form>
    </div>
</section>
<c:if test="${!empty(onHandList)}">
    <section>
        <table>
            <tr>
                <th><input type="checkbox" /></th>
                <th>Client</th>
                <th>SKU</th>
                <th>Lot</th>
                <th>Location</th>
                <th>Qty</th>
                <th>Last Count Date</th>
                <th>Cycle Count Days</th>
                <th>Days Since Last Count</th>
            </tr>
            <c:forEach var="onHand" items="${onHandList}">
                <tr>
                    <td><input type="checkbox" /></td>
                    <td>${onHand.client}</td>
                    <td>${onHand.skuLotLocPK.sku}</td>
                    <td>${onHand.skuLotLocPK.lot}</td>
                    <td>${onHand.skuLotLocPK.loc}</td>
                    <td>${onHand.qty}</td>
                    <td><fmt:formatDate pattern="MM-dd-yyyy" value="${onHand.clientSkuCcInfo.lastCycleCount}" /></td>
                    <td>${onHand.clientSkuCcInfo.abc.days}</td>
                    <td>${onHand.clientSkuCcInfo.daysSinceLastCount}</td>
                </tr>
            </c:forEach>
        </table>
    </section>
</c:if>
</body>
</html>