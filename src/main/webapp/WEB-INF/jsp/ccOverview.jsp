<!DOCTYPE html>
<%@ include file="shared/tagLibaray.jsp"%>

<head>
    <title>LSqrd Solution - Cycle Count Overview</title>
    <%@ include file="shared/head.jsp"%>
</head>

<body>

<header>
    <%@ include file="shared/navigation_bar.jsp"%>
</header>

<b>Cycle Count Overview</b>
<form method="GET" action="/overview/historicCCList" >
    <input type="submit" value="Search" id="search" />
</form>
<spring:url value="/overview/historicCCList" var="taskUrl" />
<display:table name="overview" requestURI="${taskUrl}" pagesize="50" >
    <display:setProperty name="basic.empty.showtable" value="true" />
    <thead id="sModel">
    <tr>
        <th><input type="text" name="modelType" class="search_init"></th>
        <th><input type="text" name="modelClient" class="search_init"></th>
    </tr>
    </thead>
    <display:column property="owner" title="Client" />
    <display:column property="sku" title="SKU" />
    <display:column property="loc" title="Location" />
    <display:column property="countDate" title="Count Date" format="{0, date, MM-dd-yyyy hh:mm}" />
    <display:column property="user" title="User" />
    <display:column property="status" title="Status" />
    <display:column property="adjReason" title="Adj Reason" />
    <display:column property="taskNumber" title="Task" />
    <display:column property="reportId" title="Report ID" />
    <display:column property="orderNumber" title="Order Number" />
    <display:column property="lot" title="Lot" />
    <display:column property="qty" title="Qty" />
</display:table>

</body>
</html>