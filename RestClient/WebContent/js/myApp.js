var myApp=angular.module("myApp", []);

myApp.controller("ProductController",function($scope,$http)
{
	//JSON object to represent a product so whatever we will enter in product properties through html will set in the below format in product object in the given scope
	$scope.product={'id':0,'name':'','brand':'','price':''};
	
	//method to save a product this method is getting called from index.html and this will send the post request to the server to save the product
	$scope.save=function()
	{
		var uri="http://localhost:8080/RestServices/rest/products";
	/*this product object will store the values which we passed in UI through ng-model binding, this product will have the JSON representation as given above.*/
		$http.post(uri,$scope.product).then(
				/*response will received in the below variable from the service*/
				function(response)
				{
					alert(JSON.stringify(response.data));
				},
			/*if there would be any error will be received in the below error variable.*/
				function(error)
				{
					alert(JSON.stringify(error.data));
				});
	};
	
	//method to load all products, in this case we won't receive the single product but will get the collection of objects for that we will have to make a wrapper class for collection of objects on the
	//service side which will send a single object and that object will contain the list of products
	$scope.loadAll=function()
	{
		var uri="http://localhost:8080/RestServices/rest/products";
	/*When we are loading all the products we don't need to pass anything in the product object i think
	 * $http.get(uri,$scope.product).then(*/
		$http.get(uri,$scope.product).then(
				function(response)
				{
					//received data contains an array by the name productList, here we putting the list in the scope in the variable products and we are going to use it render it on UI
					$scope.products=response.data.productList;
				},
				function(error)
				{
					//if any error will come will be displayed..
					alert(JSON.stringify(error.data));
					
				});
	};
	});