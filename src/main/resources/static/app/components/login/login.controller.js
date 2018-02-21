(function() {
    'use strict';

    angular
        .module('app')
        .controller('LoginController', LoginController);

    LoginController.$inject = ['$rootScope', '$state', '$timeout', 'Auth', '$uibModalInstance'];

    function LoginController ($rootScope, $state, $timeout, Auth, $uibModalInstance) {
        var vm = this;

        vm.authenticationError = false;
        vm.cancel = cancel;
        vm.credentials = {};
        vm.login = login;
        vm.password = null;
        vm.username = null;
        vm.signInButtonText = 'Sign In';
        vm.authenticationErrorTimeOut = false;

        function cancel () {
            vm.credentials = {
                username: null,
                password: null,
            };
            vm.authenticationError = false;
            $uibModalInstance.dismiss('cancel');
        }

        function login (event) {
            event.preventDefault();
            vm.authenticationErrorTimeOut = false;
            vm.authenticationError = false;
            vm.signInButtonText = 'Signing In';
            Auth.login({
                username: vm.username,
                password: vm.password,
            }).then(function () {
                vm.authenticationError = false;
                $uibModalInstance.close();
                
                $rootScope.$broadcast('authenticationSuccess');

                $state.go('admin');
            }).catch(function (error) {
                if(error.data.AuthenticationException || error.data.exception.indexOf('ResourceAccessException')==-1){
                	vm.authenticationError = true;
                }else{
                	vm.authenticationErrorTimeOut = true;
                }
                vm.signInButtonText = "Sign In";
            });
            
            $timeout(function(){
            	vm.signInButtonText = "Sign In";
                vm.authenticationErrorTimeOut = true;
            }, 15000);
        }

   }
})();
