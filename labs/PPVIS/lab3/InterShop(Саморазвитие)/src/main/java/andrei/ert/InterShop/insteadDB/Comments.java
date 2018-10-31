package andrei.ert.InterShop.insteadDB;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Comments {
    private static List<String> list = new ArrayList<String>(Arrays.asList("Great stuff!!! Fast charging. Packed as necessary",
            "All the good time! Great quality plastic, exceeded expectations, very beautiful device, not something extra, nice in your hand, immediately began to charge Samsung, sitting on the Internet and it charges!!! Come with a charge of 75%. Order to this cable for charging the phone in this store, super quality and токопроводимость, in general, the seller note! And by the way delivery in 5 days))) is the fastest of my orders rest up and out… All good!;)",
            "When you open the had to remove the protective film. Good product, already have. Order free shipping with a maximum of 60 days delivery. It 'S for 34 days Leningrad area.",
            "Such work. Only charging cable, through which the computer  gadgets",
            "Extremely bad packaged boxes come crumpled, was purchased for a gift (((",
            "Everything is fine, posting a month, are satisfied",
            "come and whole all 3-4 weeks. заказываю not think not in the first time and the last one satisfied with the shop will отпишусь problems. thanks! shop recommend!",
            "Order 60 days, 50 of which lay in China. Wrote, he extended his protection and posting immediately went. Always come quickly enough, not the first time. Quality as always on top. Very satisfied.",
            "Great quality product without burrs perfect came with 75% load, not taxed took the arrive but the fault Brazilian that are a joke",
            "given and sent fast seller tracking number, such deal with nice sellers",
            "High quality item, satisfied",
            "Extremely bad packaged boxes come crumpled, was purchased for a gift (((",
            "Everything is fine, posting a month, are satisfied",
            "come and whole all 3-4 weeks. заказываю not think not in the first time and the last one satisfied with the shop will отпишусь problems. thanks! shop recommend!",
            "Order 60 days, 50 of which lay in China. Wrote, he extended his protection and posting immediately went. Always come quickly enough, not the first time. Quality as always on top. Very satisfied.",
            "Great quality product without burrs perfect came with 75% load, not taxed took the arrive but the fault Brazilian that are a joke",
            "given and sent fast seller tracking number, such deal with nice sellers",
            "High quality item, satisfied"));

    public static void addComment(String comment){
        List<String> result = new ArrayList<>();
        result.add(comment);
        result.addAll(list);
        list = result;
    }
    public static List<String> getList(){
        return list;
    }
}
