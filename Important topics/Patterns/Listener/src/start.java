
public class start{
    public static void main(String[] args) {
        RadioButton radioButton1 = new RadioButton(0, 0,"button1");
        RadioButton radioButton2 = new RadioButton(100, 100,"button2");
        RadioButton radioButton3 = new RadioButton(200, 200,"button3");

        radioButton1.addListener(radioButton2);
        radioButton1.addListener(radioButton3);

        radioButton2.addListener(radioButton1);
        radioButton2.addListener(radioButton3);

        radioButton3.addListener(radioButton1);
        radioButton3.addListener(radioButton2);

        System.out.println(radioButton1.on + " : " + radioButton2.on + " : " + radioButton3.on);

        Mouse.click(50, 50);
        System.out.println(radioButton1.on + " : " + radioButton2.on + " : " + radioButton3.on);

        Mouse.click(3, 3);
        System.out.println(radioButton1.on + " : " + radioButton2.on + " : " + radioButton3.on);

        Mouse.click(101, 97);
        System.out.println(radioButton1.on + " : " + radioButton2.on + " : " + radioButton3.on);

        Mouse.click(198, 203);
        System.out.println(radioButton1.on + " : " + radioButton2.on + " : " + radioButton3.on);
    }
}
