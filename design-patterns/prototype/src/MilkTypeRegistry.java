
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class MilkTypeRegistry {
    Map<String,Milk> milkMap= new HashMap<>();

    public MilkTypeRegistry() {
        initialize();
    }

    public Milk getMilk(String type) {
        Milk clone = null;
        if(type.matches("(faluda|lassi)")) {
            try {
                clone = (Milk) (milkMap.get(type).clone());
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
        }

        return clone;
    }

    private void initialize(){

        Faluda faluda= new Faluda();
        faluda.setTemp("cool");
        faluda.setCondiments("saffron,roseWater");

       Lassi lassi= new Lassi();
       lassi.setTemp("cool");
       lassi.setCondiments("suger yourget salt");

       milkMap.put("faluda",faluda);
        milkMap.put("lassi",lassi);


    }
}
