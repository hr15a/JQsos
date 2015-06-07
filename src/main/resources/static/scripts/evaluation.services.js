angular.module('jes').service("evaluationServices", evaluationServices);

function evaluationServices($http, serviceBaseURL) {

	var self = this;

	self.countByFunctionalDomain = countByFunctionalDomain;
	self.getByFunctionalDomain = getByFunctionalDomain;

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

	return self;
}