function getfilmTable(rows) {
  var headings = 
    [ "id", "title", "year", "director", "stars", "review"];
  return(getTable(headings, rows));
}

function xmlfilmTable(resultRegion) {
  var address = "SelectAll";
  var data = makeParamString("xml");
  ajaxPost(address, data, 
           function(request) { 
             showResponseText(request, resultRegion); 
           });
}


function xmlSearchFilm(resultRegion,id) {
	  var address = "SelectById";
	  var data = makeParamStringSearch(id,"xml");
	  ajaxPost(address, data, 
	           function(request) { 
	             showResponseText(request, resultRegion); 
	           });
	}

function showResponseText(request, resultRegion) {
	  if ((request.readyState == 4) &&
	      (request.status == 200)) {
	    htmlInsert(resultRegion, request.responseText);
	} }




function jsonfilmTable(resultRegion) {
	  var address = "SelectAll";
	  var data = makeParamString("json");
	  ajaxPost(address, data, 
	           function(request) { 
		  showResponseText(request, resultRegion); 
	           });
	}

function jsonSearchFilm(resultRegion,id) {
	  var address = "SelectById";
	  var data = makeParamStringSearch(id,"json");
	  ajaxPost(address, data, 
	           function(request) { 
	             showResponseText(request, resultRegion); 
	           });
	}

	
	
	
	
	
	
	function stringFilmTable(resultRegion) {
		  var address = "SelectAll";
		  var data = makeParamString("");
		  ajaxPost(address, data, 
		           function(request) { 
			  	showResponseText(request, resultRegion); 
		           });
		}
	
	function stringSearchFilm(resultRegion,id) {
		  var address = "SelectById";
		  
		  var data = makeParamStringSearch(id,"");
		  console.log(id)
		  ajaxPost(address, data, 
		           function(request) { 
		             showResponseText(request, resultRegion); 
		           });
		}
	function filmdelete(resultRegion){
		var address="DeletebyID";
		var x = document.getElementById("delete").value;
		
		 var data = makeParamStringDelete(x);
		 console.log(x)
		  ajaxPost(address, data, 
		           function(request) { 
		             showResponseText(request, resultRegion); 
		           });
		
		
	}
	function insertFilm(resultRegion) {
		  var address = "insert";
		  var x = document.getElementById("json").value;
		  
		  var jsondata = encodeURI(x);
		  console.log(x);
		  console.log(jsondata);
		  var data = makeParamStringinsert(jsondata);
		  ajaxPost(address, data, 
		           function(request) { 
		             showResponseText(request, resultRegion); 
		           });
		}
	function updateFilm(resultRegion) {
		  var address = "Update";
		  var x = document.getElementById("updatejson").value;
		  var y = document.getElementById("updateID").value;
		  
		  var jsondata = encodeURI(x);
		  console.log(jsondata);
		  
		  
		  var data = makeParamupdate(y,jsondata);
		  console.log(data);
		 var test= data+"&json="+jsondata;
		 console.log(test);
		  ajaxPost(address, test, 
		           function(request) { 
		             showResponseText(request, resultRegion); 
		           });
		}
	
	
	
	

