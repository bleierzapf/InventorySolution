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
            <c:if test="${!empty(errorLoc)}">
                <c:out value="${errorLoc}" /> <br />
            </c:if>
            <Label>LOC: </Label><input type="search" name="iLoc" /> <br />
            <c:if test="${!empty(errorLot)}">
                <c:out value="${errorLot}" /> <br />
            </c:if>
            <Label>LOT: </Label><input type="search" name="iLot" /> <br />
            <c:if test="${!empty(errorQty)}">
                <c:out value="${errorQty}" /> <br />
            </c:if>
            <Label>QTY: </Label><input type="search" name="iQty" /> <br />
            <input type="submit" name="submit" value="Submit" />
            <c:if test="${!(empty(errorLoc) && empty(errorLot) && empty(errorQty))}">
                <input type="submit" name="submit" value="Confirm Variance" />
            </c:if>
        </c:if>
    </form:form>
</div>
</body>
</html>

