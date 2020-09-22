package enumerations;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.HashMap;
import java.util.Map;

public enum EdibleCategory {
    drink,snack,menu;

    private static final Map<String,EdibleCategory> edibleCategoryMap = new HashMap<String,EdibleCategory>();

    static{
        edibleCategoryMap.put("drink",drink);
        edibleCategoryMap.put("snack",snack);
        edibleCategoryMap.put("menu",menu);
        edibleCategoryMap.put("",null);
    }

    @JsonCreator
    public static EdibleCategory forValue(String value){
        return edibleCategoryMap.get(value);
    }

    @JsonValue
    public String toValue(){
        for (Map.Entry<String, EdibleCategory> entry : edibleCategoryMap.entrySet()){
            if(entry.getValue()==this) return entry.getKey();
        }

        return null; //failed
    }
}
