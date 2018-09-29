import javax.swing.*;

import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.WinDef.HWND;
import com.sun.jna.platform.win32.WinUser;
import com.sun.jna.platform.win32.WinUser.WNDENUMPROC;
import com.sun.jna.win32.StdCallLibrary;

import java.io.IOException;

import static com.sun.jna.platform.win32.WinUser.GWL_STYLE;

public class MainClass {
    public static void main(String[] args) {

    }
}

class Parent{
    public void f(){
        System.out.println("Parent f()");
    }

    protected void x() throws Exception{
        System.out.println("PArent x()");
    }
}


class Child extends Parent{

    @Override
    private void f(){
        System.out.println("Parent f()");
    }

    @Override
    public void x() throws /*Throwable*/ IOException{    //  сделать модификатор более лёгким можно, но не наоборот
        System.out.println("PArent x()");                   // а ексцептион можно только конкретизировать
    }
}

