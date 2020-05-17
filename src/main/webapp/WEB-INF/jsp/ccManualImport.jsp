<!DOCTYPE html>
<%@ include file="shared/tagLibaray.jsp"%>

<head>
    <title>LSqrd Solution - Cycle Count Manual Import</title>
    <%@ include file="shared/head.jsp"%>
</head>

<body>

<header>
    <%@ include file="shared/navigation_bar.jsp"%>
</header>

<br>
<form class="fileUploadForm" action="fileUpload" method="POST" enctype="multipart/form-data">
    <table class="uploadFileTable">
        <tr>
            <th colspan="2">Cycle Count Manual Import</th>
        </tr>
        <tr>
            <td colspan="3"><label for="file">Upload File</label></td>
            <td><input id="file" type="file" name="file" /></td>
        </tr>
        <tr>
            <td><button type="submit">Upload</button></td>
        </tr>
    </table>
    <br>
    <table class="uploadTemplateTable">
        <tr>
            <th colspan="3">Upload Format (CSV File)</th>
        </tr>
        <tr>
            <td>Message</td>
            <td>STORERKEY</td>
            <td>SKU</td>
            <td>LOC</td>
            <td>LOT</td>
            <td>QTY</td>
            <td>COUNT_DATE</td>
            <td>USER</td>
            <td>ADJUSTMENT_REASON</td>
        </tr>
        <tr>
            <td>Leave Blank</td>
            <td>Client #</td>
            <td>Part #</td>
            <td>Location</td>
            <td>Lot #</td>
            <td>Count Qty</td>
            <td>Count Date</td>
            <td>Auditor</td>
            <td>Adjustment Code</td>
        </tr>
    </table>
</form>

</body>
</html>