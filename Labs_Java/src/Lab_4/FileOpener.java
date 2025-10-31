package Lab_4;

import java.io.*;
import java.nio.file.*;

public class FileOpener {
    public static void main(String[] args){
        //Path fileOne = Paths.get("File1.txt");
        //Path fileTwo = Paths.get("FileTwo.txt");
        FileInputStream fileOne = null;
        FileOutputStream fileTwo = null;
        try{
             fileOne = new FileInputStream("File.txt");
             fileTwo = new FileOutputStream("FileTwo.txt");

            //Files.copy(fileOne, fileTwo, StandardCopyOption.REPLACE_EXISTING);
            int dataByte;
            while((dataByte = fileOne.read()) != -1){

                fileTwo.write(dataByte);
                //fileOne.close();
            }
            fileOne.close();
            fileTwo.close();
            System.out.println("Данные из файла 1 скопированы в файл 2");
        } catch (NoSuchFileException e){
            System.out.println("Ошибка нет файла " + e.toString());
        } catch (IOException e) {
            System.out.println("Ошибка IO " + e.toString());
        } catch (Exception e) {
            System.out.println("Неопознанная ошибка " + e.toString());
        } finally {

            System.out.println("End of working");
        }
    }
}
