import xyz.model.*;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class ModelTest {

    ArrayList<Model> myItems;
    Item i0;
    Item i1;
    Item i2;
    Item i3;

    public ModelTest(){
        myItems = new ArrayList<Model>();
        i0 = new Item();
        i1 = new Item();
        i2 = new Item();
        i3 = new Item();


        i0.Name = "Mozarella";
        i0.Description = "Softened";
        i0.Unit = ".oz";
        i0.Amount = 4;

        i1.Name = "Dough";
        i1.Description ="White Flour";
        i1.Unit = ".oz";
        i1.Amount = 6;

        i2.Name = "Marinara";
        i2.Description = "Tomato & Herbs";
        i2.Unit = ".oz";
        i2.Amount = 4;

        i3.Name = "Pizza";
        i3.Description = "Mozarella & Red Herb Sauce";
        i3.Unit = "";
        i3.Amount = 1;

        //Update all keys

        i3.addModel(i0);
        i3.addModel(i1);
        i3.addModel(i2);

        i0.update();
        i1.update();
        i2.update();
        i3.update();

        myItems.add(i0);
        myItems.add(i1);
        myItems.add(i2);
        myItems.add(i3);

    }

    @Test
    public void TestProperty(){
        ModelObject pizza = (ModelObject)myItems.get(3);
        ModelObject dough = (ModelObject)myItems.get(1);
        assertEquals(i3.getName(), (String)pizza.get("Name"));

    }

    @Test
    public void TestGetModelUID() {
        ModelObject pizza = (ModelObject)myItems.get(3);
        ModelObject dough = (ModelObject)pizza.getModel(i1.getModelName(), i1.UID);
        assertEquals( i1.UID,(String)dough.get("UID"));
    }

    @Test
    public void TestJSONOut(){
        ModelObject pizza = (ModelObject)myItems.get(3);
        System.out.println(pizza.toString());
    }

    @Test
    public void TestIngestJSON(){
        ModelObject pizza = (ModelObject)myItems.get(3);
        String jsonPizza = pizza.toString();
        ModelObject ingestPizza = new ModelObject(jsonPizza);
        assertEquals(ingestPizza.get("UID"), pizza.get("UID"));
    }

    @Test
    public void TestIngestInternalJSON(){
        ModelObject pizza = (ModelObject)myItems.get(3);
        ModelObject dough = (ModelObject)myItems.get(1);
        String jsonPizza = pizza.toString();
        ModelObject ingestPizza = new ModelObject(jsonPizza);
        ModelObject ingestDough = (ModelObject)ingestPizza.getModel("Item", dough.UID);
        assertEquals(ingestDough.UID,dough.UID);
    }




}
