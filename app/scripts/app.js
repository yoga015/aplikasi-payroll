'use strict';

/**
 * @ngdoc overview
 * @name payrollAppApp
 * @description
 * # payrollAppApp
 *
 * Main module of the application.
 */
angular
  .module('payrollAppApp', [
    'ngAnimate',
    'ngCookies',
    'ngResource',
    'ngRoute',
    'ngSanitize',
    'ngTouch'
  ])
  .config(function ($routeProvider) {
    $routeProvider
      .when('/', {
        templateUrl: 'views/main.html',
        controller: 'MainCtrl',
        controllerAs: 'main'
      })
      .when('/about', {
        templateUrl: 'views/about.html',
        controller: 'AboutCtrl',
        controllerAs: 'about'
      })
      .when('/permission', {
        templateUrl: 'views/system/permission.html',
        controller: 'SystemPermissionCtrl',
        controllerAs: 'permission'
      })
      .otherwise({
        redirectTo: '/'
      });
  });
