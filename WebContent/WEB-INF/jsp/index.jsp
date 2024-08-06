<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:useBean id="hike" class="com.jenncontrollers.Hike"
	scope="session" />
<jsp:useBean id="controller" class="com.jenncontrollers.Controller"
	scope="session" />
    <title>Title</title>
</head>
<body background="images/BrownWood.png">
<p>
<br>

<img src="images/Beartooth4.png" width="610" height="190"><img src="images/Phone.png" width="230" height="190">
<img src="images/ThreeTrails.png" align="right">


<br>
				
    <form method="POST">


  <h2><em><p>&emsp;&emsp;Calculate your Tour Cost Today! </em></h2></p>    
    

    
        <div>
        <p>
		  <b><label for="hikepath">&emsp;&emsp;&emsp;&emsp;Choose a Hiking Path:&emsp;&emsp;</label></b>
		  <select id="hikepath" name="hikepath">
		  	<option> Select Hike </option>
		    <option value="GARDINER">GARDINER</option>
		    <option value="HELLROARING">HELLROARING</option>
		    <option value="BEATEN">BEATEN</option>
		  </select>
        </div>
        </p>
        <div> 
            <p>
            <b><label for="hikeduration">&emsp;&emsp;&emsp;&emsp;Choose Duration:&emsp;&emsp;&emsp;&emsp;</label></b>
		    <select id="hikeduration" name="hikeduration">
		    <option> Select Duration </option>
		    <option id = "2 days" value="2 Days"> 2 Days </option>
		    <option id = "3 days" value="3 Days"> 3 Days </option>
		    <option id = "4 days" value="4 Days"> 4 Days </option>
		    <option id = "5 days" value="5 Days"> 5 Days </option>
		    <option id = "7 days" value="7 Days"> 7 Days</option>
		  </select>     
           <b> &nbsp;<span style="color: red">${param1Errors} </span><b>
        </div>
        
        <script>
document.getElementById("hikepath").onchange = durationChange

function durationChange() {
    var elem = document.getElementById("hikepath");
    if (elem.options[elem.selectedIndex].text == "GARDINER") {
        document.getElementById("2 days").disabled = true;
        document.getElementById("3 days").disabled = false;
        document.getElementById("4 days").disabled = true;
        document.getElementById("5 days").disabled = false;
        document.getElementById("7 days").disabled = true;
    }
    if (elem.options[elem.selectedIndex].text == "HELLROARING") {
    	document.getElementById("2 days").disabled = false;
        document.getElementById("3 days").disabled = false;
        document.getElementById("4 days").disabled = false;
        document.getElementById("5 days").disabled = true;
        document.getElementById("7 days").disabled = true;
    }
    if (elem.options[elem.selectedIndex].text == "BEATEN") {
    	document.getElementById("2 days").disabled = true;
        document.getElementById("3 days").disabled = true;
        document.getElementById("4 days").disabled = true;
        document.getElementById("5 days").disabled = false;
        document.getElementById("7 days").disabled = false;
    }
}


</script>

        </p>
        <div>
        					
            <label for="param3">&emsp;&emsp;&emsp;&emsp;Choose Start Date: &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;</label>
            <input type="date" id="param3" name="param3" value="${model.param3} " placeholder="enter start date">
            &nbsp;<span style="color: red">${param3Errors} ${param2Errors}</span>
        </div>
        <div>
    
         <div> 
            <p>
            <b><label for="param5">&emsp;&emsp;&emsp;&emsp;Choose Size of Party:&thinsp;&emsp;&emsp;</label><b>
		    <select id="param5" name="param5">
		    <option value="1 Person"> 1 Person </option>
		    <option value="2 People"> 2 People </option>
		    <option value="3 People"> 3 People </option>
		    <option value="4 People"> 4 People </option>
		    <option value="5 People"> 5 People </option>
		    <option value="6 People"> 6 People </option>
		    <option value="7 People"> 7 People </option>
		    <option value="8 People"> 8 People </option>
		    <option value="9 People"> 9 People </option>
		    <option value="10 People"> 10 People </option>
		  </select>     
        </div>
        
                <p>
           <b> <label for="param4">&emsp;&emsp;&emsp;&emsp;Enter Name of Party: &ensp;&ensp;&ensp;&thinsp;</label><b>
            <input type="text" id="param4" name="param4" value="${model.param4}" placeholder="2 characters minimum">
            &nbsp;<span style="color: red">${param4Errors}</span>
        </div>
        </p>
        
        &emsp;&emsp;&emsp;&emsp;<input type="submit" id="search" value="Tour Cost"  style="width: 80px; height: 40px;" />
		      
</style> 
    </form>
    <br>
    <br>
     <img src="images/F500.png">&thinsp;&thinsp;<img src="images/Boots.png" width="180" height="140">
    <br>
<p style="color: #8B4513">    
<h5 style="color: #8B4513">Copyright © Beartooth Hiking Company - 80 Pine Street, Cambridge, Massachusetts 02215 | 617-272-7000 | trips@beartoothhiking.com | 1986 - 2021. </p></h5>
</body>
</html>
