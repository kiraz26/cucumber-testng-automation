package com.app.tests;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.app.utilities.ConfigurationReader;

public class JDBCWithLog4j {

	public static final Logger logger = LogManager.getLogger();

	@Test
	public void getRecordsCount() {

		logger.info("Establishing database connection");

		try (Connection connection = DriverManager.getConnection(ConfigurationReader.getProperty("oracledb.url"),
				ConfigurationReader.getProperty("oracledb.username"),
				ConfigurationReader.getProperty("oracledb.password"));
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("Select * From employees");) {

			logger.debug("Executing query: Select * From employees");
			logger.info(ConfigurationReader.getProperty("oracledb.url"),
					"UserName:" + ConfigurationReader.getProperty("oracledb.username"),
					"PassWord:" + ConfigurationReader.getProperty("oracledb.password"));
			logger.info("Number of records fetched from database: " + resultSet.getRow());

		} catch (Exception e) {

			logger.error("Something went wrong!");
			logger.error(e.getMessage());

		}

	}

}
