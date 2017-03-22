# ImagePicker
Android自定义相册，完全仿微信UI，实现了拍照、图片选择（单选/多选）、 裁剪 、旋转、等功能。

### 目前该项目原作者已经停止维护，改由[南尘](https://github.com/nanchen2251)进行维护。
#### 现在已经支持7.0，请大家更新使用。
#### 有问题请大家在issues(https://github.com/jeasonlzy/ImagePicker/issues) 提出，我会一一维护。
#### 目前项目选择回来的图片暂时未做压缩，压缩可以到[https://github.com/nanchen2251/CompressHelper](https://github.com/nanchen2251/CompressHelper)
#### 项目编译版本为SDK为25，Tools为25.0.2，如果导入版本和你的主工程不符而导致运行崩溃，请修改你的主工程版本到更高，或者直接import该module。
该项目参考了：

* [https://github.com/pengjianbo/GalleryFinal](https://github.com/pengjianbo/GalleryFinal) 
* [https://github.com/easonline/AndroidImagePicker](https://github.com/easonline/AndroidImagePicker)

喜欢原作的可以去使用。同时欢迎大家下载体验本项目，如果使用过程中遇到什么问题，欢迎反馈。

### 联系方式
 * 原作者邮箱地址： liaojeason@126.com （建议大家加入下面的QQ群，原作者很忙。）
 * QQ群： （1群:489873144，原作者是群主，还可以用OkGo哦）   
 （2群：118116509，南尘是群主，可能妹纸新手多一点） 
 * 本群旨在为使用我的github项目的人提供方便，如果遇到问题欢迎在群里提问。个人能力也有限，希望一起学习一起进步。
 * [南尘博客园](http://www.cnblogs.com/liushilin/)  
 * [南尘github](https://github.com/nanchen2251)
 
 
 
### 更新日志

V 0.4.8<br>
 * [修复]解决demo中直接呼起相机并裁剪不会返回数据的bug，不需要这个功能的可以不更新;
 
 
V 0.4.7<br>
 * [新增]新增可直接调起相机的功能;
 * [修复]解决可能和主项目provider冲突的潜在问题；
 * [修复]点击图片预览空指针崩溃问题；
 * [修复]使用Intent传值限制导致的崩溃问题;
 * [修复]部分机型拍照后图片旋转问题；
 * [修复]更改选择框图片背景为灰色，以免白色图看不清。
 
 
V 0.3.5<br>
 * [新增]提供直接调起相机的方式，并可直接设置牌照是否裁剪；
 * [修复]Android7.0设备调系统相机直接崩溃的问题；
 * [注意]如果出现 java.lang.RuntimeException: Unable to get provider android.support.v4.content.FileProvider: java.lang.SecurityException: Provider must not be exported，请直接clean再运行即可。
 
## 演示
 ![image](https://github.com/jeasonlzy/Screenshots/blob/master/ImagePicker/demo1.png)![image](https://github.com/jeasonlzy/Screenshots/blob/master/ImagePicker/demo2.gif)
 ![image](https://github.com/jeasonlzy/Screenshots/blob/master/ImagePicker/demo3.gif)![image](https://github.com/jeasonlzy/Screenshots/blob/master/ImagePicker/demo5.gif)

## 1.用法

使用前，对于Android Studio的用户，可以选择添加:
```java
	compile 'com.lzy.widget:imagepicker:0.4.8'  //指定版本
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
### 1.然后配置图片选择器，一般在Application初始化配置一次就可以,这里就需要将上面的图片加载器设置进来,其余的配置根据需要设置
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
### 2.以上配置完成后，在适当的方法中开启相册，例如点击按钮时
```java
	public void onClick(View v) {
            Intent intent = new Intent(this, ImageGridActivity.class);
            startActivityForResult(intent, IMAGE_PICKER);  
        }
    }
```

### 3.如果你想直接调用相机
```java
	Intent intent = new Intent(this, ImageGridActivity.class);
	intent.putExtra(ImageGridActivity.EXTRAS_TAKE_PICKERS,true); // 是否是直接打开相机
        startActivityForResult(intent, REQUEST_CODE_SELECT);
```
### 4.重写`onActivityResult`方法,回调结果
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
