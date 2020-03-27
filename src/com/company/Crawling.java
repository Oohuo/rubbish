package com.company;



import com.company.HttpRequest;

import java.sql.*;

import static java.lang.Thread.sleep;


/**
 * @author ZH
 */
public class Crawling {
    public static void main(String[] args) {
        Connection con;
        String driver = "com.mysql.jdbc.Driver";
        //这里我的数据库是cgjr
        String url = "jdbc:mysql://localhost:3306/zanghua?useUnicode=true&characterEncoding=utf-8&useSSL=false";
        String user = "";
        String password = "";
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, password);
            if (!con.isClosed()) {
                System.out.println("数据库连接成功");
            }
            Statement statement = con.createStatement();

//            执行查询语句
       /*     String sql = "select * from lajihuamin;";//我的表格叫persons
            ResultSet resultSet = statement.executeQuery(sql);


//            打印查询出来的东西
            String name;
            String num;
            while (resultSet.next()) {
                name = resultSet.getString("id");
                num = resultSet.getString("text");
                System.out.println(name + '\t' + num);
            }*/


            //            执行插入语句



           /* for (int i=0;i<1000;i++){
                try {
                    String url_Words = HttpRequest.sendPost("https://nmsl.shadiao.app/./api.php?level=min&lang=zh_cn", null);
                    System.out.println(url_Words);
                    String sql2 = "Insert into " + "lajihuamin" + " (text)" + "values" + "('" + url_Words + "')";
                    System.out.println(sql2);
                    statement.executeUpdate(sql2);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }*/


            for (int i=0;i<1500;i++){
                try {
                    sleep(50);
                    String url_Words = HttpRequest.sendPost("https://nmsl.shadiao.app/api.php", null);
                    //System.out.println(url_Words);
                    String sql2 = "Insert into " + "lajihuamax" + " (msg)" + "values" + "('" + url_Words + "')";

                    System.out.println(sql2+"***"+i);
                    statement.executeUpdate(sql2);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
//                       执行更新语句


//            关闭连接
           // resultSet.close();
            con.close();
            System.out.println("已关闭连接");
        } catch (ClassNotFoundException e) {
            System.out.println("驱动没有");

        } catch (SQLException e) {
            System.out.println("连接失败");
        }
    }
}
