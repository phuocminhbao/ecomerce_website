<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/user/taglib.jsp"%>
<title>Home</title>
<body>
	<!-- 
Body Section 
-->
	<div class="row">
		<div id="sidebar" class="span3">
			<div class="well well-small">
				<ul class="nav nav-list">
					<c:forEach var="item" items="${ category }">
						<li><a href='<c:url value="/items/${ item.id }"/>'><span
								class="icon-plus"></span> ${ item.name }</a></li>
						<li>
					</c:forEach>
					<li><a class="totalInCart" href="cart.html"><strong>Total
								Amount <span class="badge badge-warning pull-right"
								style="line-height: 18px;"><fmt:formatNumber
										type="number" groupingUsed="true" value="${ TotalPriceCart }" />
									$</span>
						</strong></a></li>
				</ul>
			</div>
		</div>

		<!--
New Products
-->
		<div class="well well-small">
			<h3>New Products</h3>
			<hr class="soften" />
			<div class="row-fluid">
				<div id="newProductCar" class="carousel slide">
					<div class="carousel-inner">
						<c:if test="${ newProducts.size() > 0 }">
							<div class="item active">
								<ul class="thumbnails">
									<c:forEach var="item" items="${ newProducts }" varStatus="loop">
										<li class="span3">
											<div class="thumbnail">
												<a class="zoomTool" href="productdetail/${ item.id_product }"
													title="add to cart"><span class="icon-search"></span>
													QUICK VIEW</a> <a href="productdetail/${ item.id_product }" class="tag"></a> <a
													href="productdetail/${ item.id_product }"><img
													src="<c:url value="/assets/user/img/${ item.img }"/>"
													alt=""></a>
											</div>
										</li>
										<c:if
											test="${ (loop.index + 1) % 4 == 0 || (loop.index + 1)  == newProducts.size() }">
								</ul>
							</div>
							<c:if test="${ (loop.index + 1) < newProducts.size() }">
								<div class="item">
									<ul class="thumbnails">
							</c:if>
						</c:if>
						</c:forEach>
						</c:if>

					</div>
					<a class="left carousel-control" href="#newProductCar"
						data-slide="prev">&lsaquo;</a> <a class="right carousel-control"
						href="#newProductCar" data-slide="next">&rsaquo;</a>
				</div>
			</div>
		</div>
		<!--
	Featured Products
	-->
		<div class="well well-small">
			<h3>
				<a class="btn btn-mini pull-right" href="products.html"
					title="View more">View More<span class="icon-plus"></span></a>
				Featured Products
			</h3>
			<hr class="soften" />
			<div class="row-fluid">
				<c:if test="${ highlightProducts.size() > 0 }">
					<!-- check if product size available or not, if yes open a ul -->
					<ul class="thumbnails">

						<c:forEach var="item" items="${ highlightProducts }"
							varStatus="loop">
							<li class="span4">
								<div class="thumbnail">
									<a class="zoomTool" href="productdetail/${ item.id_product }" title="add to cart"><span
										class="icon-search"></span> QUICK VIEW</a> <a
										href="productdetail/${ item.id_product }"><img
										src="<c:url value="/assets/user/img/${ item.img }"/>" alt=""></a>
									<div class="caption">
										<h5>${ item.name }</h5>
										<h4>
											<a class="shopBtn"
												href="<c:url value="/AddCart/${ item.id_product }"/>"
												title="add to cart"><span class="icon-plus"></span></a> <span
												class="pull-right"><fmt:formatNumber type="number"
													groupingUsed="true" value="${ item.price }" /> $</span>
										</h4>
									</div>
								</div>
							</li>
							<!-- index run from 0 to end, plus index with 1 to have a valid value -->
							<!-- if index + 1 devided by 3 with 0 reminder,or if it is the last item, it will close ul tag  -->
							<c:if
								test="${ (loop.index + 1) % 3 == 0 || (loop.index + 1)  == highlightProducts.size() }">
					</ul>
					<!-- if index + 1 lopp < size of product, open a new ul -->
					<c:if test="${ (loop.index + 1) < highlightProducts.size() }">
						<ul class="thumbnails">
					</c:if>
				</c:if>

				</c:forEach>

				</c:if>
			</div>
		</div>

		<hr>

	</div>
</body>

