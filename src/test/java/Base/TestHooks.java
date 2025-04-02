package Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class TestHooks {
	public static WebDriver driver;
	public static String screenshotFolder = null;

	@Before
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@After
	public void tearDown(Scenario scenario) throws IOException {
		if (scenario.isFailed()) {
			String safeFileName = scenario.getName().replaceAll("[^a-zA-Z0-9.-]", "_") + ".png";
			captureScreenshot(safeFileName);
		}
		System.out.println("Closing the browser...");
		if (driver != null) {
			driver.quit();
		}
		System.out.println("Browser closed.");
	}

	public void captureScreenshot(String filename) throws IOException {
		
		if (screenshotFolder == null) {
			LocalDateTime date = LocalDateTime.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy-HH-mm-ss");
			screenshotFolder = "Screenshots_" + date.format(formatter);
		}

		File directory = new File("./src/test/resources/ScreenShots/" + screenshotFolder);
		if (!directory.exists()) {
			directory.mkdirs();
			
		}

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File destination = new File(directory, filename);
		FileUtils.copyFile(source, destination);
		System.out.println("Screenshot saved: " + destination.getAbsolutePath());
	}
	
	public static ArrayList<String> provider(String sheetName, String rowNum) throws IOException {
	    File path = new File("./src/test/resources/Excel/validData.xlsx"); 
	    FileInputStream dataReader = new FileInputStream(path);
	    XSSFWorkbook workbook = new XSSFWorkbook(dataReader);
	    XSSFSheet sheet = workbook.getSheet(sheetName); 

	    ArrayList<String> list = new ArrayList<>();
	    DataFormatter format = new DataFormatter();

	    int noOfRows = sheet.getPhysicalNumberOfRows(); 
        int rowIndex=Integer.parseInt(rowNum);
	    if (rowIndex >= 0 && rowIndex < noOfRows) { 
	        XSSFRow row = sheet.getRow(rowIndex);
	        if (row != null) {
	            int noOfCells = row.getLastCellNum(); 
	            for (int j = 0; j < noOfCells; j++) {
	                XSSFCell cell = row.getCell(j);
	                if (cell != null) {
	                    list.add(format.formatCellValue(cell)); 
	                }
	            }
	        }
	    } else {
	        System.out.println("Row index out of range Exception : " + rowIndex);
	    }

	    workbook.close();
	    dataReader.close();
	    return list; 
	}

}
