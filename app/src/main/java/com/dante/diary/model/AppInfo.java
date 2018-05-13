package com.dante.diary.model;

import com.google.gson.annotations.SerializedName;

/**
 * For app update
 */

public class AppInfo {



    @SerializedName("lastest_version")
    private String version;
    @SerializedName("lastest_version_code")
    private int versionCode;
    private String message;
    @SerializedName("apk_url")
    private String apkUrl;
    private boolean forceUpdate;
    @SerializedName("former_version")
    private String formerVersion;
    @SerializedName("share_app_description")
    private String shareApp;
    @SerializedName("egg_url")
    private String eggUrl;
    private String announcement;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public int getVersionCode() {
        return versionCode;
    }

    public void setVersionCode(int versionCode) {
        this.versionCode = versionCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getApkUrl() {
        return apkUrl;
    }

    public void setApkUrl(String apkUrl) {
        this.apkUrl = apkUrl;
    }

    public boolean isForceUpdate() {
        return forceUpdate;
    }

    public void setForceUpdate(boolean forceUpdate) {
        this.forceUpdate = forceUpdate;
    }

    public String getFormerVersion() {
        return formerVersion;
    }

    public void setFormerVersion(String formerVersion) {
        this.formerVersion = formerVersion;
    }

    public String getShareApp() {
        return shareApp;
    }

    public void setShareApp(String shareApp) {
        this.shareApp = shareApp;
    }

    @Override
    public String toString() {
        return "AppInfo{" +
                "version='" + version + '\'' +
                ", versionCode=" + versionCode +
                ", message='" + message + '\'' +
                ", apkUrl='" + apkUrl + '\'' +
                ", forceUpdate=" + forceUpdate +
                ", formerVersion='" + formerVersion + '\'' +
                ", shareApp='" + shareApp + '\'' +
                '}';
    }

    public String getEggUrl() {
        return eggUrl;
    }

    public void setEggUrl(String eggUrl) {
        this.eggUrl = eggUrl;
    }

    public String getAnnouncement() {
        return announcement;
    }

    public void setAnnouncement(String announcement) {
        this.announcement = announcement;
    }
}
