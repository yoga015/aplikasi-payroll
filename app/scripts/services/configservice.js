'use strict';

/**
 * @ngdoc service
 * @name payrollAppApp.ConfigService
 * @description
 * # ConfigService
 * Factory in the payrollAppApp.
 */
angular.module('payrollAppApp')
        .factory('ConfigService', function Configservice($location) {
            var proto = $location.protocol();
            var host = $location.host();
            var port = $location.port();
            var server = proto + '://' + host + ':' + port;
            return {
                serverUrl: server
            };
        });
