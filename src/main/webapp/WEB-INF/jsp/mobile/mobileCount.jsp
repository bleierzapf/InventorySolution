<!DOCTYPE html>
<%@ include file="../shared/tagLibaray.jsp"%>

<head>
    <title>Mobile Client - Interface</title>
    <%@ include file="../mobile/mobileHead.jsp"%>
</head>

<body>
<div class="mobile-container">
<%@ include file="mobileNavigation.jsp"%>

    <c:if test="${empty(taskToCount)}">
        <h4>No Available Counts</h4>
    </c:if>
    <c:if test="${!empty(taskToCount)}">
        <section>
            <c:forEach items="${taskToCount}" var="countTask">
                <tr><td>${countTask.skuLotLocPK.loc}</td></tr>
            </c:forEach>
        </section>
    </c:if>
</div>
</body>
</html>

