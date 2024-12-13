import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Day5Part1 {
    public static void main(String[] args) {

        ArrayList<String> fileData = getFileData("src/Day5Input.txt");
        ArrayList<Integer> first = new ArrayList<>();
        ArrayList<Integer> second = new ArrayList<>();
        ArrayList<Integer[]> tests = new ArrayList<>();
        int ans = 0;
        for (int i = 0; i < fileData.size(); i++)
        {
            if (fileData.get(i).contains("|"))
            {
                first.add(Integer.parseInt(fileData.get(i).split("\\|")[0]));
                second.add(Integer.parseInt(fileData.get(i).split("\\|")[1]));
            }
            else
            {
                Integer[] temp = new Integer[fileData.get(i).split(",").length];
                for (int j = 0; j < fileData.get(i).split(",").length; j++)
                {
                    temp[j] = Integer.parseInt(fileData.get(i).split(",")[j]);
                }
                tests.add(temp);
            }
        }
        System.out.print(first + " | ");
        System.out.print(second + " | ");
        System.out.println(tests);
        for (int k = 0; k < tests.size(); k++)
        {
            boolean works = true;
            for (int l = 0; l < first.size(); l++)
            {
                if (Arrays.asList(tests.get(k)).contains(first.get(l)) && Arrays.asList(tests.get(k)).contains(second.get(l)))
                {
                    System.out.print(true + " | " + first.get(l) + " | " + second.get(l) + " | ");
                    if (Arrays.asList(tests.get(k)).indexOf(first.get(l)) > Arrays.asList(tests.get(k)).indexOf(second.get(l)))
                    {
                        System.out.println(false);
                        works = false;
                    }
                }
            }
            if (works)
            {
                ans += tests.get(k)[(tests.get(k).length - 1) / 2];
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
