function submitBook(){
    console.log("enter submit")
    var name=document.forms["postForm"].bookName.value
    var des=document.forms["postForm"].bookDes.value
    var url=document.forms["postForm"].bookUrl.value
    var message=document.forms["postForm"].bookMessage.value

    if (name=="" || des=="" || url=="" || message==""){
        alert("信息不完整")
        return false
    }
    var data={}
    data["bookName"]=name
    data["bookDescription"]=des
    data["bookUrl"]=url
    data["bookMessage"]=message
    var xh=new XMLHttpRequest()
    xh.open("POST","/bookManage/postBook-processing",true)
    xh.onreadystatechange=function () {
        if (xh.readyState==4){
            if (xh.status==200){
                var text=xh.responseText
                var result=JSON.parse(text)
                var success=result["result"]
                if (success){
                    alert("上传成功")
                }else{
                    alert("上传失败：未知错误")
                }
            }else if (xh.status==403){
                alert("无权操作")
            }else{
                alert("上传失败：未知错误")
            }
        }
    }
    xh.send(JSON.stringify(data))
    return false
}