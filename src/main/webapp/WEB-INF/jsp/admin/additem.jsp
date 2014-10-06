<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">Add Item</h1>
		<div class="row">
			<div class="col-lg-6 col-lg-offset-1">
				<c:set value="${flag}" var="isAdded"/>
				<c:if test="${isAdded==true}">
					<div class="alert alert-success">
                         New Item Successfully Inserted.
                    </div>
				</c:if>
				<form:form commandName="newItem" method="POST">
					<div class="form-group">
						<label>Item Name</label>
						<form:input path="name" cssClass="form-control" />
						<p class="help-block">Enter Item Name</p>
					</div>

					<div class="form-group">
						<label>Item Price</label>
						<form:input path="price" cssClass="form-control" />
						<p class="help-block">Enter Item Price.</p>
					</div>
					<button type="submit" class="btn btn-primary">Add Item</button>
				</form:form>
			</div>
		</div>
		<!-- /.col-lg-12 -->
	</div>
</div>