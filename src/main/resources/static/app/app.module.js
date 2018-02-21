(function() {
    'use strict';

    angular
        .module('app', [
            'ngTouch',
        	'ngStorage',
            'ngResource',
            'ui.bootstrap',
            'ui.router',
            'angular-loading-bar',
            'ui.grid',
            'ui.grid.pagination',
            'ui.grid.edit'
        ])
        .run(run);

    run.$inject = ['stateHandler'];

    function run(stateHandler) {
        stateHandler.initialize();
    }
})();
