<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" %>
<head>
    <meta charset="UTF-8">
    <title>HPlus</title>
    <link rel="stylesheet" href="/css/style.css" type="text/css"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
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