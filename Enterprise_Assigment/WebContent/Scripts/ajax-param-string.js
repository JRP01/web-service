function makeParamString(format) {
  var paramString =
    "format=" + format;
  return(paramString);
}
function makeParamStringDelete(id) {
	  var paramString =
	    "id=" + id;
	  return(paramString);
	}


function makeParamStringSearch(id,format) {
	  var paramString =
		"id=" + getValue(id)
	    "&format=" + format;
	  return(paramString);
	}

function makeParamStringinsert(json) {
	  var paramString =
	    "json=" + json;
	  return(paramString);
	}

function makeParamupdate(id,format) {
	  var paramString =
		"id=" + id
	    "&json=" + format;
	  return(paramString);
	}


