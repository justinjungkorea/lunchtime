package lunch_package;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    static Restaurant restaurant;
    static Scanner sc = null;
    static BufferedReader br = null;

    public static void main(String[] args) throws Exception{
        new LunchGUI();
//        sc = new Scanner(System.in);
//        br = new BufferedReader(new InputStreamReader(System.in));
//        RestraurantDAO dao = RestaurantDAOImpl.getInstance();
//
//        while(true){
//            printMenu();
//            int input = sc.nextInt();
//            if(input==0)    break;
//            else if(input==1){
//                for(Restaurant temp:dao.getAll()){
//                    System.out.println(temp);
//                }
//            }
//            else if(input==2){
//                inputData();
//                int result = dao.insert(restaurant);
//                if(result!=0)  System.out.println("insert success");
//                else                    System.out.println("insert fail");
//            }
//            else if(input==3){
//                for(Restaurant temp:dao.getKorean()){
//                    System.out.println(temp);
//                }
//            }
//            else if(input==4){
//                for(Restaurant temp:dao.getJapanese()){
//                    System.out.println(temp);
//                }
//            }
//            else if(input==5){
//
//            }
//            else{
//                System.out.println("wrong number!");
//            }
//        }
    }

    static void inputData() throws Exception{
        restaurant = new Restaurant();
        String name,kind,recoMenu;
        System.out.print("dname:");
        name = br.readLine();
        System.out.print("kind:");
        kind = br.readLine();
        System.out.print("recoMenu:");
        recoMenu = br.readLine();
        restaurant.setName(name);
        restaurant.setKind(kind);
        restaurant.setRecoMenu(recoMenu);
    }

    static void printMenu(){
        System.out.println("=============================");
        System.out.println("1.Allselect");
        System.out.println("2.input");
        System.out.println("3.korean");
        System.out.println("4.japanese");
        System.out.println("5.chinese");
        System.out.println("0.exit");
        System.out.println("=============================");
        System.out.print("menu:");
    }


}
