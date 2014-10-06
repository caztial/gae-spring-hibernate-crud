<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">Add Items To Order</h1>
		<div class="row">
			<div class="col-lg-6 col-lg-offset-1">
				<c:set value="${flag}" var="isAdded"/>
				<c:if test="${isAdded==true}">
					<div class="alert alert-success">
                         Successfully Updated.
                    </div>
				</c:if>
				<form method="POST" action="#" >
					<div class="form-group">
						<label>Order No : ${orderid}</label><br/><br/>
						<label>Item Name :</label>
						<input name="orderNo" value="${orderid} " type="hidden" />
					
						<select name="itemid" >
							<c:forEach items="${itemlist}" var="item">
								<option value="${item.itemId}">${item.name}</option>
							</c:forEach>
						</select>
						
						
						
						<p class="help-block">Select Item to Add</p>
					</div>
					<button type="submit" class="btn btn-primary">Add Item</button>
				</form>
				<br/>
				
			<div class="table-responsive">
					<table class="table table-striped table-bordered table-hover">
	
						<tbody>
						<c:forEach items="${itemsInOrder}" var="items">
							<tr>
								<td>${items.name}</td>
								<td>${items.price}</td>
							</tr>
						</c:forEach>
						</tbody>
					</table>
				</div>
				
				
				
			</div>
		</div>
		<!-- /.col-lg-12 -->
	</div>
</div>