(function() {
    'use strict';

    angular
        .module('app')
        .factory('AuthServerProvider', AuthServerProvider);

    AuthServerProvider.$inject = ['$http', '$sessionStorage', '$q'];

    function AuthServerProvider ($http, $sessionStorage,  $q) {
        var service = {
            getToken: getToken,
            login: login,
            loginWithToken: loginWithToken,
            storeAuthenticationToken: storeAuthenticationToken,
            logout: logout
        };

        return service;

        function getToken () {
            return $sessionStorage.authenticationToken;
        }

        function login (credentials) {

            var data = {
                username: credentials.username,
                password: credentials.password,
                
            };
            return $http.post('api/authenticate', data).then(authenticateSuccess);

            function authenticateSuccess (response) {
                var bearerToken = response.headers('Authorization');
                if (angular.isDefined(bearerToken) && bearerToken.slice(0, 7) === 'Bearer ') {
                    var jwt = bearerToken.slice(7, bearerToken.length);
                    service.storeAuthenticationToken(jwt);
                    return jwt;
                }
            }
        }

        function loginWithToken(jwt) {
            var deferred = $q.defer();

            if (angular.isDefined(jwt)) {
                this.storeAuthenticationToken(jwt);
                deferred.resolve(jwt);
            } else {
                deferred.reject();
            }

            return deferred.promise;
        }

        function storeAuthenticationToken(jwt) {
            $sessionStorage.authenticationToken = jwt;
            
        }

        function logout () {
            delete $sessionStorage.authenticationToken;
        }
    }
})();
