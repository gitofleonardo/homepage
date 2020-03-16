function request(params) {           //从href中分割获取输入健的值
            var url = location.href;
            var paraString = url.substring(url.indexOf("?") + 1, url.length).split("&");
            var paraObj = { };
            for (i = 0; j = paraString[i]; i++) {
                paraObj[j.substring(0, j.indexOf("=")).toLowerCase()] = j.substring(j.indexOf("=") + 1, j.length);
            }
            var returnValue = paraObj[params.toLowerCase()];
            if (typeof (returnValue) == "undefined") {
                return "";
            } else {
                return returnValue;
            }
}

function getCurrentSecond(obj){       //页面跳转时先获取当前音乐的信息
            var audio = document.getElementById("media");
            var number=document.getElementById("musicNumber").innerText;
            var second = audio.currentTime;
            var paused = audio.paused;
            var muted = audio.muted;
            var volume = audio.volume;
            url=obj.href + '?number=' + number + "&currentSecond=" + second + 
	"&paused=" + paused + "&muted=" + muted + "&volume=" + volume;
            obj.href=url;
}

function initialize(){           //页面加载时初始化音乐内容，状态
            var currentSecond = decodeURI(request("currentSecond"));
            var stopButton = document.getElementById("audio");
            var muteButton = document.getElementById("mute");
            var makeMuteButton = document.getElementById("makeMute");
            var volumeDiv=document.getElementById("volumeDiv");
            var volumeProgress=document.getElementById("volumeProgress");
            var paused = decodeURI(request("paused"));
            var muted = decodeURI(request("muted"));
            var audio = document.getElementById("media");
            var number = decodeURI(request("number"));
            var volume = decodeURI(request("volume"));
            var name="从你的全世界路过#illusionary Daytime#告白之夜#银魂#Try#稳稳的幸福#夏天的风#雨前茶";
            var musicNumber = document.getElementById("musicNumber");
            var musicList=document.getElementById("musicList");
            name=name.split("#");
            initMusicSrc(number,audio,musicNumber,musicList);
            audio.currentTime = currentSecond;
            if(volume==""){
                audio.volume = 1;
            }else{
                audio.volume = volume;
            }
            volumeProgress.value=audio.volume*100;
            document.getElementById("volume").innerHTML=audio.volume*100;
            volumeDiv.style.visibility="hidden";
            document.addEventListener("click", function(e){        
                if(flag){           
                    volumeDiv.style.visibility="hidden";
                }
            });
            if(paused=="true"){
                audio.pause();
                stopButton.src="Images/bofang.png";
            }else{
                audio.play();
                stopButton.src="Images/zanting.png";
            }
            if(muted=="true"){
                audio.muted=true;
                makeMuteButton.src="Images/jingyin.png";
                muteButton.src="Images/jingyin.png";
            }else{
                audio.muted=false;
                makeMuteButton.src="Images/yinliang.png";
                muteButton.src="Images/yinliang.png";
            }
}

function initMusicSrc(number,audio,musicNumber,musicList){
            if(number=="0"){
                audio.src="Musics/从你的全世界路过.mp3";
                musicNumber.innerHTML=0;
                musicList.value="0";
            }else if(number=="1"){
                audio.src="Musics/illusionary Daytime.mp3";
                musicNumber.innerHTML=1;
                musicList.value="1";
            }else if(number=="2"){
                audio.src="Musics/告白之夜.mp3";
                musicNumber.innerHTML=2;
                musicList.value="2";
            }else if(number=="3"){
                audio.src="Musics/银魂.mp3";
                musicNumber.innerHTML=3;
                musicList.value="3";
            }else if(number=="4"){
                audio.src="Musics/Try.mp3";
                musicNumber.innerHTML=4;
                musicList.value="4";
            }else if(number=="5"){
                audio.src="Musics/稳稳的幸福.mp3";
                musicNumber.innerHTML=5;
                musicList.value="5";
            }else if(number=="6"){
                audio.src="Musics/夏天的风.mp3";
                musicNumber.innerHTML=6;
                musicList.value="6";
            }else if(number=="7"){
                audio.src="Musics/雨前茶.mp3";
                musicNumber.innerHTML=7;
                musicList.value="7";
            }
}

function controlStatus(){             //控制音乐栏的各个状态
            var audio = document.getElementById("media");
            var prevButton = document.getElementById("prev");
            var stopButton = document.getElementById("audio");
            var nextButton = document.getElementById("next");
            var repeatButton = document.getElementById("repeat");
            var muteButton = document.getElementById("mute");
            var makeMuteButton = document.getElementById("makeMute");
            var name="从你的全世界路过#illusionary Daytime#告白之夜#银魂#Try#稳稳的幸福#夏天的风#雨前茶";
            var number=document.getElementById("musicNumber").innerText;
            var musicList=document.getElementById("musicList");
            var paused;
            name=name.split("#");
            length=name.length;
            prevButton.onclick = function(){
                paused=audio.paused;
                number=parseInt(number)-1;
                if(number==-1){
                    number=length-1;
                }else{
                    number=number%length;
                }
                document.getElementById("musicNumber").innerHTML=number;
                musicList.value=number;
                audio.src=musicSrc(number);
                if(paused){
                    audio.pause();
                }else{
                    audio.play();
                }
            }
            nextButton.onclick = function(){
                paused=audio.paused;
                number=(parseInt(number)+1)%length;
                document.getElementById("musicNumber").innerHTML=number;
                musicList.value=number;
                audio.src=musicSrc(number);
                if(paused){
                    audio.pause();
                }else{
                    audio.play();
                }
            }
            stopButton.onclick = function(){
                if (audio.paused) { //判断当前的状态是否为暂停，若是则点击播放，否则暂停
                    audio.play();
                    stopButton.src="Images/zanting.png";
                }else{
                    audio.pause();
                    stopButton.src="Images/bofang.png";
                }
            }
            repeatButton.onclick = function(){
                audio.currentTime = 0;
                audio.play();
                stopButton.src="Images/zanting.png";
            }
            muteButton.onclick = function(){
                var volumeDiv=document.getElementById("volumeDiv");
                if(volumeDiv.style.visibility=="hidden"){
                    volumeDiv.style.visibility="visible";
                }else{
                    volumeDiv.style.visibility="hidden";
                }
            }
            makeMuteButton.onclick = function(){
                if(audio.muted){
                    audio.muted=false;
                    makeMuteButton.src="Images/yinliang.png";
                    muteButton.src="Images/yinliang.png";
                }else{
                    audio.muted=true;
                    makeMuteButton.src="Images/jingyin.png";
                    muteButton.src="Images/jingyin.png";
                }
            }
}

function musicSheet(){
            var name="从你的全世界路过#illusionary Daytime#告白之夜#银魂#Try#稳稳的幸福#夏天的风#雨前茶";
            var number=document.getElementById("musicNumber").innerText;
            var audio=document.getElementById("media");
            var totalDuration=Math.trunc(audio.duration);
            var timeProgress=document.getElementById("timeProgress");
            var value;
            var current=document.getElementById("current");
            var total=document.getElementById("total");
            var musicList=document.getElementById("musicList");
            name=name.split("#");
            length=name.length;
            current.innerHTML=setTimeStyle(audio.currentTime);
            if(isNaN(totalDuration)==false){             //判断totalDuration是否为NaN值，若是则显示00:00
                total.innerHTML=setTimeStyle(totalDuration);
            }else{
                total.innerHTML=setTimeStyle(0);
            }
            value=(audio.currentTime/totalDuration)*100;
            timeProgress.value=value;
            if(audio.ended){
                timeProgress.value=100;
                number=(parseInt(number)+1)%length;
                document.getElementById("musicNumber").innerHTML=number;
                audio.src="Musics/"+name[number]+".mp3";
                musicList.value=number;
                audio.play();
            }
}
setInterval('musicSheet()',100);  //每隔100毫秒刷新一次当前音乐时间进度

function setTimeStyle(time){      //根据秒数time，设置出"00:00"的时间格式，返回字符串
            var minute,second;
            time=Math.trunc(time);
            minute=Math.trunc(time/60);
            second=time-minute*60;
            if(minute<10){
                minute="0"+minute;
            }
            if(second<10){
                second="0"+second;
            }
            return minute+":"+second;
}

function musicSrc(number){        //选择音乐曲目，返回字符串
            var src;
            if(number=="0"){
                src="Musics/从你的全世界路过.mp3";
            }else if(number=="1"){
                src="Musics/illusionary Daytime.mp3";
            }else if(number=="2"){
                src="Musics/告白之夜.mp3";
            }else if(number=="3"){
                src="Musics/银魂.mp3";
            }else if(number=="4"){
                src="Musics/Try.mp3";
            }else if(number=="5"){
                src="Musics/稳稳的幸福.mp3";
            }else if(number=="6"){
                src="Musics/夏天的风.mp3";
            }else if(number=="7"){
                src="Musics/雨前茶.mp3";
            }
            return src;
}

function changeTimeProgress(event){           //点击进度条改变音乐进度
            event = event || window.event;
            var offsetX=event.offsetX;                  //鼠标在元素内的坐标
            var audio=document.getElementById("media");
            var totalDuration=Math.trunc(audio.duration);
            var timeProgress=document.getElementById("timeProgress");
            var current=document.getElementById("current");
            timeProgress.value=offsetX;
            audio.currentTime=Math.trunc((offsetX/100)*totalDuration);
            current.innerHTML=setTimeStyle(audio.currentTime);
}

function changeVolumeProgress(event){           //点击进度条改变音量大小
            event = event || window.event;
            var offsetX=event.offsetX;                  //鼠标在元素内的坐标
            var volumeProgress=document.getElementById("volumeProgress");
            var audio=document.getElementById("media");
            var muteButton = document.getElementById("mute");
            var makeMuteButton = document.getElementById("makeMute");
            volumeProgress.value=offsetX;
            audio.volume=volumeProgress.value/100;
            document.getElementById("volume").innerHTML=Math.trunc(audio.volume*100);
            if(audio.volume==0){
                audio.muted=true;
                makeMuteButton.src="Images/jingyin.png";
                muteButton.src="Images/jingyin.png";
            }else{
                audio.muted=false;
                makeMuteButton.src="Images/yinliang.png";
                muteButton.src="Images/yinliang.png";
            }
}

function changeMusic(value){
            var audio = document.getElementById("media");
            var paused;
            paused=audio.paused;
            document.getElementById("musicNumber").innerHTML=value;
            audio.src=musicSrc(value);
            if(paused){
                audio.pause();
            }else{
                audio.play();
            }
}
