package Blackboard;

import java.util.ArrayList;

public class Blackboard {
    int temperature;
    ArrayList<String> noticeList;
    public Blackboard(){
        this.noticeList=new ArrayList<>();
    }
    public void show(){
        int number=1;
        for(String s:noticeList){
            String mes="公告"+number+":"+s;
            number++;
        }
    }
    public void update(String s){
        noticeList.add(s);
    }
}
