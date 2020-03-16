function checkUser(){
    console.log("check")
    var account=document.getElementById("account").value
    var password=document.getElementById("password").value
    var accountInput=document.getElementById("accountGroup")
    var passwordInput=document.getElementById("passwordGroup")
    if (account==""){
        accountInput.classList.add("has-error")
        console.log("warning")
        return false
    }else{
        accountInput.classList.remove("has-error")
    }
    if (password==""){
        passwordInput.classList.add("has-error")
        console.log("warning")
        return false
    }else{
        passwordInput.classList.remove("has-error")
    }
    console.log("success")
    return true
}