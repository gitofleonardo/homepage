function mousemove(obj){
        obj.src="Images/xujinhua.jpg";
}

function mouseout(obj){
        obj.src="Images/quanshenzhao.png";
}

function increase(){
        var image=document.getElementById("img");
        var width=image.width;
        var height=image.height;
        height=Math.trunc((image.height/image.width)*(width+20));         //数值取整
        if(height>290){
                height=290;
                width=Math.trunc((image.width/image.height)*height);
                if(width>260){
                        width=260;
                }
                image.width=width;
                image.height=height;
                return;
        }
        width=width+20;
        if(width>260){
                width=260;
        }
        image.width=width;
        image.height=height;
}

function decrease(){
        var image=document.getElementById("img");
        var width=image.width;
        var height=image.height;
        height=Math.trunc((image.height/image.width)*(width-20));
        if(height<218){
                height=218;
                width=Math.trunc((image.width/image.height)*height);
                if(width<155){
                        width=155;
                }
                image.width=width;
                image.height=height;
                return;
        }
        width=width-20;
        if(width<155){
                width=155;
        }
        image.width=width;
        image.height=height;
}