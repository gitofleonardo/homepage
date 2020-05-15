var dayCount=0
var day

$(document).ready(function(){
    var startDay=new Date("2019-10-19")
    var diffTime=new Date().getTime()-startDay.getTime()
    dayCount=Math.floor(diffTime/(24*3600*1000))
    console.log(dayCount)
    day=new Vue({
        el:"#day",
        data:{
            imgs:[
                
            ]
        }
    })
    loadDay()
})
function loadDay(){
    var tmp=dayCount
    while (tmp>0){
        var remain=tmp%10
        tmp=parseInt(tmp/10)
        console.log(tmp)
        var name="/static/imgs/"+remain+".png"
        var src={}
        src.src=name
        day.imgs.unshift(src)
    }
}