package xyz.model;


public class Item extends ModelObject {


    public String Description;
    public String Unit;
    public int Amount;

    public Item() {
        super();
        ClassName = "Item";
        Name = "UniqueItem";

        put("ClassName", ClassName);
        put("Name", Name);
        put("Description", Description);
        put("Unit", Unit);
        put("Amount", Amount);

    }

    public Item(String name){
        super();
        ClassName = "Item";
        Name = name;

        put("Description", Description);
        put("Unit", Unit);
        put("Amount", Amount);
    }

    public Item(String name, String descrip, String unit, int amount){
        super();
        ClassName = "Item";
        Name = name;
        Description = descrip;
        Unit = unit;
        Amount = amount;

        put("Description", Description);
        put("Unit", Unit);
        put("Amount", Amount);
    }

    public void update(){
        super.update();
        put("Description", Description);
        put("Unit", Unit);
        put("Amount", Amount);
    }


}
