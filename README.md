# RedBaby 

1.项目名 

```
项目名   RedBaby   
```


2.包名 

```
总包名  com.3team.baby

mvp模式 等待君君探讨
```


3.类名  驼峰形式    UpperCamelCase

```
Activity类      名字Activity

Fragment类      名字Fragment

Adapter类       名字Adapter

Bean类          名字Bean

Utils类         名字Utils

公共类          Base名字

自定义控件类    名字View
```

4.布局名    类型_名字

```
Activity类      activity_名字

Fragment类      fragment_名字

适配器布局      item_名字   若多条目，则 item_名字_01 类推

引用布局        include_名字
```

5.布局内控件名  命名模式为：view缩写_模块名称_view的逻辑名称

```
例如：MainActivity 中 底部的一个button

btn_01_main_activity    或  btn_作用_main_acitivity
```
常用的缩写名单：

```
LayoutView      lv
TextView        tv
Button          btn
ImageView       iv
CheckBox        chk
RadioButton     rdoBtn
EditText        ediTxt
```
等等，要求用**butterKnife 引入布局**！！

6.方法名

```
初始化              initXX()
带返回值的方法      getXX()
保存数据            saveXX()

数据库操作

库名：Shopping_Car

表名：table_shopping

字段：shopping_id 商品id(唯一的)

      shopping_name 商品名称
    
      shopping_price 商品价格

      shopping_url 商品url

      shopping_pic 商品图片

      shopping_state 商品状态

      shopping_count 商品数量
