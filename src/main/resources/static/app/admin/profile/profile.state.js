(function() {
    'use strict';

    angular
        .module('app')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
        $stateProvider.state('profile', {
            parent: 'admin',
            url: '/profile',
            data: {
                authorities: ['ROLE_ADMIN'],
                pageTitle: 'Profile'
            },
            views: {
                'content1@': {
                    templateUrl: 'app/admin/profile/profile.html',
                    controller: 'ProfileController',
                    controllerAs: 'vm'
                }
            },
            resolve:{
            	data:['Lookup','Profile', function(Lookup, Profile){
            		return Lookup.queryAll().then(function(){
            			return Profile.get();
            		})
            		
            	}]
            }
        });
    }
})();