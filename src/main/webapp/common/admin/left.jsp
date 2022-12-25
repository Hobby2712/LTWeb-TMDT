<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- Spinner Start -->
<div id="spinner"
	class="show bg-white position-fixed translate-middle w-100 vh-100 top-50 start-50 d-flex align-items-center justify-content-center">
	<div class="spinner-border text-primary"
		style="width: 3rem; height: 3rem;" role="status">
		<span class="sr-only">Loading...</span>
	</div>
</div>
<!-- Spinner End -->


<!-- Sidebar Start -->
<div class="sidebar pe-4 pb-3">
	<a href="index.html" class="navbar-brand mx-4 mb-3"> <img
		src="<c:url value="/template/img/logo1.png"/>" alt="">
	</a>
	<nav class="navbar bg-white navbar-light">
		<div class="navbar-nav w-100">
			<a href="/Web/admin/homeAdmin" class="nav-item nav-link"><i class="fa fa-bar-chart me-2" style="margin-right: 10px !important;"></i>Thống kê</a> 
			<a href="/Web/admin/ManagerAccount" class="nav-item nav-link"><i class="fa fa-address-book" style="margin-right: 10px !important;"></i>Quản lí tài khoản</a> 
			<a href="/Web/admin/ManagerCategory" class="nav-item nav-link"><i class="fa fa-list-alt" style="margin-right: 10px !important;"></i>Quản lý Category</a>
			<a href="/Web/admin/ManagerProduct" class="nav-item nav-link"><i class="fa fa-th me-2" style="margin-right: 10px !important;"></i>Quản lý Product</a> 
			<a href="/Web/logout" class="nav-item nav-link"><i class="fa fa-sign-out me-2" style="margin-right: 10px !important;"></i>LogOut</a>
		</div>
	</nav>
</div>