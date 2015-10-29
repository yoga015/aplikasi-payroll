'use strict';

/**
 * @ngdoc service
 * @name payrollAppApp.PermissionService
 * @description
 * # PermissionService
 * Factory in the payrollAppApp.
 */
angular.module('payrollAppApp')
        .factory('PermissionService', function($http, ConfigService) {
            return {
                query: function(page, size) {
                    if (!page) {
                        page = 0;
                    }
                    if (!size) {
                        size = 10;
                    }

                    return $http.get(ConfigService.serverUrl + '/api/permission/all', {
                        params: {'page': page, 'size': size}
                    });
                },
                get: function(column, value) {
                    return $http.get(ConfigService.serverUrl + '/api/permission/get/' + column, {
                        params: {'val': value}
                    });
                },
                save: function(obj) {
                    if (obj.id) {
                        return $http.put(ConfigService.serverUrl + '/api/permission/' + obj.id, obj);
                    } else {
                        return $http.post(ConfigService.serverUrl + '/api/permission/', obj);
                    }
                },
                remove: function(obj) {
                    if (obj.id) {
                        return $http.delete(ConfigService.serverUrl + '/api/permission/' + obj.id);
                    }
                },
                count: function() {
                    return $http.get(ConfigService.serverUrl + '/api/permission/count/all');
                }
            };
        });