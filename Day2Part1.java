import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day2Part1 {
    public static void main(String[] args) {

        ArrayList<String> fileData = getFileData("src/Day2Input.txt");
        int ans = 0;
        for (String e : fileData)
        {
            boolean works = true;
            int[] temp = new int[e.split(" ").length];
            boolean increasing;
            for (int i = 0; i < temp.length; i++) {
                temp[i] = Integer.parseInt(e.split(" ")[i]);
            }
            increasing = temp[0] < temp[1];
            for (int j = 0; j < temp.length - 1; j++)
            {
                if (!increasing && temp[j] < temp[j + 1] || Math.abs(temp[j] - temp[j + 1]) > 3)
                {
                    works = false;
                }
                else if (increasing && temp[j] > temp[j + 1] || Math.abs(temp[j] - temp[j + 1]) > 3)
                {
                    works = false;
                }
            }
            if (works)
            {
                ans++;
            }
        }
        System.out.print(ans);
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