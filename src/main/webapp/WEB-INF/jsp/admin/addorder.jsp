<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">Add Order</h1>
		<div class="row">
			<div class="col-lg-6 col-lg-offset-1">
				<c:set value="${flag}" var="isAdded"/>
				<c:if test="${isAdded==true}">
					<div class="alert alert-success">
                         New Order Successfully Inserted.
                    </div>
				</c:if>
				<form:form commandName="newOrder" method="POST">
					

					<div class="form-group">
						<label>Payment Method</label>
						<form:input path="paymentMethod" cssClass="form-control" />
						<p class="help-block">Enter Payment Method.</p>
					</div>
					<button type="submit" class="btn btn-primary">Add Order</button>
				</form:form>
			</div>
		</div>
		<!-- /.col-lg-12 -->
	</div>
</div>