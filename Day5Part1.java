
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day5Part1 {
    public static void main(String[] args) {

        ArrayList<String> fileData = getFileData("src/Day5Input.txt");
        ArrayList<Integer> first = new ArrayList<>();
        ArrayList<Integer> second = new ArrayList<>();
        ArrayList<int[]> tests = new ArrayList<>();
        for (int i = 0; i < fileData.size(); i++)
        {
            if (fileData.get(i).contains("|"))
            {
                first.add(Integer.parseInt(fileData.get(i).split("\\|")[0]));
                second.add(Integer.parseInt(fileData.get(i).split("\\|")[1]));
            }
            else
            {
                int[] temp = new int[fileData.get(i).split(",").length];
                for (int j = 0; j < fileData.get(i).split(",").length; j++)
                {
                    temp[j] = Integer.parseInt(fileData.get(i).split(",")[j]);
                }
                tests.add(temp);
            }
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
Main.java
Displaying Main.java.