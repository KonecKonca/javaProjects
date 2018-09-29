import javax.swing.*;

import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.WinDef.HWND;
import com.sun.jna.platform.win32.WinUser;
import com.sun.jna.platform.win32.WinUser.WNDENUMPROC;
import com.sun.jna.win32.StdCallLibrary;

import java.io.IOException;

import static com.sun.jna.platform.win32.WinUser.GWL_STYLE;

public class MainClass{
    public static void main(String[] args) {
        MyClass m1 = new MyClass();
        MyClass m2 = null;

        m1.setA(4);

        try {
            m2 = m1.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        m1.print();
        m2.print();
    }
}

class MyClass{
    int a;

    public void print(){
        System.out.println(this.getClass().getName() + " " + a);
    }
    public void setA(int a){
        this.a = a;
    }
    @Override
    protected MyClass clone() throws CloneNotSupportedException {
        MyClass newMy = new MyClass();
        newMy.setA(this.a);
        return newMy;
    }
}
