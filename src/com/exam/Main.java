package com.exam;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<MenuItem> menuItems = new ArrayList<>();
        List<Order> orders = new ArrayList<>();

        try {
            FileReader fr = new FileReader("menu.txt");
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();
            while (line != null) {
                String[] tokens = line.split(",");
                int number = Integer.parseInt(tokens[0]);
                String name = tokens[1];
                int price = Integer.parseInt(tokens[2]);
                int heat = Integer.parseInt(tokens[3]);
                MenuItem m = new MenuItem(number, name, price, heat);
                menuItems.add(m);
                line = br.readLine();
            }
            //print the menu
            while (true) {
                boolean start = true;
                while (start) {
                    for (int i = 0; i < menuItems.size(); i++) {
                        System.out.println(i + 1 + ") " + menuItems.get(i).getName());
                    }
                    System.out.println("0) 結算");
                    System.out.println("q) 離開(結束程式)");
                    //order the menu
                    System.out.print("請輸入餐點:");
                    Scanner scanner = new Scanner(System.in);
                    int orderitem = scanner.nextInt();
                    if (orderitem != 0) {
                        MenuItem m = menuItems.get(orderitem - 1);
                        System.out.print("請輸入數量:");
                        scanner = new Scanner(System.in);
                        int ordernumber = scanner.nextInt();
                        Order order = new Order(m, ordernumber);
                        orders.add(order);
                        System.out.println("目前餐點：");
                        for (int i = 0; i < orders.size(); i++) {
                            System.out.println(i + 1 + ". " + orders.get(i).menuItem.getName() + " " + orders.get(i).getQuantity() + "份");
                        }
                        System.out.println("=================");
                    } else {
                        start = false;
                        System.out.println("所有餐點：");
                        for (int i = 0; i < orders.size(); i++) {
                            System.out.println(i + 1 + ". " + orders.get(i).menuItem.getName() + " " + orders.get(i).getQuantity() + "份");
                        }
                        int totalprice = 0;
                        for (int i = 0; i < orders.size(); i++) {
                            totalprice += orders.get(i).menuItem.getPrice() * orders.get(i).getQuantity();
                        }
                        System.out.println("合計；" + totalprice);
                        int totalheat = 0;
                        for (int i = 0; i < orders.size(); i++) {
                            totalheat += orders.get(i).menuItem.getHeat() * orders.get(i).getQuantity();
                        }
                        if (totalheat > 1200) {
                            System.out.println("高熱量餐點");
                        }
                        break;
                    }
                }
                //按下enter => 清空點餐紀錄 => 重新開始點餐
                System.in.read();
                orders.clear();
                start = true;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
