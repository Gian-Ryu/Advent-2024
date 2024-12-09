
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Day3Part1 {
    public static void main(String[] args) {

        ArrayList<String> fileData = getFileData("src/Day3Input.txt");
        System.out.println(fileData);
        int ans = 0;
        for (String e : fileData)
        {
            ArrayList<String> allMatches = new ArrayList<String>();
            String regex = "mul\\([1-9][0-9],[1-9][0-9]\\)";
            Matcher m = Pattern.compile(regex).matcher(e);
            while (m.find()) {
                allMatches.add(m.group());
            }
            System.out.println(allMatches);
            //ans +=
        }
    }

    public static ArrayList<String> getFileData(String fileName) {
        ArrayList<String> fileData = new ArrayList<String>();
        try {
            File f = new File(fileName);
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                String line = s.nextLine();
                if (!line.equals(""))
                    fileData.add(line);
            }
            return fileData;
        }
        catch (FileNotFoundException e) {
            return fileData;
        }
    }
}
