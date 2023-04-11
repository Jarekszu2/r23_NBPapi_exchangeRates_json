package model;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class Rate {

    private String no;
    private String effectiveDate;
    private double mid;

    @SerializedName(value = "bid")
    private double Bid;

    @SerializedName(value = "ask")
    private double Ask;
}
