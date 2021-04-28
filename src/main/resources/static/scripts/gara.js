



function rimuovere(name)
{
	
	if (confirm("Vuoi rimuovere la gara " + name + " ?")) {
		searchViaAjax(name);
	}

}


function prenota(id,email)
{
	
	if (confirm("Vuoi prenotare  la gara " + id + " ?")) {
		prenotaViaAjax(id,email);
	}

}


function prenotaViaAjax(id,email)
{
	$.ajax({
		type : "POST",
		beforeSend: function(xhr) {
		  	xhr.setRequestHeader("Accept", "application/json");
		  	xhr.setRequestHeader("Content-Type", "application/json");
		  },
		url : "/part/prenota?id="+id+"&email="+email,

		dataType : 'json',
		timeout : 100,
		success : function(data) {
			console.log(data);
		}
	});

	

}


//jQuery(document).ready(function($) {
//	
//
//	$("button").click(function(){
//		
//		searchViaAjax();;
//	});
//	
//});

function searchViaAjax(name)
{
	
	$.ajax({
		type : "DELETE",
		beforeSend: function(xhr) {
		  	xhr.setRequestHeader("Accept", "application/json");
		  	xhr.setRequestHeader("Content-Type", "application/json");
		  },
		  
		url : "/gara/delete?nome="+name,
		dataType : 'json',
		timeout : 100,
		success : function(data) {
			
			console.log(data);
		}
	});

}


function listPart(id)
{
	
	$.ajax({
		type : "GET",
		beforeSend: function(xhr) {
		  	xhr.setRequestHeader("Accept", "application/json");
		  	xhr.setRequestHeader("Content-Type", "application/json");
		  },
		  
		url : "/gara/listPartecipante?id="+id,
		dataType : 'json',
		timeout : 100,
		success : function(data) {
			
			console.log(data);
		}
	});

	

}

