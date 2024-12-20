import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day6Part2 {
    public static void main(String[] args) {

        ArrayList<String> fileData = getFileData("src/Day6Input.txt");
        int[] pos = new int[0];
        int[] boxPos = new int[0];
        int reps = 0;
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
        for (int i = 0; i < map.length; i++)
        {
            for (int j = 0; j < map[i].length; j++)
            {
                boxPos = new int[]{i, j};
                if (!(pos[0] == boxPos[0] && pos[1] == boxPos[1]))
                {
                    map[i][j] = '#';
                    while (reps < 1000)
                    {
                        reps++;
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
                            }
                        }
                        catch (Exception e) {
                            System.out.println("breaking");
                            break;
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
                    }
                    if (reps == 1000)
                    {
                        spaces.add(boxPos[0] + "" + boxPos[1]);
                    }
                }
            }
        }
        System.out.println(spaces.size());
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