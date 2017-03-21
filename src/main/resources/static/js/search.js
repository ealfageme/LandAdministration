$(document).on('change', 'select', function() {
     // the selected options’s value

    // if you want to do stuff based on the OPTION element:
    var opt = $(this).find('option:selected')[0];
    
    switch($(this).val()) {
    case "portalNumberFloor":
    	$("#option1").show();
    	$("#option2").show();
    	$('#text1').text('Portal Number');
    	$('#text2').text('Floor');
        break;
    case "wholeCommunity":
    	$("#option1").hide();
    	$("#option2").hide();
    	$('#text1').text('');
    	$('#text2').text('');
        break;
    case "portalNumber":
    	$("#option1").show();
    	$("#option2").hide();
    	$('#text1').text('Portal Number');
    	$('#text2').text('');
        break;
    case "surname":
    	$("#option1").show();
    	$("#option2").hide();
    	$('#text1').text('Surname');
    	$('#text2').text('');
        break;
    case "DNI":
    	$("#option1").show();
    	$("#option2").hide();
    	$('#text1').text('DNI');
    	$('#text2').text('');
        break;
    default:
    	console.log($(this).val());
    }
});

$( document ).ready(function() {
	$("#option2").hide();
	$('#text1').text('Portal Number');
});