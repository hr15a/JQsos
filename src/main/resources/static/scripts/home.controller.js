angular.module('jes').controller("homeController", homeController);

function homeController($log, templateServices, evaluationServices) {

	$log.log("Running home controller.");

	var vm = this;

	vm.templates = [];
	vm.functionalDomains = [];
	vm.countEvaluations = {};
	vm.evaluations = {};
	vm.currentDomain = "";
	vm.currentEvaluation;

	vm.getAllTemplates = getAllTemplates;
	vm.countEvaluationByDomain = countEvaluationByDomain;
	vm.getEvaluationByDomain = getEvaluationByDomain;
	vm.evaluationDetail = evaluationDetail;

	getAllTemplates();

	function getAllTemplates() {

		templateServices
				.getAll()
				.success(
						function(data, status, headers, config) {
							vm.templates = data;

							for (var index = 0; index < vm.templates.length; index++) {

								var pFunctionalDomain = vm.templates[index].qsosAppFamily;

								vm.functionalDomains.push(pFunctionalDomain);

								countEvaluationByDomain(pFunctionalDomain);
							}

						}).error(function(data, status, headers, config) {
					$log.log("ERROR.");
				})
	}

	function countEvaluationByDomain(pFunctionalDomain) {

		var pFunctionalDomainURI = pFunctionalDomain.replace(/ /g, "_");

		evaluationServices.countByFunctionalDomain(pFunctionalDomainURI)
				.success(function(data, status, headers, config) {
					var value = data;
					vm.countEvaluations[pFunctionalDomain] = value;
				}).error(function(data, status, headers, config) {
					$log.log("ERROR.");
				})
	}

	function getEvaluationByDomain(pFunctionalDomain) {

		if (vm.currentDomain === pFunctionalDomain) {

			vm.currentDomain = "";
			vm.currentEvaluation = null;
			vm.evaluations[pFunctionalDomain].splice(0,
					vm.evaluations[pFunctionalDomain].length);

		} else {

			var pFunctionalDomainURI = pFunctionalDomain.replace(/ /g, "_");

			evaluationServices
					.getByFunctionalDomain(pFunctionalDomainURI)
					.success(
							function(data, status, headers, config) {

								vm.evaluations = {};
								vm.currentDomain = pFunctionalDomain;

								vm.evaluations[pFunctionalDomain] = angular
										.copy(
												data,
												vm.evaluations[pFunctionalDomain]);

							}).error(function(data, status, headers, config) {
						$log.log("ERROR.");
					})
		}
	}

	function evaluationDetail(index) {

		if (vm.currentEvaluation === index) {
			vm.currentEvaluation = null;
		} else {
			vm.currentEvaluation = index;
		}

	}

}
