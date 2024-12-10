
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Day3Part2 {
    public static void main(String[] args) {

        ArrayList<String> fileData = getFileData("src/Day3Input.txt");
        System.out.println(fileData);
        int ans = 0;
        boolean on = true;
        for (String e : fileData)
        {
            String find = "do\\(\\) | don't\\(\\) | mul\\([1-9][0-9]*,[1-9][0-9]*\\)";
            Matcher n = Pattern.compile(find).matcher(e);
            while(n.find())
            {
                if (n.group().charAt(0) == 'd') {
                    on = n.group().charAt(2) != 'n';
                }
                else if (on)
                {
                    int[] ints = new int[2];
                    ints[0] = Integer.parseInt(n.group().split(",")[0].substring(4));
                    ints[1] = Integer.parseInt(n.group().split(",")[1].substring(0, n.group().split(",")[1].length() - 1));
                    ans += ints[0] * ints[1];
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
