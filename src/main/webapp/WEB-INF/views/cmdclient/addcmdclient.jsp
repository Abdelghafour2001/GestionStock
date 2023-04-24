<%@ include file="/WEB-INF/views/includes/includes.jsp"%>
<!DOCTYPE html>
<html lang="fr">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Ajouter Commande</title>

<!-- Custom fonts for this template-->
<link
	href="<%=request.getContextPath()%>/resources/vendor/fontawesome-free/css/all.min.css"
	rel="stylesheet" type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">

<!-- Custom styles for this template-->
<link
	href="<%=request.getContextPath()%>/resources/css/sb-admin-2.min.css"
	rel="stylesheet">

</head>

<body id="page-top">

	<!-- Page Wrapper -->
	<div id="wrapper">

		<!-- Sidebar -->
		<%@ include file="/WEB-INF/views/left_menu/leftMenu.jsp"%>
		<!-- End of Sidebar -->

		<!-- Content Wrapper -->
		<div id="content-wrapper" class="d-flex flex-column">

			<!-- Main Content -->
			<div id="content">

				<!-- Topbar -->
				<%@ include file="/WEB-INF/views/top_menu/topMenu.jsp"%>
				<!-- End of Topbar -->

				<!-- Begin Page Content -->
				<div class="container-fluid">
					<!-- Page Heading -->
					<h1 class="h3 mb-4 text-gray-800">Commandes Clients</h1>
				</div>
				<div class="card shadow mb-6" style="margin: 0px 40px">
					<div class="card-header py-3">
						<h6 class="m-0 font-weight-bold text-primary">Nouvelle
							Commande</h6>
					</div>
					<!-- /.container-fluid -->
					<div class="card-body " style="margin: 0px 20px">
						<c:url value="/cmdclient/enregistrer" var="urlnewcmd"/>
						<form modelAttribute="client" action="${urlnewcmd}"
							enctype="multipart/form-data">
							<div class="form-row">
								<div class="col-md-4 mb-3">
									<label for="code" class="form-label"><fmt:message
											key="common.code" /></label> <input type="text" class="form-control"
										id="code" value="${codeCde}" disabled />
								</div>
								<div class="col-md-4 mb-3">
									<label for="date" class="form-label">Date Commande</label> <input
										type="text" class="form-control" id="date"
										placeholder="Date Commande" value="${dateCde}" disabled />
								</div>
								<div class="col-md-4 mb-3">
									<label><fmt:message key="common.client" /></label> <select
										class="form-control" id="listeClients">
										<option value="-1">Selectionnez un client</option>
										<c:forEach items="${clients }" var="clt">
											<option value="${clt.getIdClient() }">${clt.getNom() }</option>
										</c:forEach>
									</select>
								</div>
							</div>
							<div class="panel-footer">
								<button type="submit" class="btn btn-primary">
									<i class="fas fa-save">&nbsp;<fmt:message
											key="common.enregistrer" /></i>
								</button>
								<button type="reset" class="btn btn-danger">
									<i class="fas fa-undo">&nbsp;<fmt:message
											key="common.annuler" /></i>
								</button>
								
						</form>
						<div class="alert alert-warning" role="alert" id="choseclmsg">Veuillez
									Choisir un client d'abord!</div>
							</div>
					</div>
					<br> 
					<div class="card shadow mb-4">
						<div class="card-header py-3">
							<h6 class="m-0 font-weight-bold text-primary">Détails de la
								commmande</h6>

						</div>
						<div class="card-body">
							<div class="form-row">
								<div class="col-md-4 mb-3">
									<label>Code Article</label> <input type="text"
										id="codeArticle_search" class="form-control"
										placeholder="Saisir un code d'article" />
								</div>
								<div class="col-md-4 mb-3" id="inexistant">
									<label style="color: red">Article inexistant</label>
								</div>
								<div class="alert alert-primary" role="alert" id="deletedmsg">
									Article bien supprimé!</div>
							</div>
							<br>

							<div class="table-responsive">
								<table class="table table-bordered" id="detailscmd" width="100%"
									cellspacing="0">
									<thead>
										<tr>
											<th>Article</th>
											<th>Quantite</th>
											<th>Prix Unitaire TTC</th>
											<th>Total</th>
											<th>Action</th>
										</tr>
									</thead>

									<tbody>

									</tbody>
								</table>
							</div>
						</div>
					</div>

				</div>

			</div>

			<!-- End of Main Content -->

			<!-- Footer -->
			<footer class="sticky-footer bg-white">
				<div class="container my-auto">
					<div class="copyright text-center my-auto">
						<span>Copyright &copy; Gestion Stock 2021</span>
					</div>
				</div>
			</footer>
			<!-- End of Footer -->

		</div>
		<!-- End of Content Wrapper -->

	</div>
	<!-- End of Page Wrapper -->

	<!-- Scroll to Top Button-->
	<a class="scroll-to-top rounded" href="#page-top"> <i
		class="fas fa-angle-up"></i>
	</a>


	<!-- Bootstrap core JavaScript-->
	<script
		src="<%=request.getContextPath()%>/resources/vendor/jquery/jquery.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

	<!-- Core plugin JavaScript-->
	<script
		src="<%=request.getContextPath()%>/resources/vendor/jquery-easing/jquery.easing.min.js"></script>

	<!-- Custom scripts for all pages-->
	<script
		src="<%=request.getContextPath()%>/resources/js/sb-admin-2.min.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/cmdClient.js"></script>
</body>

</html>