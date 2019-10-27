package mysql;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.apache.commons.text.StringEscapeUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class JsonToJava {
    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
        //Loads Class Dynamically
        Class.forName("com.mysql.cj.jdbc.Driver");
        //Create conn object
        Connection conn = null;
        //Create Driver and get Connection
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Business?useUnicode=true" +
                "&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
                "root", "admin");
        //Create a st for the conn
        Statement st = conn.createStatement();
        //Perform SQL query
        ResultSet results = st.executeQuery
                ("select * from CustomerInfo where purchasedDate=CURDATE() and Location ='Asia';");
        //Create ArrayList to store DB results
        ArrayList<CustomerDetails> totalResults = new ArrayList<CustomerDetails>();
        JSONArray jsonArray = new JSONArray();

        while (results.next())
        {
            //Create Customer Details object for setters
            CustomerDetails customerDetails = new CustomerDetails();
            //Set customer details Course name
            customerDetails.setCourseName(results.getString(1));
            //Set customer details Purchase Date
            customerDetails.setPurchaseDate(results.getString(2));
            //Set customer details Amount
            customerDetails.setAmount(results.getInt(3));
            //Set customer details Location
            customerDetails.setLocation(results.getString(4));

            //Add Objects to ArrayList
            totalResults.add(customerDetails);

        }

        for(int i = 0; i < totalResults.size(); i++){
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writeValue(new File
                    ("C:\\Development\\SDET-Training\\src\\customerInfo\\customerInfo" + i +".json"),
                    totalResults.get(i));

            //Create Gson Object
            Gson gson = new Gson();
            //Convert Java Object to String
            String jsFile = gson.toJson(totalResults.get(i));

            //Create JSon Array and pass jsFile object as string
            jsonArray.add(jsFile);
        }

        //Json simple to pass multiple json files into one
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("data", jsonArray);

        System.out.println(jsonObject.toJSONString());
        System.out.println(" ");

        String unescapeStringFile = StringEscapeUtils.unescapeJava(jsonObject.toJSONString());
        System.out.println(unescapeStringFile);
        System.out.println(" ");

        String updatedJsonText = unescapeStringFile.replace("\"{", "{");
        String newFormattedText = updatedJsonText.replace("}\"", "}");
        System.out.println(newFormattedText);

        try {
            FileWriter file = new FileWriter
                    ("C:\\Development\\SDET-Training\\src\\customerInfo\\singleJson.json");
            file.write(newFormattedText);

            file.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        //Close DB connection
        conn.close();
    }
}
