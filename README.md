# ImagePicker
Android自定义相册，完全仿微信UI，实现了拍照、图片选择（单选/多选）、 裁剪 、旋转、等功能。

### 目前该项目暂时停止维护

该项目参考了：

* [https://github.com/pengjianbo/GalleryFinal](https://github.com/pengjianbo/GalleryFinal) 
* [https://github.com/easonline/AndroidImagePicker](https://github.com/easonline/AndroidImagePicker)

喜欢原作的可以去使用。同时欢迎大家下载体验本项目，如果使用过程中遇到什么问题，欢迎反馈。

### 联系方式
 * 邮箱地址： liaojeason@126.com 
 * QQ群： 1群（[廖子尧](https://github.com/jeasonlzy)）： 489873144   2群（[南尘](http://www.cnblogs.com/liushilin/)）：118116509 
 
### 更新日志

V 0.5.5<br>
 * [修复]选择图页面进入预览取消选择或者选择后返回列表不更新的问题；
 * [修复]6.0动态权限可能导致崩溃的bug；

V 0.5.4<br>
 * [修复]部分内存泄漏问题；
 * [修复]新增显示已选中图片的调用方法：详情请查看demo首页的ImagePickerActivity；如果不需要此功能，则WxDemoActivity可能是你想要的。

V 0.5.3<br>
 * [修复]矫正图片旋转导致的oom；
 * [修复]部分手机TitleBar和状态栏重复的问题；

V 0.5.1<br>
 * [更正] 由于原图功能其实还没有做，所以本版本隐去了原图的显示。以免用户误解原图问题。
 * [修复] 使用RecyclerView替换GridView解决改变选中状态全局刷新的问题；
 * [提示] 虽然本次解决了全局刷新，但是如果使用的是Picasso依然会出现重新加载一张图片的问题，这是Picasso自己的问题，建议使用Glide框架。
 
 
V 0.5.0<br>
 * [修复] 解决provider冲突问题； 

V 0.4.8<br>
 * [修复] 解决demo中直接呼起相机并裁剪不会返回数据的bug，不需要这个功能的可以不更新;
 
 
V 0.4.7<br>
 * [新增] 新增可直接调起相机的功能;
 * [修复] 解决可能和主项目provider冲突的潜在问题；
 * [修复] 点击图片预览空指针崩溃问题；
 * [修复] 使用Intent传值限制导致的崩溃问题;
 * [修复] 部分机型拍照后图片旋转问题；
 * [修复] 更改选择框图片背景为灰色，以免白色图看不清。
 
 
V 0.3.5<br>
 * [新增] 提供直接调起相机的方式，并可直接设置牌照是否裁剪；
 * [修复] Android7.0设备调系统相机直接崩溃的问题；
 * [注意] 如果出现 java.lang.RuntimeException: Unable to get provider android.support.v4.content.FileProvider: java.lang.SecurityException: Provider must not be exported，请直接clean再运行即可。
 
## 演示
 ![image](https://github.com/jeasonlzy/Screenshots/blob/master/ImagePicker/demo1.png)![image](https://github.com/jeasonlzy/Screenshots/blob/master/ImagePicker/demo2.gif)
 ![image](https://github.com/jeasonlzy/Screenshots/blob/master/ImagePicker/demo3.gif)![image](https://github.com/jeasonlzy/Screenshots/blob/master/ImagePicker/demo5.gif)

## 1.用法

使用前，对于Android Studio的用户，可以选择添加:
```java
	compile 'com.lzy.widget:imagepicker:0.5.5'  //指定版本
```

## 2.功能和参数含义

### 温馨提示:目前库中的预览界面有个原图的复选框,暂时只做了UI,还没有做压缩的逻辑

<table>
  <tdead>
    <tr>
      <th align="center">配置参数</th>
      <th align="center">参数含义</th>
    </tr>
  </tdead>
  <tbody>
    <tr>
      <td align="center">multiMode</td>
      <td align="center">图片选着模式，单选/多选</td>
    </tr>
    <tr>
      <td align="center">selectLimit</td>
      <td align="center">多选限制数量，默认为9</td>
    </tr>
    <tr>
      <td align="center">showCamera</td>
      <td align="center">选择照片时是否显示拍照按钮</td>
    </tr>
    <tr>
      <td align="center">crop</td>
      <td align="center">是否允许裁剪（单选有效）</td>
    </tr>
    <tr>
      <td align="center">style</td>
      <td align="center">有裁剪时，裁剪框是矩形还是圆形</td>
    </tr>
    <tr>
      <td align="center">focusWidth</td>
      <td align="center">矩形裁剪框宽度（圆形自动取宽高最小值）</td>
    </tr>
    <tr>
      <td align="center">focusHeight</td>
      <td align="center">矩形裁剪框高度（圆形自动取宽高最小值）</td>
    </tr>
    <tr>
      <td align="center">outPutX</td>
      <td align="center">裁剪后需要保存的图片宽度</td>
    </tr>
    <tr>
      <td align="center">outPutY</td>
      <td align="center">裁剪后需要保存的图片高度</td>
    </tr>
    <tr>
      <td align="center">isSaveRectangle</td>
      <td align="center">裁剪后的图片是按矩形区域保存还是裁剪框的形状，例如圆形裁剪的时候，该参数给true，那么保存的图片是矩形区域，如果该参数给fale，保存的图片是圆形区域</td>
    </tr>
    <tr>
      <td align="center">imageLoader</td>
      <td align="center">需要使用的图片加载器，自需要实现ImageLoader接口即可</td>
    </tr>
  </tbody>
</table>

## 3.代码参考
### 0.首先你需要继承 `com.lzy.imagepicker.loader.ImageLoader` 这个接口,实现其中的方法,比如以下代码是使用 `Picasso` 三方加载库实现的
```java
    public class PicassoImageLoader implements ImageLoader {
    
        @Override
        public void displayImage(Activity activity, String path, ImageView imageView, int width, int height) {
            Picasso.with(activity)//
                    .load(Uri.fromFile(new File(path)))//
                    .placeholder(R.mipmap.default_image)//
                    .error(R.mipmap.default_image)//
                    .resize(width, height)//
                    .centerInside()//
                    .memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE)//
                    .into(imageView);
        }
    
        @Override
        public void clearMemoryCache() {
            //这里是清除缓存的方法,根据需要自己实现
        }
    }
```

### 1.在你的AndroidManifest.xml文件里面添加下面的
```java
<activity
            android:name="com.lzy.imagepicker.ui.ImagePreviewDelActivity"
            android:theme="@style/ImagePickerThemeFullScreen"/>
```
### 2.然后配置图片选择器，一般在Application初始化配置一次就可以,这里就需要将上面的图片加载器设置进来,其余的配置根据需要设置
```java
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_picker);

        ImagePicker imagePicker = ImagePicker.getInstance();
        imagePicker.setImageLoader(new PicassoImageLoader());   //设置图片加载器
		imagePicker.setShowCamera(true);  //显示拍照按钮
		imagePicker.setCrop(true);        //允许裁剪（单选才有效）
		imagePicker.setSaveRectangle(true); //是否按矩形区域保存
		imagePicker.setSelectLimit(9);    //选中数量限制
		imagePicker.setStyle(CropImageView.Style.RECTANGLE);  //裁剪框的形状
		imagePicker.setFocusWidth(800);   //裁剪框的宽度。单位像素（圆形自动取宽高最小值）
        imagePicker.setFocusHeight(800);  //裁剪框的高度。单位像素（圆形自动取宽高最小值）
		imagePicker.setOutPutX(1000);//保存文件的宽度。单位像素
        imagePicker.setOutPutY(1000);//保存文件的高度。单位像素
	}
```
### 3.以上配置完成后，在适当的方法中开启相册，例如点击按钮时
```java
	public void onClick(View v) {
            Intent intent = new Intent(this, ImageGridActivity.class);
            startActivityForResult(intent, IMAGE_PICKER);  
        }
    }
```

### 4.如果你想直接调用相机
```java
	Intent intent = new Intent(this, ImageGridActivity.class);
	intent.putExtra(ImageGridActivity.EXTRAS_TAKE_PICKERS,true); // 是否是直接打开相机
        startActivityForResult(intent, REQUEST_CODE_SELECT);
```
### 5.重写`onActivityResult`方法,回调结果
```java
	@Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == ImagePicker.RESULT_CODE_ITEMS) {
            if (data != null && requestCode == IMAGE_PICKER) {
                ArrayList<ImageItem> images = (ArrayList<ImageItem>) data.getSerializableExtra(ImagePicker.EXTRA_RESULT_ITEMS);
                MyAdapter adapter = new MyAdapter(images);
                gridView.setAdapter(adapter);
            } else {
                Toast.makeText(this, "没有数据", Toast.LENGTH_SHORT).show();
            }
        }
    }
```

## 更多使用，请下载demo参看源代码
