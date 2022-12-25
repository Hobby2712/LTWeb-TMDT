<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<body>
	<!-- Breadcrumb Section Begin -->
	<section class="breadcrumb-section set-bg"
		data-setbg="<c:url value="/template/img/breadcrumb.jpg"/>">
		<div class="container">
			<div class="row">
				<div class="col-lg-12 text-center">
					<div class="breadcrumb__text">
						<h2>Shopping Cart</h2>
						<div class="breadcrumb__option">
							<a href="<c:url value="/home"/>">Home</a> <span>Shopping
								Cart</span>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- Breadcrumb Section End -->

	<!-- Shoping Cart Section Begin -->
	<section class="shoping-cart spad">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<div class="shoping__cart__table">
						<table>
							<thead>
								<tr>
									<th class="shoping__product">Products</th>
									<th>Price</th>
									<th>Quantity</th>
									<th>Total</th>
									<th></th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${cartList}" var="cart">

									<tr>
										<td class="shoping__cart__item"><img
											src="<c:url value="/image?fname=${cart.p.image}"/>" alt="">
											<h5>${cart.p.name}</h5></td>
										<td class="shoping__cart__price">
											${cart.p.tienTe(cart.p.price)}</td>
										<td class="shoping__cart__quantity">
											<div class="quantity">
												<div class="pro-qty">
													<input type="text" class="prodcount" value="${cart.count}">
													<input type="hidden" class="prodid" value="${cart.p.id}">
												</div>
											</div>
										</td>
										<td class="shoping__cart__total">
										<p id="total_price" style="font-size: 18px;
    																color: #1c1c1c;
    																font-weight: 700;
    																width: 110px">
											${cart.p.tienTe(cart.totalprice)}
											</p></td>
										<td class="shoping__cart__item__close"><a href="deleteCart?pid=${cart.p.id}"><span
											class="icon_close"></span></a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-12">
					<div class="shoping__cart__btns">
						<a href="/Web/shop?index=1" class="primary-btn cart-btn">CONTINUE SHOPPING</a> 
					</div>
				</div>
				<div class="col-lg-6">
					<div class="shoping__checkout">
						<h5>Cart Total</h5>
						<ul>
							<li>Total <span id="total">${totalP}</span></li>
						</ul>
						<a href="checkout" class="primary-btn">PROCEED TO CHECKOUT</a>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- Shoping Cart Section End -->

</body>

</html>