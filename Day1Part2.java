import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Day1Part2 {
    public static void main(String[] args) {

        ArrayList<String> fileData = getFileData("src/Day1Input.txt");
        int[] first = new int[fileData.size()];
        int[] second = new int[fileData.size()];
        int ans = 0;
        for (int i = 0; i < fileData.size(); i++)
        {
            first[i] = Integer.parseInt(fileData.get(i).split(" {3}")[0]);
            second[i] = Integer.parseInt(fileData.get(i).split(" {3}")[1]);
        }
        for (int j = 0; j < first.length; j++)
        {
            for (int k = 0; k < second.length; k++)
            {
                if (first[j] == second[k])
                {
                    ans += first[j];
                }
            }
        }
        System.out.println(ans);
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