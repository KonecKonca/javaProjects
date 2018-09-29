
public class start {
    public static void main(String[] args){
        failWork f = new failWork();

        f.sozdanie();
        f.addInfo();
        f.closeFail(); // чтобы нача уже не записывать а считывать инфу, мы должны у объеката записи вызвать метод close()
        f.readInfo();
    }
}
