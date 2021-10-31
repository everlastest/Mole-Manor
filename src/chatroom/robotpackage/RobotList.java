package chatroom.robotpackage;

import java.util.ArrayList;

public class RobotList {

    private ArrayList<Robot> robotList = new ArrayList<>();
    private RobotList() {}
    private static RobotList instance = new RobotList();
    public static RobotList getInstance(){
        return instance;
    }

    /**
     * 添加机器人
     * @param robotName
     */
    public void addRobot(String... robotName){
        for(String i : robotName){
            Robot robot = new Robot(i);
            robot.start();
            robotList.add(robot);
        }
    }

    /**
     * 停用机器人
     */
    public void stop(){
        for(Robot r : robotList){
            r.stop();
        }
    }
}
