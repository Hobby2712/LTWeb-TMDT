<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<body>
	<!-- Content Start -->
	<div class="content" style="background-color: #fff;">
		<nav
			class="navbar navbar-expand bg-white navbar-light sticky-top px-4 py-0"
			style="padding: 5px !important;">
			<a href="#" class="sidebar-toggler flex-shrink-0"> <i
				class="fa fa-bars"></i>
			</a>
		</nav>
		<!-- Navbar End -->
		<!-- Shoping Cart Section Begin -->
		<section class="shoping-cart spad" style="padding-top: 10px;">
			<div class="container">
				<div class="section-title product__discount__title"
					style="margin-bottom: 50px;">
					<h2>Đơn hàng</h2>
				</div>
				<div class="row">
					<div class="col-lg-12">
						<div class="featured__controls">
							<ul>
								<li class="active" data-filter="*">All(${count_all})</li>
								<c:forEach items="${sList}" var="s">
									<c:if test="${s.status == 1}">
										<li data-filter=".xacnhan">Chờ xác nhận(${s.count})</li>
									</c:if>
									<c:if test="${s.status == 6}">
										<li data-filter=".nhandon">Chờ nhận đơn(${s.count})</li>
									</c:if>
									<c:if test="${s.status == 2}">
										<li data-filter=".layhang">Chờ lấy hàng(${s.count})</li>
									</c:if>
									<c:if test="${s.status == 3}">
										<li data-filter=".danggiao">Đang giao(${s.count})</li>
									</c:if>
									<c:if test="${s.status == 4}">
										<li data-filter=".dagiao">Đã giao(${s.count})</li>
									</c:if>
									<c:if test="${s.status == 7}">
										<li data-filter=".trahang">Trả hàng(${s.count})</li>
									</c:if>
								</c:forEach>
							</ul>
						</div>
					</div>
				</div>
				<div class="row featured__filter">
					<div class="col-lg-12">
						<div class="shoping__cart__table">
							<table>
								<thead>
									<tr>
										<th class="shoping__product">Sản phẩm</th>
										<th>Thành tiền</th>
										<th>Tình trạng</th>
										<th>Thao tác</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${oList}" var="o">
										<c:if test="${o.status == 1}">
											<tr class="mix xacnhan">
												<td class="shoping__cart__item"
													style="width: 400px !important;"><img
													src="<c:url value="${o.p.image}"/>" alt="">
													<h5>${o.p.name}(x${o.count})</h5></td>
												<td class="shoping__cart__price">${o.p.tienTe(o.totalprice)}</td>
												<td class="shoping__cart__total">Chờ xác nhận</td>
												<td class="shoping__cart__total"><a
													href="/Web/seller/updateStatus?id=${o.id}&status=6">Xác
														nhận</a></td>
											</tr>
										</c:if>
										<c:if test="${o.status == 6}">
											<tr class="mix nhandon">
												<td class="shoping__cart__item"
													style="width: 400px !important;"><img
													src="<c:url value="${o.p.image}"/>" alt="">
													<h5>${o.p.name}(x${o.count})</h5></td>
												<td class="shoping__cart__price">${o.p.tienTe(o.totalprice)}</td>
												<td class="shoping__cart__total">Chờ nhận đơn</td>
												<td class="shoping__cart__total"></td>
											</tr>
										</c:if>
										<c:if test="${o.status == 2}">
											<tr class="mix layhang">
												<td class="shoping__cart__item"
													style="width: 400px !important;"><img
													src="<c:url value="${o.p.image}"/>" alt="">
													<h5>${o.p.name}(x${o.count})</h5></td>
												<td class="shoping__cart__price">${o.p.tienTe(o.totalprice)}</td>
												<td class="shoping__cart__total">Chờ lấy hàng</td>
												<td class="shoping__cart__total"></td>
											</tr>
										</c:if>
										<c:if test="${o.status == 3}">
											<tr class="mix danggiao">
												<td class="shoping__cart__item"
													style="width: 400px !important;"><img
													src="<c:url value="${o.p.image}"/>" alt="">
													<h5>${o.p.name}(x${o.count})</h5></td>
												<td class="shoping__cart__price">${o.p.tienTe(o.totalprice)}</td>
												<td class="shoping__cart__total">Đang giao</td>
												<td class="shoping__cart__total"></td>
											</tr>
										</c:if>
										<c:if test="${o.status == 4}">
											<tr class="mix dagiao">
												<td class="shoping__cart__item"
													style="width: 400px !important;"><img
													src="<c:url value="${o.p.image}"/>" alt="">
													<h5>${o.p.name}(x${o.count})</h5></td>
												<td class="shoping__cart__price">${o.p.tienTe(o.totalprice)}</td>
												<td class="shoping__cart__total">Đã giao</td>
												<td class="shoping__cart__total"></td>
											</tr>
										</c:if>
										<c:if test="${o.status == 7}">
											<tr class="mix trahang">
												<td class="shoping__cart__item"
													style="width: 400px !important;"><img
													src="<c:url value="${o.p.image}"/>" alt="">
													<h5>${o.p.name}(x${o.count})</h5></td>
												<td class="shoping__cart__price">${o.p.tienTe(o.totalprice)}</td>
												<td class="shoping__cart__total">Trả hàng</td>
												<td class="shoping__cart__total"></td>
											</tr>
										</c:if>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
		</section>
	</div>
</body>

