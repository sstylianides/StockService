<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Stock Search</title>
</head>
<body>


search for a ticker symbol and date range<br>

<P></P>

<form name="myform" action="servlets/StockSearch" method="post">
    Ticker Symbol<input type="text" name="symbol">
    <br>
    Start Date <input type="date" name="startDate">
    <br>
    End Date <input type="date" name="endDate">
    <br>
    Interval:
    <input type="radio" id="daily" name="interval" value="daily" checked />
    <label for="daily">Daily</label>

    <input type="radio" id="weekly" name="interval" value="weekly"/>
    <label for="weekly">Weekly</label>

    <input type="radio" id="monthly" name="interval" value="monthly"/>
    <label for="monthly">Monthly</label>
    <br>
    <input type="SUBMIT" value="OK">
    <input type="HIDDEN" name="submit" value="true">
</form>
</body>
</html>