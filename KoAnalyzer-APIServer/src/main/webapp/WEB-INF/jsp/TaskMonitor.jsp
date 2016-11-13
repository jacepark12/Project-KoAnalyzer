<%@ page import="com.KoAnalyzer.APIServer.Phrase" %>
<%@ page import="fusioncharts.FusionCharts" %>
<%@ page import="java.util.List" %>
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
        <h1>Project-KoAnalyzer</h1>
        <p>자연어 처리 분석에 이용된 어근 / 토큰에 대한 통계입니다 </p>
        <p>
          <!--
          <a class="btn btn-primary btn-lg" href="http://localhost:8080/KoAnalyze/rest/files/documents" role="button">저장된 문서 확인하기 &raquo;</a>-->
          <button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal">Open Large Modal</button>

          <!-- Modal -->
          <div class="modal fade" id="myModal" role="dialog">
            <div class="modal-dialog modal-lg">
              <div class="modal-content">
                <div class="modal-header">
                  <button type="button" class="close" data-dismiss="modal">&times;</button>
                  <h4 class="modal-title">Modal Header</h4>
                </div>
                <div class="modal-body">
        <p>This is a large modal.</p>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
      </div>
    </div>
    </div>
    </div>
    </div>

    </p>
      </div>
    </div>

    <div class="container">
      <h2>자연어 처리 내역 및 통계</h2>

      <h2>분석된 어근 및 토큰</h2>
      <h3>자연어 처리된 어근 및 토큰의 분석 횟수입니다.</h3>
      <div id="keywordChart"></div>
      <%
        FusionCharts keywordColumnChart = new FusionCharts(
                "pie3d",
                "chart1",
                "800",
                "600",
                "keywordChart",
                "json",
                (String)request.getAttribute("phraseTextData"));
      %>
      <%=keywordColumnChart.render()%>

      <h2>분석된 어근 및 토큰의 품사</h2>
      <h3>자연어 처리된 어근 및 토큰의 품사 비율입니다.</h3>
      <div id="posChart"></div>
      <%
        FusionCharts keywordColumnChart2 = new FusionCharts(
                "pie3d",
                "chart2",
                "800",
                "600",
                "posChart",
                "json",
                (String)request.getAttribute("phrasePosData"));
      %>
      <%=keywordColumnChart2.render()%>

      <h2>분석된 어근 및 토큰</h2>
      <h3>분석된 어근 및 토큰 리스트입니다.</h3>

      <div>
        <%
          List<Phrase> phraseArrayList = (List<Phrase>) request.getAttribute("phraseArrayList");
        %>

        <%
          for(int i =0; i < phraseArrayList.size(); i++)
          {
        %>
          <li><%=phraseArrayList.get(i).getText()%></li>
        <%
          }
        %>
      </div>
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
