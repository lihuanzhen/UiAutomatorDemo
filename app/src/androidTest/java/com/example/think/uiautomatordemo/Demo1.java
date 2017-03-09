package com.example.think.uiautomatordemo;

import android.os.RemoteException;
import android.support.test.InstrumentationRegistry;
import android.support.test.uiautomator.Configurator;
import android.support.test.uiautomator.UiCollection;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiScrollable;
import android.support.test.uiautomator.UiSelector;
import android.support.test.uiautomator.UiWatcher;
import android.view.KeyEvent;

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
    public void demo4() throws UiObjectNotFoundException {
        mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
        mDevice.pressHome();
        UiSelector se = new UiSelector().text("探游");
        UiObject obj = mDevice.findObject(se);
        obj.click();
        mDevice.click(198, 106);
        mDevice.pressKeyCode(KeyEvent.KEYCODE_A);

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
    //??
    public void demo7() throws UiObjectNotFoundException, RemoteException {
        mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
//        mDevice.pressHome();
//        UiSelector se = new UiSelector().className("android.view.View").index(1);
//        com.vphone.launcher:id/workspace

//        UiSelector se = new UiSelector().resourceId("com.vphone.launcher:id/layout");

        UiSelector se = new UiSelector().className("android.view.View").instance(1);
//        UiSelector se = new UiSelector().index(4);
        UiObject obj = mDevice.findObject(se);
//        System.out.println(obj.get);
        int count = obj.getChildCount();
        System.out.println(count);

        for (int j = 0; j < count; j++) {
            UiObject child = obj.getChild(new UiSelector().index(j));

            System.out.println(child.getText());
        }
    }

    //UiCollection
    @Test
    public void UiCollectionDemo() throws UiObjectNotFoundException {
        mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
        UiCollection u = new UiCollection(new UiSelector().className("android.view.View").instance(1));
        UiObject object = u.getChildByText(new UiSelector().className("android.widget.TextView"), "ToDoList");
        object.click();
    }

    //UiWatcher
    @Test
    public void UiWatcherDemo() throws UiObjectNotFoundException, RemoteException, InterruptedException {
        //先要注册监听器
        mDevice.registerWatcher("phone", new UiWatcher() {
            public boolean checkForCondition() {
                UiObject call = mDevice.findObject(new UiSelector().text("来电"));
                UiObject reject = mDevice.findObject(new UiSelector().text("拒绝"));
                UiObject view = mDevice.findObject(new UiSelector().className("android.view.View"));
                if (call.exists()) {
                    System.out.println("电话监听器被触发啦！！！！");
                }
                if (reject.exists()) {
                    System.out.println("存在挂断电话图标");
                    try {
                        mDevice.swipe(reject.getBounds().left, reject.getBounds().top, 573, 569, 40);
                        return true;
                    } catch (UiObjectNotFoundException e) {
                        e.printStackTrace();
                    }
                }
                return false;
            }
        });


        UiSelector zhihu = new UiSelector().text("知乎");
        UiObject obj = mDevice.findObject(zhihu);

        Thread.sleep(3000);
        obj.click();
        UiObject mobile = mDevice.findObject
                (new UiSelector().className("android.widget.EditText").text("请输入手机号"));
        mobile.setText("13910102020");
        mDevice.removeWatcher("phone");
        mDevice.hasAnyWatcherTriggered();
        mDevice.hasWatcherTriggered("phone");
    }

    @Test
    public void UiScrollableDemo() throws UiObjectNotFoundException {
        mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
        UiSelector zhihu = new UiSelector().text("知乎日报");
        UiObject obj = mDevice.findObject(zhihu);
        obj.clickAndWaitForNewWindow();
        UiScrollable scoll = new UiScrollable(new UiSelector().className("android.widget.ListView"));
        scoll.flingToEnd(5);


    }

    @Test
    public void ConfigDemo() throws UiObjectNotFoundException {
        mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
        Configurator con =Configurator.getInstance();
        con.setWaitForSelectorTimeout(1000);
        UiSelector zhihu = new UiSelector().text("知乎日报");
        UiObject obj = mDevice.findObject(zhihu);
        obj.click();
    }

}
