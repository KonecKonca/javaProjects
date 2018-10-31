public class Dannie {
    private String autorName;
    private String workTitle;
    private double price;

    public Dannie(){
        autorName = "";
        workTitle = "";
        price = 0;
    }
    public Dannie(String name){
        this();
        autorName = name;
    }
    public Dannie(String name, String title){
        this(name);
        workTitle = title;
    }
    public Dannie(String name, String title, double pr){
        this(name, title);
        price = pr;
    }

    public String getAutorName() {
        return autorName;
    }

    public String getWorkTitle() {
        return workTitle;
    }

    public double getPrice() {
        return price;
    }

    public void setAutorName(String autorName) {
        this.autorName = autorName;
    }
    public void setWorkTitle(String workTitle) {
        this.workTitle = workTitle;
    }
    public void setPrice(double price) {
        this.price = price;
    }
}
