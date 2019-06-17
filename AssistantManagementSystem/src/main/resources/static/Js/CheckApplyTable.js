$(document).ready(function() {	
	$('.checkoutBtn').click(function(){
		var urls = "http://localhost:8080/CheckDetailTable/" + $(this).data('id');		
		window.location.href = urls;
		
	});  
});