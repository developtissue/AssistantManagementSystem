$(document).ready(function() {	
		
	$('#submits').click(function(){
		
		var temp = $('#course').val();
		var temp1 = $('#require').val();
		var urls = "http://localhost:8080/Post/"+ temp1 +"/"+temp;			
		
		$.ajax({
			url: urls,
	       	type: 'POST'
	    }).then(function(data) {
	    	alert("修改成功！");
	    	window.location.reload();
	    });
		
	}); 
	
	
});