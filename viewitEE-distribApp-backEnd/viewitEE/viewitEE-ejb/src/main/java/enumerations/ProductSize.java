package enumerations;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.HashMap;
import java.util.Map;

public enum ProductSize {
    S,M,L;

    private static final Map<String,ProductSize> productSizeMap = new HashMap<String,ProductSize>();

    static{
        productSizeMap.put("S",S);
        productSizeMap.put("M",M);
        productSizeMap.put("L",L);
        productSizeMap.put("",null);
    }

    @JsonCreator
    public static ProductSize forValue(String value){
        return productSizeMap.get(value);
    }

    @JsonValue
    public String toValue(){
        for (Map.Entry<String, ProductSize> entry : productSizeMap.entrySet()){
            if(entry.getValue()==this) return entry.getKey();
        }

        return null; //failed
    }
}

