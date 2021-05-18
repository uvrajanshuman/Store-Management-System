/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package store.management;

/**
 *
 * @author ANSHUMAN
 */
public class Item {
    private String item_id,item_name,item_price,item_category,item_desc,item_quantity,item_desired_quantity="0";
    private byte[] item_image=null;

    public void setItem_image(byte[] item_image) {
        this.item_image = item_image;
    }

    public void setItem_Desired_quantity(String desired_quantity) {
        this.item_desired_quantity = desired_quantity;
    }

    public String getItem_Desired_quantity() {
        return item_desired_quantity;
    }

    public byte[] getItem_image() {
        return item_image;
    }
    public void setItem_id(String item_id) {
        this.item_id = item_id;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public void setItem_price(String item_price) {
        this.item_price = item_price;
    }

    public void setItem_category(String item_category) {
        this.item_category = item_category;
    }

    public void setItem_desc(String item_desc) {
        this.item_desc = item_desc;
    }

    public void setItem_quantity(String item_quantity) {
        this.item_quantity = item_quantity;
    }

    public String getItem_id() {
        return item_id;
    }

    public String getItem_name() {
        return item_name;
    }

    public String getItem_price() {
        return item_price;
    }

    public String getItem_category() {
        return item_category;
    }

    public String getItem_desc() {
        return item_desc;
    }

    public String getItem_quantity() {
        return item_quantity;
    }
}
