package GUI;

import BLL.Item;
import BLL.ItemBLL;
import DAL.ItemDAO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ItemComponent extends JPanel {
    public JPanel getItemComponent(Item item) {
        JPanel p = new JPanel();
        JLabel label = new JLabel(item.getName(), JLabel.CENTER);
        JButton editBtn = new JButton("Update Item");
        JButton removeBtn = new JButton("Remove Item");
        editBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String s = JOptionPane.showInputDialog("Edit: ", item.getName());
                ItemBLL.updateItemByName(item, s);
                label.setText(s);
                p.revalidate();
                p.repaint();
            }
        });
        removeBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ItemBLL.removeItemById(item);
                remove(p);
                revalidate();
                repaint();
            }
        });
        p.add(label);
        p.add(editBtn);
        p.add(removeBtn);

        p.setLayout(new FlowLayout());
        return p;
    }

    ItemComponent() {
        List<Item> itemList = ItemDAO.getItemList();
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        for (Item _item : itemList) {
            System.out.println(_item.getId() + " " + _item.getName());
            add(getItemComponent(_item));
        }
    }

    public void addItemComponent(Item item) {
        add(getItemComponent(item));
        revalidate();
        repaint();
    }

}
