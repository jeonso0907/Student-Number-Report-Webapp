package ExcelController;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;

import Object.Data;
import java.io.*;
import java.util.*;

public class ExcelController {

    /**
     * Read the excel file by each row and return a list of each row as a result
     *
     * @param excelLocation
     * @return a list of each excel row
     * @throws IOException
     */
    public static List<Data> analyzeData(int sheetNumber, String excelLocation) throws IOException, InvalidFormatException {
        List<Data> sheet = new ArrayList<>();
        FileInputStream inputStream = new FileInputStream(new File(excelLocation));

        Workbook workbook = WorkbookFactory.create(inputStream);
        Sheet firstSheet = workbook.getSheetAt(sheetNumber);
        Iterator<Row> iterator = firstSheet.iterator();
        int i = 0;
        String academicProgram = "";

        while (iterator.hasNext()) {
            Row nextRow = iterator.next();
            Iterator<Cell> cellIterator = nextRow.cellIterator();
            Data pivot = new Data();

            while (cellIterator.hasNext()) {
                Cell nextCell = cellIterator.next();
                int columnIndex = nextCell.getColumnIndex();

                if (columnIndex == 0 && i % 6 == 1 && i < 13) {
                    academicProgram = nextCell.getStringCellValue();
                }

                if (columnIndex >= 2 && i % 6 != 0 && i < 13) {
                    nextCell.setCellType(HSSFCell.CELL_TYPE_FORMULA);
                    nextCell.setCellFormula("INDEX(Data!$D:$D, " +
                            "MATCH(\"" + academicProgram + "\"&INDIRECT(ADDRESS(ROW(),2))&INDIRECT(ADDRESS(1,COLUMN())), INDEX(Data!$A:$A&Data!$B:$B&Data!$C:$C,), 0))");
                }

                if (columnIndex >= 2 && i % 6 == 0 && i > 0 && i < 13) {
                    int firstYear = i - 4;
                    int firstSecond = i - 3;
                    int thirdFourth = i - 2;
                    int continuing = i - 1;
                    int former = i;
                    String cellCol = "COLUMN()";
                    String total = "INDIRECT(ADDRESS(" + firstYear + ", " + cellCol + ")) + "
                                    + "INDIRECT(ADDRESS(" + firstSecond + ", " + cellCol + ")) + "
                                    + "INDIRECT(ADDRESS(" + thirdFourth + ", " + cellCol + ")) + "
                                    + "INDIRECT(ADDRESS(" + continuing + ", " + cellCol + ")) + "
                                    + "INDIRECT(ADDRESS(" + former + ", " + cellCol + "))";
                    nextCell.setCellType(HSSFCell.CELL_TYPE_FORMULA);
                    nextCell.setCellFormula(total);
                }

                if (columnIndex >= 2 && i >= 13) {
                    int engineering = i - 11;
                    int architecture = i - 5;
                    String cellCol = "COLUMN()";
                    String total = "INDIRECT(ADDRESS(" + engineering + ", " + cellCol + ")) + "
                                    + "INDIRECT(ADDRESS(" + architecture + ", " + cellCol + "))";
                    nextCell.setCellType(HSSFCell.CELL_TYPE_FORMULA);
                    nextCell.setCellFormula(total);
                }

//                switch (columnIndex) {
//                    case 1:
//                        pivot.setAcademicProgram((String) getCellValue(nextCell));
//                        break;
//                    case 2:
//                        pivot.setSourceCode((String) getCellValue(nextCell));
//                        break;
//                    case 3:
//                        pivot.setAcademicYear((int) getCellValue(nextCell));
//                        break;
//                    case 4:
//                        pivot.setCount((int) getCellValue(nextCell));
//                        break;
//                }

            }
            i++;
            sheet.add(pivot);
        }

        inputStream.close();
        FileOutputStream outputStream = new FileOutputStream(excelLocation);
        workbook.write(outputStream);
        workbook.close();

        return sheet;
    }

    public static List<Data> readPivot(String excelLocation) throws IOException, InvalidFormatException {

        List<Data> sheet = new ArrayList<>();
        FileInputStream inputStream = new FileInputStream(new File(excelLocation));

        Workbook workbook = WorkbookFactory.create(inputStream);
        Sheet firstSheet = workbook.getSheetAt(1);
        Iterator<Row> iterator = firstSheet.iterator();
        String academicProgram = "";
        String sourceCode = "";
        int year = 0;
        int count = 0;

        while (iterator.hasNext()) {
            Row nextRow = iterator.next();
            int rowNum = nextRow.getRowNum();
            System.out.println("Row Num: " + rowNum);
            if (rowNum != 0) {
                Iterator<Cell> cellIterator = nextRow.cellIterator();
                Data data = new Data();
                while (cellIterator.hasNext()) {
                    Cell nextCell = cellIterator.next();
                    int columnNum = nextCell.getColumnIndex();

                    data.setAcademicProgram(nextRow.getCell(0));
                    data.setSourceCode(nextRow.getCell(1).getStringCellValue());
                    data.setAcademicYear((int) nextRow.getCell(2).getNumericCellValue());
                    data.setCount((int) nextRow.getCell(3).getNumericCellValue());
                }

                sheet.add(data);
            }
        }

        inputStream.close();
        FileOutputStream outputStream = new FileOutputStream(excelLocation);
        workbook.write(outputStream);
        workbook.close();

        return sheet;
    }

    public static List<Data> readData(String excelLocation) {

        return null;
    }

    /**
     * Based on the type of the cell value, return the value with right call
     *
     * @param cell
     * @return the value with right type call
     */
    private static Object getCellValue(Cell cell) {
        switch (cell.getCellType()) {
            case Cell.CELL_TYPE_STRING:
                return cell.getStringCellValue();

            case Cell.CELL_TYPE_BOOLEAN:
                return cell.getBooleanCellValue();

            case Cell.CELL_TYPE_NUMERIC:
                return cell.getNumericCellValue();
        }

        return null;
    }

}
