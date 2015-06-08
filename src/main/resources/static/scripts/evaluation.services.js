angular.module('jes').service("evaluationServices", evaluationServices);

function evaluationServices($http, serviceBaseURL) {

	var self = this;

	self.countByFunctionalDomain = countByFunctionalDomain;
	self.getByFunctionalDomain = getByFunctionalDomain;
	self.validateEvaluation = validateEvaluation;

	function countByFunctionalDomain(pFunctionalDomain) {
		return $http({
			method : 'GET',
			url : serviceBaseURL + '/evaluation/' + pFunctionalDomain + '/count'
		});
	}
	
	function getByFunctionalDomain(pFunctionalDomain) {
		return $http({
			method : 'GET',
			url : serviceBaseURL + '/' + pFunctionalDomain + '/evaluation'
		});
	}

	function validateEvaluation(pEvaluation) {
		return $http({
			method : 'PUT',
			url : serviceBaseURL + '/evaluation/validate',
			data: pEvaluation
		});
	}
	
	return self;
}