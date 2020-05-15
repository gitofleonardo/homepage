function disposeDialog(div){
    var id=div.getAttribute("data-dispose")
    document.getElementById(id).style.display="none"
}
function showDialog(div){
    console.log("click")
    var id=div.getAttribute("data-show-dialog")
    document.getElementById(id).style.display="block"
}