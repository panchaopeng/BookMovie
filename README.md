# BookMovie
## 一个查看或查找图书、电影动态信息的APP。数据源于豆瓣开放API。
### 主MVVM，辅MVC模式，单Activity多Fragment架构。
### [APK下载](https://github.com/panchaopeng/BookMovie/blob/master/app/src/main/app.apk)
### 0.修改第三方底部导航BottomBar，链式调用到底。[BottomBar](https://github.com/panchaopeng/BookMovie/blob/master/app/src/main/java/com/pcp/life/widget/BottomBar.java)
### 查看MainActivity onCreate initBottomBar() 的写法：[链式调用](https://github.com/panchaopeng/BookMovie/blob/master/app/src/main/java/com/pcp/life/mvvm/activity/MainActivity.java)
### 1.登录(用户和密码两者不为空)
#### 登录时将登录框往上顶，防止输入法遮挡
![image](https://github.com/panchaopeng/VideoStorege/blob/master/1_BookMovie_GIF/1.login.gif)
### 2.下拉刷新与上拉加载(SmartRefreshLayout)
#### 页面采用懒加载，只有可见状态才请求数据
![image](https://github.com/panchaopeng/VideoStorege/blob/master/1_BookMovie_GIF/2.refresh_loadMore .gif)
### 3.自定义加载Dialog与OkGo结合
#### 当请求数据时，自动显示Dialog；当数据返回时，Dialog自动消失。还可以结合RxJava使用。
![image](https://github.com/panchaopeng/VideoStorege/blob/master/1_BookMovie_GIF/3.dialog.gif)
### 4.手动查找图书或者电影信息(MaterialSearchView)
![image](https://github.com/panchaopeng/VideoStorege/blob/master/1_BookMovie_GIF/4_1_book.gif)
![image](https://github.com/panchaopeng/VideoStorege/blob/master/1_BookMovie_GIF/4_2_book_isbn.gif)
![image](https://github.com/panchaopeng/VideoStorege/blob/master/1_BookMovie_GIF/4_3_movie.gif)
### 5.扫描(zxing-lite)
#### 自定义扫描界面，扫描二维码、一维码。还可以本地解析图片及打开灯光。
![image](https://github.com/panchaopeng/VideoStorege/blob/master/1_BookMovie_GIF/4_4_scan.gif)
![image](https://github.com/panchaopeng/VideoStorege/blob/master/1_BookMovie_GIF/4_5_album.gif)
### 6.使用Glide加载图片(Glide4.8.0)
#### 清除Glide图片缓存，[glide工具类](https://github.com/panchaopeng/BookMovie/tree/master/app/src/main/java/com/pcp/life/utils/glide)
![image](https://github.com/panchaopeng/VideoStorege/blob/master/1_BookMovie_GIF/5_glide.gif)




