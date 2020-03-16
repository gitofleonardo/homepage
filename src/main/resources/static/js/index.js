var centerPercent=60;
var first=false;
var currentIndex=0;
var displayPictures=["#pic1","#pic2","#pic3"];
var mainSpeed=400;

$(document).ready(function(){
    $("#pic1").click(function(){
        if (currentIndex==1){
            displayPicRightFunc()
        }else if (currentIndex==2){
            displayPicLeftFunc();
        }
    });
    $("#pic2").click(function(){
        if (currentIndex==0){
            displayPicLeftFunc()
        }else if (currentIndex==2){
            displayPicRightFunc();
        }
    });
    $("#pic3").click(function(){
        if (currentIndex==0){
            displayPicRightFunc()
        }else if (currentIndex==1){
            displayPicLeftFunc();
        }
    });
    setPicPos();

    $(".book-list-item").on("click",function(){
        var id=this.id
        console.log(id)
        loadBookContent(id)
    })
    testImageConnection()
})

function contactMe(){
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
function setPicPos(){
    console.log("setPos call");
    var sideWidth=(100-centerPercent)/2;
    var sidePicWidth=100-centerPercent;
    var sideHeight=(sidePicWidth/centerPercent)*100;
    var sidePaddingTop=(100-sideHeight)/2;

    var picCenter=displayPictures[currentIndex];
    var picLeft=displayPictures[currentIndex-1<0?displayPictures.length-1:currentIndex-1];
    var picRight=displayPictures[(currentIndex+1)%displayPictures.length];

    $(picLeft).animate({
        top:String(sidePaddingTop)+"%",
        left:String(-sideWidth)+"%",
        width:String(sidePicWidth)+"%",
        height:String(sideHeight)+"%"
    },0);
    $(picRight).animate({
        top:String(sidePaddingTop)+"%",
        left:String(centerPercent+sideWidth)+"%",
        width:String(sidePicWidth)+"%",
        height:String(sideHeight)+"%"
    },0);
}
function displayPicLeftFunc(){
    if (first){
        setPicPos();
        first=false;
    }else{
        $(".display-pic-container").css("pointer-event","none");

        var sideWidth=(100-centerPercent)/2;
        var sidePicWidth=100-centerPercent;
        var sideHeight=(sidePicWidth/centerPercent)*100;
        var sidePaddingTop=(100-sideHeight)/2;

        var picCenter=displayPictures[currentIndex];
        $(picCenter).animate({
            top:String(sidePaddingTop)+"%",
            left:String(-sideWidth)+"%",
            width:String(sidePicWidth)+"%",
            height:String(sideHeight)+"%"
        },mainSpeed,"linear",function(){
    
        });
        var picLeft=displayPictures[currentIndex-1<0?displayPictures.length-1:currentIndex-1];
        $(picLeft).animate({
            top:String(sidePaddingTop)+"%",
            left:String(-sidePicWidth)+"%"
        },mainSpeed/2,"linear",function(){
            //查找下一张右图片的位置
            //并设置好位置
            var nextRightPic=displayPictures[(currentIndex+1)%displayPictures.length];
            $(nextRightPic).css({
                top:String(sidePaddingTop)+"%",
                left:String(100)+"%",
                width:String(sidePicWidth)+"%",
                height:String(sideHeight)+"%"
            });
            $(nextRightPic).animate({
                top:String(sidePaddingTop)+"%",
                left:String(sideWidth+centerPercent)+"%",
                width:String(sidePicWidth)+"%",
                height:String(sideHeight)+"%"
            },mainSpeed/2,"linear");
        });
        var picRight=displayPictures[currentIndex+1>displayPictures.length-1?0:currentIndex+1];
        $(picRight).animate({
            top:String(0)+"%",
            left:String(sideWidth)+"%",
            width:String(centerPercent)+"%",
            height:String(100)+"%"
        },mainSpeed,"linear",function(){
            $(".display-pic-container").css("pointer-event","all");
        });
        currentIndex=(currentIndex+1)%displayPictures.length;
    }
}
function displayPicRightFunc(){
    if (first){
        setPicPos();
        first=false;
    }else{
        $(".display-pic-container").css("pointer-event","none");
        var sideWidth=(100-centerPercent)/2;
        var sidePicWidth=100-centerPercent;
        var sideHeight=(sidePicWidth/centerPercent)*100;
        var sidePaddingTop=(100-sideHeight)/2;

        var picCenter=displayPictures[currentIndex];
        $(picCenter).animate({
            top:String(sidePaddingTop)+"%",
            left:String(sideWidth+centerPercent)+"%",
            width:String(sidePicWidth)+"%",
            height:String(sideHeight)+"%"
        },mainSpeed,"linear",function(){
    
        });
        var picLeft=displayPictures[currentIndex-1<0?displayPictures.length-1:currentIndex-1];
        $(picLeft).animate({
            top:String(0)+"%",
            left:String(sideWidth)+"%",
            width:String(centerPercent)+"%",
            height:String(100)+"%"
        },mainSpeed,"linear",function(){
            $(".display-pic-container").css("pointer-event","all");
        });
        var picRight=displayPictures[currentIndex+1>displayPictures.length-1?0:currentIndex+1];
        $(picRight).animate({
            left:String(100)+"%",
        },mainSpeed/2,"linear",function(){
            var nextLeftPic=displayPictures[currentIndex-1<0?displayPictures.length-1:currentIndex-1];
            $(nextLeftPic).css({
                top:String(sidePaddingTop)+"%",
                left:String(-sidePicWidth)+"%",
                width:String(sidePicWidth)+"%",
                height:String(sideHeight)+"%"
            });
            $(nextLeftPic).animate({
                top:String(sidePaddingTop)+"%",
                left:String(-sideWidth)+"%",
                width:String(sidePicWidth)+"%",
                height:String(sideHeight)+"%"
            },mainSpeed/2,"linear");
        });
        currentIndex=currentIndex-1<0?displayPictures.length-1:currentIndex-1;
    }
}

function loadBookContent(id){
    var data={}
    data["id"]=id
    
    var xh=new XMLHttpRequest()
    xh.open("POST","/getBookDetail",true)
    xh.setRequestHeader("content-type","application/json")
    xh.onreadystatechange=function(){
        if (xh.readyState==4){
            if (xh.status==200){
                var bookNa=document.getElementById("bookName")
                var bookDes=document.getElementById("bookDescription")
                var bookUr=document.getElementById("bookUrl")
                var bookMsg=document.getElementById("bookMessage")

                var body=xh.responseText
                var result=JSON.parse(body)
                var bookName=result["bookName"]
                var bookDesctiption=result["bookDescription"]
                var bookUrl=result["bookUrl"]
                var bookMessage=result["message"]

                console.log(bookNa)
                console.log(bookName)
                console.log(bookDesctiption)
                console.log(bookUr)
                bookNa.innerText=bookName
                bookDes.innerText=bookDesctiption
                bookUr.innerHTML="<a href="+bookUrl+">"+bookUrl+"</a>"
                bookMsg.innerText=bookMessage
            }
        }
    }
    xh.send(JSON.stringify(data))
}

function uploadBook(){
    window.location.href="/uploadBook"
}
function loadImages(page){
    var xh=new XMLHttpRequest()
    xh.open("GET","/images?page="+page+"&size=8",true)
    xh.setRequestHeader("content-type","application/json")
    xh.onreadystatechange=function(){
        if (xh.readyState==4){
            console.log(xh.status)
            if (xh.status==200){
                try{
                    var text=xh.responseText
                    console.log(text)
                    var result=JSON.parse(text)
                    var imageContainer=document.getElementById("picWallContainer")
                    var images=result["_embedded"]["images"]
                    console.log(images)
                    imageContainer.innerHTML=""
                    for (var i=0;i<images.length;i++){
                        var imageNode=document.createElement("div")
                        imageNode.classList.add("col-sm-3")
                        imageNode.classList.add("col-md-3")
                        var thumbNail=document.createElement("div")
                        thumbNail.classList.add("thumbnail")
                        var img=document.createElement("img")
                        img.src=images[i].url
                        img.addEventListener("load",function(){
                            drawImg(this)
                        })
                        var des=document.createElement("div")
                        des.innerText=images[i].description
                        
                        thumbNail.appendChild(img)
                        thumbNail.appendChild(des)
                        imageNode.appendChild(thumbNail)
    
                        imageContainer.appendChild(imageNode)
                    }
                    var pagination=document.getElementById("picWallPagination")
                    pagination.innerText=""
                    var size=result["page"]["totalPages"]
                    for (var i=0;i<size;i++){
                        var li=document.createElement("li")
                        var a=document.createElement("a")
                        a.href="#picWall"
                        a.innerText=i+1
                        li.appendChild(a)
                        li.addEventListener("click",function(){
                            loadImages(this.firstChild.innerText-1)
                        })
                        pagination.appendChild(li)
                    }
                }catch{
                    showNoPermissionOnAlbum()
                }finally{

                }
            }else{
                showNoPermissionOnAlbum()
            }
        }
    }
    xh.send("")
}
function testImageConnection(){
    var xh=new XMLHttpRequest()
    xh.open("GET","/imageResource",true)
    xh.setRequestHeader("content-type","application/json")
    xh.onreadystatechange=function () {
        if (xh.readyState=4){
            if (xh.status!=403){
                loadImages(0)
            }else{
                showNoPermissionOnAlbum()
            }
        }
    }
    xh.send("")
}
function showNoPermissionOnAlbum(){
    var picWallBoxy=document.getElementById("picWallBody")
    picWallBoxy.innerText=""
    var alert=document.createElement("div")
    alert.classList.add("alert")
    alert.classList.add("alert-warning")
    alert.innerText="您无权查看此相册"
    picWallBoxy.appendChild(alert)
}
function drawImg(img){
    $(img).jqthumb({
        width:'100%',
        height:'150px',
        position:{y:'50%',x:'50%'},
        zoom:'1',
        method:'auto'
    })
}