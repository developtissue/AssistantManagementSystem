$(document).ready(function() {	
	
	$('#refuse').click(function(){
		var temp = $('#comment').val();
		var temp1 = $('#first-name').val();
		var urls = "http://localhost:8080/ModifyComment/"+"2/"+ temp1 +"/"+temp;			
		
		$.ajax({
			url: urls,
	       	type: 'POST'
	    }).then(function(data) {
	    	alert("修改成功！");
	    	window.location.href = "http://localhost:8080/CheckApplyTable";
	    });
		
	}); 
	
});