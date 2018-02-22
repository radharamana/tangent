(function () {
    'use strict';

    angular
        .module('app')
        .factory('Employee', Employee);

    Employee.$inject = ['$resource','$rootScope','$timeout'];

    function Employee ($resource, $rootScope, $timeout) {
        var service = $resource('api/employees/:id', {}, {
            'query': {method: 'GET', isArray: true},
            'get': { method: 'GET'},
        });
        
        service.queryLoading = function(filter){
        	$rootScope.loading = true;
        	var ret = service.query(filter);
        	
        	ret.$promise.then(function(res){
        		$rootScope.loading = false;
        		return res;
        	}).catch(function(err){
        		$rootScope.loading = false;
        	});
        	
        	$timeout(function(){
        		$rootScope.loading = false;
            }, 15000);
        	
        	return ret;
        	
        }
        
        
        return service;
    }
    
    
})();
