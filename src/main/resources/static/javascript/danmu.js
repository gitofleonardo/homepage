var danmuPool=[
    {content:"给我也整一个"},
    {content:"2333333"},
    {content:"明明我先来的"},
    {content:"嘤嘤嘤"}
]
var currentIndex=0

$(document).ready(function(){
    loadDanmu()
})
function loadDanmu(){
    var xh=new XMLHttpRequest()
    xh.open("GET","/danmus")
    xh.onreadystatechange=function () {
        if (xh.readyState==4){
            if (xh.status==200){
                var result=xh.responseText
                var obj=JSON.parse(result)
                danmuPool=obj["_embedded"]["danmus"]
                startDisplay()
            }
        }
    }
    xh.send("")
}
function startDisplay(){
    if (danmuPool.length<=0){
        return
    }
    setInterval(showDanmu,2000)
}
function showDanmu(){
    var danmu=document.getElementById("main-danmu")
    var singleDanmu=createSingleDanmu(danmuPool[currentIndex]["content"])
    var top=Math.random()*90
    singleDanmu.style.top=top+"%"
    danmu.appendChild(singleDanmu)
    currentIndex=(currentIndex+1)%danmuPool.length
}
function showNewDanmu(content){
    var danmu=document.getElementById("main-danmu")
    var singleDanmu=createSingleDanmu(content)
    singleDanmu.classList.add("new-danmu")
    var top=Math.random()*90
    singleDanmu.style.top=top+"%"
    danmu.appendChild(singleDanmu)
}
function createSingleDanmu(content){
    var danmu=document.createElement("div")
    danmu.classList.add("single-danmu")
    var a=document.createElement("a")
    a.innerHTML=content
    danmu.appendChild(a)
    danmu.addEventListener("animationend",removeThis)
    return danmu
}
function removeThis(){
    var danmu=document.getElementById("main-danmu")
    danmu.removeChild(this)
}
function sendDanmu(){
    var content=document.getElementById("danmu-content").value
    if (content==null || content==""){
        return
    }
    var danmu={}
    danmu.content=content
    var xh=new XMLHttpRequest()
    xh.open("POST","/danmus")
    xh.setRequestHeader("Content-Type","application/json")
    xh.onreadystatechange=function () {
        if (xh.readyState==4){
            if (xh.status>=200 && xh.status<300){
                danmuPool.push(danmu)
                showNewDanmu(content)
            }
        }
    }
    xh.send(JSON.stringify(danmu))
    document.getElementById("danmu-content").value=""
}