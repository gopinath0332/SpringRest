// const angular = require("angular");
// require("bootstrap");


const appMoule = angular.module("angularapp", []);
const PERSON_URL = "./api/list-db";


appMoule.controller("MarkController", ($scope,$http) => {
	
	$http.get(PERSON_URL).success((list)=>{
		$scope.students = list;
	});

    $scope.updateMark = function() {
        let newObj = {
            "fname": $scope.templateHolder.first_name,
            "lname": $scope.templateHolder.last_name
        };
        let config = {
        		headers: {
        			   'Content-Type': "applications/json"
        			 },
        			 handle:"string"
        };
        $scope.students.push(newObj);
        $http.post("./api/contact",newObj,config);
    };
});
