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
						<h2>Chi tiết sản phẩm</h2>
						<div class="breadcrumb__option">
							<a href="<c:url value="/home"/>">Home</a> <span>Product
								Detail</span>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- Breadcrumb Section End -->

	<!-- Product Details Section Begin -->
	<section class="product-details spad">
		<div class="container">
			<div class="row">
				<div class="col-lg-6 col-md-6">
					<div class="product__details__pic">
						<div class="product__details__pic__item">
							<img class="product__details__pic__item--large"
								src="<c:url value="/image?fname=${detail.image}"/>" alt="">
						</div>
					</div>
				</div>
				<div class="col-lg-6 col-md-6">
					<div class="product__details__text">
						<input type="hidden" id="productid" value="${detail.id}">
						<h3>${detail.name}</h3>
						<div class="product__details__rating">
                            <span>(Đã bán: ${detail.sold})</span>
                        </div>
						<div class="product__details__price">${detail.tienTe(detail.price)}</div>
						<p>${detail.description.replace("
","<br>")}</p>
						<div class="product__details__quantity">
							<div class="quantity">
								<div class="pro-qtyd">
									<input type="text" id="quantityP" value="1">
								</div>
							</div>
						</div>
						<a onclick="addCart()" class="primary-btn"
							style="cursor: pointer;">ADD TO CARD</a>
					</div>
				</div>
			</div>
		</div>
	</section>
</body>

</html>