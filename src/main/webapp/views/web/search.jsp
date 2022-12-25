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
					<div class="breadcrumb__text" id="breadcrumb_text_change">
						<h2>NKD Shop</h2>
						<div class="breadcrumb__option">
							<a href="<c:url value="/home"/>">Home</a> <span>Search</span>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- Breadcrumb Section End -->

	<!-- Product Section Begin -->
	<section class="product spad">
		<div class="container">
			<div class="row">
				<div class="col-lg-3 col-md-5">
					<div class="sidebar">
						<div class="sidebar__item">
							<div class="latest-product__text">
								<h4>Hàng mới</h4>
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
					</div>
				</div>
				<div class="col-lg-9 col-md-7">
					<div class="product__discount"
						style="padding-bottom: 0px !important">
						<div class="section-title product__discount__title">
							<h2>Kết quả tìm kiếm</h2>
						</div>
					</div>
					<div class="filter__item">
						<div class="row">
							<div class="col-lg-4 col-md-5"></div>
							<div class="col-lg-4 col-md-4">
								<div class="filter__found">
									<h6>
										<span>${count}</span> Products found
									</h6>
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<c:forEach items="${pList}" var="p">
							<div class="col-lg-4 col-md-6 col-sm-6">
								<div class="product__item">
									<div class="product__item__pic set-bg"
										data-setbg="<c:url value="/image?fname=${p.image}"/>">
										<ul class="product__item__pic__hover">
											<li><a href="addCart?pid=${p.id}"><i class="fa fa-shopping-cart"></i></a></li>
										</ul>
									</div>
									<div class="product__item__text">
										<h6>
											<a href="detail?pid=${p.id}">${p.name}</a>
										</h6>
										<h5>${p.tienTe(p.price)}đ</h5>
									</div>
								</div>
							</div>
						</c:forEach>
					</div>
					<div class="product__pagination">
						<c:if test="${tag>1}">
							<c:if test="${tag>16}">
								<a href="search?index=1&txt=${txtSearch}"><<</a>
							</c:if>
							<a href="search?index=${tag-1}&txt=${txtSearch}"><</a>
						</c:if>
						<c:forEach begin="1" end="${endPage}" var="i">
							<a class="${tag == i ?"
								active":""}" href="search?index=${i}&txt=${txtSearch}">${i}</a>
						</c:forEach>
						<c:if test="${tag<endPage}">
							<a href="search?index=${tag+1}&txt=${txtSearch}">></a>
							<c:if test="${tag<endPage-16}">
								<a href="search?index=${endPage}&txt=${txtSearch}">>></a>
							</c:if>
						</c:if>

					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- Product Section End -->
</body>

</html>