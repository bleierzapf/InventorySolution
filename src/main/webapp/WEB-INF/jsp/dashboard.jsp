<!DOCTYPE html>
<%@ include file="shared/tagLibaray.jsp"%>

<head>
    <title>LSqrd Solution - Dashboard</title>
    <%@ include file="shared/head.jsp"%>
    <script type="text/javascript" src="js/dashboard.js"></script>
    <script type="text/javascript">
        window.onload = function(){
            let dps = [];
            const pieChart = new CanvasJS.Chart("pieChartContainer", {
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

            pieChart.render();
        }
    </script>
</head>

<body>

<header>
    <%@ include file="shared/navigation_bar.jsp"%>
</header>

<b>Dashboard</b>

<div id="pieChartContainer" style="height: 370px; max-width: 500px; margin: 0px auto;"></div>
<script src="js/canvasjs.min.js"></script>
</body>
</html>