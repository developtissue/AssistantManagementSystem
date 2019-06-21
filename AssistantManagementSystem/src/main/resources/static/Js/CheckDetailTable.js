$(document).ready(function() {	
	
	if ($('#status').val() == '录取') {
		$('#accepts').hide();
		$('#refuse').hide();
		$('#comment').attr("disabled",true);
	}
	$('#accepts').click(function(){
		var temp = $('#comment').val();
		var temp1 = $('#first-name').val();
		var urls = "http://localhost:8080/ModifyComment/"+"1/"+ temp1 +"/"+temp;			
		
		$.ajax({
			url: urls,
	       	type: 'POST'
	    }).then(function(data) {
	    	alert("修改成功！");
	    	window.location.href = "http://localhost:8080/CheckApplyTable";
	    });
		
	});
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