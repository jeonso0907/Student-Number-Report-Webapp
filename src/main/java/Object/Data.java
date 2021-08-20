package Object;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.io.IOException;
import java.util.List;

public class Data {

    public Data(){
    }

    private String academicProgram;
    private String sourceCode;
    private int academicYear;
    private int count;
    private boolean isTotal;

    public String getAcademicProgram() {
        return academicProgram;
    }

    public void setAcademicProgram(Cell academicProgram) {
        this.academicProgram = academicProgram.getStringCellValue();
    }

    public String getSourceCode() {
        return sourceCode;
    }

    public void setSourceCode(String sourceCode) {
        this.sourceCode = sourceCode;
    }

    public int getAcademicYear() {
        return academicYear;
    }

    public void setAcademicYear(int academicYear) {
        this.academicYear = academicYear;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public boolean isTotal() {
        return isTotal;
    }

    public void setTotal(boolean total) {
        isTotal = total;
    }
}
