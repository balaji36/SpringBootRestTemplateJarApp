

<div class="p1">
	<h1 align="center">Welcome to Task Manager</h1>

	<div>
	
	<div class="container">
		<table class="table table-bordered table-striped table-hover">
			<thead>
				<tr>
					<th >Id</th>
					<th >Name</th>
					<th >Description</th>
					<th >Date</th>
					<th >Finished</th>
					<th >Update</th>
					<th >Delete</th>
				</tr>
			</thead>

			<tbody>

				<c:forEach var="task" items="${tasks}">
					<tr>
						<td >${task.id}</td>
						<td >${task.name}</td>
						<td >${task.description}</td>
						<td ><time:formatDate pattern="yyyy-MM-dd hh:mm:ss" value="${task.date}"/></td>
						<td >${task.finished}</td>

						<td><a href="updatetask?id=${task.id}">
								<button type="button" class="btn btn-info btn-sm  ">
									<span class="glyphicon glyphicon-edit"></span>
								</button>

						</a></td>
						<td><a href="deletetask?id=${task.id}">

								<button type="button" class="btn btn-info btn-sm">
									<span class="glyphicon glyphicon-trash"></span>
								</button>
						</a></td>
					</tr>

				</c:forEach>

			</tbody>
		</table>

</div>
	</div>
</div>