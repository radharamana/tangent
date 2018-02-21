(function() {
    'use strict';

    angular
        .module('app')
        .factory('authExpiredInterceptor', authExpiredInterceptor);

    authExpiredInterceptor.$inject = ['$rootScope', '$q', '$injector', '$sessionStorage'];

    function authExpiredInterceptor($rootScope, $q, $injector, $sessionStorage) {
        var service = {
            responseError: responseError
        };

        return service;

        function responseError(response) {
            if (response.status === 401) {
                delete $sessionStorage.authenticationToken;
                var Principal = $injector.get('Principal');
                if (Principal.isAuthenticated()) {
                    var Auth = $injector.get('Auth');
                    Auth.authorize(true);
                }else{
                	 $injector.get('LoginService').open();
                }
            }
            return $q.reject(response);
        }
    }
})();
