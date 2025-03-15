function calculate() {
    var expression = document.getElementById('expression').value;
    var xhr = new XMLHttpRequest();
    xhr.open("POST", "calculate", true);
    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4 && xhr.status === 200) {
            document.getElementById("result").innerHTML = "Result: " + xhr.responseText;
        }
    };
    xhr.send("expression=" + encodeURIComponent(expression));
}
