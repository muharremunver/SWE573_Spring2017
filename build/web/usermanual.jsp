<%-- 
    Document   : usermanual
    Created on : 16.May.2017, 22:32:13
    Author     : MUHARREM
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>User Manual</title>
    <link rel="stylesheet" type="text/css" href="css/homepage.css"/>
</head>
<body>
    <div class="topnav" id="myTopnav">
	<a href="homepage.jsp">Home</a>
	<a href="usermanual.jsp">User Manual</a>
    </div>
<br/>

<h2>1. Filters</h2>
<p> To start a search, it is required to select a city, date, max tweet ant top tweet values. Max tweet value shows how many result set will be requested from Twitter API. Each result set has 100 tweets. Top tweet value shows how many venues will be shown isn result list. </p>
<p> Additional filter rules:</p>
<p> - Date can not be older than 9 days ago.</p>
<p> - Date can not be greater than today.</p>
<p> - Max tweet value cannot be greater than 1000.</p>
<p> Warninng messages examples are below:</p>
<img src="images/cityRequired.png" height="175px" width="450px"> </img>
<img src="images/dateRequired.png" height="175px" width="450px"> </img>
<img src="images/soonerDateRequired.png" height="175px" width="450px"> </img>
<img src="images/olderDateRequired.png" height="175px" width="450px"> </img>

<h2>2. Homepage</h2>
<p> You can see the name of the city when you hover to it.</p>
<img src="images/cityHover.png" height="450px" width="900px"> </img>
<p> When you select a city and date, you can start searching by clicking 'Search' button.</p>


<h2>3. Results</h2>
<p> You can see the results of search in this page. There are three column in the grid. First column shows the picture of venue, second column is name of the venue and third column is ratng of the venue.</p>
<p> Results are ordered by their ratings in descending order.</p>
<img src="images/resultsSample.PNG" height="450px" width="900px"> </img>

<br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>





</body>



<footer>
    <img src="images/twitter.png" height="50px"/> 
</footer>
</html>



