import java.io.*;


// Reader Writer --- онли для тестовых  (также к ним ещё несколько их наследников)
// InputStream OutputStream  --- работает с потоком байтов ( более универсальный )
public class start{
    public static void main(String[] args) throws Exception{
        try {
            help();
        }
        catch (Exception ex){}
    }

    private static void help()throws Exception{
        File file = new File("name.txt");
        if(!file.exists()) {
            //file.mkdir(); СОЗДАТЬ ПАПКУ (возле src)
            file.createNewFile();
            System.out.println("exist");
        }

        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write("str1\n");
        fileWriter.write("str2\n");
        fileWriter.flush();

        FileReader fileReader = new FileReader(file);  // изначально читает поток байт(неудобно -> юзаем буферид и буферврайт)
        /*char[] chars = new char[20];
        fileReader.read(chars);
        System.out.println(chars);*/  /// неудобный варик

        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write("str3");
        bufferedWriter.newLine();  // здесь строка переводится автоматически
        bufferedWriter.write("str4");
        bufferedWriter.flush();
        bufferedWriter.close();

        BufferedReader bufferedReader = new BufferedReader(fileReader);
        while(bufferedReader.ready()){
            System.out.println(bufferedReader.readLine());
        }

        /*if(file.isDirectory()){
            System.out.println("dir");
        }
        if(file.isFile()){
            System.out.println("file");
        }*/
    }
}
