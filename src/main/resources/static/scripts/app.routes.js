angular.module('jes').config(appRoutesConfig);

function appRoutesConfig($stateProvider, $urlRouterProvider) {

	$urlRouterProvider.otherwise("/");

	$stateProvider.state('home', {
		url : '/',
		views : {
			'main@' : {
				templateUrl : './partial/default.html'
			}
		}
	});

}