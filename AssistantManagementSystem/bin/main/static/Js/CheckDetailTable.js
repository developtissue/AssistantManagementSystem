$(document).ready(function() {	
	$('#btn').click(function(){
		var urls = "http://localhost:8080/CheckDetailTable/" + $(this).data('id');		
		window.location.href = urls;
		
	});  
});