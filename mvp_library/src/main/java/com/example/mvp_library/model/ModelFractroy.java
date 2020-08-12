package com.example.mvp_library.model;

import com.example.mvp_library.base.BaseFragment;

import java.util.HashMap;
import java.util.Map;

public class ModelFractroy {
    //存储model的基类
    private static Map<String,BaseModel> modelMap=new HashMap<>();

    //反射
    public static <M extends BaseModel> M createModel (Class<M> mClass){
        if (modelMap.get(mClass)!=null){
            return (M) modelMap.get(mClass);
        }
        M mModel=null;
        try {
            mModel=mClass.newInstance();
            modelMap.put(mClass.getName(),mModel);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return mModel;
    }
}
