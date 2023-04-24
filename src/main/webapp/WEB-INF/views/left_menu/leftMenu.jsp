 <%@ include file="/WEB-INF/views/includes/includes.jsp" %>

<ul
	class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion"
	id="accordionSidebar">

	<!-- Sidebar - Brand -->
	<a
		class="sidebar-brand d-flex align-items-center justify-content-center"
		href="${home}">
		<div class="sidebar-brand-icon rotate-n-15">
			<i class="fas fa-shopping-basket"></i>
		</div>
		<div class="sidebar-brand-text mx-3">
			GESTION <sup>stock</sup>
		</div>
	</a>

	<!-- Divider -->
	<hr class="sidebar-divider my-0">
<c:url value="/home/" var="home"></c:url>
	<!-- Nav Item - Dashboard -->
	<li class="nav-item"><a class="nav-link" href="${home}"> <i
			class="fas fa-fw fa-tachometer-alt"></i> <span><fmt:message key="common.dashboard"/></span></a></li>

	<!-- Divider -->
	<hr class="sidebar-divider">
	

	<!-- Heading -->
	<div class="sidebar-heading">Informations</div>
<c:url value="/article/" var="article"></c:url>
	<!-- Nav Item - Pages Collapse Menu -->
	<li class="nav-item"><a class="nav-link " href="${article }"
		data-toggle="" data-target="#collapseTwo" aria-expanded="true"
		aria-controls=""> <i class="fas fa-fw fa-shopping-basket"></i> <span><fmt:message key="common.article"/></span>
	</a>
		</li>
<c:url value="/client/" var="client"></c:url>
	
		<li class="nav-item"><a class="nav-link collapsed" href="${client }"
		data-toggle="collapse" data-target="#collapseUtilities1"
		aria-expanded="true" aria-controls="collapseUtilities1"> <i
			class="fas fa-fw fa-users"></i> <span><fmt:message key="common.client"/></span>
	</a>
		<div id="collapseUtilities1" class="collapse"
			aria-labelledby="headingUtilities" data-parent="#accordionSidebar">
			<div class="bg-white py-2 collapse-inner rounded">
				<a class="collapse-item" href="${client }"><fmt:message key="common.client"/></a>
<c:url value="/cmdclient/" var="cmdclient"></c:url>
				<a class="collapse-item" href="${cmdclient }"><fmt:message key="common.client.commande"/></a>

			</div>
		</div></li>
	<c:url value="/fournisseur/" var="fournisseur"></c:url>
			<li class="nav-item"><a class="nav-link collapsed" href="${fournisseur }"
		data-toggle="collapse" data-target="#collapseUtilities"
		aria-expanded="true" aria-controls="collapseUtilities"> <i
			class="fas fa-fw fa-dolly"></i> <span><fmt:message key="common.fournisseur"/></span>
	</a>
	<div id="collapseUtilities" class="collapse"
			aria-labelledby="headingUtilities" data-parent="#accordionSidebar">
			<div class="bg-white py-2 collapse-inner rounded">
				<a class="collapse-item" href="${fournisseur }"><fmt:message key="common.fournisseur"/></a>
				<c:url value="/cmdfournisseur/" var="cmdfournisseur"></c:url>
				<a class="collapse-item" href="${cmdfournisseur }"><fmt:message key="common.fournisseur.commande"/></a>

			</div>
		</div></li>
	
	
	
	<!-- Divider -->
	<hr class="sidebar-divider">

<c:url value="/vente/" var="vente"></c:url>
	<!-- Nav Item - Charts -->
	<li class="nav-item"><a class="nav-link" href="${vente }"> <i
			class="fas fa-fw fa-chart-area"></i> <span><fmt:message key="common.vente"/></span></a></li>
<c:url value="/stock/" var="stock"></c:url>
	<!-- Nav Item - Tables -->
	<li class="nav-item"><a class="nav-link" href="${stock }"> <i
			class="fas fa-fw fa-table"></i> <span><fmt:message key="common.stock"/></span></a></li>

	<!-- Divider -->
	<hr class="sidebar-divider d-none d-md-block">

<!-- Nav Item - Utilities Collapse Menu -->
	<li class="nav-item"><a class="nav-link collapsed" href="#"
		data-toggle="collapse" data-target="#collapseUtilities2"
		aria-expanded="true" aria-controls="collapseUtilities2"> <i
			class="fas fa-fw fa-cog"></i> <span><fmt:message key="common.parametrage"/></span>
	</a>
		<div id="collapseUtilities2" class="collapse"
			aria-labelledby="headingUtilities" data-parent="#accordionSidebar">
			<div class="bg-white py-2 collapse-inner rounded">
				<h6 class="collapse-header">Modifier :</h6>
				<c:url value="/utilisateur/" var="user"></c:url>
				<a class="collapse-item" href="${user }"><fmt:message key="common.parametrage.utilisateur"/></a> 
				<c:url value="/categories/" var="category"></c:url>
				<a class="collapse-item" href="${category }"><fmt:message key="common.parametrage.category"/></a> 

			</div>
		</div></li>
	<!-- Divider -->
	<hr class="sidebar-divider d-none d-md-block">

	<!-- Sidebar Toggler (Sidebar) -->
	<div class="text-center d-none d-md-inline">
		<button class="rounded-circle border-0" id="sidebarToggle"></button>
	</div> 

</ul>