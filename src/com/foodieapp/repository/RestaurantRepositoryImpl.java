package com.foodieapp.repository;

import com.foodieapp.model.CuisineType;
import com.foodieapp.model.FastFoodRestaurant;
import com.foodieapp.model.MenuItem;
import com.foodieapp.model.Restaurant;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RestaurantRepositoryImpl implements RestaurantRepository{

    private Map<Long,Restaurant> restaurants;
    CuisineType cuisineType;


    public RestaurantRepositoryImpl(){
        restaurants = new HashMap<>();
        init();
    }

    public void init(){
       Restaurant restaurant1 = new FastFoodRestaurant(1,"Arsalan",
               cuisineType.FAST_FOOD_RESTAURANT,"Mohali", LocalTime.of(10,00),
               LocalTime.of(21,00),new ArrayList<>(),false);

       restaurants.put(restaurant1.getRestaurantId(),restaurant1);

    }

    public void addRestaurant(Restaurant restaurant) {
//        if (restaurant.getMenuItems() == null) {
//            restaurant.setMenuItems(new ArrayList<>());
//        }
            restaurants.put(restaurant.getRestaurantId(), restaurant);


    }




    public void setActivationStatus(boolean status,long restaurantId) {
        Restaurant restaurant=restaurants.get(restaurantId);
        if(restaurant!=null){
           if(LocalTime.now().isAfter(restaurant.getOpeningTime()) &&
                   LocalTime.now().isBefore(restaurant.getClosingTime())){
            restaurant.setActive(true);
//            if(status){
//                restaurant.setOpeningTime(restaurant.getOpeningTime());
//                restaurant.setClosingTime(restaurant.getClosingTime());
//            }
            System.out.println("Resturant Status of is set as Active as of "+LocalTime.now());
        }
           else {
               System.out.println("Restaurant "+restaurant.getName()+" is not active now");
           }
        }
        else {
            System.out.println("Restaurant status is set as Not Active");
        }
    }
    private Restaurant getRestaurantMenuItems(MenuItem item){
        for(Restaurant restaurant:restaurants.values()){
            if(restaurant.getMenuItems()!=null && restaurant.getMenuItems().contains(item)){
                return restaurant;
            }
        }
        return null;
    }
    public void updateMenuItem(MenuItem item) {
          Restaurant restaurant=getRestaurantMenuItems(item);
          if(restaurant!=null){
              List<MenuItem> menuList=restaurant.getMenuItems();
              for(MenuItem menuItem:menuList){
                  if(menuItem.getName().equals(item.getName())){
                      menuItem.setPrice(item.getPrice());
                      menuItem.setType(item.getType());
                      menuItem.setCalorieCount(item.getCalorieCount());
                      System.out.println("MenuItems Updated : "+menuItem);
                      return;
                  }
              }
              System.out.println("The Menu is not Present");
          }
          else {
              System.out.println("There is no such Restaurant");
          }
    }

    public Restaurant getRestaurantById(long id) {
        return null;
    }

    public List<Restaurant> findRestaurantByLocation(String location) {
        List<Restaurant> restaurantList=new ArrayList<>();
        for (Restaurant restaurantObj :restaurants.values() ){
          if(  restaurantObj.getLocation().equalsIgnoreCase(location)){
              restaurantList.add(restaurantObj);
          }
        }
        if(restaurantList.size()==0){
            System.out.println("Restaurant not found");
        }
        return restaurantList;
    }

    public List<Restaurant> findRestaurantByName(String name) {
        List<Restaurant> restaurantList=new ArrayList<>();
        for (Restaurant restaurantObj :restaurants.values() ){
            if(  restaurantObj.getName().equalsIgnoreCase(name)){
                restaurantList.add(restaurantObj);
            }
        }
        if(restaurantList.size()==0){
            System.out.println("Restaurant not found");
        }
        return restaurantList;
    }

    public List<Restaurant> findRestaurantByType(CuisineType type) {
        List<Restaurant> restaurantList=new ArrayList<>();
        for (Restaurant restaurantObj :restaurants.values() ){
            if(  restaurantObj.getCuisineType().toString().equalsIgnoreCase(type.toString())){
                restaurantList.add(restaurantObj);
            }
        }
        if(restaurantList.size()==0){
            System.out.println("Restaurant not found");
        }
        return restaurantList;
    }

    public List<Restaurant> findAllActiveRestaurant() {
        List<Restaurant> restaurantList=new ArrayList<>();
        for (Restaurant restaurantObj :restaurants.values() ){
            if(  restaurantObj.isActive()){
                restaurantList.add(restaurantObj);
            }
        }
        if(restaurantList.size()==0){
            System.out.println("Restaurant not found");
        }
        return restaurantList;
    }

    public List<Restaurant> findAllDeactivatedRestaurant() {
        List<Restaurant> restaurantList=new ArrayList<>();
        for (Restaurant restaurantObj :restaurants.values() ){
            if( ! restaurantObj.isActive()){
                restaurantList.add(restaurantObj);
            }
        }
        if(restaurantList.size()==0){
            System.out.println("Restaurant not found");
        }
        return restaurantList;
    }
}
