
package com.analytics.google.mvpdemo.Network.pojo;

import java.util.List;
import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class CityResponse {

    @SerializedName("generic_data")
    private List<GenericDatum> genericData;

    @Override
    public String toString() {
        return "CityResponse{" +
                "genericData=" + genericData +
                '}';
    }

    public List<GenericDatum> getGenericData() {
        return genericData;
    }

    public void setGenericData(List<GenericDatum> genericData) {
        this.genericData = genericData;
    }

}
