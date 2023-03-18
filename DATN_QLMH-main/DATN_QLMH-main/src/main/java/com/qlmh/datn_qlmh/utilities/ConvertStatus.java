package com.qlmh.datn_qlmh.utilities;

public class ConvertStatus {
    public static String getProductStatusName(int status,String lang) {
        switch (status) {
            case 1:
                return MessageUtils.get(lang, "msg.status.active");
            case 2:
                return MessageUtils.get(lang, "msg.status.inactive");
            case 3:
                return MessageUtils.get(lang, "msg.status.draft");
            default:
                return MessageUtils.get(lang, "msg.status.not-existent");

        }
    }
    public static String getDeliveredName(int status,String lang) {
        switch (status) {
            case 1:
                return MessageUtils.get(lang, "msg.status.waiting");
            case 2:
                return MessageUtils.get(lang, "msg.status.taken");
            case 3:
                return MessageUtils.get(lang, "msg.status.processing");
            case 4:
                return MessageUtils.get(lang, "msg.status.packed");
            case 5:
                return MessageUtils.get(lang, "msg.status.transported");
            case 6:
                return MessageUtils.get(lang, "msg.status.delivered");
            default:
                return MessageUtils.get(lang, "msg.status.error");

        }
    }
    public static String getOrderName(int status,String lang) {
        switch (status) {
            case 1:
                return MessageUtils.get(lang, "msg.status.ordered");
            case 2:
                return MessageUtils.get(lang, "msg.status.wait-confirmed");
            case 3:
                return MessageUtils.get(lang, "msg.status.confirmed");
            case 4:
                return MessageUtils.get(lang, "msg.status.preparing");
            case 5:
                return MessageUtils.get(lang, "msg.status.delivered-to-the-carrier");
            case 6:
                return MessageUtils.get(lang, "msg.status.transported");
            case 7:
                return MessageUtils.get(lang, "msg.status.delivered");
            default:
                return MessageUtils.get(lang, "msg.status.cancel");

        }
    }
    public static String orderType(int status, String lang){
        switch (status) {
            case 1:
                return MessageUtils.get(lang, "msg.status.order-pre");
            case 2:
                return MessageUtils.get(lang, "msg.status.order-available");
            default:
                return MessageUtils.get(lang, "No body");

        }
    }
}
