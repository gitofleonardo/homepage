function dismissDialog(div){
    var id=div.getAttribute("data-dismiss")
    document.getElementById(id).style.display="none"
}
function showDialog(div){
    var id=div.getAttribute("data-dialog")
    document.getElementById(id).style.display="block"
}