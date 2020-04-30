<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
<c:if test="${!empty(ccList)}">
    <section>
        <table>
            <c:forEach var="ccStatus" items="${ccList}">
                <tr>
                    <td>${ccStatus.storerSkuPK.storerKey}</td>
                    <td>${ccStatus.storerSkuPK.sku}</td>

                    <td>${ccStatus.lastCycleCount}</td>
                    <td>${ccStatus.lastCcReleaseDate}</td>
                </tr>
            </c:forEach>
        </table>
    </section>
</c:if>
<!--
<c:if test="${!empty(skuList)}">
    <section>
        <table>
        <c:forEach var="sku" items="${skuList}">
            <tr>
                <td>${sku.storerKey}</td>
                <td>${sku.sku}</td>
                <td>${sku.abc}</td>
                <td>${sku.putAwayLoc}</td>
            </tr>
        </c:forEach>
        </table>
    </section>
</c:if>
-->
</body>
</html>