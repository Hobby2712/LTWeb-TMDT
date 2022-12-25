<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<body>
	<!-- Featured Section Begin -->
	<section class="featured spad">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<div class="featured__controls">
						<ul>
							<li class="active" data-filter="*">All</li>
							<li data-filter=".xacnhan">Chờ xác nhận</li>
							<li data-filter=".layhang">Chờ lấy hàng</li>
							<li data-filter=".danggiao">Đang giao</li>
							<li data-filter=".dagiao">Đã giao</li>
							<li data-filter=".dahuy">Đã huỷ</li>
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
									<th>Số lượng</th>
									<th>Thành tiền</th>
									<th>Tình trạng</th>
									<th>Actions</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${oList}" var="o">
									<c:if test="${o.status == 1}">
										<tr class="mix xacnhan">
											<td class="shoping__cart__item"
												style="width: 400px !important;"><img
												src="<c:url value="${o.p.image}"/>" alt="">
												<h5>${o.p.name}</h5></td>
											<td class="shoping__cart__quantity">${o.count}</td>
											<td class="shoping__cart__price">${o.p.tienTe(o.totalprice)}</td>
											<td class="shoping__cart__total">Chờ xác nhận</td>
											<td class="shoping__cart__total"><a
												href="addCart?pid=${o.p.id}">Mua lại</a> <a
												href="/Web/updateStatusOrder?id=${o.id}&status=5"" >Huỷ
													đơn</a></td>

										</tr>
									</c:if>
									<c:if test="${o.status == 2}">
										<tr class="mix layhang">
											<td class="shoping__cart__item"
												style="width: 400px !important;"><img
												src="<c:url value="${o.p.image}"/>" alt="">
												<h5>${o.p.name}</h5></td>
											<td class="shoping__cart__quantity">${o.count}</td>
											<td class="shoping__cart__price">${o.p.tienTe(o.totalprice)}</td>
											<td class="shoping__cart__total">
											<td class="shoping__cart__total">Đang lấy hàng</td>
											<td class="shoping__cart__total"><a
												href="addCart?pid=${o.p.id}">Mua lại</a> <a
												href="/Web/updateStatusOrder?id=${o.id}&status=5"" >Huỷ
													đơn</a></td>
										</tr>
									</c:if>
									<c:if test="${o.status == 3}">
										<tr class="mix danggiao">
											<td class="shoping__cart__item"
												style="width: 400px !important;"><img
												src="<c:url value="${o.p.image}"/>" alt="">
												<h5>${o.p.name}</h5></td>
											<td class="shoping__cart__quantity">${o.count}</td>
											<td class="shoping__cart__price">${o.p.tienTe(o.totalprice)}</td>
											<td class="shoping__cart__total">Đang giao</td>
											<td class="shoping__cart__total"><a
												href="/Web/updateStatusOrder?id=${o.id}&status=8"" >Xác
													nhận lấy hàng</a><a href="addCart?pid=${o.p.id}">Mua lại</a></td>
										</tr>
									</c:if>
									<c:if test="${o.status == 4}">
										<tr class="mix dagiao">
											<td class="shoping__cart__item"
												style="width: 400px !important;"><img
												src="<c:url value="${o.p.image}"/>" alt="">
												<h5>${o.p.name}</h5></td>
											<td class="shoping__cart__quantity">${o.count}</td>
											<td class="shoping__cart__price">${o.p.tienTe(o.totalprice)}</td>
											<td class="shoping__cart__total">Đã giao</td>
											<td class="shoping__cart__total"><a
												href="addCart?pid=${o.p.id}">Mua lại</a></td>
										</tr>
									</c:if>
									<c:if test="${o.status == 5}">
										<tr class="mix dahuy">
											<td class="shoping__cart__item"
												style="width: 400px !important;"><img
												src="<c:url value="${o.p.image}"/>" alt="">
												<h5>${o.p.name}</h5></td>
											<td class="shoping__cart__quantity">${o.count}</td>
											<td class="shoping__cart__price">${o.p.tienTe(o.totalprice)}</td>
											<td class="shoping__cart__total">Đã huỷ</td>
											<td class="shoping__cart__total"><a
												href="addCart?pid=${o.p.id}">Mua lại</a></td>
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
	<!-- Featured Section End -->
</body>