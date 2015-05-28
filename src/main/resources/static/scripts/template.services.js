angular.module('jes').service("templateServices", templateServices);

function templateServices($http, serviceBaseURL) {

	var self = this;

	self.getAll = getAll;

	function getAll() {
		return $http({
			method : 'GET',
			url : serviceBaseURL + '/template'
		});
	}

	return self;
}