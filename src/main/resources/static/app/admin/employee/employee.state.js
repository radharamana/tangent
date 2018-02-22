(function() {
    'use strict';

    angular
        .module('app')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
        $stateProvider.state('employee', {
            parent: 'admin',
            url: '/employee',
            data: {
                authorities: ['ROLE_ADMIN'],
                pageTitle: 'Employee'
            },
            views: {
                'content1@': {
                    templateUrl: 'app/admin/employee/employee.html',
                    controller: 'EmployeeController',
                    controllerAs: 'vm'
                }
            },
            resolve:{
            	data:['Lookup','Employee', function(Lookup, Employee){
            		return Lookup.queryAll().then(function(){
            			return Employee.queryLoading();
            		})
            		
            	}]
            }
        });
    }
})();