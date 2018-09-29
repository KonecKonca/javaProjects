import java.util.*;

public class MainClass {
    public static void main(String[] args){

    }
}

class Folder{
    private String name;
    private  int creationDate;
    private List<Folder> folders = new ArrayList<>();
    private List<File> files = new ArrayList<>();

    public Folder(String name) {
        this.name = name;
    }
    public void addFolder(Folder folder){
        folders.add(folder);
    }
    public  void removeFolder(Folder folder){
        folders.remove(folder);
    }
    public List<Folder> getFolders(){
        return folders;
    }

    public void addFile(File file){
        files.add(file);
    }
    public  void removeFiles(File file){
        files.remove(file);
    }
    public List<File> getFiles(){
        return files;
    }
}

class File{
    private String fileName;
    public String getFileName() {
        return fileName;
    }
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}