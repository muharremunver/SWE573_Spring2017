<%-- 
    Document   : result
    Created on : 01.May.2017, 00:51:19
    Author     : MUHARREM
--%>

<%@page import="java.util.Date"%>
<%@page import="java.util.ResourceBundle"%>
<%@page import="wise.CheckinObject"%>
<%@page import="java.util.ArrayList"%>
<%@page import="wise.TwitterUtils"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/result.css"/>
        <title>Result</title>
</head>
<body>
    <div class="topnav" id="myTopnav">
	<a href="homepage.jsp">Home</a>
	<a href="usermanual.jsp">User Manual</a>
    </div>
    <br />
    <br />
    <%
        String cityName = request.getParameter("city");
        String date = request.getParameter("datepicker");
        String maxTweet = request.getParameter("maxTweet");
        String topTweet = request.getParameter("topTweet");
        
        ArrayList<CheckinObject> checkinList; 

        if (cityName == "" || cityName == null || date == "" || date == null) {
            response.sendRedirect("/homepage.jsp");   
            return;
        }
        else  
        {
           ResourceBundle resource = ResourceBundle.getBundle("wise.cityCodes");
           String cityCode = resource.getString(cityName);
           checkinList = new TwitterUtils().dataList(cityCode, date, maxTweet, topTweet);
        }
        
       
        %>
     
    	<table id="tableData" class="table table-bordered table-striped">
            <thead>
                <tr>
                    <th class="thLocationImage">Photo of the venue</th>
                    <th class="thLocationName">Name of the venue</th>
                    <th class="thCount">Count</th>
                    <%-- <th class="thCheckin">Checkin Id</th> --%>
                </tr>
            </thead>
            
            <tbody>
    <%         
        for (CheckinObject checkin : checkinList) {
        %>   
            <tr>
                <td><img src=<%= checkin.Image %> alt="" border=3 /></td>
                <td><%= checkin.LocationName %></td>
                <td><%= checkin.Count %></td>
                <%-- <td><%= checkin.CheckinId %></td> --%>
            </tr>
    <% } %>        
            </tbody>
            
	</table>    
 
        
        
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script> 
<script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.11.2/jquery-ui.min.js"></script>
<script type="text/javascript" src="scripts/paging.js"></script> 
<script type="text/javascript">
            $(document).ready(function() {
                $('#tableData').paging({limit:20});
            });
        </script>
<script type="text/javascript">

  var _gaq = _gaq || [];
  _gaq.push(['_setAccount', 'UA-36251023-1']);
  _gaq.push(['_setDomainName', 'jqueryscript.net']);
  _gaq.push(['_trackPageview']);

  (function() {
    var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
    ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
    var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
  })();

</script>        
        
</body>
</html>
