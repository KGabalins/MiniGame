import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Orc myOrc = new Orc("Karlito", 10, 10);
        myOrc.description();
        myOrc.display();
        //saveData(myOrc);
        //loadData("Karlito.txt");
        myOrc = loadData("Karlito.txt");
        myOrc.display();

    }

    public static void writeToFile(String path, PCharacter pCharacter){
        try {
            FileWriter myWriter = new FileWriter(path);
            myWriter.write(pCharacter.name + "," + pCharacter.hp + "," + pCharacter.damage + "," + pCharacter.type);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static Orc loadData(String loadFile){
        String path = "src/saveFiles/" + loadFile;

        try {
            File myObj = new File(path);
            Scanner myReader = new Scanner(myObj);
            String data = myReader.nextLine();
            if(data.endsWith("orc")){
                String[] newData = data.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
                Orc newOrc = new Orc(newData[0], Integer.parseInt(newData[1]), Integer.parseInt(newData[2]));
                return newOrc;
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    public static void saveData(PCharacter pCharacter){
        try {
            File myObj = new File("src/saveFiles/" + pCharacter.name + ".txt");
            if (myObj.createNewFile()) {
                writeToFile(myObj.toString(), pCharacter);
                System.out.println("File created: " + myObj.getName());
            } else {
                int counter = 1;
                while(true){
                    File newObj = new File("src/saveFiles/" + pCharacter.name + counter + ".txt");
                    if(newObj.createNewFile()){
                        writeToFile(newObj.toString(), pCharacter);
                        System.out.println("File created: " + newObj.getName());
                        break;
                    } else {
                        counter++;
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}