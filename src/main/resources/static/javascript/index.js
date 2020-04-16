var note1
var note2
var note3
var col1
var col2
var col3
var i=0

function onWindowScroll(e){
    var e = e || window.event
    if (e.wheelDelta){
        if (e.wheelDelta > 0){
            setTransparent()
        }else if (e.wheelDelta < 0){
            setNonTransparent()
        }
    }else if (e.detail){
        if (e.detail > 0){
            setTransparent()
        }else if (e.detail < 0){
            setNonTransparent()
        }
    }
}
function setTransparent(){
    document.getElementById("nav-mask").style.backgroundColor="transparent"
}
function setNonTransparent(){
    document.getElementById("nav-mask").style.backgroundColor="skyblue"
}
function appendForItem(item){
    if (i===0){
        note1.col.push(item)
    }else if (i===1){
        note2.col.push(item)
    }else{
        note3.col.push(item)
    }
    i++
    i%=3
}
function loadExps(){
    var xh=new XMLHttpRequest()
    xh.open("GET","http://localhost/notes",true)
    xh.onreadystatechange=function(){
        if (xh.readyState==4){
            if (xh.status==200){
                try{
                    var t=xh.responseText
                    var results=JSON.parse(t)
                    var i
                    for (i=0;i<results.length;i++){
                        appendForItem(results[i])
                    }
                }catch(e){
                    console.log(e)
                }
            }
        }
    }
    xh.send("")
}

$(document).ready(function(){
    note1=new Vue({
        el:"#type1",
        data:{
            col:[]
        },
        nextTick:function () {
            console.log(col1.offsetHeight || col1.clientHeight)
        }
    })
    note2=new Vue({
        el:"#type2",
        data:{
            col:[]
        }
    })
    note3=new Vue({
        el:"#type3",
        data:{
            col:[]
        }
    })
    //add scroll listener
    if (document.addEventListener){
        document.addEventListener("DOMMouseScroll",onWindowScroll,false)
    }
    window.onmousewheel=document.onmousewheel=onWindowScroll
    col1=document.getElementById("col1")
    col2=document.getElementById("col2")
    col3=document.getElementById("col3")
    loadExps()
})