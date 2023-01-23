<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Vehicle</title>
<link rel="stylesheet" href="../resources/static/css/update-style.css">
</head>
<body>
<form>
<label for ="manufacturer"> Choose car manufacturer: </label>
<select name="manufacturer" id="manufacturer">
<option value="audi">Audi</option>
<option value="bmw">BMW</option>
<option value="ford">Ford</option>
<option value="honda"> Honda </option>
<option value="hyundai"> Hyundai </option>
<option value="kia"> Kia </option>
<option value="mahindra"> Mahindra </option>
<option value="mercedes"> Mercedes </option>
<option value="Porsche">Porsche</option>
<option value="renault">Renault</option>
<option value="skoda">Skoda</option>
<option value="suzuki">Suzuki</option>
<option value="tata">Tata Motors</option>
<option value="toyota">Toyota</option>
<option value="volkswagen">Volkswagen</option>
<option value="volvo">Volvo</option>
</select>
<label for="year">Year of manufacture:</label>
<input type="text" id="year" name="makeYear">
 <label for="engine">Vehicle engine type: </label>
 <select name="engineType" id="engine">
 <option value="bs4">BS4</option>
 <option value="bs6">BS6</option>
 </select>
 <label for="fuel">Vehicle fuel type: </label>
 <select name="fuelType" id="fuel">
 <option value="petrol">Petrol</option>
 <option value="diesel">Diesel<option>
 <option value="cng">CNG</option>
 </select>
 <label for="hybrid">Hybrid vehicle: </label>
 <select name="hybrid" id="hybrid">
 <option value="true">True</option>
 <option value="false">False</option>
 </select>
 <label for="electric">Electric vehicle: </label>
 <select name="electric" id="electric">
 <option value="true">True</option>
 <option value="false">False</option>
 </select>
 <br>
 <button type="submit">Submit</button>
</form>
</body>
</html>