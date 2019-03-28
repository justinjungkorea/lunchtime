package lunch_package;

import java.util.List;

public interface RestraurantDAO {

    List<Restaurant> getAll();
    int insert(Restaurant restaurant);
    List<Restaurant> getKorean();
    List<Restaurant> getJapanese();
    List<Restaurant> getChinese();
    List<Restaurant> getWestern();
    List<Restaurant> getEtc();
    Restaurant getRestaurant(String str);

}
