
//javascript pitfalls and errors

//dont use var
var foo = function () {
    var local1 = 2;


    {
        var local2 = 3;
        console.log(local2);
    }
}