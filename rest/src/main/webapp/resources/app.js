// const angular = require("angular");
// require("bootstrap");


const appMoule = angular.module("angularapp", []);
const PERSON_URL = "./api/list-db";


appMoule.controller("MarkController", ($scope,$http) => {
//    $scope.students = [];
//    $.ajax({
//        url: PERSON_URL,
//        async: true
//    }).then((list) => {
//        $scope.students = list;
//        console.debug(list);
//    }, (error) => {
//        console.error("Error in fetching list:::");
//    });
	
	$http.get(PERSON_URL).success((list)=>{
		$scope.students = list;
	});

    $scope.updateMark = function() {
        let newObj = {
            "fname": $scope.templateHolder.first_name,
            "lname": $scope.templateHolder.last_name
        };
        $scope.students.push(newObj);
    };
});
