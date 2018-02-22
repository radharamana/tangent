(function() {
    'use strict';

    angular
        .module('app')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
        $stateProvider.state('home', {
            parent: 'app',
            url: '/',
            data: {
                authorities: []
            },
            views: {
                'content1@': {
                    templateUrl: 'app/home/signin/signin.html',
                    controller: 'SigninController',
                    controllerAs: 'vm'
                }
            },
            resolve: {
                authenticated:['Principal','$state',
                    function (Principal, $state) {
                        if(Principal.isAuthenticated())$state.go('admin');
                    }
                ]
            }
        });
    }
})();
