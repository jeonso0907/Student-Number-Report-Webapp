package Object;

import java.io.IOException;
import java.util.List;
import Object.Data;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

public class DataList {

    public DataList() throws IOException, InvalidFormatException {
        dataList = Homepage.Homepage.start();
    }

    private List<Data> dataList;

    public List<Data> getDataList() {
        return dataList;
    }

    public void setDataList(List<Data> dataList) {
        this.dataList = dataList;
    }
}
