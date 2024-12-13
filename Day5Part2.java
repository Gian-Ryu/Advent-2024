import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Day5Part2 {
    public static void main(String[] args) {

        ArrayList<String> fileData = getFileData("src/Day5Input.txt");
        ArrayList<Integer> first = new ArrayList<>(); // the numbers in the first rule
        ArrayList<Integer> second = new ArrayList<>(); // the numbers in the second rule
        ArrayList<Integer[]> tests = new ArrayList<>(); // all the test cases
        ArrayList<Integer[]> wrong = new ArrayList<>(); // all the incorrect cases
        int ans = 0; // all middle numbers of wrong cases
        for (int i = 0; i < fileData.size(); i++) // makes the arrays except wrong: WORKS FINE
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
        for (int k = 0; k < wrong.size(); k++)
        {
            int[] a = new int[first.size()];
            ArrayList<Integer> fixed = new ArrayList<>();
            for (int l = 0; l < wrong.get(k).length; l++)
            {
                int idx = 0;
                for (int m = 0; m < first.size(); m++)
                {
                    if (first.get(m) == wrong.get(k)[l] && Arrays.asList(wrong.get(k)).contains(first.get(m)) &&
                            Arrays.asList(wrong.get(k)).contains(second.get(m)))
                    {
                        idx++;
                    }
                }
                a[idx] = wrong.get(k)[l];
            }
            for (int n : a)
            {
                if (n != 0)
                {
                    fixed.add(n);
                }
            }
            ans += fixed.get((fixed.size() - 1) / 2);
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
