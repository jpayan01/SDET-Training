package selenium_docker_integration;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;

public class StartDocker {

    @Test
    public void startFile() throws IOException, InterruptedException {
        // Create flag and set it to False
        boolean flag = false;
        // Create Java Runtime object to run batch file
        Runtime runtime = Runtime.getRuntime();
        runtime.exec("cmd /c start dockerUp.bat");
        // The file name to be read
        String fileOutput = "output.txt";

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.SECOND, 45);
        long stopNow = calendar.getTimeInMillis();

        while (System.currentTimeMillis() < stopNow){
            if(flag){
                break;
            }
            //Create Buffered Reader to be able to read file
            BufferedReader reader = new BufferedReader(new FileReader(fileOutput));
            //Scan current line and assign it to a String variable
            String currentLine = reader.readLine();

            //Iterate over the file document for as long as it is not null
            while(currentLine != null && !flag){
                if(currentLine.contains("registered to the hub and ready to use")){
                    System.out.println("fount text");
                    flag = true;
                    break;
                }
                currentLine = reader.readLine();
            }
            reader.close();

            Assert.assertTrue(flag);
        }

    } // End of Main method

} // End of Class
