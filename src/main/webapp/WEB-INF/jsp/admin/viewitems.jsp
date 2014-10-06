<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">Manage Items</h1>
		<div class="panel panel-default">
			<div class="panel-heading">Displaying all the items in the inventory</div>
			<!-- /.panel-heading -->
			<div class="panel-body">
				<div class="table-responsive">
					<table class="table table-striped table-bordered table-hover">
						<thead>
							<tr>
								<th>#</th>
								<th>Item Name</th>
								<th>Item Price</th>
								<th>Action</th>
							</tr>
						</thead>
						<tbody>
						<c:forEach items="${items}" var="item">
							<tr>
								<td>${item.itemId}</td>
								<td>${item.name}</td>
								<td>${item.price}</td>
								<td>
									<a href="/admin/edititem.html?id=${item.itemId}" class="btn btn-warning">Edit</a>
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