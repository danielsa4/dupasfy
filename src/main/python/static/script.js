document.getElementById("func_form").style.display ="none";

function openTest() {
    document.getElementById("func_form").style.display = "";
}

document.getElementById('func-button').addEventListener('click', openTest);