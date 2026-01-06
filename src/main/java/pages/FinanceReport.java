package pages;

import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import baseclass.Base;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;

public class FinanceReport extends Base {

	static Map<String, String> hasmap = new HashMap<String, String>();
	static List<JSONObject> jsonObjectsList = new ArrayList<>();

	static WebDriver driver;

	@FindBy(xpath = "//*[@id=\"navbarsExample03\"]/ul/li[1]/a")
	private WebElement DashboardMenu;

	@FindBy(xpath = "//*[@id=\"navbarsExample03\"]/ul/li[1]/div/a[2]")
	private WebElement FinanceReportMenu;

	@FindBy(xpath = "//*[@id=\"time\"]")
	private WebElement dateFilter;

	@FindBy(xpath = "//*[@id=\"flatpickr\"]")
	private WebElement timeFraneFilter;

	@FindBy(xpath = "//*[@id=\"smart-form-register\"]/div[2]/div/div[2]/div/div/div[1]/button")
	private WebElement searchBTN;

	@FindBy(xpath = "//*[@id=\"smart-form-register\"]/div[2]/div/div[2]/div/div/div[3]/button")
	private WebElement resetBTN;

	@FindBy(xpath = "//*[@id=\"smart-form-register\"]/div[2]/div/div[2]/div/div/div[5]/button")
	private WebElement exportCSVBTN;

	@FindBy(xpath = "//*[@id=\"example_previous\"]")
	private WebElement previousBTN;

	@FindBy(xpath = "//*[@id=\"example_next\"]")
	private WebElement nextBTN;

	@FindBy(xpath = "//table[@id='example']//thead//tr//th//a")
	private static List<WebElement> ColumnNames;

	@FindBy(xpath = "//table[@id='example']//tbody//tr")
	private static List<WebElement> Rowcounts;

	@FindBy(xpath = "//*[@id='example']/thead/tr/th/a")
	private static List<WebElement> Columncounts;

	@FindBy(xpath = "//*[@id=\"example_paginate\"]/span/a")
	private static List<WebElement> PageButtons;

	public FinanceReport(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String getColumnNames() {

		String aall = null;

		for (WebElement allcolnames : ColumnNames) {

			aall = allcolnames.getText();
			System.out.println("------->" + aall);
		}
		System.out.println(aall);
		return aall;

	}

	public int getrowCounts() {
		return Rowcounts.size();

	}

	public int getColumnCounts() {
		return Columncounts.size();

	}

	public void clickNextBTN() {

		for (int i = 1; i < PageButtons.size(); i++) {
			nextBTN.click();
		}

	}

	public void clickPreviousBTN() {

		for (int i = 1; i < PageButtons.size(); i++) {
			previousBTN.click();
		}

	}

	public void clickDownloadBTN() {

		exportCSVBTN.click();

	}

	public WebElement dateElementFromXpath() {
		return driver.findElement(By.xpath("//span[@aria-label='" + getCurentMonthStartDate() + "']"));
	}

	public WebElement dateElementToXpath() {
		return driver.findElement(By.xpath("//span[@aria-label='" + getCurentMonthEndDate() + "']"));
	}

	public String getCurentMonthStartDate() {

		LocalDate today = LocalDate.now();

		YearMonth currentMonth = YearMonth.from(today);

		LocalDate startOfMonth = currentMonth.atDay(1);

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		System.out.println("Start of Month: " + startOfMonth.format(formatter));

		DateTimeFormatter desiredFormatter = DateTimeFormatter.ofPattern("MMMM d, yyyy");

		LocalDate startOfMonthdate = LocalDate.parse(startOfMonth.format(formatter));

		String startOfMonthdateString = startOfMonthdate.format(desiredFormatter);

		System.out.println("Formatted Date: " + startOfMonthdateString);

		return startOfMonthdateString;
	}

	public String getCurentMonthEndDate() {

		LocalDate today = LocalDate.now();

		YearMonth currentMonth = YearMonth.from(today);

		LocalDate endOfMonth = currentMonth.atEndOfMonth();

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		System.out.println("End of Month: " + endOfMonth.format(formatter));

		DateTimeFormatter desiredFormatter = DateTimeFormatter.ofPattern("MMMM d, yyyy");

		LocalDate endOfMonthdate = LocalDate.parse(endOfMonth.format(formatter));

		String endOfMonthdateString = endOfMonthdate.format(desiredFormatter);

		System.out.println("Formatted Date: " + endOfMonthdateString);

		return endOfMonthdateString;
	}

	public JSONArray checkCondition() throws IOException {

		driver.findElement(By.xpath("//*[@id=\"navbarsExample03\"]/ul/li[1]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"navbarsExample03\"]/ul/li[1]/div/a[2]")).click();

		WebElement findElement = driver.findElement(By.xpath("//*[@id=\"time\"]"));

		Select s = new Select(findElement);
		s.selectByVisibleText("Weekly");

		/*
		 * driver.findElement(By.xpath("//*[@id=\"flatpickr\"]")).click(); Actions a =
		 * new Actions(driver); WebElement calenderFrom = driver.findElement(By.xpath(
		 * "/html/body/div[4]/div[2]/div/div[2]/div/span[14]")); calenderFrom.click();
		 * 
		 * WebElement CalenderPrevious =
		 * driver.findElement(By.xpath("/html/body/div[4]/div[1]/span[1]"));
		 * CalenderPrevious.click(); CalenderPrevious.click();
		 * 
		 * WebElement calenderTo =
		 * driver.findElement(By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/span[5]"
		 * )); calenderTo.click();
		 */

		searchBTN.click();

		clickDownloadBTN();

		getColumnNames();

		System.out.println(PageButtons.size());

		for (int but = 1; but <= PageButtons.size(); but++) {

			driver.findElement(By.xpath("//*[@id=\"example_paginate\"]/span/a[" + but + "]")).click();

			for (int i = 1; i <= getrowCounts(); i++) {

				for (int j = 1; j <= getColumnCounts(); j++) {

					WebElement keyTxt = driver
							.findElement(By.xpath("//table[@id='example']//thead//tr//th[" + j + "]//a"));

					WebElement valueTxt = driver
							.findElement(By.xpath("//table[@id='example']//tbody//tr[" + i + "]//td[" + j + "]"));

					hasmap.put(keyTxt.getText(), valueTxt.getText());

				}

				ObjectMapper objectmapper = new ObjectMapper();
				String jsonString = objectmapper.writeValueAsString(hasmap);

				JSONObject jsonObject = new JSONObject(jsonString);
				jsonObjectsList.add(jsonObject);

			}

		}

		JSONArray jsonArray = new JSONArray(jsonObjectsList);
		System.out.println(jsonArray);

		return jsonArray;

	}

	public JSONArray ExportCsvAndGetValues() throws IOException, CsvException {

		CSVReader r = new CSVReader(new FileReader(
				"D:\\Vignesh R (09-08-2024)\\TSS Projects\\Automation download files\\Finance_Report_2024-10-23.csv"));

		String[] csvValues;
		List<List<String>> result = new ArrayList<List<String>>();
		// iterate through csv till the end of the values
		while ((csvValues = r.readNext()) != null) {

			List<String> va = Arrays.stream(csvValues).flatMap(s -> Arrays.stream(s.split(";")))
					.collect(Collectors.toList());
			result.add(va);

		}

		System.out.println(result);

		JSONArray jsonArray = new JSONArray();
		System.out.println(result.size());

		result.remove(0);
		result.remove(result.size() - 1);

		for (List<String> innerList : result) {
			JSONObject jsonObject = new JSONObject();

			jsonObject.put("TRANSACTION DATE", DateTimeConversion(innerList.get(0)));
			jsonObject.put("ENDING CARD NO", innerList.get(1));
			jsonObject.put("CUSTOMER NUMBER", innerList.get(2));
			jsonObject.put("MERCHANT NAME", innerList.get(3));
			jsonObject.put("STATION DETAILS", innerList.get(4));
			jsonObject.put("PUMP NUMBER", innerList.get(5));
			jsonObject.put("COMPANY NAME", innerList.get(6));
			jsonObject.put("RECEIPT NUMBER", innerList.get(7));
			jsonObject.put("REGO/SERIAL NUMBER", innerList.get(8));
			jsonObject.put("FUEL TYPE", innerList.get(9));
			jsonObject.put("TRANSACTION AMOUNT", "K" + innerList.get(10).trim());
			jsonObject.put("TRANSACTION FEE", "K" + innerList.get(11).replace(" ", "").replace("\t", ""));

			if (innerList.get(12).equals("0")) {
				jsonObject.put("FK COMMISSION", formatValue(innerList.get(12)));
			} else {
				jsonObject.put("FK COMMISSION", "K" + innerList.get(12).replace(" ", "").replace("\t", ""));
			}

//				if (innerList.get(12).equalsIgnoreCase("0")) {
//					jsonObject.put("FK COMMISSION", "K0.00");
//				}else if ((innerList.get(12).length())<=0) {
//					jsonObject.put("FK COMMISSION", innerList.get(12).replace(" ", "").replace("\t", ""));
//				}else {
//					jsonObject.put("FK COMMISSION", "K"+innerList.get(12).replace(" ", "").replace("\t", ""));
//				}

			jsonObject.put("BALANCE DUE TO MERCHANT", "K" + innerList.get(13).replace(" ", "").replace("\t", ""));
			jsonObject.put("REFUND AMOUNT", innerList.get(14).replace(" ", "").replace("\t", ""));

			jsonArray.put(jsonObject);

		}

		// Print the JSONArray
		System.out.println(jsonArray);
		return jsonArray;

	}

	public String DateTimeConversion(String inputvalue) {

		// String inputValue = "2024-08-21 16:40:59.0";

		System.out.println(inputvalue.trim());

		// Parse the input string into a LocalDateTime object
		DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");
		LocalDateTime dateTime = LocalDateTime.parse(inputvalue.trim(), inputFormatter);

		// Format the LocalDateTime object into the desired format
		DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		String outputValue = dateTime.format(outputFormatter);

		// System.out.println(outputValue); // Output: 21-08-2024 16:40:59
		return outputValue;
	}

	public void financeReportList() {
		DashboardMenu.click();
		FinanceReportMenu.click();
		selectVisibleText(dateFilter, "Date Range");
		timeFraneFilter.click();
		dateElementFromXpath().click();
		dateElementToXpath().click();
	}

	public static boolean compareJSONArrays(JSONArray jsonArray1, JSONArray jsonArray2) {
		if (jsonArray1.length() != jsonArray2.length()) {
			return false;
		}
		for (int i = 0; i < jsonArray1.length(); i++) {
			JSONObject jsonObject1 = jsonArray1.getJSONObject(i);
			JSONObject jsonObject2 = jsonArray2.getJSONObject(i);

			if (jsonObject1 != jsonObject1) {
				return false;
			}
		}

		return true;
	}

	private static String formatValue(String value) {
		try {
			double doubleValue = Double.parseDouble(value);
			if (doubleValue == 0) {
				return "K0.00";
			} else {
				return value;
			}
		} catch (NumberFormatException e) {
			// Handle invalid input (e.g., non-numeric string)
			return "Invalid value";
		}
	}

}
