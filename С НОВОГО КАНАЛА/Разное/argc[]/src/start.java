public class start {
    public static void main(String[] args) {
        for(String str : args){
            System.out.println(str);
        }
        forAdmin(args);
    }

    public static void forAdmin(String[] arg){
        for(String str : arg){
            if(str.equals("parol")){
                System.out.println("////////////////\nsecret))\n////////////////////////");
            }
        }
    }
}
