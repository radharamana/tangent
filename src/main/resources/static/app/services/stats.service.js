(function () {
    'use strict';

    angular
        .module('app')
        .factory('Stats', Stats);

    Stats.$inject = ['$resource'];

    function Stats ($resource) {
        var service = $resource('api/employees/stats', {}, {
            'get': { method: 'GET'},
        });
        
        return service;
    }
    
    
})();
