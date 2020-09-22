package enumerations;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.HashMap;
import java.util.Map;

public enum Genre {
    Action,Animated,Comedy,Musical;

    private static Map<String,Genre> genreMap = new HashMap<String,Genre>();

    static{
        genreMap.put("Action",Action);
        genreMap.put("Animated",Animated);
        genreMap.put("Comedy",Comedy);
        genreMap.put("Musical",Musical);
    }

    @JsonCreator
    public static Genre forValue(String value){
        return genreMap.get(value);
    }

    @JsonValue
    public String toValue(){
        for (Map.Entry<String, Genre> entry : genreMap.entrySet()){
            if(entry.getValue()==this) return entry.getKey();
        }

        return null; //failed
    }
}
