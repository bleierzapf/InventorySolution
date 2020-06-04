<!DOCTYPE html>
<%@ include file="shared/tagLibaray.jsp"%>

<head>
    <title>LSqrd Solution - Dashboard</title>
    <%@ include file="shared/head.jsp"%>
    <script type="text/javascript">
        window.onload = function(){
            let dps = [];
            const chart = new CanvasJS.Chart("chartContainer", {
                animationEnabled: true,
                title: {
                    text: "Count Timeliness"
                },
                data: [{
                    type: "pie",
                    startAngle: 240,
                    yValueFormatString: "##0",
                    indexLabel: "{label} - {y}",
                    dataPoints: dps
                }]
            });

            let yValue;
            let gLabel;

            <c:forEach items="${ccTimelinessData}" var="data">
                gLabel = "${data.key}";
                yValue = "${data.value}";
                dps.push({label: gLabel, y: yValue});
            </c:forEach>

            chart.render();
        }
    </script>
</head>

<body>

<header>
    <%@ include file="shared/navigation_bar.jsp"%>
</header>

<b>Dashboard</b>

<div id="chartContainer" style="height: 370px; max-width: 370px; margin: 0px auto;"></div>
<script src="js/canvasjs.min.js"></script>
</body>
</html>