<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<body>
	<!-- Categories Section Begin -->
	<section class="categories">
		<div class="container">
			<div class="row">
				<div class="categories__slider owl-carousel">
					<c:forEach items="${cList}" var="c">
						<div class="col-lg-3">
							<div class="categories__item set-bg"
								data-setbg="<c:url value="/image?fname=${c.image}"/>">
								<h5>
									<a href="category?cid=${c.id}">${c.name}</a>
								</h5>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>
		</div>
	</section>
	<!-- Categories Section End -->

	<!-- Featured Section Begin -->
	<section class="featured spad">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<div class="section-title">
						<h2>Sản phẩm</h2>
					</div>
				</div>
			</div>
			<div id="content" class="row featured__filter">
				<c:forEach items="${pList}" var="p">
					<div class="col-lg-3 col-md-4 col-sm-6 productP">
						<div class="featured__item">
							<div class="featured__item__pic set-bg"
								data-setbg="<c:url value="/image?fname=${p.image}"/>">
								<ul class="featured__item__pic__hover">
									<li><a href="addCart?pid=${p.id}"><i class="fa fa-shopping-cart"></i></a></li>
								</ul>
							</div>
							<div class="featured__item__text">
								<h6>
									<a href="detail?pid=${p.id}">${p.name}</a>
								</h6>
								<h5>${p.tienTe(p.price)}</h5>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</section>
	<!-- Featured Section End -->

	<!-- Banner Begin -->
	<div class="banner">
		<div class="container">
			<div class="row">
				<div class="col-lg-6 col-md-6 col-sm-6">
					<div class="banner__pic">
						<img src="<c:url value="/template/img/banner1.png"/>"
							alt="">
					</div>
				</div>
				<div class="col-lg-6 col-md-6 col-sm-6">
					<div class="banner__pic">
						<img src="<c:url value="/template/img/banner2.png"/>"
							alt="">
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Banner End -->

	<!-- Latest Product Section Begin -->
	<section class="latest-product spad">
		<div class="container">
			<div class="row">
				<div class="col-lg-6 col-md-6">
					<div class="latest-product__text">
						<h4>Sản phẩm mới</h4>
						<div class="latest-product__slider owl-carousel">
							<div class="latest-prdouct__slider__item">
								<c:forEach items="${pList3Lastest}" var="p3l">
									<a href="detail?pid=${p3l.id}" class="latest-product__item">
										<div class="latest-product__item__pic">
											<img src="<c:url value="/image?fname=${p3l.image}"/>" alt="">
										</div>
										<div class="latest-product__item__text">
											<h6>${p3l.name}</h6>
											<span>${p3l.tienTe(p3l.price)}</span>
										</div>
									</a>
								</c:forEach>

							</div>
							<div class="latest-prdouct__slider__item">
								<c:forEach items="${pList3_6Lastest}" var="p3_6l">
									<a href="detail?pid=${p3_6l.id}" class="latest-product__item">
										<div class="latest-product__item__pic">
											<img src="<c:url value="/image?fname=${p3_6l.image}"/>" alt="">
										</div>
										<div class="latest-product__item__text">
											<h6>${p3_6l.name}</h6>
											<span>${p3_6l.tienTe(p3_6l.price)}</span>
										</div>
									</a>
								</c:forEach>
							</div>
						</div>
					</div>
				</div>
				
				<div class="col-lg-6 col-md-6">
					<div class="latest-product__text">
						<h4>Bán chạy</h4>
						<div class="latest-product__slider owl-carousel">
							<div class="latest-prdouct__slider__item">
								<c:forEach items="${pList3BestSeller}" var="p3b">
									<a href="detail?pid=${p3b.id}" class="latest-product__item">
										<div class="latest-product__item__pic">
											<img src="<c:url value="/image?fname=${p3b.image}"/>" alt="">
										</div>
										<div class="latest-product__item__text">
											<h6>${p3b.name}</h6>
											<span>${p3b.tienTe(p3b.price)}</span>
										</div>
									</a>
								</c:forEach>

							</div>
							<div class="latest-prdouct__slider__item">
								<c:forEach items="${pList3_6BestSeller}" var="p3_6b">
									<a href="detail?pid=${p3_6b.id}" class="latest-product__item">
										<div class="latest-product__item__pic">
											<img src="<c:url value="/image?fname=${p3_6b.image}"/>" alt="">
										</div>
										<div class="latest-product__item__text">
											<h6>${p3_6b.name}</h6>
											<span>${p3_6b.tienTe(p3_6b.price)}</span>
										</div>
									</a>
								</c:forEach>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- Latest Product Section End -->

</body>