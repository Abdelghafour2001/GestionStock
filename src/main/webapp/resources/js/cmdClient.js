$(document).ready(function(){
	$("#deletedmsg").hide("slow",function(){$("#deletedmsg").hide()});
	$("#choseclmsg").hide("slow",function(){$("#choseclmsg").hide()});
	$("#codeArticle_search").on("keypress",function(e){
		if(e.keyCode==13){
			var codeArticle=$("#codeArticle_search").val();
				if(verifierClient() && codeArticle){
			searchArticle(codeArticle);
			}			
		}
	});
	
	$("#listeClients").on("change",function(e){
		if(verifierClient()){
			creerCommande($("#listeClients option:selected").val());
		}
	})
});
// /////////////////////////////
function verifierClient(){
	var idClient = $("#listeClients option:selected").val();
	if(idClient){
		if(idClient === "-1"){
			$("#choseclmsg").show("slow",function(){$("#choseclmsg").show()});
			return false;
		}
		$("#choseclmsg").hide("slow",function(){$("#choseclmsg").hide()});
		return true;
	}
	
}

function creerCommande(idClient){
	
	if(idClient){
	$.getJSON("creerCommande", {
		idClient: idClient,
		ajax:true
	},function(data){
		if(data){
			console.log("client a ete maj");
			
		}
	});
	
	}

}


function updateDetails(id){
	var infos = $("#json"+id).text();
	$('#detailscmd > tbody ').empty();
	var obj = JSON.parse(infos);
	var lengthObj = obj.length;
	for(var i=0;i<lengthObj;i++){
		var Total = obj[i].article.prixUnitaireTTC *obj[i].quantite;
		$('#detailscmd > tbody ').append(`<tr><td>${obj[i].article.codeArticle}</td>
		<td>${obj[i].quantite}</td>
		<td>${obj[i].article.prixUnitaireTTC}</td>
		<td>${Total}</td></tr>`);
	}		
}
// ////////////17min------error 406 fix
function searchArticle(codeArticle){
if(codeArticle){
		var detailHtml="";
		
		$.getJSON("ajouterLigne",{codeArticle: codeArticle, ajax:true
	},
	function(data){
		if(data){
			
			var total = data.quantite * data.prixUnitaire;
			if($("#qte"+data.article.idArticle).length > 0 && $("#total"+data.article.idArticle).length > 0 ){
				$("#qte"+data.article.idArticle).text(data.quantite);
				$("#total"+data.article.idArticle).text(total);
			}else{
				detailHtml+=
					"<tr id='ligne"+data.article.idArticle+"'>"+
						"<td>"+ data.article.codeArticle +"</td>"+
						"<td id='qte"+data.article.idArticle+"'>"+ data.quantite +"</td>"+
						"<td>"+ data.article.prixUnitaireTTC +"</td>"+
						"<td id='total"+data.article.idArticle+"'>"+ total +"</td>"+
						"<td><button class='btn btn-danger' onclick='supprimerLigne("+data.article.idArticle+")'><i class='fas fa-trash'></i></button></td>"+
				"</tr>";
				$('#detailscmd > tbody ').append(detailHtml);
				$("#inexistant").hide("slow",function(){$("#inexistant").hide()});
				$("#deletedmsg").hide("slow",function(){$("#deletedmsg").hide()});
			}		
				
		}
		
	}).fail(function(){
		$("#inexistant").show("slow",function(){$("#inexistant").show()});
		$("#deletedmsg").hide("slow",function(){$("#deletedmsg").hide()});
	});
	
	}
}


function supprimerLigne(idArticle){
	if(idArticle){
		$.getJSON("supprimerLigne", {
			idArticle: idArticle,
			ajax:true
		},function(data){
			if(data){
				console.log("deleted");
				$("#ligne"+idArticle).hide("slow",function(){$("#ligne"+idArticle).hide()});
				$("#deletedmsg").show("slow",function(){$("#deletedmsg").show()});
			}
		});
		
		}
}




