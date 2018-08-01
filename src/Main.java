import java.io.IOError;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args){
        ArrayList<String> map = new ArrayList<>();
        ArrayList<String> solution= new ArrayList<>();
        Scanner input = new Scanner(System.in);
        System.out.print("Introdusca el nombre del archivo del mapa:");
        String mapfile = input.nextLine();
        try {
            Stream<String> lines = Files.lines(
                    Paths.get(mapfile),
                    StandardCharsets.UTF_8
            );
            lines.forEach(s -> );
        }catch (IOException exception){
            System.out.println("Error");
        }

    }
}
