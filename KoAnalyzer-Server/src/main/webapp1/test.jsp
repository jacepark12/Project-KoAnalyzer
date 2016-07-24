<%@ page import="fusioncharts.FusionCharts" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Loading Data from a Static JSON String - fusioncharts.com</title>
    <script src="./js/fusioncharts.js"></script>
</head>
<body>
<div id="chart"></div>

<%
    FusionCharts column2DChart= new FusionCharts(
            "pie3d",// chartType
            "chart1",// chartId
            "600", //   chartWidth
            "400",//    chartHeight
            "chart",//  chartContainer
            "json",//   dataFormat
            "{\"data\":[{\"label\":\"test\",\"value\":2}],\"chart\":{\"caption\":\"DensityKeyWord\",\"theme\":\"ocean\"}}\n"
           // "{\"chart\": {\"caption\": \"Harry\'s SuperMart\",\"subCaption\": \"Top 5 stores in last month by revenue\",\"numberPrefix\": \"$\",\"theme\": \"ocean\"},\"data\": [{\"label\": \"Bakersfield Central\",\"value\": \"880000\"}, {\"label\": \"Garden Groove harbour\",\"value\": \"730000\"}, {\"label\": \"Los Angeles Topanga\",\"value\": \"590000\"}, {\"label\": \"Compton-Rancho Dom\",\"value\": \"520000\"}, {\"label\": \"Daly City Serramonte\",\"value\": \"330000\"}]}"
    );
%>
<%=column2DChart.render()%>

</body>
</html>