(function() {
    'use strict';

    angular
        .module('app')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
        $stateProvider.state('admin', {
            parent: 'app',
            url: '/admin',
            data: {
                authorities: ['ROLE_ADMIN']
            },
            views: {
                'content1@': {
                    templateUrl: 'app/admin/employee/employee.html',
                    controller: 'EmployeeController',
                    controllerAs: 'vm'
                }
            }
        });
    }
})();
