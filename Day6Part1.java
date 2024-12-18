import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day6Part1 {
    public static void main(String[] args) {

        ArrayList<String> fileData = getFileData("src/Day6Input.txt");
        int[] pos = new int[0];
        String dir = "up";
        String nextSpace = "";
        ArrayList<String> spaces = new ArrayList<>();
        Character[][] map = new Character[fileData.size()][fileData.get(0).length()];
        for (int i = 0; i < fileData.size(); i++)
        {
            for (int j = 0; j < fileData.get(0).length(); j++)
            {
                map[i][j] = fileData.get(i).charAt(j);
                if (fileData.get(i).charAt(j) == '^')
                {
                    pos = new int[]{i, j};
                }
            }
        }
        spaces.add(pos[0] + "," + pos[1]);
        //int x = 0;
        while (true)
        {
            //System.out.print(pos[0] + ", " + pos[1] + " | ");
            try
            {
                switch(dir)
                {
                    case "up":
                        nextSpace = (pos[0] - 1) + "," + pos[1] + "," + map[pos[0] - 1][pos[1]];
                        break;
                    case "down":
                        nextSpace = (pos[0] + 1) + "," + pos[1] + "," + map[pos[0] + 1][pos[1]];
                        break;
                    case "right":
                        nextSpace = pos[0] + "," + (pos[1] + 1) + "," + map[pos[0]][pos[1] + 1];
                        break;
                    case "left":
                        nextSpace = pos[0] + "," + (pos[1] - 1) + "," + map[pos[0]][pos[1] - 1];
                        break;
                }
                //System.out.print(nextSpace + " | ");
                while (nextSpace.split(",")[2].equals("#"))
                {
                    switch(dir)
                    {
                        case "up":
                            dir = "right";
                            nextSpace = pos[0] + "," + (pos[1] + 1) + "," + map[pos[0]][pos[1] + 1];
                            break;
                        case "down":
                            dir = "left";
                            nextSpace = pos[0] + "," + (pos[1] - 1) + "," + map[pos[0]][pos[1] - 1];
                            break;
                        case "right":
                            dir = "down";
                            nextSpace = (pos[0] + 1) + "," + pos[1] + "," + map[pos[0] + 1][pos[1]];
                            break;
                        case "left":
                            dir = "up";
                            nextSpace = (pos[0] - 1) + "," + pos[1] + "," + map[pos[0] - 1][pos[1]];
                            break;
                    }
                    //System.out.print("new "  +nextSpace + " | ");
                }
            }
            catch (Exception e) {
                System.out.println("breaking");
                break;
            }
            map[pos[0]][pos[1]] = 'X';
            if (!spaces.contains(pos[0] + "," + pos[1]))
            {
                spaces.add(pos[0] + "," + pos[1]);
            }
            switch(dir)
            {
                case "up":
                    pos[0] -= 1;
                    break;
                case "down":
                    pos[0] += 1;
                    break;
                case "right":
                    pos[1] += 1;
                    break;
                case "left":
                    pos[1] -= 1;
                    break;
            }
            //System.out.println(pos[0] + ", " + pos[1]);
            //x++;
        }
        System.out.println(spaces.size() + 1);
        /*for (int i = 0; i < map.length; i++)
        {
            for (int j = 0; j < map[0].length; j++)
            {
                System.out.print(map[i][j]);
            }
            System.out.println();
        } */
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
