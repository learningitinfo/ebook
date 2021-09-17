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
    //调用渲染方法显示购物车信息
    renderCartList(shopcartListData);
    //调用计算总价格的方法
    getTotalPrice();
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
                <td><input type='checkbox' ${item.checked?"checked":""} onclick="selectGood(${item.goodsno})"/></td>
                <td>
                   <div class="shopimg">
                       <img src='${item.image}'>
                   </div>
                </td>
                <td>
                    ${item.name}
                </td>
                <td>
                    <span class="price">￥${item.salesprice}</span>
                </td>
                <td>
                    <span class="opr">-</span>
                     <input type='' value="${item.nums}" class="inpunum"/>
                    <span class="opr">+</span>
                </td>
                <td>
                    <span class="totalprice">￥${item.salesprice*item.nums}</span>
                </td>
                <td>
                    <a href="#">删除</a>
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
//全选功能
function checkAll(){ 
    let flag=document.querySelector("#selectAll").checked;
    if(flag){
        let all=[];
        for(let item of shopcartListData){
            item.checked=true;
            all.push(item);
        }
        shopcartListData=all;
        //调用购物车列表渲染方法
        renderCartList(shopcartListData);
        document.querySelector("#selectAll").nextElementSibling.innerHTML="反选";
        document.querySelector("#selectAll").checked=true;
    }else{
        let all=[];
        for(let item of shopcartListData){
            item.checked=false;
            all.push(item);
        }
        shopcartListData=all;
        //调用购物车列表渲染方法
        renderCartList(shopcartListData);
        document.querySelector("#selectAll").nextElementSibling.innerHTML="全选";
        document.querySelector("#selectAll").checked=false;
    }
    getTotalPrice();
    //计算已经选择到的商品个数
    let selectedCount=shopcartListData.filter(item=>item.checked).length;
    document.querySelector('#selectedcount').innerHTML=selectedCount;
}
/*
    获取总价格
*/
function getTotalPrice(){
   let totalprice=shopcartListData.filter(item=>item.checked).reduce((prev,cur)=>prev+cur.salesprice*cur.nums,0);
   document.querySelector('#totalprice').innerHTML=`
        <span>已选择</span><span id='selectedcount'>0</span><span>件商品</span>
        总价:<span class='pr'>￥${totalprice}</span>
        <button class='btn'>去结算</button>
   `;
}

//选中商品信息
function selectGood(goodsno){
    //定义变量，用来记录选择的商品在商品列表中的位置(下标)
    let count;
    shopcartListData.forEach((item,index)=>{
        if(item.goodsno==goodsno){
            count=index;
        }
    })
    if(shopcartListData[count].checked){
        shopcartListData[count].checked=false;
    }else{
        shopcartListData[count].checked=true;
    }
    //在调用一次计算
    getTotalPrice();
    //计算已经选择到的商品个数
    let selectedCount=shopcartListData.filter(item=>item.checked).length;
    document.querySelector('#selectedcount').innerHTML=selectedCount;
}
