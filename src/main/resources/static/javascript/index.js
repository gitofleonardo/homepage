var note1
var note2
var note3
var books
var col1
var col2
var col3
var i=0
var threadhold=6

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
    item.totalCount=item.experiences.length
    if (item.experiences.length>threadhold){
        item.remain=item.experiences.slice(threadhold)
        item.experiences=item.experiences.slice(0,threadhold)
    }else{
        item.remain=[]
    }
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
function expand(body){
    var id=parseInt(body.getAttribute("data-type-id"))
    var col=body.getAttribute("data-col")
    var item
    if (col=="1") {
        item = note1.col.find(function (value) {
            return value.id == id
        })
    }else if (col=="2"){
        item=note2.col.find(function(value){
            return value.id==id
        })
    }else if (col=="3"){
        item=note3.col.find(function(value){
            return value.id==id
        })
    }
    if (item.remain.length>0){
        item.experiences=item.experiences.concat(item.remain)
        item.remain=[]
    }else{
        if (item.experiences.length>threadhold){
            item.remain=item.experiences.slice(threadhold)
            item.experiences=item.experiences.slice(0,threadhold)
        }
    }
}
function loadExps(){
    var xh=new XMLHttpRequest()
    xh.open("GET","/notes",true)
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
function loadBooks(){
    var xh=new XMLHttpRequest()
    xh.open("GET","/recommendedBooks",true)
    xh.onreadystatechange=function () {
        if (xh.readyState==4){
            if (xh.status==200){
                var t=xh.responseText
                var result=JSON.parse(t)["_embedded"]["recommendedBooks"]
                books.books=result
            }
        }
    }
    xh.send("")
}
function chooseNoteAvatar(type){
    var id=type.getAttribute("data-type-id")
    document.getElementById(id).click()
}
function uploadAvatar(event,input){
    var avatar=event.target.files[0]
    var id=input.getAttribute("data-type-id")
    console.log(avatar)
    var data=new FormData()
    data.append("id",id)
    data.append("avatar",avatar)
    var xh=new XMLHttpRequest()
    xh.open("POST","/avatar",true)
    xh.onreadystatechange=function () {
        if (xh.readyState==4){
            if (xh.status==200){
                alert("上传成功")
                window.location.reload()
            }else if (xh.status==403){
                alert("您无权更新")
            }
        }
    }
    xh.send(data)
}
function newType() {
    var type=prompt("输入板块名称")
    if (type!==""){
        var data={}
        data["name"]=type
        var xh=new XMLHttpRequest()
        xh.open("POST","/postExpType",true)
        xh.onreadystatechange=function () {
            if (xh.readyState==4){
                if (xh.status==200){
                    try {
                        var result=JSON.parse(xh.responseText)
                        if (result["success"]){
                            alert("新增成功")
                            window.location.href="/"
                        }else{
                            alert("增加失败")
                        }
                    }catch (e) {
                        alert("增加失败")
                    }
                }
            }
        }
        xh.send(JSON.stringify(data))
    }else{
        alert("名称不能为空")
    }
}
function setCurrentBook(li){
    var id=li.getAttribute("data-book-id")
    var item=books.books.find(function (value) {
        return value.id==id
    })
    books.currentShown=item
}
function openSignOn(){
    document.getElementById("login-dialog").style.display="none"
    document.getElementById("signon-dialog").style.display="flex"
}
function openLogin() {
    document.getElementById("login-dialog").style.display="flex"
    document.getElementById("signon-dialog").style.display="none"
}
function onSubmitSignOn(){
    var email=document.getElementById("email").value
    var password=document.getElementById("password").value
    var passwordRepeat=document.getElementById("passwordRepeat").value
    var validateValue=document.getElementById("validate").value

    var emailPattern=/^([a-zA-Z]|[0-9])(\w|\-)+@[a-zA-Z0-9]+\.([a-zA-Z]{2,4})$/
    var passwordPattern=/^[\S]{6,16}$/
    var validatePattern=/^[0-9]{5}$/

    if (!emailPattern.test(email)){
        alert("邮箱格式不正确")
        return false
    }
    if (password!=passwordRepeat){
        alert("两次密码不一致")
        return false
    }
    if (!passwordPattern.test(password) || !passwordPattern.test(passwordRepeat)){
        alert("密码必须为6-16个字符")
        return false
    }
    if (!validatePattern.test(validateValue)){
        alert("验证码格式不正确")
        return false
    }
    makeSignOn(email,password,validateValue)
    return false
}
function makeSignOn(email,password,validate){
    var data={}
    data["email"]=email
    data["password"]=password
    data["validate"]=validate
    var xmlHttp=new XMLHttpRequest()
    xmlHttp.open("POST","/doSignOn",true)
    xmlHttp.setRequestHeader("content-type","application/json")
    xmlHttp.onreadystatechange=function(){
        if (xmlHttp.readyState==4){
            if (xmlHttp.status==200){
                var text=xmlHttp.responseText
                var state=JSON.parse(text)
                console.log(text)
                var success=state["success"]
                if (success){
                    alert("注册成功")
                    openLogin()
                }else{
                    alert("注册失败")
                }
            }
        }
    }
    xmlHttp.timeout=10000
    xmlHttp.ontimeout=function(){
        button.onclick=onSubmit
    }
    xmlHttp.send(JSON.stringify(data))
    console.log(JSON.stringify(data))
}
$(document).ready(function(){
    console.log("凭什么打开了控制台")
    note1=new Vue({
        el:"#type1",
        data:{
            col:[],
        },
        nextTick:function () {
            console.log(col1.offsetHeight || col1.clientHeight)
        }
    })
    note2=new Vue({
        el:"#type2",
        data:{
            col:[],
        }
    })
    note3=new Vue({
        el:"#type3",
        data:{
            col:[],
        }
    })
    books=new Vue({
        el:"#book",
        data:{
            books:[],
            currentShown:{bookName:"什么也没有哦",bookDescription:"什么也没有哦"}
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
    loadBooks()
})