<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/user/taglib.jsp" %>   
<head>
<title>Cart</title>
</head>
<body>
<div class="row">
	<div class="span12">
    <ul class="breadcrumb">
		<li><a href="index.html">Home</a> <span class="divider">/</span></li>
		<li class="active">Checkout</li>
    </ul>
	<div class="well well-small">
		<h1>Cart <small class="pull-right"> ${TotalQuantyCart} items in the cart </small></h1>
	<hr class="soften"/>	

	<table class="table table-bordered table-condensed">
              <thead>
                <tr>
                  <th>Product</th>
                  <th>Description</th>
                  <th>Color</th>
                  <th>Price</th>
                  <th>Quantity </th>
                  <th>Edit </th>
                  <th>Delete </th>
                  <th>Total price</th>
				</tr>
              </thead>
              <tbody>
				<c:forEach var="item" items="${ Cart }">
					<tr>
	                  <td><img width="100" src="<c:url value="/assets/user/img/${ item.value.product.img }"/>" alt=""></td>
	                  <td>${ item.value.product.title }</td>
	                  <td><span class="shopBtn" style="background-color: ${ item.value.product.code_color };"><span class="icon-ok"></span></span> </td>
	                  <td><fmt:formatNumber type="number" groupingUsed="true" value="${ TotalPriceCart }"/> ₫</td>
	                  <td>
						<input type="number" min="0" max="1000" class="span1" style="max-width:34px" placeholder="1" id="quanty-card-${ item.key }" size="16" type="text" value="${ item.value.quanty }">
					  </td>
	                  <td>
	                  	<button data-id="${ item.key }" class="btn btn-mini btn-danger edit-cart" type="button">
	                  		<span class="icon-edit"></span>
	                  	</button>
	                  </td>
	                  <td>
	                  	<a href="<c:url value="/DeleteCart/${ item.key }"/>" class="btn btn-mini btn-danger" type="button">
	                  		<span class="icon-remove"></span>
	                  	</a>
	                  </td>
	                  <td><fmt:formatNumber type="number" groupingUsed="true" value="${ item.value.totalPrice }"/> ₫</td>
	                </tr>
				</c:forEach>
                
				</tbody>
            </table><br/>
			
	<a href="<c:url value="/home"/>" class="shopBtn btn-large"><span class="icon-arrow-left"></span> Continue to buy </a>
	<a href="<c:url value="/checkout"/>" class="shopBtn btn-large pull-right">Pay<span class="icon-arrow-right"></span></a>

</div>
</div>
</div>
<content tag="script">
<script>
	$(".edit-cart").on("click", function(){
		var id = $(this).data("id");
		var quanty = $("#quanty-card-"+id).val();	
		window.location = "EditCart/"+id+"/"+quanty;
	});
</script>
</content>
</body>