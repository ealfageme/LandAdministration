function owner(){
	var e = document.getElementById("SelectOwner");
	var strOwner = e.options[e.selectedIndex].value;
	window.location.href= "/ownerPage/"+strOwner;
}