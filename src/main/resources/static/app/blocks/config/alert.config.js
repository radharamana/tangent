(function() {
    'use strict';

    angular
        .module('app')
        .config(alertServiceConfig);

    alertServiceConfig.$inject = ['AlertServiceProvider'];

    function alertServiceConfig(AlertServiceProvider) {
        AlertServiceProvider.showAsToast(false);
    }
})();