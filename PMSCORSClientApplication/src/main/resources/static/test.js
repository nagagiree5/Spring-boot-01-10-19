$(document).ready(function(){
	$.ajax({
		url: "http://localhost:4343/PMS/product/6666",
		type: "GET"
		
	}).then(function(data,status,xhr){
		var obj =JSON.parse(JSON.stringify(data))
		$("#id1").html(obj.productId)
		$("#id2").html(obj.productName)
		$("#id3").html(obj.price)
		$("#id4").html(obj.manufacturer)
	
		
		
	})
})
    