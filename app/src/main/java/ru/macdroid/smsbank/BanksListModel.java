package ru.macdroid.smsbank;

public class BanksListModel {

    private String bankName;
    private int bankPhotoId;
    private String bankId;

    public BanksListModel(String bankName, int bankPhotoId, String bankId) {
        this.bankName = bankName;
        this.bankPhotoId = bankPhotoId;
        this.bankId = bankId;
    }

    public String getBankId() {
        return bankId;
    }

    public String getBankName() {
        return bankName;
    }

    public int getBankPhotoId() {
        return bankPhotoId;
    }
}
