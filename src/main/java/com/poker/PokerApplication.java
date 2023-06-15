package com.poker;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.*;

@SpringBootApplication
@EnableCaching
@OpenAPIDefinition
public class PokerApplication {


	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		SpringApplication.run(PokerApplication.class, args);
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Poker","root","root");
		PreparedStatement ps = con.prepareStatement("Select * from player where player_id Between ? and ?");
		ps.setInt(1,2);
		ps.setInt(2,4);
		ResultSet res = ps.executeQuery();
		while(res.next())
			System.out.println(res.getInt("player_id") + " " + res.getString("name"));
	}

}
