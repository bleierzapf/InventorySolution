<!DOCTYPE html>
<%@ include file="shared/tagLibaray.jsp"%>

<head>
    <title>LSqrd Solution - Sku Import</title>
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
            <th colspan="2">Item Master Update</th>
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
            <td><i>Other Field Names</i></td>
        </tr>
        <tr>
            <td>Leave Blank</td>
            <td>Client #</td>
            <td>Part #</td>
            <td><i>Update Data</i></td>
        </tr>
    </table>
</form>

</body>
</html>