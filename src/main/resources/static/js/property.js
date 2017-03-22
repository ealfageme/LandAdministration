function property(){
	var e = document.getElementById("SelectProperty");
	var strProperty = e.options[e.selectedIndex].value;
	var url = "/propertyPage/"+strProperty
	window.location= url;
}