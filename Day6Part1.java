import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day6Part1 {
    public static void main(String[] args) {

        ArrayList<String> fileData = getFileData("src/Day6Input.txt");
        System.out.println(fileData);
        int[] pos = new int[0];
        String dir = "up";
        boolean end = false;
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
        while (!end)
        {
            switch(dir)
            {
                case "up":
                    nextSpace = (pos[0] + 1) + "," + pos[1] + "," + map[pos[0]][pos[1]];
                    break;
                case "down":
                    nextSpace = (pos[0] - 1) + "," + pos[1] + "," + map[pos[0]][pos[1]];
                    break;
                case "right":
                    nextSpace = pos[0] + "," + (pos[1] + 1) + "," + fileData.get(pos[0]).charAt(pos[1] + 1);
                    break;
                case "left":
                    nextSpace = pos[0] + "," + (pos[1] - 1) + "," + fileData.get(pos[0]).charAt(pos[1] - 1);
                    break;
            }
            while (nextSpace.split(",")[2].equals("#"))
            {
                switch(dir)
                {
                    case "up":
                        dir = "right";
                        nextSpace = (pos[0] + 1) + "," + pos[1] + "," + fileData.get(pos[0] + 1).charAt(pos[1]);
                        break;
                    case "down":
                        dir = "left";
                        nextSpace = (pos[0] - 1) + "," + pos[1] + "," + fileData.get(pos[0] - 1).charAt(pos[1]);
                        break;
                    case "right":
                        dir = "down";
                        nextSpace = pos[0] + "," + (pos[1] + 1) + "," + fileData.get(pos[0]).charAt(pos[1] + 1);
                        break;
                    case "left":
                        dir = "up";
                        nextSpace = pos[0] + "," + (pos[1] - 1) + "," + fileData.get(pos[0]).charAt(pos[1] - 1);
                        break;
                }
            }
            switch(dir)
            {
                case "up":
                    if (!spaces.contains(pos[0] + "," + pos[1]))
                    {
                        spaces.add(pos[0] + "," + pos[1]);
                    }
                    pos[0] += 1;
                    break;
                case "down":
                    nextSpace = (pos[0] - 1) + "," + pos[1] + "," + fileData.get(pos[0] - 1).charAt(pos[1]);
                    break;
                case "right":
                    nextSpace = pos[0] + "," + (pos[1] + 1) + "," + fileData.get(pos[0]).charAt(pos[1] + 1);
                    break;
                case "left":
                    nextSpace = pos[0] + "," + (pos[1] - 1) + "," + fileData.get(pos[0]).charAt(pos[1] - 1);
                    break;
            }
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