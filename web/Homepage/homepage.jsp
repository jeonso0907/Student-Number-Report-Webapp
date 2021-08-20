<%--
  Created by IntelliJ IDEA.
  User: jeons
  Date: 2021-08-13
  Time: 오후 10:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <!-- jQuery -->
    <script src="https://code.jquery.com/jquery.min.js"></script>
    <!-- google charts -->
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>

    <link rel="stylesheet" href="homepage.css">
    <title>Homepage.Homepage</title>

</head>
<body>
    <h2>Homepage.Homepage</h2>
    <p>Select your data file</p>

    <TABLE BORDER="1" CELLPADDING="3" CELLSPACING="1">
    <TR>
        <TH>Academic </TH>
        <TH>Source</TH>
        <TH>Count</TH>
    </TR>
    <jsp:useBean class = "Object.DataList" id="data" scope="page"/>
<%--    <c:forEach var="data" items="${data.getDataList}">--%>
<%--        <TR>--%>
<%--            <TD>${data.academicProgram}</TD>--%>
<%--            <TD>${data.sourceCode}</TD>--%>
<%--            <TD>${data.count}</TD>--%>
<%--        </TR>--%>
<%--    </c:forEach>--%>
    </TABLE>

    <script>
        var chartDrawFun = {
            chartDraw : function() {
                var chartData = '';

                var chartDataFormat;

                function drawDashboard() {
                    var data = new google.visualization.DataTable();

                    data.addColumn('Academic Program');
                    data.addColumn('')

                    // Display data
                    var dataRow = [];

                }
            }
        }
    </script>
</body>

</html>
