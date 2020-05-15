function changeToModify() {
    var frame=document.getElementById("user-frame")
    var info=document.getElementById("infos")
    var mi=document.getElementById("modifyinfos")
    info.classList.remove("active")
    mi.classList.add("active")
    frame.src="/modifyinfos"
}
function changeToMyInfos(){
    var frame=document.getElementById("user-frame")
    var info=document.getElementById("infos")
    var mi=document.getElementById("modifyinfos")
    info.classList.add("active")
    mi.classList.remove("active")
    frame.src="/infos"
}