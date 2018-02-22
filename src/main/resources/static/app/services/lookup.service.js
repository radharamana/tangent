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
        		$rootScope.lookups.genderObj = {};
        		$rootScope.lookups.gender.forEach(function(e){
        			$rootScope.lookups.genderObj[e.value] = e.label;
        		});
        		return service.race.query().$promise;
        	}).then(function(res){
        		$rootScope.lookups.race=res;
        		$rootScope.lookups.raceObj = {};
        		$rootScope.lookups.race.forEach(function(e){
        			$rootScope.lookups.raceObj[e.value] = e.label;
        		});
        		return service.position.query().$promise;
        	}).then(function(res){
        		$rootScope.lookups.position = res;
        		$rootScope.lookups.positionObj = {};
        		$rootScope.lookups.position.forEach(function(e){
        			$rootScope.lookups.positionObj['k'+e.value] = e.label;
        		});
        	});
        	
        }
        
//        var loginListener = $rootScope.$on('authenticationSuccess', function (event, httpResponse) {
//        	service.queryAll();
//        });
        
        return service;
    }
    
    
})();
