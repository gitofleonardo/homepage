function refleshTime(){
                var d=new Date();
                var year=d.getFullYear();  //年
                var mouth=d.getMonth()+1;  //月
                var date=d.getDate();      //日
                var hour=d.getHours();     //时
                var minute=d.getMinutes(); //分
                var second=d.getSeconds(); //秒
                if (mouth<10){
                    mouth='0'+mouth;
                }
                if (date<10){
                    date='0'+date;
                }
                if (hour<10){
                    hour='0'+hour;
                }
                if (minute<10){
                    minute='0'+minute;
                }
                if (second<10){
                    second='0'+second;
                }
                document.getElementById('YearMouthDay').innerHTML='当前日期：'+year+'年'+mouth+'月'+date+'日';
                document.getElementById('HourMinuteSecond').value=hour+':'+minute+':'+second;
}
setInterval("refleshTime()",500);//每单位毫秒数执行一次前面的语句