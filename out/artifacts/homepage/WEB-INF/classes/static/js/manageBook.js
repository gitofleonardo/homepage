$(document).ready(function(){
    console.log("ready")
    loadBook(0)
})
function contactMe() {
    var sUserAgent = navigator.userAgent.toLowerCase();
    var bIsIpad = sUserAgent.match(/ipad/i) == "ipad";
    var bIsIphoneOs = sUserAgent.match(/iphone os/i) == "iphone os";
    var bIsMidp = sUserAgent.match(/midp/i) == "midp";
    var bIsUc7 = sUserAgent.match(/rv:1.2.3.4/i) == "rv:1.2.3.4";
    var bIsUc = sUserAgent.match(/ucweb/i) == "ucweb";
    var bIsAndroid = sUserAgent.match(/android/i) == "android";
    var bIsCE = sUserAgent.match(/windows ce/i) == "windows ce";
    var bIsWM = sUserAgent.match(/windows mobile/i) == "windows mobile";
    if (bIsIpad || bIsIphoneOs || bIsMidp || bIsUc7 || bIsUc || bIsAndroid || bIsCE || bIsWM) {
        window.location.href="mqqwpa://im/chat?chat_type=wpa&uin=971840889&version=1&src_type=web&web_src=oicqzone.com"
    } else {
        window.location.href="tencent://message/?uin=971840889&Site=http://huangchengxi.cn"
    }
}
function loadBook(page){
    let xh=new XMLHttpRequest();
    xh.open("GET","/recommendedBooks?page="+page+"&size=5",true)
    xh.setRequestHeader("Content-Type","application/json")
    xh.onreadystatechange=function () {
        if (xh.readyState==4){
            if (xh.status==200){
                var text=xh.responseText
                var json=JSON.parse(text)
                var books=json["_embedded"]["recommendedBooks"]
                var pageCount=json["page"]["totalPages"]
                var size=json["page"]["size"]

                let tbody=document.getElementById("bookTable")
                tbody.innerText=""
                for (var i=0;i<size;i++){
                    var book=books[i]
                    var bookName=book["bookName"]
                    var bookDes=book["bookDescription"]
                    var bookUrl=book["bookUrl"]
                    var bookMessage=book["bookMessage"]
                    var row=document.createElement("tr")
                    var tdn=document.createElement("td")
                    var tdd=document.createElement("td")
                    var tdu=document.createElement("td")
                    var tdm=document.createElement("td")
                    var tdp=document.createElement("td")
                    tdn.innerText=bookName
                    tdd.innerText=bookDes
                    var a=document.createElement("a")
                    a.href=bookUrl
                    a.innerText=bookUrl
                    tdu.appendChild(a)
                    tdm.innerText=bookMessage
                    var del=document.createElement("a")
                    del.innerText="删除"
                    del.id=book["id"]
                    del.addEventListener("click",conformDelete)
                    tdp.appendChild(del)
                    row.appendChild(tdn)
                    row.appendChild(tdd)
                    row.appendChild(tdu)
                    row.appendChild(tdm)
                    row.appendChild(tdp)
                    tbody.appendChild(row)
                }
                var pagination=document.getElementById("bookPagination")
                pagination.innerText=""
                for (var i=0;i<pageCount;i++){
                    var li=document.createElement("li")
                    var a=document.createElement("a")
                    a.addEventListener("click",function(){
                        var page=this.innerText-1
                        loadBook(page)
                    })
                    a.innerText=i+1
                    li.appendChild(a)
                    pagination.appendChild(li)
                }
            }
        }
    }
    xh.send("")
}
function conformDelete(){
    var con=window.confirm("确认删除")
    if (con==true){
        var data={}
        data["id"]=this.id
        var xh=new XMLHttpRequest()
        xh.open("POST","/bookManage/delete",true)
        xh.onreadystatechange=function(){
            if (xh.readyState==4){
                if (xh.status==403){
                    alert("无权操作")
                }else if (xh.status==200){
                    alert("删除成功")
                    loadBook(0)
                }
            }
        }
        xh.send(JSON.stringify(data))
    }
}