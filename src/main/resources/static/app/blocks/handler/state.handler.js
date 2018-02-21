(function() {
    'use strict';

    angular
        .module('app')
        .factory('stateHandler', stateHandler);

    stateHandler.$inject = ['$rootScope', '$state', '$sessionStorage',  '$window','$transitions',
        'Auth', 'Principal'];

    function stateHandler($rootScope, $state, $sessionStorage,  $window, $transitions,
        Auth, Principal) {
        return {
            initialize: initialize
        };

        function initialize() {
        	$transitions.onStart( { }, function(trans) {
        		$rootScope.toState = trans.to();
                $rootScope.toStateParams = trans.params();
                $rootScope.fromState = trans.from();

                
                if (Principal.isIdentityResolved()) {
                    Auth.authorize();
                }

            });
        	
        }
    }
})();
