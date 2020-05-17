<!DOCTYPE html>
<%@ include file="shared/tagLibaray.jsp"%>

<head>
    <title>LSqrd Solution - Cycle Count Release</title>
    <%@ include file="shared/head.jsp"%>
</head>

<body>

<header>
    <%@ include file="shared/navigation_bar.jsp"%>
</header>

<b>Cycle Count Release</b>

<section id="ccSelectionTable" class="display">
    <table>
        <form:form method="GET" action="/availableCCResults" >
            <input type="submit" value="Search" id="search" />
        </form:form>
        <br>
        <form:form method="POST" action="/releaseCounts" id="cycleCountResults">
            <input type="submit" name="ReleaseSelectedCounts" value="Release Selected Counts" />
        <thead>
            <tr>
                <th><!--<button id="selectAllCheckbox" onclick="test()"/>Select All--></th>
                <th>Client</th>
                <th>SKU</th>
                <th>Lot</th>
                <th>Location</th>
                <th>Qty</th>
                <th>Last Count Date</th>
                <th>Cycle Count Days</th>
                <th>Days Since Last Count</th>
            </tr>
            <tr>
                <th></th>
                <th><input path="client" type="text"/></th>
                <th><input path="skuLotLocPK.sku" type="text" /></th>
                <th><input path="skuLotLocPK.lot" type="text" /></th>
                <th><input path="skuLotLocPK.loc" type="text" /></th>
                <th><input path="qty" type="text" /></th>
                <th><input path="clientSkuCcInfo.lastCycleCount" type="text" /></th>
                <th><input path="clientSkuCcInfo.abc.days" type="text" /></th>
                <th><input path="clientSkuCcInfo.daysSinceLastCount" type="text" /></th>
            </tr>
        </thead>
        <c:if test="${!empty(onHandList)}">
            <section>
                <c:forEach items="${onHandList}" var="onHand" >
                    <tr>
                        <td><input type="checkbox" name="ids[]" id="selectCheckBox" value="${onHand.skuLotLocPK.sku}"/></td>
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
            </section>
        </c:if>
        </form:form>
    </table>
</section>

</body>
    <script type="text/javascript" src="/js/app.js" />
</html>