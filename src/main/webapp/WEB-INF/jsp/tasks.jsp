<!DOCTYPE html>
<%@ include file="shared/tagLibaray.jsp"%>

<head>
    <title>LSqrd Solution - Tasks</title>
    <%@ include file="shared/head.jsp"%>
</head>

<body>

<header>
    <%@ include file="shared/navigation_bar.jsp"%>
</header>

<b>Tasks Page</b>
<br>

<form method="GET" action="/tasks/viewAllTasks" >
    <input type="submit" value="Search" id="search" />
</form>
<spring:url value="/tasks/viewAllTasks" var="taskUrl" />
<display:table name="allTasks" requestURI="${taskUrl}" pagesize="50" >
    <display:setProperty name="basic.empty.showtable" value="true" />
        <thead id="sModel">
            <tr>
                <th><input type="text" name="modelType" class="search_init"></th>
                <th><input type="text" name="modelClient" class="search_init"></th>
            </tr>
        </thead>
    <display:column title="Select"><input type="checkbox" name="ids[]" property="taskNumber" class="tableCheckBox" /></display:column>
    <display:column property="taskType" title="Task Type" />
    <display:column property="storerKey" title="Client" />
    <display:column property="skuLotLocPK.sku" title="SKU" />
    <display:column property="skuLotLocPK.lot" title="Lot" />
    <display:column property="skuLotLocPK.loc" title="Location" />
    <display:column property="status" title="Status" />
    <display:column property="priority" title="Priority" />
    <display:column property="qty" title="Qty" />
    <display:column property="user" title="User" />
    <display:column property="startTime" title="Start Time" format="{0, date, MM-dd-yyyy hh:mm}" />
    <display:column property="endTime" title="End Time" format="{0, date, MM-dd-yyyy hh:mm}" />
</display:table>

</body>
</html>