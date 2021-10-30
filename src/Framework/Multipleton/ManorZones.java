package Framework.Multipleton;

import java.util.NoSuchElementException;

/**
 * 摩尔庄园的分区：游乐园、农场、商场、聊天室
 */
//利用枚举类型实现多例模式
public enum ManorZones {
    MOLEAMUSE_ZONE,MOLEFARM_ZONE,MOLEMALL_ZONE,CHATROOM_ZONE;
    /**
     * 获取摩尔庄园特定分区的单例
     * @param zoneName 分区名称
     * @return 获取分区的单例
     */
    public static ManorZones getInstance(String zoneName){
        return switch (zoneName){
            case "MoleAmuse"->MOLEAMUSE_ZONE;
            case "MoleFarm"->MOLEFARM_ZONE;
            case "MoleMall1" ->MOLEMALL_ZONE;
            case "Chatroom"->CHATROOM_ZONE;
            default->throw new NoSuchElementException("Zone doesn't exist.");
        };
    }
}