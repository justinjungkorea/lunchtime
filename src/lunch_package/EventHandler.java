package lunch_package;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Random;

public class EventHandler implements ActionListener, ListSelectionListener {
    private LunchGUI ui;
    private RestraurantDAO dao;

    public EventHandler(LunchGUI ui){
        this.ui = ui;
        dao = RestaurantDAOImpl.getInstance();
        ui.display();
        ui.data = dao.getAll();
        ui.restaurant = new Restaurant();
        for(Restaurant temp:ui.data){
            ui.defaultListModel.addElement(temp.getName());
        }
    }

    public void inputText(){
        ui.fname.setText(ui.restaurant.getName());
        ui.fkind.setText(ui.restaurant.getKind());
        ui.frecoMenu.setText(ui.restaurant.getRecoMenu());
    }

    public void clearText(){
        ui.fname.setText("");
        ui.fkind.setText("");
        ui.frecoMenu.setText("");
    }

    public void refresh(){
        ui.data = dao.getAll();
        ui.defaultListModel.clear();
        for(Restaurant temp:ui.data){
            ui.defaultListModel.addElement(temp.getName());
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==ui.all){
            refresh();
        }
        else if(e.getSource()==ui.korean){
            ui.data = dao.getKorean();
            ui.defaultListModel.clear();
            for(Restaurant temp:ui.data){
                ui.defaultListModel.addElement(temp.getName());
            }
        }
        else if(e.getSource()==ui.japanese){
            ui.data = dao.getJapanese();
            ui.defaultListModel.clear();
            for(Restaurant temp:ui.data){
                ui.defaultListModel.addElement(temp.getName());
            }
        }
        else if(e.getSource()==ui.chinese){
            ui.data = dao.getChinese();
            ui.defaultListModel.clear();
            for(Restaurant temp:ui.data){
                ui.defaultListModel.addElement(temp.getName());
            }
        }
        else if(e.getSource()==ui.western){
            ui.data = dao.getWestern();
            ui.defaultListModel.clear();
            for(Restaurant temp:ui.data){
                ui.defaultListModel.addElement(temp.getName());
            }
        }
        else if(e.getSource()==ui.etc){
            ui.data = dao.getEtc();
            ui.defaultListModel.clear();
            for(Restaurant temp:ui.data){
                ui.defaultListModel.addElement(temp.getName());
            }
        }
        else if(e.getSource()==ui.menuL){
            if(ui.fname.getText().length()<1){
                JOptionPane.showMessageDialog(null,"식당을 선택하여 주세요!");
                return;
            }
            try {
                Desktop.getDesktop().browse(java.net.URI.create(ui.restaurant.getMenuLink()));
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        else if(e.getSource()==ui.add){

            if(ui.fname.getText().length()<1){
                JOptionPane.showMessageDialog(null,"이름을 입력하세요!");
                return;
            }
            if(ui.fkind.getText().length()<1){
                JOptionPane.showMessageDialog(null,"종류를 입력하세요!");
                return;
            }
            if(ui.frecoMenu.getText().length()<1){
                JOptionPane.showMessageDialog(null,"추천메뉴를 입력하세요!");
                return;
            }
            String name = ui.fname.getText();
            String kind = ui.fkind.getText();
            String recoMenu = ui.frecoMenu.getText();
            String confirm = String.format("이름: %s\n종류: %s\n추천메뉴: %s\n입력하시겠습니까?\n",name,kind,recoMenu);
            int input = JOptionPane.showConfirmDialog(null,confirm,"데이터 입력",JOptionPane.YES_NO_OPTION);
            if(input==JOptionPane.YES_OPTION){
                ui.restaurant.setName(name);
                ui.restaurant.setKind(kind);
                ui.restaurant.setRecoMenu(recoMenu);
                dao.insert(ui.restaurant);
                refresh();
            }
        }
        else if(e.getSource()==ui.clear){
            clearText();
        }
        else if(e.getSource()==ui.random){
            clearText();
            Random random = new Random();
            ui.data = dao.getAll();
            int n = random.nextInt(ui.data.size());
            ui.restaurant = dao.getRestaurant(ui.data.get(n).getName());
            inputText();
        }
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if(!e.getValueIsAdjusting() && !ui.jlist.isSelectionEmpty()){
            ui.restaurant = dao.getRestaurant(ui.jlist.getSelectedValue());
            inputText();
        }
    }


}
