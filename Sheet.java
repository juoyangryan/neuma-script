import java.io.*; 
import org.apache.poi.hssf.usermodel.HSSFWorkbook; 
import org.apache.poi.ss.usermodel.Sheet; 
import org.apache.poi.ss.usermodel.Workbook; 
  
public class Sheet { 
    public static void main(String[] args)  
      throws FileNotFoundException, IOException { 

  
        // Creating Workbook instances 
        Workbook wb = new HSSFWorkbook(); 
  
        // An output stream accepts output bytes and sends them to sink. 
        OutputStream fileOut = new FileOutputStream("Runs.xlsx"); 
          
        // Creating Sheets using sheet object 
        Sheet sheet = wb.createSheet("Runs"); 
        Row header = Sheet.createRow(0);
        header.createCell(0).setCellValue("Information");
        for(int i = 1; i < 24; i++){
        	header.createCell(i).setCellValue("Trial number " + (i+1));
        }

          
  
System.out.println("Sheets Has been Created successfully"); 
  
        wb.write(fileOut); 
    } 
} 