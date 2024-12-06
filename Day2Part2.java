import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day2Part2 {
    public static void main(String[] args) {

        ArrayList<String> fileData = getFileData("src/Day2Input.txt");
        int ans = 0;
        for (String e : fileData)
        {
            boolean works = true; //to check if the given input works
            ArrayList<Integer> failed = new ArrayList<>(); //an array of all the indexes of fails.
            ArrayList<Integer> temp = new ArrayList<>();
            boolean increasing;
            for (int i = 0; i < e.split(" ").length; i++) {
                temp.add(Integer.parseInt(e.split(" ")[i]));
            }
            increasing = temp.get(0) < temp.get(1);
            for (int j = 0; j < temp.size() - 1; j++)
            {
                if (increasing && temp.get(j) >= temp.get(j + 1) || Math.abs(temp.get(j) - temp.get(j + 1)) > 3)
                {
                    failed.add(j + 1);
                }
                else if (!increasing && temp.get(j) <= temp.get(j + 1) || Math.abs(temp.get(j) - temp.get(j + 1)) > 3)
                {
                    failed.add(j + 1);
                }
            }
            if (!failed.isEmpty())
            {
                ArrayList<Integer> tempTemp = new ArrayList<>(temp);
                System.out.print(failed + " | ");
                System.out.print(tempTemp + " | ");
                boolean first = true;
                int rem = failed.getFirst() - 1;
                tempTemp.remove(rem);
                System.out.print(tempTemp + " | ");
                increasing = tempTemp.get(0) < tempTemp.get(1);
                for (int k = 0; k < tempTemp.size() - 1; k++)
                {
                    if (increasing && tempTemp.get(k) >= tempTemp.get(k + 1) || Math.abs(tempTemp.get(k) - tempTemp.get(k + 1)) > 3)
                    {
                        first = false;
                        break;
                    }
                    else if (!increasing && tempTemp.get(k) <= tempTemp.get(k + 1) || Math.abs(tempTemp.get(k) - tempTemp.get(k + 1)) > 3)
                    {
                        first = false;
                        break;
                    }
                }
                System.out.print(first + " || ");
                if (!first)
                {
                    ArrayList<Integer> tempTemp2 = new ArrayList<>(temp);
                    System.out.print(tempTemp2 + " | ");
                    rem = failed.getFirst();
                    tempTemp2.remove(rem);
                    System.out.print(tempTemp2 + " | ");
                    increasing = tempTemp2.get(0) < tempTemp2.get(1);
                    for (int k = 0; k < tempTemp2.size() - 1; k++)
                    {
                        if (increasing && tempTemp2.get(k) >= tempTemp2.get(k + 1) || Math.abs(tempTemp2.get(k) - tempTemp2.get(k + 1)) > 3)
                        {
                            works = false;
                            break;
                        }
                        else if (!increasing && tempTemp2.get(k) <= tempTemp2.get(k + 1) || Math.abs(tempTemp2.get(k) - tempTemp2.get(k + 1)) > 3)
                        {
                            works = false;
                            break;
                        }
                    }
                    System.out.print(works + " || ");
                }
                System.out.println("done");
            }
            if (works)
            {
                ans++;
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
