<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<title>Angular Js</title>
<link rel="stylesheet"
	href="./resources/lib/bootstrap.css" media="screen"
	title="no title" charset="utf-8">
<script src="./resources/lib/angular.js"></script>
<script src="./resources/lib/jquery.js"></script>
<script src="./resources/lib/bootstrap.js"
	charset="utf-8"></script>
</head>

<body ng-app="angularapp">
	<div id="markController" ng-controller="MarkController">
		<div>
			<div>
				<div class="col-xs-3">
					<input type="text" class="form-control"
						ng-model="templateHolder.first_name" placeholder="First Name....">
				</div>
				<div class="col-xs-3">
					<input type="text" class="form-control"
						ng-model="templateHolder.last_name" placeholder="Last Name....">
				</div>
				<button class="btn btn-success" ng-click=updateMark()>Add</button>
			</div>
			<br>
			<div class="col-xs-2">
				<input type="text" class="form-control" ng-model="rowFilter"
					placeholder="Filter...">
			</div>
			<table class="table">
				<thead>
					<th>First Name</th>
					<th>Last Name</th>
				</thead>
				<tbody>
					<tr ng-init="students=[]"
						ng-repeat="student in students | orderBy:'fname' |filter:rowFilter"">
						<td>{{student.fname}}</td>
						<td>{{student.lname}}</td>
					</tr>
				</tbody>
			</table>
		</div>

	</div>
	<script type="text/javascript" src="./resources/app.js"></script>
</body>

</html>

