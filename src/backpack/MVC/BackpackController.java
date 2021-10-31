package backpack.MVC;

public class BackpackController {
    private Backpack model;
    private BackpackView view;

    public BackpackController(Backpack model, BackpackView view){
        this.model=model;
        this.view=view;
    }
    /*public void a(String item,int num)
    {
        model.getClothesNum(item);
    }*/

    public void AddBackpackItem(String item,int num,String type){
        switch(type)
        {
            case "clothes":
                if(model.getClothes().containsKey(item)){

                    Integer n=model.getClothesNum(item);
                    n+=num;
                    model.Delclothes(item);
                    model.Addclothes(item,n);
                }
                else
                    model.Addclothes(item,num);
                break;
            case "food":
                if(model.getClothes().containsKey(item)){
                    Integer n=model.getFoodNum(item);
                    n+=num;
                    model.Delfood(item);
                    model.Addfood(item,n);
                }
                else
                    model.Addfood(item,num);
                break;
        }

    }
    /*
    public void DelBackpackItem(String item,){
        model.Delitem(item);
    }
    */

    //遍历背包
    public void updateView(){
        System.out.println("物品" + '\t' + '\t' +'\t' +"数量");
        view.printBackpack(model.getClothes());
        view.printBackpack(model.getFood());
    }


}
