function owner(){
	var e = document.getElementById("SelectOwner");
	var strOwner = e.options[e.selectedIndex].value;
	var url = "/ownerPage/"+strOwner
	window.location= url;
}