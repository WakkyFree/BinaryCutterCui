import java.util.Scanner;

public class BinaryCutterCui {


  public static void main(String[] args) {
    System.out.print("File Name: ");
    Scanner scan = new Scanner(System.in);
    String fileName = scan.next();

    System.out.print("Start Address: 0x");
    String startAdrs = scan.next();

    System.out.print("End Address: 0x");
    String endAdrs = scan.next();
    FileCut fileCutTest = new FileCut(fileName, startAdrs, endAdrs);

    fileCutTest.fileCutExe();
  }

}
