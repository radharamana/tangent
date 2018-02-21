(function() {
    'use strict';

    angular
        .module('app')
        .factory('Account', Account);

    Account.$inject = ['$resource'];

    function Account ($resource) {
        var service = $resource('api/account', {}, {
            'get': { method: 'GET', params: {}, isArray: false}
        });

        return service;
    }
})();
