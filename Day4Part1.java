
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
                    System.out.println("[" + i + ", " + j + "]");
                    if (i > 2)
                    {
                        if (foundXMAS(fileData, "up", i, j))
                        {
                            ans++;
                        }
                    }
                    if (i < fileData.size() - 2)
                    {
                        if (foundXMAS(fileData, "down", i, j))
                        {
                            ans++;
                        }
                    }
                    if (j > 2)
                    {
                        if (foundXMAS(fileData, "left", i, j))
                        {
                            ans++;
                        }
                    }
                    if (j < fileData.get(i).length() - 2)
                    {
                        if (foundXMAS(fileData, "right", i, j))
                        {
                            ans++;
                        }
                    }
                }
            }
        }
        System.out.println(ans);
    }

    public static boolean foundXMAS(ArrayList<String> arr, String dir, int row, int col)
    {
        if (dir.equals("left") && col > 2)
        {
            return arr.get(row).charAt(col - 1) == 'M' && arr.get(row).charAt(col - 2) == 'A' && arr.get(row).charAt(col - 3) == 'S';
        }
        if (dir.equals("right") && col < arr.get(row).length() - 3)
        {
            return arr.get(row).charAt(col + 1) == 'M' && arr.get(row).charAt(col + 2) == 'A' && arr.get(row).charAt(col + 3) == 'S';
        }
        if (dir.equals("up") && row > 2)
        {
            return arr.get(row - 1).charAt(col) == 'M' && arr.get(row - 2).charAt(col) == 'A' && arr.get(row - 3).charAt(col) == 'S';
        }
        if (dir.equals("down") && row < arr.size() - 3)
        {
            return arr.get(row + 1).charAt(col) == 'M' && arr.get(row + 2).charAt(col) == 'A' && arr.get(row + 3).charAt(col) == 'S';
        }
        return false;
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