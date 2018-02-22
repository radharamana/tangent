(function() {
'use strict';

angular
        .module('app')
        .controller('ProfileController', ProfileController);

ProfileController.$inject = ['$scope'];
    
function ProfileController ($scope) {
	var vm = this;
	vm.profile = $scope.$resolve.data;
}

})();