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
    <form:form action="mobileCountValidation">
        <c:if test="${!empty(taskToCount)}">
            <Label>SKU: </Label><c:out value="${taskToCount.skuLotLocPK.sku}" /> <br />
            <Label>LOC: </Label><c:out value="${taskToCount.skuLotLocPK.loc}" /> <br />
            <Label>LOT: </Label><c:out value="${taskToCount.skuLotLocPK.lot}" /> <br />
            <Label>QTY: </Label><c:out value="${taskToCount.qty}" /> <br />
            <Label>-----------------------------------------------------</Label> <br>
            <Label>LOC: </Label><input type="search" name="iLoc" /> <br />
            <Label>LOT: </Label><input type="search" name="iLot" /> <br />
            <Label>QTY: </Label><input type="search" name="iQty" /> <br />
            <input type="submit" value="Search" />
        </c:if>
    </form:form>
</div>
</body>
</html>

