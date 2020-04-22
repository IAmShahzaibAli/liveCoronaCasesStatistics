
package com.coronavirus.world.cases.tracker.AllFragment.GlobalNetwork;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GWorldwide {

    @SerializedName("TotalConfirmed")
    @Expose
    private Integer totalConfirmed;
    @SerializedName("TotalDeaths")
    @Expose
    private Integer totalDeaths;
    @SerializedName("TotalRecovered")
    @Expose
    private Integer totalRecovered;

    public Integer getTotalConfirmed() {
        return totalConfirmed;
    }

    public void setTotalConfirmed(Integer totalConfirmed) {
        this.totalConfirmed = totalConfirmed;
    }

    public Integer getTotalDeaths() {
        return totalDeaths;
    }

    public void setTotalDeaths(Integer totalDeaths) {
        this.totalDeaths = totalDeaths;
    }

    public Integer getTotalRecovered() {
        return totalRecovered;
    }

    public void setTotalRecovered(Integer totalRecovered) {
        this.totalRecovered = totalRecovered;
    }

}
