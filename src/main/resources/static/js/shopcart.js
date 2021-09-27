//定义购物车的数组，没有后端的时候，这里可以直接定义成固定的数组
let  shopcartListData=[
    {
        goodsno:'1001',
        image:'./images/goods/0abb0b66988c4dd2be4ded15c8219983.jpg',
        name:'IT项目管理',
        salesprice:120,
        nums:2,
        checked:false,
    },
    {
        goodsno:'1002',
        image:'./images/goods/f6123475715e41a39f22b5db68e33951.jpg',
        name:'鬼谷子传奇（套装全2册） （你见到鬼谷子的面容之日，是你臻于练达颖悟而走向成功之时）',
        salesprice:10.5,
        nums:1,
        checked:false,
    },
    {
        goodsno:'1003',
        image:'./images/goods/f6123475715e41a39f22b5db68e33951.jpg',
        name:'鬼谷子传奇（套装全2册） （你见到鬼谷子的面容之日，是你臻于练达颖悟而走向成功之时）',
        salesprice:20.5,
        nums:2,
        checked:false,
    },
    {
        goodsno:'1004',
        image:'./images/goods/f6123475715e41a39f22b5db68e33951.jpg',
        name:'鬼谷子传奇（套装全2册） （你见到鬼谷子的面容之日，是你臻于练达颖悟而走向成功之时）',
        salesprice:20.5,
        nums:1,
        checked:false,
    }
]
//当页面加载的时候调用
window.onload=function(){
    console.log("发送请求获取购物车信息")
    //1.发送请求得到当前用户的购物车信息
    $.ajax({
        url:"cart/find",
        type:"get",
        success:function (res) {
            console.log(res);
            //2.得到之后将数据渲染页面上
            //调用渲染方法显示购物车信息
            renderCartList(res.data);

            //3.计算总价
            //将获得的数据赋值给全局变量
            shopcartListData = res.data;

            //调用计算总价格的方法
            getTotalPrice();
        }
    });
}
//渲染购物车列表信息
function renderCartList(shopcartListData){
    //定义数组的头部信息
    let tableStart=`<table class='shoptable'>`;
    let tableHeader=`
        <thead>
            <tr>
                <th>
                    <input type='checkbox' onclick="checkAll()" id="selectAll">
                    <span>全选</span>
                </th>
                <th>图片</th>
                <th>商品名称</th>
                <th>单价</th>
                <th>数量</th>
                <th>小计</th>
                <th>操作</th>
            </tr>
        </thead>
    `
    let tablebody='';
    for(let item of shopcartListData){
        let tableBodyTr=`
            <tr>
                <!--绑定的是购物车id-->
                <td>
                    <input type='checkbox' 
                        onclick="selectGood(${item.id})" class="checkbox" id="${item.id}"/>
                </td>
                <td>
                   <div class="shopimg">
                       <img src='${item.goods.image}'>
                   </div>
                </td>
                <td>
                    ${item.goods.name}
                </td>
                <td>
                    <span class="price">￥${item.goods.salesprice}</span>
                </td>
                <td>
                    <span class="opr" onclick="changeNum(-1,${item.id})">-</span>
                     <input type='' value="${item.nums}" class="inpunum" id="input${item.id}"/>
                    <span class="opr" onclick="changeNum(1,${item.id})">+</span>
                </td>
                <td>
                    <!--toFixed指定保留小数点后几位，会进行四舍五入-->
                    <span class="totalprice" id="sm_total${item.id}">￥${(item.goods.salesprice * item.nums).toFixed(1)}</span>
                </td>
                <td>
                    <span onclick="del(${item.id})">删除</span>
                </td>
            </tr>
        `
        tablebody+=tableBodyTr;
    }

    let tableEnd=`</table>`;
    let totalpriceArea=`<div id='totalprice' class='tpr'></div>`
    let tableInfo=tableStart+tableHeader+tablebody+tableEnd+totalpriceArea;
    document.querySelector("#shopcartarea").innerHTML=tableInfo;
}
//删除购物车
function del(id) {
    //发送请求删除数据
    $.ajax({
        url:"cart/del?id="+id,
        success:function (res) {
            console.log(res);
        }
    });
}


//修改数量
function changeNum(num,id) {// 1  -1
    console.log(num,id)
    //1.判断是+还是-
    if (num == -1){
        console.log("减操作");
        //减：判断当前商品的数量是否已经是1了，因为最少应该购买一件
        //得到当前商品对应的数量
        let nums = $("#input"+id).val();
        console.log(nums);
        if (nums == 1){
            alert("至少购买一件");
            return; //不执行其它操作
        }
    }
    //2.发送请求让后台修改当前购物车的商品数量
    $.ajax({
        url: "cart/update",
        data:{
            "id":id,
            "nums":num      //1 -1
        },
        success:function (res) {
            console.log(res);
            //根据结果修改前端页面上的数量
            if (res.status == 'REQUEST_SUCCESS'){
                console.log("修改成功");
                //修改前端数据：当前购物车的数量，总价
                //3.1
                //通过id选择器找到对应的输入框
                let input = $("#input"+id);
                let nums = parseInt(input.val());
                //修改数据
                nums = nums + num;
                //再设置到输入框
                input.val(nums);

                //3.2.重新计算当前购物车对应的小计 = 当前商品数量 * 单价
                //修改全局数组中对应购物车的数量
                for(let i=0;i<shopcartListData.length;i++){
                    let cart = shopcartListData[i];
                    if (cart.id == id){
                        cart.nums = nums;
                        //小计
                        let sm_total = cart.nums * cart.goods.salesprice;
                        sm_total = sm_total.toFixed(1); //处理精度
                        //将小计渲染到对应的标签上
                        $("#sm_total"+id).text("￥"+sm_total);
                        break;
                    }
                }
                //3.3.计算总价
                totalPrice();
            }
        }
    });
}


//全选功能
function checkAll(){ 
    let flag=document.querySelector("#selectAll").checked;

    //先找到所有的购物车复选框
    //console.log(document.querySelector(".checkbox"));
    //利用jQuery通过类找到所有的复选框
    let carts = $(".checkbox");

    if(flag){
        //表明全选复选框被勾选
        //1.找到其他的复选框，让全部改为勾选状态
        carts.prop("checked",true);   //批量勾选

        //2.重新计算被勾选商品的数量、总价

        document.querySelector("#selectAll").nextElementSibling.innerHTML="反选";
        document.querySelector("#selectAll").checked=true;
    }else{
        //取消全部勾选
        carts.prop("checked",false);  //批量取消

        document.querySelector("#selectAll").nextElementSibling.innerHTML="全选";
        document.querySelector("#selectAll").checked=false;
    }
    //计算总价
    totalPrice();
}
function totalPrice() {
    let count = 0;  //统计被勾选商品的数量
    let total = 0;  //统计总价

    //先获取到所有的复选框，判断复选框的勾选状态，如果勾选上那么总价中需要包含当前商品的小计，同时
    //勾选商品的数量应该+1
    let carts = $(".checkbox");  //数组
    for(let i = 0;i < carts.length;i++){
        let cart = $(carts[i]);   //在通过下标得到对象时得到的是js对象，需要转换成jQuery对象才行
        if (cart.prop("checked")){
            count += 1;     //购买数量+1
            total += shopcartListData[i].nums * shopcartListData[i].goods.salesprice;
        }
    }
    //调整总价精度
    total = total.toFixed(1);

    //将商品的数量、总价显示在标签上
    $("#selectedcount").text(count);
    $("#total").text("￥"+total);
}

/*
    获取总价格
*/
function getTotalPrice(){
   document.querySelector('#totalprice').innerHTML=`
        <span>已选择</span><span id='selectedcount'>0</span><span>件商品</span>
        总价:<span class='pr' id="total">￥0</span>
        <button class='btn'>去结算</button>
   `;
}

//商品复选框点击事件
function selectGood(id){
    //1.获取到当前付复选框
    let checkbox = $("#"+id);

    //2.判断复选框的状态
    if (!checkbox.prop("checked")){
        //没勾选
        //2.1.权限状态改为非勾选
        document.querySelector("#selectAll").nextElementSibling.innerHTML="全选";
        document.querySelector("#selectAll").checked=false;
    }else {
        //勾选上
        //判断是否所有的商品都勾选上，如果是将所有商品复选框改为勾选状态
        let carts = $(".checkbox");
        let flag = false;
        for(let i=0;i < carts.length; i++){
            let cart = $(carts[i]);
            if (!cart.prop("checked")){
                flag = true;
                break;     //只要有一个没有勾选上，直接结束
            }
        }
        //如果代码执行到此处代表：所有的购物车商品都被勾选上了
        if (!flag){
            document.querySelector("#selectAll").nextElementSibling.innerHTML="反选";
            document.querySelector("#selectAll").checked=true;
        }
    }

    //3.重新计算总价
    totalPrice();
}
