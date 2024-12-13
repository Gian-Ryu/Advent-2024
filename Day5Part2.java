import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Day5Part2 {
    public static void main(String[] args) {

        ArrayList<String> fileData = getFileData("src/Day5Input.txt");
        ArrayList<Integer> first = new ArrayList<>();
        ArrayList<Integer> second = new ArrayList<>();
        ArrayList<Integer[]> tests = new ArrayList<>();
        ArrayList<Integer[]> wrong = new ArrayList<>();
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
        for (int k = 0; k < tests.size(); k++)
        {
            for (int l = 0; l < first.size(); l++)
            {
                if (Arrays.asList(tests.get(k)).contains(first.get(l)) && Arrays.asList(tests.get(k)).contains(second.get(l)))
                {
                    if (Arrays.asList(tests.get(k)).indexOf(first.get(l)) > Arrays.asList(tests.get(k)).indexOf(second.get(l)))
                    {
                        wrong.add(tests.get(k));
                        break;
                    }
                }
            }
        }
        for (int k = 0; k < tests.size(); k++)// +1 to count whenever on the left side.
        {
            int[] a = new int[first.size()];
            for (int l = 0; l < tests.get(k).length; l++)
            {
                int count = 0;
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