
package com.example.reports;

public class RealReport implements Report {

    private final String reportId;
    private final String title;
    private final String classification;

    private String content;
    private boolean loaded = false;

    public RealReport(String reportId, String title, String classification) {
        this.reportId = reportId;
        this.title = title;
        this.classification = classification;
    }

    
    private void loadFromDisk() {
        System.out.println("[RealReport] Loading report from disk for report: " + reportId);

        try {
            Thread.sleep(1000); 
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        content = "Confidential Report Content for '" + title + "'";
        loaded = true;
    }

    @Override
    public void display(User user) {
        if (!loaded) {
            loadFromDisk();
        }

        System.out.println("User: " + user.getName() + " is viewing report: " + title);
        System.out.println("Report Content: " + content);
    }

    public String getClassification() {
        return classification;
    }
}