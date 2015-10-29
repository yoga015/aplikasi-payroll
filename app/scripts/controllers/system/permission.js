'use strict';

/**
 * @ngdoc function
 * @name payrollAppApp.controller:SystemPermissionCtrl
 * @description
 * # SystemPermissionCtrl
 * Controller of the payrollAppApp
 */
angular.module('payrollAppApp')
        .controller('SystemPermissionCtrl', function($scope, $timeout, PermissionService) {

            $scope.paging = {
                currentPage: 1
            };
            $scope.reloadData = function() {
                PermissionService.query($scope.paging.currentPage - 1, 10).success(function(data) {
                    $scope.permissions = data.content;
                    $scope.paging.maxSize = (data.size);
                    $scope.paging.totalItems = data.totalElements;
                    $scope.paging.currentPage = parseInt(data.number) + 1;
                    $scope.paging.maxPage = data.totalPages;
                });
            };

            $scope.reloadData();

            $scope.edit = function(p) {
                if (p.id) {
                    PermissionService.get('id', p.id).success(function(data) {
                        $scope.currentPermission = data;
                        $scope.original = angular.copy($scope.currentPermission);
                    });
                }
            };

            $scope.isClean = function() {
                return angular.equals($scope.original, $scope.currentPermission);
            };

            $scope.clear = function() {
                $scope.currentPermission = null;
                $scope.original = null;
                $scope.valueExist = false;
                $scope.labelExist = false;

                $scope.reloadData();
            };

            $scope.delete = function(p) {
                bootbox.confirm('Are you sure to delete permission [' + p.value + '] ?', function(result) {
                    if (result) {
                        PermissionService.remove(p).success(function() {
                            $scope.clear();
                        });
                    }
                });
            };

            $scope.save = function() {
                PermissionService.get('value', $scope.currentPermission.value).success(function(data) {
                    if (data && $scope.currentPermission.id != data.id) {
                        $scope.valueExist = true;
                        return;
                    } else {
                        PermissionService.save($scope.currentPermission).success(function() {
                            bootbox.alert('Permission [' + $scope.currentPermission.value + '] saved ');
                            $scope.clear();
                        });
                    }
                });
            };


        });
