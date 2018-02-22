(function () {
    'use strict';

    angular
        .module('app')
        .factory('Lookup', Lookup);

    Lookup.$inject = ['$resource','$rootScope','$timeout'];

    function Lookup ($resource, $rootScope, $timeout) {
    	var service = {};
    	
    	service.gender = $resource('api/lookups/gender', {}, {
            'query': {method: 'GET', isArray: true},
        });
        
        service.race = $resource('api/lookups/race', {}, {
            'query': {method: 'GET', isArray: true},
        });
        
        service.position = $resource('api/lookups/position', {}, {
            'query': {method: 'GET', isArray: true},
        });
        
        
        service.queryAll = function(){
        	if($rootScope.lookups)return new Promise(function(resolve){resolve();});
        	$rootScope.lookups = {};
        	return service.gender.query().$promise.then(function(res){
        		$rootScope.lookups.gender=res;
        		return service.race.query().$promise;
        	}).then(function(res){
        		$rootScope.lookups.race=res;
        		return service.position.query().$promise;
        	}).then(function(res){
        		$rootScope.lookups.position = res;
        	});
        	
        }
        
//        var loginListener = $rootScope.$on('authenticationSuccess', function (event, httpResponse) {
//        	service.queryAll();
//        });
        
        return service;
    }
    
    
})();
