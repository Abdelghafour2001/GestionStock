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

<title>Ajouter Fournisseur</title>

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
					<h1 class="h3 mb-4 text-gray-800">
						<fmt:message key="common.fournisseur" />
					</h1>
				</div>
				<div class="card shadow mb-6" style="margin:0px 40px">
					<div class="card-header py-3">
						<h6 class="m-0 font-weight-bold text-primary">
							<fmt:message key="common.newfour" />
						</h6>
					</div>
					<!-- /.container-fluid -->
					<div class="card-body " style="margin:0px 20px">
					<c:url value="/fournisseur/enregistrer" var="urlnewfour"/>
						<f:form  modelAttribute="fournisseur" action="${urlnewfour }" method="POST" enctype="multipart/form-data">
							<div class="mb-3">
							<f:hidden path="idFournisseur" />
							<f:hidden path="photo" />
							</div>
							<div class="mb-3">
								<label for="nom" class="form-label"><fmt:message key="common.nom" /></label> 
								<f:input path="nom" type="text" class="form-control"
									id="nom" placeholder="Nom"/>
							</div>
							<div class="mb-3">
								<label for="prenom" class="form-label"><fmt:message key="common.prenom" /></label> 
								<f:input path="prenom" type="text" class="form-control"
									id="prenom" placeholder="Pr�nom"/>
							</div>
							<div class="mb-3">
								<label for="adresse" class="form-label"><fmt:message key="common.adresse" /></label> 
								<f:input path="adresse" type="text" class="form-control"
									id="adresse" placeholder="Adresse"/>
							</div>
							<div class="mb-3">
								<label for="mail" class="form-label"><fmt:message key="common.mail" /></label> 
								<f:input path="mail" type="email" class="form-control"
									id="mail" placeholder="example@xyz.abc"/>
							</div>
							<div class="mb-3">
								<label><fmt:message key="common.photo" /></label>
								<input type="file" name="file" />
							</div>
							<div class="panel-footer">
								<button type="submit" class="btn btn-primary"><i class="fas fa-save">&nbsp;<fmt:message key="common.enregistrer" /></i></button>
								<button type="reset" class="btn btn-danger"><i class="fas fa-undo">&nbsp;<fmt:message key="common.annuler" /></i></button>
							</div>
						</f:form>
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

	<!-- Logout Modal-->
	<!-- Logout Modal-->
	

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

</body>

</html>