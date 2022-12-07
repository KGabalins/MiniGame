import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Orc myOrc = new Orc("Karlito", 5, 10);
        myOrc.description();
        myOrc.display();
    }

    public static void writeToFile(String path, Character character){
        try {
            FileWriter myWriter = new FileWriter(path);
            myWriter.write(character.name + ", " + character.hp + ", " + character.damage);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void saveData(Character character){
        try {
            File myObj = new File("src/saveFiles/" + character.name + ".txt");
            if (myObj.createNewFile()) {
                writeToFile(myObj.toString(), character);
                System.out.println("File created: " + myObj.getName());
            } else {
                int counter = 1;
                while(true){
                    File newObj = new File("src/saveFiles/" + character.name + counter + ".txt");
                    if(newObj.createNewFile()){
                        writeToFile(newObj.toString(), character);
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