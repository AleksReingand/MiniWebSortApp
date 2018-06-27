var url = "http://127.0.0.1:8080/sort?number=";
var number;

//function template requests
function getReq(url) {
    return new Promise(function (resolve, reject) {
        var xhr = new XMLHttpRequest();
        xhr.open("GET", url);
        xhr.onload = function () {
            if (this.status === 200) {
                resolve(xhr.response);
            } else {
                reject("error");
            }
        };
        xhr.send();
    });
}

//handler button
but.addEventListener("click", function () {
    number = inp.value;
    if(!isFinite(number)){
        alert("not number");
    }
    getReq(url + number).then(function (response) {
        //get object
        var listArr = JSON.parse(response);
        var str = "";
        //get element and write result
        document.getElementById("nonSort").innerHTML = "unsort > " + "[" + listArr[0] + "]";
        document.getElementById("sort").innerHTML = "sort > " + "[" + listArr[listArr.length - 1] + "]";

        for (var i = 1; i < listArr.length; i++) {
            str += "<p>" + i + " > " + "[" + listArr[i] + "]" + "</p>"
        }
        document.getElementById("iteration").innerHTML = str;
    });


});




