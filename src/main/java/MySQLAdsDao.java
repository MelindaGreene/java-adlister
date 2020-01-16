import com.mysql.cj.jdbc.Driver;
import jdk.nashorn.internal.runtime.regexp.joni.Config;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLAdsDao implements Ads {
    Connection connection;


    public MySQLAdsDao(Config config){
        try{
            DriverManager.registerDriver((new Driver()));
            connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUsername(),
                    config.getPassword()
            );

        } catch (SQLException e){
            e.printStackTrace();
        }

    }

    @Override
//    display ads
     public List<Ad> all(){
        List<Ad> ads = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
//            takes resultset datatype has the query string

            ResultSet rs = statement.executeQuery("SELECT * FROM Ads");

//            this loop will loop through all the things your past threw
            while (rs.next()) {
//            translate the ResultSet into an List<Ad>

                Ad ad = new Ad(rs.getLong("id"),
                        rs.getLong("user_id"),
                        rs.getString("title"),
                        rs.getString("description"));
//            Add the new Ad into the List<Ad>
                ads.add(ad);
            }
        } catch (SQLException e){
            e.printStackTrace();

        }
        return ads;
//        returns the ads array list
    }

    @Override
    public Long insert(Ad ad){
        try{
            Statement stmt = connection.createStatement();

            String sql = String.format("insert into ads(title, description) values ('%s', '%s')", ad.getTitle(),ad.getDescription());
            stmt.executeLargeUpdate(sql,Statement.RETURN_GENERATED_KEYS);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0L;
    }
}
