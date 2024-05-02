package TestCases;

import TestData.excelReader;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

@Test
public class dataProvidersClass {

    @DataProvider(name = "googleSearchData")
    public static Object [][] readSearchData() throws IOException
    {
        excelReader er = new excelReader();
        return er.getExcelData("searchData.xlsx",0);
    }

    @DataProvider(name = "facebookSearchData")
    public static Object [][] readFacebookSearchData() throws IOException
    {
        excelReader er = new excelReader();
        return er.getExcelData("searchData.xlsx",1);
    }
}
