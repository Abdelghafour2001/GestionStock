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

<title>Article</title>
<link
	href="<%=request.getContextPath()%>/resources/vendor/datatables/dataTables.bootstrap4.min.css"
	rel="stylesheet">
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
						<fmt:message key="common.article"></fmt:message>
					</h1>
					<!-- DataTales Example -->


					<nav aria-label="breadcrumb" style="-bs-breadcrumb-divider: none;">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a
								href="<c:url value="/article/new"/>"><i class="fas fa-plus"><fmt:message
											key="common.ajouter" /></i></a></li>
							<li class="breadcrumb-item"><a href="#"><i
									class="fas fa-upload"><fmt:message key="common.exporter" /></i></a></li>
							<li class="breadcrumb-item"><a href="#"><i
									class="fas fa-download"><fmt:message key="common.importer" /></i></a></li>
						</ol>
					</nav>

					<div class="card shadow mb-4">
						<div class="card-header py-3">
							<h6 class="m-0 font-weight-bold text-primary">
								<fmt:message key="common.listearticle" />
							</h6>
						</div>
						<div class="card-body">
							<div class="table-responsive">
								<table class="table table-bordered" id="dataTable" width="100%"
									cellspacing="0">
									<thead>
										<tr>
											<th><fmt:message key="common.code" /></th>
											<th><fmt:message key="common.design" /></th>
											<th><fmt:message key="common.pu" /></th>
											<th><fmt:message key="common.ptva" /></th>
											<th><fmt:message key="common.puttc" /></th>
											  	<th><fmt:message key="common.photo" /></th>
											<th><fmt:message key="common.action" /></th>

										</tr>
									</thead>
									<tfoot>
										<tr>
											<th><fmt:message key="common.code" /></th>
											<th><fmt:message key="common.design" /></th>
											<th><fmt:message key="common.pu" /></th>
											<th><fmt:message key="common.ptva" /></th>
											<th><fmt:message key="common.puttc" /></th>
											 <th><fmt:message key="common.photo" /></th>
											<th><fmt:message key="common.action" /></th>

										</tr>
									</tfoot>
									<tbody>
										<c:forEach items="${articles }" var="article">
											<tr>
												<td>${article.getCodeArticle() }</td>
												<td>${article.getDesignation() }</td>
												<td>${article.getPrixUnitaireHT() }</td>
												<td>${article.getPrixTVA() }</td>
												<td>${article.getPrixUnitaireTTC() }</td>
												 <td class="center"><img src="${article.getPhotos() }"
													width="75px" height="75px" /></td>
												<td>&nbsp;&nbsp; <c:url
														value="/article/modifier/${article.getIdArticle() }"
														var="editclurl" /> <a class="btn btn-primary"
													href="${editclurl }"><i class="fas fa-edit"></i></a> <c:url
														value="/article/supprimer/${article.getIdArticle() }"
														var="deleteclurl" /> <a class="btn btn-danger"
													data-toggle="modal"
													data-target="#deleteModal${article.getIdArticle() }"
													href="#"><i class="fas fa-trash-alt"></i></a></td>
												<!-- Delete modal -->
												<div class="modal fade"
													id="deleteModal${article.getIdArticle() }" tabindex="-1"
													role="dialog" aria-labelledby="exampleModalLabel1"
													aria-hidden="true">
													<div class="modal-dialog" role="document">
														<div class="modal-content">
															<div class="modal-header">
																<h5 class="modal-title" id="exampleModalLabel1">
																	<fmt:message key="common.confirmdel" />
																</h5>
																<button class="close" type="button" data-dismiss="modal"
																	aria-label="Close">
																	<span aria-hidden="true">x</span>
																</button>
															</div>
															<div class="modal-body">
																<fmt:message key="common.confirmdelmsg" />
															</div>
															<div class="modal-footer">
																<button class="btn btn-secondary" type="button"
																	data-dismiss="modal">
																	<fmt:message key="common.cancel" />
																</button>
																<a class="btn btn-danger" href="${deleteclurl}"><fmt:message
																		key="common.confirmer" /></a>
															</div>
														</div>
													</div>
												</div>

											</tr>
										</c:forEach>

									</tbody>
								</table>
							</div>
						</div>
					</div>

				</div>
				<!-- /.container-fluid -->


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
	<script
		src="<%=request.getContextPath()%>/resources/vendor/datatables/jquery.dataTables.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/vendor/datatables/dataTables.bootstrap4.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/js/demo/datatables-demo.js"></script>
</body>

</html>