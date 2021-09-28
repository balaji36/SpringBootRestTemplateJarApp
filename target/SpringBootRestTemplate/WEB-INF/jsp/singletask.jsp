<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="services" class="text-center">
	
		<div class="container">
			<div class="col-md-8 col-md-offset-2 section-title">

				<table class="table table-bordered">

					<thead>
		
						<tr>
							<th>Id</th>
							<th>Name</th>
							<th>Addrs</th>
							<th>Date</th>
							<th>Finished</th>
						</tr>
					</thead>
					<tbody>
								
						<tr>
							<td>${task.id}</td>
							<td>${task.name}</td>
							<td>${task.addrs}</td>
							<td>${task.date}</td>
							<td>${task.finished}</td>
						</tr>
		
					</tbody>
					
				</table>

			</div>
			</div>
		</div>