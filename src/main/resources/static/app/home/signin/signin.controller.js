(function() {
'use strict';

angular
        .module('app')
        .controller('SigninController', SigninController);

SigninController.$inject = ['LoginService'];
    
function SigninController (LoginService) {
	//LoginService.open();
	var vm = this;
}

})();