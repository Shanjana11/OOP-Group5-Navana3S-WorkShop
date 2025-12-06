package com.group5.navana3s_workshop.Tasfia;

public class ReorderLowStockModel {

    private Boolean selected;
    private String partId;
    private String partName;
    private Integer currentQty;
    private Integer reorderLevel;
    private String suggestedSupplier;

    public ReorderLowStockModel(Boolean selected, String partId, String partName, Integer currentQty, Integer reorderLevel, String suggestedSupplier) {
        this.selected = selected;
        this.partId = partId;
        this.partName = partName;
        this.currentQty = currentQty;
        this.reorderLevel = reorderLevel;
        this.suggestedSupplier = suggestedSupplier;
    }

    public Boolean getSelected() {
        return selected;
    }

    public void setSelected(Boolean selected) {
        this.selected = selected;
    }

    public String getPartId() {
        return partId;
    }

    public void setPartId(String partId) {
        this.partId = partId;
    }

    public String getPartName() {
        return partName;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    public Integer getCurrentQty() {
        return currentQty;
    }

    public void setCurrentQty(Integer currentQty) {
        this.currentQty = currentQty;
    }

    public Integer getReorderLevel() {
        return reorderLevel;
    }

    public void setReorderLevel(Integer reorderLevel) {
        this.reorderLevel = reorderLevel;
    }

    public String getSuggestedSupplier() {
        return suggestedSupplier;
    }

    public void setSuggestedSupplier(String suggestedSupplier) {
        this.suggestedSupplier = suggestedSupplier;
    }

    @Override
    public String toString() {
        return "ReorderLowStockModel{" +
                "selected=" + selected +
                ", partId='" + partId + '\'' +
                ", partName='" + partName + '\'' +
                ", currentQty=" + currentQty +
                ", reorderLevel=" + reorderLevel +
                ", suggestedSupplier='" + suggestedSupplier + '\'' +
                '}';
    }
}
