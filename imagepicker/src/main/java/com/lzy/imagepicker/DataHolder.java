package com.lzy.imagepicker;

import com.lzy.imagepicker.bean.ImageItem;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 新的DataHolder，使用单例和弱引用解决崩溃问题
 * <p>
 * Author: nanchen
 * Email: liushilin520@foxmail.com
 * Date: 2017-03-20  07:01
 */
public class DataHolder {
    public static final String DH_CURRENT_IMAGE_FOLDER_ITEMS = "dh_current_image_folder_items";

    private static DataHolder mInstance;
    private Map<String, WeakReference<List<ImageItem>>> data;

    public static DataHolder getInstance() {
        if (mInstance == null){
            synchronized (DataHolder.class){
                if (mInstance == null){
                    mInstance = new DataHolder();
                }
            }
        }
        return mInstance;
    }

    private DataHolder() {
        data = new HashMap<>();
    }

    public void save(String id, List<ImageItem> object) {
        data.put(id, new WeakReference<>(object));
    }

    public Object retrieve(String id) {
        WeakReference<List<ImageItem>> objectWeakReference = data.get(id);
        return objectWeakReference.get();
    }
}
