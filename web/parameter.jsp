<%-- 
    Document   : parameter
    Created on : 13.May.2017, 16:20:57
    Author     : MUHARREM
--%>

<%@page import="java.io.FileInputStream"%>
<%@page import="java.util.Properties"%>
<%@page import="java.util.ResourceBundle"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Change Parameter</title>

    <link rel="stylesheet" type="text/css" href="css/parameter.css"/>
   
    <script type="text/javascript">
    function ValidateForm(form)
    {          
        var a = form.elements["toptweet"].value;
        var b = form.elements["maxtweet"].value;
       
        if (a == null || a == "")
        {
            alert("Top Tweet Parameter can not be empty.");
            return false;
        }
        
        if (!Int.parse(a)) {
            alert("Top Tweet Parameter format in not correct. Format is Integer");
            return false;
        }    
        
        if (b == null || b == "")
        {
            alert("Maximum Tweet Parameter can not be empty.");
            return false;
        }
        
        if (!Int.parse(b)) {
            alert("Maximum Tweet Parameter format in not correct. Format is Integer");
            return false;
        } 
    }
    </script>    
</head>    
    
<body>
    <div class="topnav" id="myTopnav">
	<a href="homepage.jsp">Home</a>
	<a href="usermanual.jsp">User Manual</a>
	<a href="parameter.jsp">Parameters</a>
	<a>WISE ✣ ✻ ✡ ❂ ★ ✹ ❆ ✮ ✬ ✰ </a>
    </div>
    <br/>
    
        <%!  
            ResourceBundle resource = ResourceBundle.getBundle("wise.config");
            Integer maxTweet = Integer.parseInt(resource.getString("MAX_TWEET_NUMBER"));
            Integer topTweet = Integer.parseInt(resource.getString("TOP_NUMBER"));
        %>
        
        
        <form name=formParameter" onsubmit="return ValidateForm(this);" method="POST" action="${pageContext.request.contextPath}/WiseServlet">              
            <div id="wrapper">
                <div id="inner1">
                    <label class="label">Top Tweet Parameter:  </label>
                    <input type="number" id="toptweet" name="toptweet" min="1" value=<%= topTweet %>> </input>
                </div>
                <br/>
                <div id="inner2">
                    <label class="label">Maximum Tweet Parameter:  </label>
                    <input type="number" id="maxtweet" name="maxtweet" min="1" max="1000" value=<%= maxTweet %>> </input>
                </div>
                 <div id="inner2">
                    <input type="submit" name="parametersubmit" value="Save"/>
                </div>
            </div>            
	</form>

    
    
</body>

<footer>
    <img src="images/twitter.png" height="50px"/> 
</footer>

</html>
