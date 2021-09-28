
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="services" class="text-center">
	
		<div class="container">
			<div class="col-md-8 col-md-offset-2 section-title">

<div class="content" >

	<h1 align="center">Login Task</h1>
	<form class="form-horizontal" action="logintask">
<div class="form-group">
			<label >Id:</label>
		<input type="text" class="form-control" id="email" name="id"
			value="${task.id}">
			</div>
		<div class="form-group">
			<label >Name:</label> <input type="text"
				class="form-control" id="email" placeholder="Enter Name"
				name="name" value="${task.name}">
		</div>
		<div class="form-group">
			<label >ADDRS:</label> <input type="text"
				class="form-control" id="pwd" placeholder="Enter Description"
				name="addrs" value="${task.addrs}">
		</div>

		



		<button type="submit" class="btn btn-default">Login</button>
	</form>

</div>
</div>
</div>
</div>




