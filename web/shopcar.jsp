<%--
  Created by IntelliJ IDEA.
  User: PZYCC
  Date: 2019/5/18
  Time: 16:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">

    <title>购物车页面</title>

    <link href="../AmazeUI-2.4.2/assets/css/amazeui.css" rel="stylesheet" type="text/css" />
    <link href="../basic/css/demo.css" rel="stylesheet" type="text/css" />
    <link href="../css/cartstyle.css" rel="stylesheet" type="text/css" />
    <link href="../css/optstyle.css" rel="stylesheet" type="text/css" />

    <script type="text/javascript" src="../js/jquery.js"></script>

</head>
<body>

<!--顶部导航条 -->
<div class="am-container header">
    <ul class="message-l">
        <div class="topMessage">
            <div class="menu-hd">
                <a href="#" target="_top" class="h">亲，请登录</a>
                <a href="#" target="_top">免费注册</a>
            </div>
        </div>
    </ul>
    <ul class="message-r">
        <div class="topMessage home">
            <div class="menu-hd"><a href="/home.jsp" target="_top" class="h">商城首页</a></div>
        </div>
        <div class="topMessage my-shangcheng">
            <div class="menu-hd MyShangcheng"><a href="person.action" target="_top"><i class="am-icon-user am-icon-fw"></i>个人中心</a></div>
        </div>
        <div class="topMessage mini-cart">
            <div class="menu-hd"><a id="mc-menu-hd" href="shopcar" target="_top"><i class="am-icon-shopping-cart  am-icon-fw"></i><span>购物车</span><strong id="J_MiniCartNum" class="h">0</strong></a></div>
        </div>
        <div class="topMessage favorite">
            <div class="menu-hd"><a href="#" target="_top"><i class="am-icon-heart am-icon-fw"></i><span>收藏夹</span></a></div>
        </div>
    </ul>
</div>

<!--悬浮搜索框-->

<div class="nav white">
    <div class="logo"><img src="../images/logo.png" /></div>
    <div class="logoBig">
        <li><img src="../images/logobig.png" /></li>
    </div>

    <div class="search-bar pr">
        <a name="index_none_header_sysc" href="#"></a>
        <form method="post" action="search">
            <input id="searchInput" name="productname" type="text" placeholder="搜索" autocomplete="off">
            <input id="ai-topsearch" class="submit am-btn" value="搜索" index="1" type="submit">
        </form>
    </div>
</div>

<div class="clear"></div>

<!--购物车 -->
<div class="concent">
    <div id="cartTable">
        <div class="cart-table-th">
            <div class="wp">
                <div class="th th-chk">
                    <div id="J_SelectAll1" class="select-all J_SelectAll">

                    </div>
                </div>
                <div class="th th-item">
                    <div class="td-inner">商品信息</div>
                </div>
                <div class="th th-price">
                    <div class="td-inner">单价</div>
                </div>
                <div class="th th-amount">
                    <div class="td-inner">数量</div>
                </div>
                <div class="th th-sum">
                    <div class="td-inner">金额</div>
                </div>
                <div class="th th-op">
                    <div class="td-inner">操作</div>
                </div>
            </div>
        </div>
        <div class="clear"></div>
        <tr class="item-list">
            <div class="bundle  bundle-last ">
                <div class="clear"></div>
                <div class="bundle-main">
                    <s:iterator value="#session.greeting3">
                    <ul class="item-content clearfix">
                        <li class="td td-chk">
                            <div class="cart-checkbox ">
                                <input class="check" id="J_CheckBox_170037950254" name="items[]" value="170037950254" type="checkbox">
                                <label for="J_CheckBox_170037950254"></label>
                            </div>
                        </li>
                        <li class="td td-item">
                            <div class="item-pic">
                                <a href="#" target="_blank" data-title="美康粉黛醉美东方唇膏口红正品 持久保湿滋润防水不掉色护唇彩妆" class="J_MakePoint" data-point="tbcart.8.12">
                                    <img src="../images/kouhong.jpg_80x80.jpg" class="itempic J_ItemImg"></a>
                            </div>
                            <div class="item-info">
                                <div class="item-basic-info">
                                    <a href="#" target="_blank" title="美康粉黛醉美唇膏 持久保湿滋润防水不掉色" class="item-title J_MakePoint" data-point="tbcart.8.11"><s:property value="productName"></s:property></a>
                                </div>
                            </div>
                        </li>
                        <li class="td td-info">
                            <div class="item-props item-props-can">
                                <span class="sku-line">颜色：12#川南玛瑙</span>
                                <span class="sku-line">包装：裸装</span>
                                <span tabindex="0" class="btn-edit-sku theme-login">修改</span>
                                <i class="theme-login am-icon-sort-desc"></i>
                            </div>
                        </li>
                        <li class="td td-price" id="price">

                                        <s:property value="productPrice"></s:property>

                        </li>
                        <li class="td td-amount">

                                        <input type="hidden" value=""/>
                                        <input class="redbtn" name="" type="button" value="-"  />
                                        <input name="Pid" class="Pid" value="<s:property value="productId"></s:property>" type="hidden"/>
                                        <input class="text_box" name="text_box" type="text" value="<s:property value="productNum"></s:property>" style="width:30px;" />
                                        <input class="addbtn" name="" type="button" value="+"  />

                        </li>
                        <li class="td td-sum">
                            <s:property value="productPrice*productNum"></s:property>
                        </li>
                        <li class="td td-op">
                            <div class="td-inner">
                                <a title="移入收藏夹" class="btn-fav" href="#">
                                    移入收藏夹</a>
                                <a href="javascript:;" data-point-url="#" class="delete">
                                    删除</a>
                            </div>
                        </li>
                    </ul>
                    </s:iterator>
                </div>
            </div>
        </tr>
        <div class="clear"></div>
    </div>
    <div class="clear"></div>
    <div class="float-bar-wrapper">
        <div id="J_SelectAll2" class="select-all J_SelectAll">
            <div class="cart-checkbox">
                <input class="check-all check" id="J_SelectAllCbx2" name="select-all" value="true" type="checkbox">
                <label for="J_SelectAllCbx2"></label>
            </div>
            <span>全选</span>
        </div>
        <div class="operations">
            <a href="#" hidefocus="true" class="deleteAll">删除</a>
            <a href="#" hidefocus="true" class="J_BatchFav">移入收藏夹</a>
        </div>
        <div class="float-bar-right">
            <div class="amount-sum">
                <span class="txt">已选商品</span>
                <em id="J_SelectedItemsCount">0</em><span class="txt">件</span>
                <div class="arrow-box">
                    <span class="selected-items-arrow"></span>
                    <span class="arrow"></span>
                </div>
            </div>
            <div class="price-sum">
                <span class="txt">合计:</span>
                <strong class="price">¥<em id="J_Total">0.00</em></strong>
            </div>
            <div class="btn-area">
                <a href="pay.html" id="J_Go" class="submit-btn submit-btn-disabled" aria-label="请注意如果没有选择宝贝，将无法结算">
                    <span>结&nbsp;算</span></a>
            </div>
        </div>

    </div>
    <div class="footer">
        <div class="footer-hd">
            <p>
                <a href="#">恒望科技</a>
                <b>|</b>
                <a href="#">商城首页</a>
                <b>|</b>
                <a href="#">支付宝</a>
                <b>|</b>
                <a href="#">物流</a>
            </p>
        </div>
        <div class="footer-bd">
            <p>
                <a href="#">关于恒望</a>
                <a href="#">合作伙伴</a>
                <a href="#">联系我们</a>
                <a href="#">网站地图</a>
                <em><a href="http://www.cssmoban.com/" target="_blank" title=""></a> - Collect from <a href="http://www.cssmoban.com/" title="" target="_blank"></a></em>
            </p>
        </div>
    </div>
</div>

<!--操作页面-->

<div class="theme-popover-mask"></div>

<div class="theme-popover">
    <div class="theme-span"></div>
    <div class="theme-poptit h-title">
        <a href="javascript:;" title="关闭" class="close">×</a>
    </div>
    <div class="theme-popbod dform">
        <form class="theme-signin" name="loginform" action="" method="post">

            <div class="theme-signin-left">

                <li class="theme-options">
                    <div class="cart-title">颜色：</div>
                    <ul>
                        <li class="sku-line selected">12#川南玛瑙<i></i></li>
                        <li class="sku-line">10#蜜橘色+17#樱花粉<i></i></li>
                    </ul>
                </li>
                <li class="theme-options">
                    <div class="cart-title">包装：</div>
                    <ul>
                        <li class="sku-line selected">包装：裸装<i></i></li>
                        <li class="sku-line">两支手袋装（送彩带）<i></i></li>
                    </ul>
                </li>
                <div class="theme-options">
                    <div class="cart-title number">数量</div>
                    <dd>
                        <input class="min am-btn am-btn-default" name="" type="button" value="-" />
                        <input class="text_box" name="" type="text" value="1" style="width:30px;" />
                        <input class="add am-btn am-btn-default" name="" type="button" value="+" />
                        <span  class="tb-hidden">库存<span class="stock">1000</span>件</span>
                    </dd>

                </div>
                <div class="clear"></div>
                <div class="btn-op">
                    <div class="btn am-btn am-btn-warning">确认</div>
                    <div class="btn close am-btn am-btn-warning">取消</div>
                </div>

            </div>
            <div class="theme-signin-right">
                <div class="img-info">
                    <img src="../images/kouhong.jpg_80x80.jpg" />
                </div>
                <div class="text-info">
                    <span class="J_Price price-now">¥39.00</span>
                    <span id="Stock" class="tb-hidden">库存<span class="stock">1000</span>件</span>
                </div>
            </div>

        </form>
    </div>
</div>
<!--引导 -->
<div class="navCir">
    <li><a href="../home2.html"><i class="am-icon-home "></i>首页</a></li>
    <li><a href="sort.html"><i class="am-icon-list"></i>分类</a></li>
    <li class="active"><a href="shopcart.html"><i class="am-icon-shopping-basket"></i>购物车</a></li>
    <li><a href="../person/index.html"><i class="am-icon-user"></i>我的</a></li>
</div>
</body>
<script type="text/javascript" src="//ajax.googleapis.com/ajax/libs/jquery/1.10.1/jquery.min.js"></script>
<script type="text/javascript" src="/js/jquery/jquery.form.js"></script>
<script language="javascript">
    $(function () {
        //计算总价，编写总价方法
        function totalPrice() {
            var zong = 0;
            $(".td-sum").each(function () {
                var all = parseInt($(this).text());
                zong += all;
            })
            $("#J_Total ").text(zong);
        };
        $(document).ready(function(){
            totalPrice();
        });
        //设置数量框不可手动填写（此处为避免不必要的操作失误）
        $(".text_box").prop("disabled", true);

        //减号逻辑
        $(".redbtn").click(function () {
            var num = $(this).siblings(".text_box").val();  //获取数量框里的数值
            num--;  //单击“-”减号时，数量递减
            $(this).siblings(".text_box").val(num);
            /*$(this).siblings(".text_box").val(num);*/ //把数量变化后的新值放入数量框中
            if (num <= 0) {
                $(this).prop("disabled", true); //当输入框内数值为0时，使“-”减号处于不可用状态。
            };
            var danjia=$(this).parent().siblings(".td-price").text();
            var xiaoji=danjia*num;
            $(this).parent("").siblings(".td-sum").text(xiaoji);
            totalPrice();//调用“总价”方法，使每点击减号，数量变化时，总价跟着变化
            var productid = $(this).siblings(".Pid").val();
            var user="aaa";
            /*ajax实时更改商品数量*/

            $.ajax({url:"sred",
                data:{productid:productid,
                    user:user
                },
                type:"POST",

                traditional:true, //默认false
                success:function(){
                },
            });
            return false;
        })

        //加号逻辑（逻辑如同减号的逻辑差不多）
        $(".addbtn").click(function () {
            var num = $(this).siblings(".text_box").val();
            num++;
            $(this).siblings(".text_box").val(num);
            if (num > 0) {
                $(this).siblings(".redbtn").prop("disabled", false); //判断当输入框内数值大于0，使“-”减号处于解封可用状态。
            };
            /*var danjia = $(this).siblings(".danjia").text();
            var xiaoji = danjia * num;
            $(this).siblings(".xiaoji").text(xiaoji);
            */

            var danjia=$(this).parent().siblings(".td-price").text();
            var xiaoji=danjia*num;
            $(this).parent().siblings(".td-sum").text(xiaoji);
            totalPrice();
            var productid = $(this).siblings(".Pid").val();
            var user="aaa";
            /*ajax实时更改商品数量*/

            $.ajax({url:"sadd",
                data:{productid:productid,
                    user:user
                },
                type:"POST",

                traditional:true, //默认false
                success:function(){
                },
            });
            return false;
        })


        //点击合计重整清算(防止单行删除某项商品后，总价不刷新)
        $("#he").click(function () {
            totalPrice(); //调用总价方法
        })

        //单行删除商品
        $(".deleteOne").click(function () {
            var mymessage=confirm("确定删除此商品吗");
            var Pid=$(this).siblings(".Pid").val();
            alert(Pid)
            if(mymessage==true)
            {
                $(this).parent().remove();
                $.ajax({url:"/DeleProduct",
                    data:{Pid:Pid
                    },
                    type:"POST",
                    traditional:true, //默认false
                    success:function(){
                        alert("成功")
                    }
                });

            }

        })

        ////全部删除商品
        $("#deleteAll").click(function () {
            var mymessage=confirm("确定删除这些行吗");
            if(mymessage==true) {
                $(".box:checked").parent().remove(); //把被选中的复选框所在的区域删除
            }
        })

        //全选
        $("#allSelect").click(function () {
            $(".box").prop("checked", true);
        })

        //取消全选
        $("#notSelect").click(function () {
            $(".box").prop("checked", false);
        });

        //全部清零
        $("#zero").click(function () {
            $(".textNum").val(0);
            $(".xiaoji").text(0);
            $("#heji").val(0);
        });
    })


</script>
</html>
