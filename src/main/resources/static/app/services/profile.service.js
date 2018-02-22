(function () {
    'use strict';

    angular
        .module('app')
        .factory('Profile', Profile);

    Profile.$inject = ['$resource'];

    function Profile ($resource) {
        var service = $resource('api/employees/me', {}, {
            'get': { method: 'GET'},
        });
        
        return service;
    }
    
    
})();
