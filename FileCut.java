import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.File;

public class FileCut {
  private String fileName;
  private String startAddress;
  private String endAddress;

  public FileCut(String _fileName, String _startAddress, String _endAddress) {
    fileName = _fileName;
    startAddress = _startAddress;
    endAddress = _endAddress;
  }

  public void fileCutExe(){
    try {
      File file = new File(fileName);
      byte[] b = new byte[(int)file.length()];
      int startByte  = Integer.parseInt(startAddress,16);
      int endByte    = Integer.parseInt(endAddress,16);
      int readByte = 0, totalByte = 0;
      
      DataInputStream dataInStream = 
        new DataInputStream(
          new BufferedInputStream(
            new FileInputStream(fileName)));

      DataOutputStream dataOutStream = 
        new DataOutputStream(
          new BufferedOutputStream(
            new FileOutputStream("COPY" + fileName)));

      while(-1 != (readByte = dataInStream.read(b))){
        dataOutStream.write(b, startByte, endByte-startByte);
        totalByte += endByte-startByte;

        System.out.println("Read file size: 0x" + Integer.toHexString(readByte) + " Cut file size: 0x" + Integer.toHexString(totalByte));
    }
      
      dataInStream.close();
      dataOutStream.close();
      
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  // Getter
  public String getFileName(){
    return fileName;
  }

  public String getStartAddress(){
    return startAddress;
  }

  public String getEndAddress(){
    return endAddress;
  }

  // Setter
  public void setFileName(String _fileName){
    fileName = _fileName;
  }

  public void setStartAddress(String _startAddress){
    startAddress = _startAddress;
  }

  public void setEndAddress(String _endAddress){
    endAddress = _endAddress;
  }


}
