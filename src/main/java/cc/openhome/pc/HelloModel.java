package cc.openhome.pc;

import java.util.*;

public class HelloModel{
    private Map<String,String> messages = new HashMap<String,String>();

    public HelloModel(){
        messages.put("caterpillar","Hello");
        messages.put("Justin","Welcome");
        messages.put("momor","Hi");
    }
    public String doHello(String user){
        String message=messages.get(user);
        return message+", "+user+"!";
    }
}
