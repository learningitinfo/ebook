let stock =0 ;
//当页面加载的时候会被调用
window.onload=function(){
     //给该元素绑定事件:元素对象.on事件类型=事件处理函数
    document.querySelector('#pco').onclick=function(){
       console.log('评论信息选项卡被点击了..');
       //隐藏上商品详情主区域的内容
       document.querySelector('.prointro-prodetail').style.display="none";
       //显示商品评论主区域的内容
       document.querySelector('.prointro-procomment').style.display="block";
       //为商品评论选项卡设置样式
      this.style.borderLeft="1px solid #ccc";
      this.style.borderTop="1px solid #ccc";
      this.style.borderRight="1px solid #ccc";
      //为商品详情选项卡设置样式
      this.previousElementSibling.style.borderTop="none";
      this.previousElementSibling.style.borderLeft="none";
      this.previousElementSibling.style.borderRight="none";
      //让气泡消失
      //this.nextElementSibling.style.display="none";
    }
    document.querySelector('#pdt').onclick=function(){
       console.log('商品详情信息被点击了..');
         //隐藏上商品详情主区域的内容
       document.querySelector('.prointro-prodetail').style.display="block";
       //显示商品评论主区域的内容
       document.querySelector('.prointro-procomment').style.display="none";
       //让相邻下一个兄弟元素隐藏边框
       this.nextElementSibling.style.borderTop="none";
       this.nextElementSibling.style.borderLeft="none";
       this.nextElementSibling.style.borderRight="none";
       //设置商品详情选项卡样式
       this.style.borderLeft="1px solid #ccc";
       this.style.borderTop="1px solid #ccc";
       this.style.borderRight="1px solid #ccc";
    }
}

//计算购物车中的数据
function calcCatCount(){
    $.ajax({
        url:"cart/find",
        type:"get",
        success:function (res) {
            if(res.data!=null){
                $(".shopcart span:eq(1)").text("（"+res.data.length+"）");
            }
        }
    });
    $("li .shopcart").click(function (){
        //获取session中的值
        let userid = window.sessionStorage.getItem("userid");
        if(userid==null) {
            window.location.href = "login.html";
        }else{
            window.location.href = "shopcart.html";
        }
    });
}

