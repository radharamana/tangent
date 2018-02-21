angular
        .module('app')
        .controller('EmployeeController', EmployeeController);

EmployeeController.$inject = ['$scope','$controller', 'Principal', '$state','Employee','uiGridConstants'];
    
function EmployeeController ($scope, $controller, Principal, $state, Employee,uiGridConstants) {
	var vm = this;
	
	vm.employeeGrid = {
			enableFiltering: true,
		    useExternalFiltering: true,
			columnDefs: [
 				{ field: 'user.first_name', displayName:'First Name', enableFiltering: false},
 				{ field: 'user.last_name', displayName:'Last Name', enableFiltering: false},
 				{ field: 'position.name', displayName:'Position'},
 				{ field: 'years_worked', displayName:'Years Worked' , enableFiltering: false},
 				{ field: 'phone_number', displayName:'Phone', enableFiltering: false},
 				{ field: 'birth_date', displayName:'Birthday'},
 				{ field: 'email'},
 				{ field: 'age', enableFiltering: false},
 				{ field: 'days_to_birthday', displayName:'Days to Birthday', enableFiltering: false},
 				{ field: 'gender', filter: { term: '1', type: uiGridConstants.filter.SELECT,
 			          selectOptions: [ { value: 'M', label: 'Male' }, { value: 'F', label: 'Female' }]},
 				},
 				{ field: 'race', filter: { term: '1', type: uiGridConstants.filter.SELECT, selectOptions: [ 
			        	{ value: 'B', label: 'Black African' }
			          , { value: 'C', label: 'Coloured' }
			          , { value: 'I', label: 'Indian or Asian' }
			          , { value: 'W', label: 'White' }
			          , { value: 'N', label: 'None Dominant' }
			          ]},
				},
 			],
 			data:Employee.queryLoading(),
 			
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
	        		
	        		$scope.gridOptions.data = Employee.queryLoading(filter);
	        	});
	        }
	};
}
        