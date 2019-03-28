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

    //constructor
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

    //input text into textfield from selected class
    public void inputText(){
        ui.fname.setText(ui.restaurant.getName());
        ui.fkind.setText(ui.restaurant.getKind());
        ui.frecoMenu.setText(ui.restaurant.getRecoMenu());
    }

    //clear textfield
    public void clearText(){
        ui.fname.setText("");
        ui.fkind.setText("");
        ui.frecoMenu.setText("");
    }

    //refresh and print all data
    public void refresh(){
        ui.data = dao.getAll();
        ui.defaultListModel.clear();
        for(Restaurant temp:ui.data){
            ui.defaultListModel.addElement(temp.getName());
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        //print all data
        if(e.getSource()==ui.all){
            refresh();
        }
        //print korean restaurant
        else if(e.getSource()==ui.korean){
            ui.data = dao.getKorean();
            ui.defaultListModel.clear();
            for(Restaurant temp:ui.data){
                ui.defaultListModel.addElement(temp.getName());
            }
        }
        //print japanese restaurant
        else if(e.getSource()==ui.japanese){
            ui.data = dao.getJapanese();
            ui.defaultListModel.clear();
            for(Restaurant temp:ui.data){
                ui.defaultListModel.addElement(temp.getName());
            }
        }
        //print chinese restaurant
        else if(e.getSource()==ui.chinese){
            ui.data = dao.getChinese();
            ui.defaultListModel.clear();
            for(Restaurant temp:ui.data){
                ui.defaultListModel.addElement(temp.getName());
            }
        }
        //print western restaurant
        else if(e.getSource()==ui.western){
            ui.data = dao.getWestern();
            ui.defaultListModel.clear();
            for(Restaurant temp:ui.data){
                ui.defaultListModel.addElement(temp.getName());
            }
        }
        //print etc restaurant
        else if(e.getSource()==ui.etc){
            ui.data = dao.getEtc();
            ui.defaultListModel.clear();
            for(Restaurant temp:ui.data){
                ui.defaultListModel.addElement(temp.getName());
            }
        }
        //open info werbsite on browser
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
        //add data
        else if(e.getSource()==ui.add){
            //check if there is empty textfield
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
            //input data after checking
            if(input==JOptionPane.YES_OPTION){
                ui.restaurant.setName(name);
                ui.restaurant.setKind(kind);
                ui.restaurant.setRecoMenu(recoMenu);
                dao.insert(ui.restaurant);
                refresh();
            }
        }
        //clear textfield
        else if(e.getSource()==ui.clear){
            clearText();
        }
        //print random data
        else if(e.getSource()==ui.random){
            Thr run = new Thr();
            Thread myThread = new Thread(run);
            myThread.start();
        }
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if(!e.getValueIsAdjusting() && !ui.jlist.isSelectionEmpty()){
            ui.restaurant = dao.getRestaurant(ui.jlist.getSelectedValue());
            inputText();
        }
    }

    class Thr implements Runnable{
        @Override
        public void run() {
            Random random = new Random();
            ui.data = dao.getAll();
            for(int i=0;i<10;++i) {
                int n = random.nextInt(ui.data.size());
                ui.restaurant = ui.data.get(n);
                inputText();
                try {
                    Thread.sleep(70);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }


        }
    }

}
