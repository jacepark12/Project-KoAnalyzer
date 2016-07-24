<%@ page import="fusioncharts.FusionCharts" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">

    <title>Document Analyze</title>
    <script src="${pageContext.request.contextPath}/js/fusioncharts.js"></script>
    <!-- Bootstrap core CSS -->
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet" type="text/css">

    <!-- Custom styles for this template -->
    <link href="${pageContext.request.contextPath}/css/jumbotron.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="../../assets/js/ie-emulation-modes-warning.js"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>

    <![endif]-->
  </head>

  <body>

    <nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">Ko-Analyzer</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
        </div><!--/.navbar-collapse -->
      </div>
    </nav>

    <!-- Main jumbotron for a primary marketing message or call to action -->
    <div class="jumbotron">
      <div class="container">
        <h1>Document Analyze</h1>
        <p>Document의 본문을 parameter에 넣거나, 기존에 저장한 Document의 IDX값을 넣어 Document를 분석할 수 있습니다. Document에서 가장 빈도수 높은 키워드, 밀집도가 높은 키워드, 감성 분석을 진행할 수 있습니다</p>
        <p><a class="btn btn-primary btn-lg" href="#" role="button">저장된 문서 확인하기 &raquo;</a></p>
      </div>
    </div>

    <div class="container">
      <h2>Document 본문</h2>
      <h3><%=(String)request.getAttribute("docText") %></h3>

      <h2>Document 핵심 키워드</h2>
      <h3>단어별 밀집도 분석과 감성 분석을 통한 Document내 주요 키워드 입니다.</h3>
      <div id="keywordChart"></div>
      <%
        FusionCharts keywordColumnChart = new FusionCharts(
                "pie3d",
                "chart1",
                "800",
                "600",
                "keywordChart",
                "json",
                (String)request.getAttribute("densityWordsJSON"));
      %>
      <%=keywordColumnChart.render()%>

      <h2>Document내 긍정 단어 분포도</h2>
      <h3>Document내 긍정의 의미를 가지고 있는 단어가 속한 위치입니다</h3>
      <div id="posWordPositionChart"></div>
      <%
        FusionCharts posWordPositionChartChart = new FusionCharts(
                "column2d",
                "chart2",
                "800",
                "600",
                "posWordPositionChart",
                "json",
                (String)request.getAttribute("posWordsPositionJSON"));
      %>
      <%=posWordPositionChartChart.render()%>


      <h2>Document내 부정 단어 분포도</h2>
      <h3>Document내 부정의 의미를 가지고 있는 단어가 속한 위치입니다</h3>
      <div id="negWordPositionChart"></div>
      <%
        FusionCharts negWordPositionChart = new FusionCharts(
                "column2d",
                "chart3",
                "800",
                "600",
                "negWordPositionChart",
                "json",
                (String)request.getAttribute("negWordsPositionJSON"));
      %>
      <%=negWordPositionChart.render()%>


      <footer>
        <p>&copy; Company 2014</p>
      </footer>
    </div> <!-- /container -->

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="../../dist/js/bootstrap.min.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
  </body>
</html>
