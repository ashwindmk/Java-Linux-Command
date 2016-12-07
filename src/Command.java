import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by ashwin on 7/12/16.
 */

public class Command
{
    public static void main(String[] args)
    {
        System.out.println("Enter command:");
        try
        {
            BufferedReader commandReader = new BufferedReader(new InputStreamReader(System.in));
            String command = commandReader.readLine();

            StringBuffer output = new StringBuffer();
            Process process = Runtime.getRuntime().exec(new String[]{"bash", "-c", command});
            process.waitFor();
            BufferedReader outputReader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            String line = "";

            while ((line = outputReader.readLine())!= null)
            {
                output.append(line + "\n");
            }

            System.out.println(output.toString());
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
