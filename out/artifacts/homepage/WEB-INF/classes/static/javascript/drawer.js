function toggleDrawer(menu){
    var id=menu.getAttribute("data-drawer-navigation")
    var open=menu.getAttribute("data-open")
    var nav=document.getElementById(id)
    if (open=="true"){
        menu.setAttribute("data-open","false")
        nav.style.width="0px"
    }else{
        menu.setAttribute("data-open","true")
        nav.style.width="250px"
    }
}