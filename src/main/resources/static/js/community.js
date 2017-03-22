function community(){
	var e = document.getElementById("SelectCommunity");
	var strCommunity = e.options[e.selectedIndex].value;
	var url = "/communityPage/"+strCommunity
	window.location= url;
}