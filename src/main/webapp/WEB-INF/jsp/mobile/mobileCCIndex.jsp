<!DOCTYPE html>
<%@ include file="../shared/tagLibaray.jsp"%>

<head>
    <title>Mobile Client - CC </title>
    <%@ include file="../mobile/mobileHead.jsp"%>

</head>

    <body>
        <div class="mobile-container">
        <%@ include file="mobileNavigation.jsp"%>
            <div class="cycleCountFilter">
            <form:form method="GET" action="/mobile/mobileCount">
                <label>Search For Available Counts</label> <br />
                <label>Section: </label><input type="search" name="iSection" value="*" /> <i>Disabled</i> <br />
                <label>Facility: </label><input type="search" name="iFacility" value="*" /> <i>Disabled</i> <br />
                <label>Zone: </label><input type="search" name="iZone" value="*" /> <i>Disabled</i> <br />
                <label>Client: </label><input type="search" name="iClient" value="*" /> <br />
                <input type="submit" value="Search" />
            </form:form>
            </div>
        </div>
    </body>
</html>

