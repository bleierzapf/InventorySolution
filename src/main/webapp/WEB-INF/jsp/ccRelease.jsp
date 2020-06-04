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

<!--
<form:form method="GET" action="/availableCCResults" >
    <input type="submit" value="Search" id="search" />
</form:form>

<form:form method="POST" action="/releaseCounts" id="cycleCountResults">
    <input type="submit" name="ReleaseSelectedCounts" value="Release Selected Counts" />

    <spring:url value="/availableCCResults" var="taskUrl" />
    <display:table name="${ccResults}" id="row" requestURI="${taskUrl}" pagesize="50" class="displayTable">
        <display:setProperty name="basic.empty.showtable" value="true" />
        <thead id="sModel">
        <tr>
            <th><input type="text" name="modelType" class="search_init"></th>
            <th><input type="text" name="modelClient" class="search_init"></th>
        </tr>
        </thead>
        <display:column title="Select"><input type="checkbox" name="ids[]" value="${skuLotLocPK.sku}" class="tableCheckBox" /></display:column>
        <display:column property="client" title="Client" />
        <display:column property="skuLotLocPK.sku" title="SKU" />
        <display:column property="skuLotLocPK.lot" title="Lot" />
        <display:column property="skuLotLocPK.loc" title="Location" />
        <display:column property="qty" title="Qty" />
        <display:column property="clientSkuCcInfo.lastCycleCount" title="Last Count" format="{0, date, MM-dd-yyyy hh:mm}" />
        <display:column property="clientSkuCcInfo.abc.abc" title="Cycle Class" />
        <display:column property="clientSkuCcInfo.daysCountOverdue" title="Next Count Due" />
    </display:table>
</form:form>
-->


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
                <th></th>
                <th>Client</th>
                <th>SKU</th>
                <th>Lot</th>
                <th>Location</th>
                <th>Qty</th>
                <th>Last Count Date</th>
                <th>Cycle Count Class</th>
                <th>Next Count Due</th>
            </tr>
            <tr>
                <th><!--<button id="selectAllCheckbox" onclick="javascript:test()"/>Select All--></th>
                <th><input path="client" type="text"/></th>
                <th><input path="skuLotLocPK.sku" type="text" /></th>
                <th><input path="skuLotLocPK.lot" type="text" /></th>
                <th><input path="skuLotLocPK.loc" type="text" /></th>
                <th><input path="qty" type="text" /></th>
                <th><input path="clientSkuCcInfo.lastCycleCount" type="text" /></th>
                <th><input path="clientSkuCcInfo.abc.abc" type="text" /></th>
                <th><input path="clientSkuCcInfo.daysCountOverdue" type="text" /></th>
            </tr>
        </thead>
        <c:if test="${!empty(ccResults)}">
            <section>
                <c:forEach items="${ccResults}" var="result" >
                    <c:if test="${result.clientSkuCcInfo.daysCountOverdue <= 30}">
                    <tr>
                        <td><input type="checkbox" name="ids[]" id="selectCheckBox" value="${result.skuLotLocPK.sku}"/></td>
                        <td>${result.client}</td>
                        <td>${result.skuLotLocPK.sku}</td>
                        <td>${result.skuLotLocPK.lot}</td>
                        <td>${result.skuLotLocPK.loc}</td>
                        <td>${result.qty}</td>
                        <td><fmt:formatDate pattern="MM-dd-yyyy" value="${result.clientSkuCcInfo.lastCycleCount}" /></td>
                        <td>${result.clientSkuCcInfo.abc.abc}</td>
                        <td>${result.clientSkuCcInfo.daysCountOverdue}</td>
                    </tr>
                    </c:if>
                </c:forEach>
            </section>
        </c:if>
        </form:form>
    </table>
</section>


</body>
    <script type="text/javascript" src="/js/app.js" />
</html>