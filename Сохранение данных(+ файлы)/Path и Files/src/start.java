import com.sun.deploy.util.SyncAccess;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.PosixFileAttributes;
import java.util.*;
import java.util.logging.FileHandler;
import java.util.logging.Level;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;
import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.newObjectType;

public class start {
    public static void main(String[] args) throws Exception{

        // 1-ый способ
//        Path path = Paths.get("exmoakki.txt");
        Path path = Paths.get("exmoakki.txt").toAbsolutePath();  // абсолютный путь

        // 2-ой способ
//        File file = new File("exmoakki.txt");
//        path = file.toPath();

        System.out.println(path.getFileName());
        System.out.println(path.getParent());
        System.out.println(path.getRoot() + "\n");

        // Основной функционал в лежит в классе Files(набор полезных статических функций)

        Files.copy(Paths.get("exmoakki.txt"), Paths.get("exmoakki2.txt"), StandardCopyOption.REPLACE_EXISTING);  // копировать файл
        Files.move(Paths.get("exmoakki2.txt"), Paths.get("xyi.txt"), StandardCopyOption.REPLACE_EXISTING);  // переименовать файл
        Files.deleteIfExists(Paths.get("xyi.txt"));  // удаление
        ///  StandardCopyOption.REPLACE_EXISTING ---- если такой файл уже есть то заменится

        System.out.println(Files.size(path));  // размер файла в байтах
        System.out.println(Files.isDirectory(path));  // является ли папкой
        System.out.println(Files.isReadable(path));  // читаем ли
        System.out.println(Files.isWritable(path) + "\n");  // можно ли писать в него

        System.out.println( Files.getAttribute(path, "size", LinkOption.NOFOLLOW_LINKS)); //  но нужно знать атрибуты

        // запись и считка побайтно
//        byte[] bytes = Files.readAllBytes(path);
//        for(int i = 0; i < bytes.length; i++){
//            System.out.print(bytes[i] + " ");
//        }
//        System.out.println();
//        Files.write(path, "bla\nxyi".getBytes());

        // считка и запись построчно
        List<String> list = Files.readAllLines(path);
        list.add("xXXXXXxxxx");
        Files.write(path, list);

        //showWhatIsInDirectory();

        //Files.walkFileTree(Paths.get("."), new Myfile2()); // вывести всё
        Files.walkFileTree(Paths.get("."), new HashSet<FileVisitOption>(), 1, new Myfile2()); // с указанием глубины прохода

    }

    private static void showWhatIsInDirectory() throws Exception{  // просмотреть файлы (1)
        try(DirectoryStream<Path> entries = Files.newDirectoryStream(Paths.get("."))) {
           for(Path path1 : entries){
               System.out.println(path1.getFileName());
           }
        }
    }

}

class MyFileVisitor extends SimpleFileVisitor<Path>{  // дял работы с файлами в директории  (1)
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException{
        System.out.println(file.getFileName());
        return FileVisitResult.CONTINUE;
    }
}

class Myfile2 extends SimpleFileVisitor<Path>{
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException{
        System.out.println(file.getFileName());
        return FileVisitResult.CONTINUE;  // TERMINATE --- прекратить
    }
}
