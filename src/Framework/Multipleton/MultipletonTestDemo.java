package Framework.Multipleton;

public class MultipletonTestDemo {
    void testMultipleton(){
        String[] zonesName={"MoleManor","MoleFarm","MoleMall","Chatroom"};
        String zone1 = ManorZones.getInstance("movieZone").toString();
        String zone2 = ManorZones.getInstance("amusementZone").toString();
        String zone3 = ManorZones.getInstance("restaurantZone").toString();
        String zone4 = ManorZones.getInstance("hotelZone").toString();
        System.out.println("游乐园的分区包括：" + zone1 + "," + zone2 + "," + zone3 + "," + zone4);
    }
}