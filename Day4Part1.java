import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day4Part1 {
    public static void main(String[] args) {

        ArrayList<String> fileData = getFileData("src/Day4Input.txt");
        //System.out.println(fileData);
        int ans = 0;
        for (int i = 0; i < fileData.size(); i++)
        {
            for (int j = 0; j < fileData.get(i).length(); j++)
            {
                if (fileData.get(i).charAt(j) == 'X')
                {
                    int[][] ways = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}, {1, 1}, {-1, -1}, {1, -1}, {-1, 1}};
                    for (int k = 0; k < ways.length; k++)
                    {
                        if (foundXMAS(fileData, i, j, ways[k][0], ways[k][1]))
                        {
                            ans++;
                        }
                    }
                }
            }
        }
        System.out.println(ans);
    }

    public static boolean foundXMAS(ArrayList<String> arr, int row, int col, int rowInc, int colInc)
    {
        Character[] letters = new Character[]{'M', 'A', 'S'};
        try
        {
            for (int i = 1; i < 4; i++)
            {
                if (arr.get(row + (rowInc * i)).charAt(col + (colInc * i)) != letters[i - 1])
                {
                    return false;
                }
            }
            return true;
        }
        catch (Exception e)
        {
            return false;
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
