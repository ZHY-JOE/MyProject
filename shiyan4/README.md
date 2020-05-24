# 实验4 Intent
## 获取URL地址并启动隐式Intent的调用
![](https://github.com/ZHY-JOE/MyProject/blob/master/shiyan4/pic1.png)</br>

xml布局</br>
[代码](https://github.com/ZHY-JOE/MyProject/blob/master/shiyan4/app/src/main/res/layout/activity_main.xml)</br>
java代码</br>
EditText获取url字符串，按钮负责调用Intent，把url setData到Intent，再传给浏览器</br>
[代码](https://github.com/ZHY-JOE/MyProject/blob/master/shiyan4/app/src/main/java/com/example/shiyan4/MainActivity.java)</br>

## 自定义WebView来加载URL
![](https://github.com/ZHY-JOE/MyProject/blob/master/shiyan4/pic2.png)</br>
![](https://github.com/ZHY-JOE/MyProject/blob/master/shiyan4/pic3.png)</br>

xml布局</br>
[代码](https://github.com/ZHY-JOE/MyProject/blob/master/shiyan4/app/src/main/res/layout/activity_web.xml)</br>
java代码</br>
接受上个页面的Intent</br>
从Intent.getData中获取url</br>
WebView加载url</br>
[代码](https://github.com/ZHY-JOE/MyProject/blob/master/shiyan4/app/src/main/java/com/example/shiyan4/WebActivity.java)</br>
