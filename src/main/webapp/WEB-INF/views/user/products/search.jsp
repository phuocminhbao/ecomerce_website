<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/user/taglib.jsp"%>

<head>
<title>Items</title>
<style>
.pagination {
	display: flex;
	justify-content: center;
}

.pagination a {
	color: black;
	float: left;
	padding: 8px 16px;
	text-decoration: none;
	transition: background-color .3s;
	border: 1px solid #ddd;
}

.pagination a.active {
	background-color: #4CAF50;
	color: white;
	border: 1px solid #4CAF50;
}

.pagination a:hover:not (.active ) {
	background-color: #ddd;
	
}


</style>
</head>
<body>

	<div class="well well-small">
		<div class="row">
			<span style="margin-left: 25px;">Item lists</span> 
		</div>

		<c:if test="${ productSearch.size() > 0 }">
			<!-- check if product size available or not, if yes open a ul -->
			<div class="row-fluid">
				<ul class="thumbnails">

					<c:forEach var="item" items="${ productSearch }"
						varStatus="loop">
						<li class="span4">
							<div class="thumbnail">
								<a href="product_details.html" class="overlay"></a> <a
									class="zoomTool" href="product_details.html"
									title="add to cart"><span class="icon-search"></span> QUICK
									VIEW</a> <a href="<c:url value="/productdetail/${ item.id_product }"/>"><img
									src="<c:url value="/assets/user/img/${ item.img }"/>" alt=""></a>
								<div class="caption cntr">
									<p>${ item.name }</p>
									<p>
										<strong><fmt:formatNumber
													type="number" groupingUsed="true" value="${ item.price }" />
												$</strong>
									</p>
									<h4>
										<a class="shopBtn" href="#" title="add to cart"> Add to
											cart </a>
									</h4>
						
									<br class="clr">
								</div>
							</div>
						</li>
						<!-- index run from 0 to end, plus index with 1 to have a valid value -->
						<!-- if index + 1 devided by 3 with 0 reminder,or if it is the last item, it will close ul tag  -->
						<c:if
							test="${ (loop.index + 1) % 3 == 0 || (loop.index + 1)  == productSearch.size() }">
				</ul>
			</div>
			<!-- if index + 1 lopp < size of product, open a new ul -->
			<c:if test="${ (loop.index + 1) < productSearch.size() }">
				<div class="row-fluid">
					<ul class="thumbnails">
			</c:if>
		</c:if>
		</c:forEach>
		</c:if>

	

	</div>
	
</body>