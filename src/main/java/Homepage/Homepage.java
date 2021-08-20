package Homepage;

import java.io.IOException;
import java.util.List;

import ExcelController.ExcelController;
import Object.Data;
import Object.DataList;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

public class Homepage {

    private static DataList dataList;

    public static List<Data> start() throws IOException, InvalidFormatException {

        // Get the excel file location
        String excelLocation = "/Users/sooyoung/Desktop/Student Worker Interview.xlsx";

        // Call excel reader to retrieve each excel sheet from excel file
        List<Data> pivotSheet = ExcelController.analyzeData(0, excelLocation);
        List<Data> dataSheet = ExcelController.readPivot(excelLocation);

        dataList = new DataList();
        dataList.setDataList(dataSheet);



        for(Data data : dataSheet) {
            System.out.print(data.getAcademicProgram() + " ");
            System.out.print(data.getSourceCode() + " ");
            System.out.print(data.getAcademicYear() + " ");
            System.out.print(data.getCount());
            System.out.println();
        }

        // List<Excel> dataSheet = ExcelReader.readExcel(1, excelLocation);
        return dataSheet;
    }

    public static DataList getDataList() {
        return dataList;
    }

}
