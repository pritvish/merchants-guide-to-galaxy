package main;

import util.FileReaderUtil;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) throws IOException {

        Scanner input = new Scanner(System.in);
        System.out.println("Enter the file location");
        String filePath = input.next();
//        String filePath = "src/test/resources/file.txt";

        // reads fileInfo from the file path supplied
        List<String> fileInfo = FileReaderUtil.readFile(filePath);

        // ContentRouter decides the class to route the particular input
        ContentRouter contentRouter = new ContentRouter();
        contentRouter.route(fileInfo);
    }
}
