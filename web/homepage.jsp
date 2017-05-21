<%-- 
    Document   : homepage
    Created on : 30.Nis.2017, 23:58:15
    Author     : MUHARREM
--%>

<%@page import="wise.TwitterUtils"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Homepage</title>
    <link rel="stylesheet" type="text/css" href="css/normalize.css">
    <link rel="stylesheet" type="text/css" href="css/jquery.qtip.min.css">
    <link rel="stylesheet" type="text/css" href="css/homepage.css"/>

    <script type="text/javascript" src="scripts/jquery-1.8.0.min.js"></script>
    <script type="text/javascript" src="scripts/raphael-min.js"></script>
    <script type="text/javascript" src="scripts/paths.js"></script>
    <script type="text/javascript" src="scripts/turkiye.js?v=123"></script>
    <script type="text/javascript" src="scripts/jquery.qtip.min.js"></script>
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css" />
    <link rel="stylesheet" href="/resources/demos/style.css" />
    
    <script type="text/javascript">
            $(function(){
                    $("#map svg path").click(
                      function() {
                            var id = $(this).attr("id");
                            $("#sehir").text(id);
                            document.getElementById("city").value = id;
                     });
            })
    </script>
    
    <script>
    $( function() {
        $( "#datepicker" ).datepicker();
    } );
    </script> 
    
    <script type="text/javascript">
    $(document).ready(function() {
        document.getElementById("city").value = "";
        });
    </script>
    
    <script type="text/javascript">
    function ValidateForm(form)
    {          
        var city = form.elements["city"].value;
        var selectedDate = form.elements["datepicker"].value;
        var topTweet = form.elements["topTweet"].value;
        var maxTweet = form.elements["maxTweet"].value;
        
        if (city == null || city == "")
        {
            alert("Please select a city");
            return false;
        }
        
        if (selectedDate == null || selectedDate == "")
        {
            alert("Please select a date");
            return false;
        }
        
        if (!Date.parse(selectedDate)) {
            alert("Date format in not correct. Format is MM/DD/YYYY");
            return false;
        }      

        if (maxTweet == null || maxTweet == "")
        {
            alert("Max tweet parameter can not be empty.");
            return false;
        }
        
        if (topTweet == null || topTweet == "")
        {
            alert("Top tweet parameter can not be empty.");
            return false;
        }
        

        
        var currentTime = new Date(); 
        currentTime.setHours(0,0,0,0);

        var currTime = new Date(selectedDate);
        if (currTime >= currentTime)
        {
            alert("Date must be smaller than today");
            return false;
        }

        if (parseInt((currentTime - currTime )/(24*3600*1000)) > 9) {
            alert("Time interval between today and selected date cannot be greater than 9 days. Please select a sooner date.");
            return false;

        }
    }
    
    </script> 
    
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    
    <style type="text/css">
            body{background:#fff;}
            #map{width:1050px;height:620px;position:relative;margin:auto;}
            #map svg {position: relative;top: -100px; left: 0px;}
            svg > a {cursor: pointer;display:block;}
            #sehir{font-size:30px;text-align:center;margin-top:25px;color:#666;}
    </style>   
</head>

<body>
    <div class="topnav" id="myTopnav">
	<a href="homepage.jsp">Home</a>
	<a href="usermanual.jsp">User Manual</a>
    </div>
    <br/>
    <div class="container">			
        <form name=formHomepage" action="result.jsp" onsubmit="return ValidateForm(this);">
            
            <div  id="sehir">  </div>
            <div  id="map"></div>  
            
            <div class="container">
                <label class="label" style="margin-right: 50px">Date: </label>
                <input class="label" id = "datepicker" name="datepicker"/>  
                <label class="label" style="margin-left: 50px">Number of tweets to search:</label><input type="number" name="maxTweet" id="maxTweet" min="1" max="1000" style="width: 100px"/>
                <label class="label" style="margin-left: 50px">The number of results to show in the list:</label><input type="number" name="topTweet" id="topTweet" min="1" style="width: 100px"/>               
            </div>
            <br/>
            <div class="container">             
                <input type="submit" name="submit" value="Search"/>
            </div>    
             <input type="text" id="city" name="city" value=""  readonly="readonly" style="visibility:hidden"/>
	</form>
    </div>
</body>


<footer>
    <img src="images/twitter.png" height="50px"/> 
</footer>



</html>




