'use strict';

describe('Controller: SystemPermissionCtrl', function () {

  // load the controller's module
  beforeEach(module('payrollAppApp'));

  var SystemPermissionCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    SystemPermissionCtrl = $controller('SystemPermissionCtrl', {
      $scope: scope
      // place here mocked dependencies
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    //expect(SystemPermissionCtrl.awesomeThings.length).toBe(3);
  });
});
