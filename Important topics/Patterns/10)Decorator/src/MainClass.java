
public class MainClass {
    public static void main(String[] args){
        FileStream fileStream = new FileStreamReader();
        fileStream.read();

        System.out.println("\n-------------------------\n");

        FileStream fileDecoratorStream = new FileBestReader(new FileStreamReader());
        fileDecoratorStream.read();
    }
}

interface FileStream {
    void  read();
}
class FileStreamReader implements FileStream{
    @Override
    public void read() {
        System.out.println("read file");
    }
}

class FileBestReader implements FileStream{
    FileStream fileStream;
    public FileBestReader(FileStream fileStream) {
        this.fileStream = fileStream;
    }

    @Override
    public void read() {
        System.out.println("!!!!!!!!!!!!!! DECORATOR");
        fileStream.read();
        System.out.println("Any new functional added in read");
    }
}
