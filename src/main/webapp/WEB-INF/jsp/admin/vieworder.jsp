<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">Manage Orders</h1>
		<div class="panel panel-default">
			<div class="panel-heading">Displaying all the orders</div>
			<!-- /.panel-heading -->
			<div class="panel-body">
				<div class="table-responsive">
					<table class="table table-striped table-bordered table-hover">
						<thead>
							<tr>
							
								<th>Order No</th>
								<th>Payment Method</th>
								<th>Action</th>
							</tr>
						</thead>
						<tbody>
						<c:forEach items="${orders}" var="order">
							<tr>
								<td>${order.orderNo}</td>
								<td>${order.paymentMethod}</td>
								<td>
									<a href="/admin/orderitems.html?id=${order.orderNo}" class="btn btn-primary">Add Items</a>
									<a href="/admin/editorder.html?id=${order.orderNo}" class="btn btn-warning">Edit</a>
									
								</td>
							</tr>
						</c:forEach>
						</tbody>
					</table>
				</div>
				<!-- /.table-responsive -->
			</div>
			<!-- /.panel-body -->
		</div>
	</div>

</div>