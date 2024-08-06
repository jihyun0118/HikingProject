<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<body style="background-color:#FAEBD7;">
    <title>Title</title>
</head>
<body>
<br>


    <h1>&emsp;&emsp;Congratulations, Party ${model.param4}! You have reserved for BHC Hiking.</h1>
    <br>
    <div>&emsp;&emsp;&emsp;&emsp;Hike Name:  &thinsp;&thinsp;&thinsp;&thinsp;&thinsp;&thinsp;&thinsp;&thinsp;&thinsp;&thinsp;${model.param1}&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp; 
    <img src="images/BookedHike.png" align="right">
</body></div>
    <br>
    <div>&emsp;&emsp;&emsp;&emsp;Hike Duration:  &thinsp;&thinsp;&thinsp;&thinsp;${model.param2}</div>
    <br>
    <div>&emsp;&emsp;&emsp;&emsp;Hike Start Date:  &thinsp;&thinsp;${model.param3}</div>
    <br>
    <div>&emsp;&emsp;&emsp;&emsp;Party Size:  &emsp;&emsp;&thinsp;&thinsp;${model.param5}</div>
    <br>
    <div>&emsp;&emsp;&emsp;&emsp;Party Name:  &thinsp;&thinsp;&thinsp;&thinsp;&thinsp;&thinsp;&thinsp;&thinsp;${model.param4}</div>
    <br>
    <div>&emsp;&emsp;&emsp;&emsp;Total Hike Cost: &thinsp;&thinsp;$ ${hikingCost}</div>
    
</html>
