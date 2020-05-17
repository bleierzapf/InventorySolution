<!DOCTYPE html>
<%@ include file="shared/tagLibaray.jsp"%>

<head>
    <title>LSqrd Solution - Location Import</title>
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
            <th colspan="2">Location Import</th>
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
            <td>LOC</td>
            <td><i>Other Field Names</i></td>
        </tr>
        <tr>
            <td>Leave Blank</td>
            <td>Location Name</td>
            <td><i>Update Data</i></td>
        </tr>
    </table>
</form>

</body>
</html>