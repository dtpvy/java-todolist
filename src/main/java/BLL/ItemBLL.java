package BLL;


import DAL.ItemDAO;

public class ItemBLL {
    public static Item addItemByName(String data) {
        System.out.println("Adding item: " + data);
        Item item = ItemDAO.addItem(new Item(data));
        if (item != null) {
            System.out.println("Add item " + data + " success");
        } else {
            System.out.println("Add item " + data + " fail");
        }
        return item;
    }

    public static void removeItemById(Item item) {
        System.out.println("Removing item: " + item.getName());
        if (ItemDAO.removeItem(item.getId())) {
            System.out.println("Remove item by id = " + item.getId() + " success");
        } else {
            System.out.println("Remove item by id = " + item.getId() + " fail");
        }
    }

    public static void updateItemByName(Item item, String newName) {
        System.out.println("Updating item");
        item.setName(newName);
        if (ItemDAO.updateItem(item)) {
            System.out.println("Update item " + item.getId() + "with name = " + item.getName() + " success");
        } else {
            System.out.println("Update item fail");
        }
    }
}
