$(document).ready(function(){
	$("#prixTVA").on("keyup",function(){
		tvaKeyUpFunction();
	})
});

tvaKeyUpFunction= function(){
	var puht= $("#prixUnitaireHT").val();
	var tauxtva= $("#prixTVA").val();
	var prixTTC = parseFloat(parseFloat(puht) * parseFloat(tauxtva)/100+parseFloat(puht));
	$("#prixUnitaireTTC").val(prixTTC);
}