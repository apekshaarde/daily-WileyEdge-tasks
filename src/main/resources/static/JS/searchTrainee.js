function searchData(str){
       var xhttp= new XMLHttpRequest();
        xhttp.onreadystatechange=function(){
        console.log("hellooo");
    		 	if(this.readyState==4 && this.status==200){
    		 	console.log("In function");
    		 		document.getElementById("result").innerHTML=this.responseText;
    		 	}
    	   };
    	   xhttp.open("GET","searchTrainee?txt="+str,true);
    	   xhttp.send();
}