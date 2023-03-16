package org.example.domain;

public class DataInfo {
  private String dataName;
  private int dataSize;
  private DataType dataType;

  public DataInfo(String dataInfo) {
    String[] tokens = dataInfo.split(",");
    
    this.dataName = tokens[0];
    this.dataSize = Integer.parseInt(tokens[1]);
    this.dataType = loadingDataType(Integer.parseInt(tokens[2]));
  }

  private DataType loadingDataType(int typeNum) {
    if(typeNum == 0) return DataType.TYPE_0;
    return DataType.TYPE_1;
  }

  public int getDataSize() {return dataSize;}

  public String toString() {
    return dataName + "(" + dataType.toString() + ")";
  }
}
