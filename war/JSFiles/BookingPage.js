
$(document).ready(function(){	
	
	//Generic ajax call function 
	var ajaxFun = function(url,dataValue,dataType)	{			
		  return $.ajax({
				
				url         :  url,
				data        :  dataValue,
				dataType    :  dataType,
				contentType :  'application/json',
				success     :  function(data){
								console.log("returned data" + data)
								return data;
				},
				failure     :  function(data){
					           return data;
				}
			 
				
			});	
	}
	
	//Making ajax call to server with company key	
	let companyKey = "2fe6f17d-d161-4de7-8ed5-46c53b3540d9";	
	var serviceValue =  ajaxFun('/bookingPage',companyKey,'json');
	
	
	//Getting the service name and appending it into the li element
	
	$.each(serviceValue, function(key,value){
	 		
		 var service       = serviceValue.services;
		 var serviceNameul = document.createElement('ul');	
		 serviceNameul.setAttribute('class','serviceNameul');
		 
		 $.each(service,function(k,v){						
			 
			 var serviceName        = v.service_name;	
			 serviceDuration        = v.duration;
			 serviceCost            = v.cost;
			 serviceKey             = v.key;
			 console.log("the value is " + JSON.stringify(serviceName)  +"   " + JSON.stringify(serviceDuration) + " " + JSON.stringify(serviceCost) + "service key" + JSON.stringify(serviceKey)); 
			
			   
			    var serviceli = document.createElement("li");
			    serviceli.setAttribute('class','serviceLiClass');
			    serviceli.appendChild(document.createTextNode(serviceName));
			   
			   				    		  			    
			    var servDurSpan = document.createElement('span');
			    servDurSpan.setAttribute('class','serviceDurSpan')
			    servDurSpan.appendChild(document.createTextNode(serviceDuration + "mins"));
			    serviceli.appendChild(servDurSpan);
			  			
			    
			    var serCostSpan = document.createElement('span');
			    serCostSpan.setAttribute('class','serCostSpan');
			    serCostSpan.appendChild(document.createTextNode(serviceCost + "rs"));
			    serviceli.appendChild(serCostSpan);
			   
			    var serviceDiv  = document.getElementById('serviceList');		
			    serviceNameul.appendChild(serviceli);
			    serviceDiv.append(serviceNameul);
			    
		 });
		 
		   		    
		  
	});
	 			  
	
	
});