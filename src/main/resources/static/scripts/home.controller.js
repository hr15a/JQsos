angular.module('jes').controller("homeController", homeController);

function homeController($log, templateServices) {

	$log.log("Running home controller.");

	var vm = this;

	vm.templates = [];
	vm.functionalDomains = [];

	vm.getAllTemplates = getAllTemplates;

	getAllTemplates();

	function getAllTemplates() {

		templateServices.getAll().success(
				function(data, status, headers, config) {
					vm.templates = data;
					
					for (var index = 0 ; index < vm.templates.length ; index++) {
						vm.functionalDomains.push(vm.templates[index].qsosAppFamily);
					}
					
				}).error(function(data, status, headers, config) {
			$log.log("ERROR.");
		})
	}

}
