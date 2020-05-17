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
    <display:column title="Select"><input type="checkbox" name="ids[]" value="${skuLotLocPK.sku}" class="tableCheckBox" /></display:column>
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


<!--
<section id="availableTasksTable" class="display">
    <table>
        <form method="GET" action="/tasks/viewAllTasks" >
            <input type="submit" value="Search" id="search" />
        </form>
        <br>
        <form>
            <thead>
            <tr>
                <th><button id="selectAllCheckbox" onclick="javascript:test()"/>Select All</th>
                <th>Task Type</th>
                <th>Client</th>
                <th>SKU</th>
                <th>Lot</th>
                <th>Location</th>
                <th>Status</th>
                <th>Priority</th>
                <th>Qty</th>
                <th>User</th>
                <th>Start Time</th>
                <th>End Time</th>
            </tr>
            <tr>
                <th></th>
                <th><input path="taskType" type="text"/></th>
                <th><input path="storerKey" type="text"/></th>
                <th><input path="skuLotLocPK.sku" type="text" /></th>
                <th><input path="skuLotLocPK.lot" type="text" /></th>
                <th><input path="skuLotLocPK.loc" type="text" /></th>
                <th><input path="status" type="text" /></th>
                <th><input path="priority" type="text" /></th>
                <th><input path="qty" type="text" /></th>
                <th><input path="user" type="text" /></th>
                <th><input path="startTime" type="text" /></th>
                <th><input path="endTime" type="text" /></th>
            </tr>
            </thead>
            <c:if test="${!empty(allTasks)}">
                <section>
                    <c:forEach items="${allTasks}" var="task" >
                        <tr>
                            <td><input type="checkbox" name="ids[]" id="selectCheckBox" value="${task.skuLotLocPK.sku}"/></td>
                            <td>${task.taskType}</td>
                            <td>${task.storerKey}</td>
                            <td>${task.skuLotLocPK.sku}</td>
                            <td>${task.skuLotLocPK.lot}</td>
                            <td>${task.skuLotLocPK.loc}</td>
                            <td>${task.status}</td>
                            <td>${task.priority}</td>
                            <td>${task.qty}</td>
                            <td>${task.user}</td>
                            <td><fmt:formatDate pattern="MM-dd-yyyy hh:mm" value="${task.startTime}" /></td>
                            <td><fmt:formatDate pattern="MM-dd-yyyy hh:mm" value="${task.endTime}" /></td>
                        </tr>
                    </c:forEach>
                </section>
            </c:if>
        </form>
    </table>
</section>
-->
</body>
</html>