(function() {
'use strict';
angular
        .module('app')
        .controller('EmployeeController', EmployeeController);

EmployeeController.$inject = ['$rootScope','$scope','$controller', 'Principal', '$state','Employee','uiGridConstants'];
    
function EmployeeController ($rootScope, $scope, $controller, Principal, $state, Employee,uiGridConstants) {
	var vm = this;
	
	vm.employeeGrid = {
			enableFiltering: true,
		    useExternalFiltering: true,
			columnDefs: [
				{ field: 'email'},
 				{ field: 'user.first_name', displayName:'First Name', enableFiltering: false},
 				{ field: 'user.last_name', displayName:'Last Name', enableFiltering: false},
 				{ field: 'position.name', displayName:'Position'
 					, filter:{ selectOptions: $rootScope.lookups.position, type: uiGridConstants.filter.SELECT}
 				},
 				{ field: 'years_worked', displayName:'Years Worked' , enableFiltering: false},
 				{ field: 'phone_number', displayName:'Phone', enableFiltering: false},
 				{ field: 'birth_date', displayName:'Birthday', enableFiltering: false},
 				{ field: 'age', enableFiltering: false},
 				{ field: 'days_to_birthday', displayName:'Days to Birthday', enableFiltering: false},
 				{ field: 'gender', 
 					filter: { selectOptions: $rootScope.lookups.gender, type: uiGridConstants.filter.SELECT},
 				},
 				{ field: 'race', 
 					filter: { selectOptions: $rootScope.lookups.race, type: uiGridConstants.filter.SELECT}
 				},
 			],
 			data:$scope.$resolve.data,
 			
	        onRegisterApi: function(gridApi){
	        	vm.gridApi = gridApi;
	        	
	        	vm.gridApi.core.on.filterChanged($scope,function(){
	        		var grid = this.grid;
	        		var filter = {};
	        		grid.columns.forEach(function(column, index){
	    	        	if(column.filters[0].term){
	    	        		filter[column.field]=column.filters[0].term;
	    	        	}
	    	        });
	        		
	        		grid.options.data = Employee.queryLoading(filter);
	        	});
	        }
	};
}
})();        