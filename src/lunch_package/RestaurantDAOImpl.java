package lunch_package;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RestaurantDAOImpl implements RestraurantDAO {
    private RestaurantDAOImpl(){}
    private static RestraurantDAO pattern;
    Connection connection = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;

    public static RestraurantDAO getInstance(){
        if(pattern==null) pattern = new RestaurantDAOImpl();
        return pattern;
    }

    @Override
    public List<Restaurant> getAll() {
        List<Restaurant> list = new ArrayList<>();
        try {
            connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.100:1521/XEPDB1", "USER13", "user13");
            stmt = connection.prepareStatement("select * from restaurant order by name");
            rs = stmt.executeQuery();
            while(rs.next()){
                Restaurant restaurant = new Restaurant();
                restaurant.setNum(rs.getInt(1));
                restaurant.setName(rs.getString(2));
                restaurant.setKind(rs.getString(3));
                restaurant.setRecoMenu(rs.getString(4));
                restaurant.setMenuLink(rs.getString(5));
                list.add(restaurant);
            }
            rs.close();
            stmt.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public List<Restaurant> getKorean() {
        List<Restaurant> list = new ArrayList<>();
        try {
            connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.100:1521/XEPDB1", "USER13", "user13");
            stmt = connection.prepareStatement("select * from RESTAURANT where kind='한식' order by name");
            rs = stmt.executeQuery();
            while(rs.next()){
                list.add(new Restaurant(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)));
            }
            rs.close();
            stmt.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public List<Restaurant> getJapanese() {
        List<Restaurant> list = new ArrayList<>();
        try {
            connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.100:1521/XEPDB1", "USER13", "user13");
            stmt = connection.prepareStatement("select * from RESTAURANT where kind='일식' order by name");
            rs = stmt.executeQuery();
            while(rs.next()){
                list.add(new Restaurant(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)));
            }
            rs.close();
            stmt.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public List<Restaurant> getChinese() {
        List<Restaurant> list = new ArrayList<>();
        try {
            connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.100:1521/XEPDB1", "USER13", "user13");
            stmt = connection.prepareStatement("select * from RESTAURANT where kind='중식' order by name");
            rs = stmt.executeQuery();
            while(rs.next()){
                list.add(new Restaurant(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)));
            }
            rs.close();
            stmt.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public List<Restaurant> getWestern() {
        List<Restaurant> list = new ArrayList<>();
        try {
            connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.100:1521/XEPDB1", "USER13", "user13");
            stmt = connection.prepareStatement("select * from RESTAURANT where kind='양식' order by name");
            rs = stmt.executeQuery();
            while(rs.next()){
                list.add(new Restaurant(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)));
            }
            rs.close();
            stmt.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public List<Restaurant> getEtc() {
        List<Restaurant> list = new ArrayList<>();
        try {
            connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.100:1521/XEPDB1", "USER13", "user13");
            stmt = connection.prepareStatement("select * from RESTAURANT where kind='기타' order by name");
            rs = stmt.executeQuery();
            while(rs.next()){
                list.add(new Restaurant(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)));
            }
            rs.close();
            stmt.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public int insert(Restaurant restaurant) {
        int result = -1;

        try {
            connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.100:1521/XEPDB1", "USER13", "user13");
            stmt = connection.prepareStatement("insert into restaurant(num, name, kind, reco_menu) values (restaurant_num_seq.nextval,?,?,?)");
            stmt.setString(1,restaurant.getName());
            stmt.setString(2,restaurant.getKind());
            stmt.setString(3,restaurant.getRecoMenu());
            result = stmt.executeUpdate();

        } catch (Exception e) {
            System.out.println("insert error : "+e.getMessage());
            e.printStackTrace();
        }


        return result;
    }

    @Override
    public Restaurant getRestaurant(String str) {
        Restaurant temp = null;
        try {
            connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.100:1521/XEPDB1", "USER13", "user13");
            stmt = connection.prepareStatement("select * from RESTAURANT where name=?");
            stmt.setString(1,str);
            rs = stmt.executeQuery();
            while(rs.next()){
                temp = new Restaurant(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
            }
            rs.close();
            stmt.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return temp;
    }
}
