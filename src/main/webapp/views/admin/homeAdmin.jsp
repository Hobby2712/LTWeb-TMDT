<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="content" style="background-color: #fff;">
	<section class="featured spad" style="padding-top: 10px;">
		<div class="container">
			<!-- Navbar End -->
			<div class="section-title product__discount__title"
				style="margin-bottom: 50px; margin-top: 20px;">
				<h2>Doanh số theo năm</h2>
			</div>

			<div class="form-group row">
				<div class="col-sm-2">
					<select class="form-control" id="nam_thong_ke"
						style="padding-top: 0 !important;">
						<c:forEach items="${yearSelect}" var="y">
							<c:if test="${y==yearIndex}">
								<option selected="selected">${y}</option>
							</c:if>
							<c:if test="${y!=yearIndex}">
								<option>${y}</option>
							</c:if>
						</c:forEach>
					</select>
				</div>
			</div>

			<script>
	                    var input = document.getElementById('nam_thong_ke')
	                        input.change = function () {
	                            var nam = input.options[input.selectedIndex].text;
	                            if (nam != '0') {
	                                var x = '/Web/admin/homeAdmin?year=' + nam;
	                                console.log(x);
	                                location.href = x;
	                            }
	                        }
	            </script>


			<div>
				<canvas id="mychart2"></canvas>
			</div>
			<div class="section-title product__discount__title"
				style="margin-bottom: 50px; margin-top: 50px;">
				<h2>Thống kê</h2>
			</div>
			<div class="col-lg-12" style="margin: auto;">
				<div class="shoping__cart__table">
					<table>
						<thead>
							<tr>
								<th>Store</th>
								<th>Tháng</th>
								<th>Doanh thu</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${tList}" var="t">
								<tr>
									<td class="shoping__cart__price">${t.store}</td>
									<td class="shoping__cart__price">Tháng ${t.month}</td>
									<td class="shoping__cart__price">${t.tienTe(t.total)}</td>
								</tr>
							</c:forEach>

						</tbody>
					</table>
				</div>
			</div>
			<c:if test="${endPage>1}">
				<div class="product__pagination">
					<c:if test="${tag>1}">
						<c:if test="${tag>16}">
							<a href="homeAdmin?index=1&year=${yearIndex}"><<</a>
						</c:if>
						<a href="homeAdmin?index=${tag-1}&year=${yearIndex}"><</a>
					</c:if>
					<c:forEach begin="1" end="${endPage}" var="i">
						<a class="${tag == i ?"
							active":""}" href="homeAdmin?index=${i}&year=${yearIndex}">${i}</a>
					</c:forEach>
					<c:if test="${tag<endPage}">
						<a href="homeAdmin?index=${tag+1}&year=${yearIndex}">></a>
						<c:if test="${tag<endPage-16}">
							<a href="homeAdmin?index=${endPage}&year=${yearIndex}">>></a>
						</c:if>
					</c:if>

				</div>
			</c:if>

		</div>
	</section>
</div>
<script src="<c:url value="/template/js/chart.js" />"></script>
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<script>
	let info = [], label = [];
	<c:forEach items="${chart}" var="c">
		info.push(${c.total})
		label.push('${c.store}')
	</c:forEach>
	window.onload = function() {
		drawChart2("mychart2", info, label)
	}
</script>