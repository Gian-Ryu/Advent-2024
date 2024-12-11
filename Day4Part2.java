
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day4Part2 {
    public static void main(String[] args) {

        ArrayList<String> fileData = getFileData("src/Day4Input.txt");
        int ans = 0;
        for (int i = 0; i < fileData.size(); i++)
        {
            for (int j = 0; j < fileData.get(i).length(); j++)
            {
                if (fileData.get(i).charAt(j) == 'A')
                {
                    ans += foundXMAS(fileData, i, j);
                }
            }
        }
        System.out.println(ans);
    }

    public static int foundXMAS(ArrayList<String> arr, int row, int col)
    {
        int works = 0;
        Character[][] sets = new Character[][]{{'M', 'S', 'M', 'S'}, {'S', 'M', 'S', 'M'}, {'M', 'S', 'S', 'M'}, {'S', 'M', 'M', 'S'}};
        try
        {
            for (int i = 0; i < sets.length; i++)
            {
                if (arr.get(row - 1).charAt(col - 1) == sets[i][0] && arr.get(row + 1).charAt(col + 1) == sets[i][1] &&
                        arr.get(row - 1).charAt(col + 1) == sets[i][2] && arr.get(row + 1).charAt(col - 1) == sets[i][3])
                {
                    works++;
                }
            }
            return works;
        }
        catch (Exception e)
        {
            return 0;
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