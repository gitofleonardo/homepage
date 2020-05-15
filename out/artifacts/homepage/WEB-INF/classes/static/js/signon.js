window.onload=function(){
    window.alert("注意:你必须联系本人获取注册码")
}
function onSubmit(){
    var emailG=document.getElementById("emailGroup")
    var passwordG=document.getElementById("passwordGroup")
    var passwordRepeatG=document.getElementById("repeatPasswordGroup")
    var validateG=document.getElementById("validateGroup")

    var email=document.getElementById("email").value
    var password=document.getElementById("password").value
    var passwordRepeat=document.getElementById("passwordRepeat").value
    var validateValue=document.getElementById("validate").value

    var emailPattern=/^([a-zA-Z]|[0-9])(\w|\-)+@[a-zA-Z0-9]+\.([a-zA-Z]{2,4})$/
    var passwordPattern=/^[\S]{6,16}$/
    var validatePattern=/^[0-9]{5}$/

    if (!emailPattern.test(email)){
        emailG.classList.add("has-error")
        showError("邮箱格式不正确")
        return false
    }else{
        hideError()
        emailG.classList.remove("has-error")
    }
    if (password!=passwordRepeat){
        showError("两次密码不一致")
        passwordG.classList.add("has-error")
        passwordRepeatG.classList.add("has-error")
        return false
    }else{
        hideError()
        passwordG.classList.remove("has-error")
        passwordRepeatG.classList.remove("has-error")
    }
    if (!passwordPattern.test(password) || !passwordPattern.test(passwordRepeat)){
        showError("密码必须为6-16个字符")
        passwordG.classList.add("has-error")
        return false
    }else{
        hideError()
        passwordG.classList.remove("has-error")
    }
    if (!validatePattern.test(validateValue)){
        validateG.classList.add("has-error")
        return false
    }else{
        validateG.classList.remove("has-error")
    }
    makeSignOn(email,password,validateValue)
    return false
}
function makeSignOn(email,password,validate){
    var button=document.getElementById("signOnButton")
    button.onclick=function(){}
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
                    showSuccess(state["message"])
                    jumpToLogin()
                }else{
                    showError(state["message"])
                    button.onclick=onSubmit
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
function openQQ(){
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
        window.location.href="tencent://message/?uin=971840889&Site=http://vps.shuidazhe.com&Menu=yes"
    }
}
function jumpToLogin(){
    window.location.href="/login"
}
function showError(message){
    var errorGroup=document.getElementById("errorGroup")
    var inputError=document.getElementById("inputError")

    errorGroup.style.display="block"
    inputError.innerText=message
}
function showSuccess(message){
    var errorGroup=document.getElementById("errorGroup")
    var inputError=document.getElementById("inputError")

    errorGroup.style.display="block"
    inputError.classList.remove("alert-danger")
    inputError.classList.add("alert-success")
    inputError.innerText=message
}
function hideError(){
    document.getElementById("errorGroup").style.display="none"
}