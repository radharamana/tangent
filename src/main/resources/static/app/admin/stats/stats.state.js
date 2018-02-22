(function() {
    'use strict';

    angular
        .module('app')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
        $stateProvider.state('stats', {
            parent: 'admin',
            url: '/stats',
            data: {
                authorities: ['ROLE_ADMIN'],
                pageTitle: 'Stats'
            },
            views: {
                'content1@': {
                    templateUrl: 'app/admin/stats/stats.html',
                    controller: 'StatsController',
                    controllerAs: 'vm'
                }
            },
            resolve:{
            	data:['Lookup','Stats', function(Lookup, Stats){
            		return Lookup.queryAll().then(function(){
            			return Stats.get();
            		})
            		
            	}]
            }
        });
    }
})();