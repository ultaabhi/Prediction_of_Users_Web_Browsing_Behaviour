 import java.io.*;
 class Record
{
   String first;
   String last;
   String date;

  public Record(String first, String last, String date){
       this.first = first;
       this.last = last;
       this.date = date;
  }

  public static void main(String args[]){
   try{
    FileInputStream fstream = new FileInputStream("abc.txt");
          DataInputStream in = new DataInputStream(fstream);
          BufferedReader br = new BufferedReader(new InputStreamReader(in));
          String strLine;
          while ((strLine = br.readLine()) != null)   {
   String[] tokens = strLine.split(" ");
   Record record = new Record(tokens[0],tokens[1],tokens[2]);//process record , etc

   }
   in.close();
   }catch (Exception e){
     System.err.println("Error: " + e.getMessage());
   }
 }
}