package GUI;

import BLL.Item;
import BLL.ItemBLL;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class App {
    App() {
        JFrame f = new JFrame("Todo List");
        JPanel p1 = new JPanel();
        JPanel p3 = new JPanel();
        p1.setLayout(new FlowLayout());
        p3.setLayout(new BoxLayout(p3, BoxLayout.Y_AXIS));
        JLabel label = new JLabel("Them Item:", JLabel.CENTER);
        JTextField item = new JTextField(10);
        JButton addBtn = new JButton("Add Item");
        ItemComponent itemComponent = new ItemComponent();
        addBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Item item1 = ItemBLL.addItemByName(item.getText());
                itemComponent.addItemComponent(item1);
            }
        });
        p1.add(label);
        p1.add(item);
        p1.add(addBtn);
        p3.add(p1);
        p3.add(itemComponent);
        f.add(p3);
        f.setLayout(new FlowLayout());
        f.setVisible(true);
        f.setSize(400, 400);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });
    }

    public static void main(String args[]) {
        new App();
    }
}