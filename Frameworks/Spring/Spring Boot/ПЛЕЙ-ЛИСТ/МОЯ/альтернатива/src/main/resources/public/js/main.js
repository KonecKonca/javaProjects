var app = angular.module("springDemo", []);

app.controller("AppCtrl", function ($scope) {
    $scope.websites = [{
        iconImageUrl : 'http://i.ebayimg.com/00/$(KGrHqZ,!hQE9uKkj(2zBPkP!VULiQ~~_7.JPG',
        id: 'stackoverflow',
        website: 'stackoverflow.com',
        title: 'StackOverFlow website',
        description: "StackOverFlow description"
    }];

    // $scope.websites = [];
    //
    // $http.get('http://localhost:8080/api/stackoverflow').success(function(data){
    //     $scope.websites = data;
    // });

});