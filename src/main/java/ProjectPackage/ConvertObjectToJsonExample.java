package ProjectPackage;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import DataTypes.Item;

public class ConvertObjectToJsonExample {

    public static void main(String[] args) {

        //Person person = new Person("mkyong", 42);
        Item item = new Item("",0,0,(double) 0,true,true,true);

        ObjectMapper om = new ObjectMapper();

        try {

            // covert Java object to JSON strings
            String json = om.writeValueAsString(item);

            // output: {"name":"mkyong","age":42}
            System.out.println(json);

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }


    }
}
