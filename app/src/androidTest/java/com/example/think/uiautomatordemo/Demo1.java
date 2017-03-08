package com.example.think.uiautomatordemo;

import android.os.RemoteException;
import android.support.test.InstrumentationRegistry;
import android.support.test.uiautomator.UiCollection;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiSelector;

import org.junit.Test;

/**
 * Created by think on 2017/3/7.
 */

public class Demo1 {
    private UiDevice mDevice;

    @Test
    public void demo1() throws UiObjectNotFoundException {
        mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
        mDevice.pressHome();
        UiObject contact = mDevice.findObject(new UiSelector().text("联系人"));
        contact.click();

    }

    @Test
    public void demo2() throws UiObjectNotFoundException {
        mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
        mDevice.pressHome();
        UiSelector qq = new UiSelector().text("QQ");
        UiObject obj = mDevice.findObject(qq);
        obj.dragTo(334, 991, 10);
    }

    @Test
    public void demo3() throws UiObjectNotFoundException {
        mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
        mDevice.pressHome();
        UiSelector qq = new UiSelector().className("android.view.View").instance(0);
        UiObject obj = mDevice.findObject(qq);
        obj.swipeRight(10);
    }

    @Test
    public void demo4() throws UiObjectNotFoundException, RemoteException {
        mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
        mDevice.pressHome();
        UiSelector zhihu = new UiSelector().text("知乎");
        UiObject obj = mDevice.findObject(zhihu);
        obj.click();
        UiObject mobile = mDevice.findObject
                (new UiSelector().className("android.widget.EditText").text("请输入手机号"));
        mobile.setText("13910102020");
    }

    @Test
    public void demo5() throws UiObjectNotFoundException, RemoteException {
        mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
        mDevice.pressHome();
        UiSelector zhihu = new UiSelector().text("知乎");
        UiObject obj = mDevice.findObject(zhihu);
        obj.click();
        UiObject mobile = mDevice.findObject
                (new UiSelector().className("android.widget.EditText").text("请输入手机号"));
        mobile.setText("13910102020");
    }

    @Test
    public void demo6() throws UiObjectNotFoundException, RemoteException {
        mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
        mDevice.pressHome();
        UiSelector zhihu = new UiSelector().text("知乎");
        UiObject obj = mDevice.findObject(zhihu);
        obj.click();
        UiObject mobile = mDevice.findObject
                (new UiSelector().className("android.widget.EditText").text("请输入手机号"));
        mobile.setText("13910102020");
    }

    @Test
    public void demo7() throws UiObjectNotFoundException, RemoteException {
        mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
        mDevice.pressHome();
        UiSelector se = new UiSelector().className("android.view.View");
        UiObject obj =mDevice.findObject(se);
        int count =obj.getChildCount();
        for(int j=0;j<count;j++){
            UiObject child =obj.getChild(new UiSelector().index(j));
           System.out.print(child.getText());
        }
    }

    @Test
    public void demo8() throws UiObjectNotFoundException {
        UiCollection u =new UiCollection(new UiSelector().className("android.view.View").instance(1));
UiObject object=u.getChildByText(new UiSelector().className("android.widget.TextView"),"ToDoList");
        object.click();
    }


}
