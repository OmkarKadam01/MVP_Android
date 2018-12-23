
package com.analytics.google.mvpdemo.Network.pojo;

import com.google.gson.annotations.SerializedName;


public class GenericDatum {

    @SerializedName("entity_code")
    private String entityCode;
    @SerializedName("entity_id")
    private String entityId;
    @SerializedName("entity_name")
    private String entityName;
    @SerializedName("season_type")
    private String seasonType;

    public String getEntityCode() {
        return entityCode;
    }

    public void setEntityCode(String entityCode) {
        this.entityCode = entityCode;
    }

    public String getEntityId() {
        return entityId;
    }

    public void setEntityId(String entityId) {
        this.entityId = entityId;
    }

    @Override
    public String toString() {
        return "GenericDatum{" +
                "entityCode='" + entityCode + '\'' +
                ", entityId='" + entityId + '\'' +
                ", entityName='" + entityName + '\'' +
                ", seasonType='" + seasonType + '\'' +
                '}';
    }

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public String getSeasonType() {
        return seasonType;
    }

    public void setSeasonType(String seasonType) {
        this.seasonType = seasonType;
    }

}
