(function() {
'use strict';

angular
        .module('app')
        .controller('StatsController', StatsController);

StatsController.$inject = ['$scope'];
    
function StatsController ($scope) {
	var vm = this;
	vm.stats = $scope.$resolve.data;
}

})();