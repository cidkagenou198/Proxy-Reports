
package com.example.reports;


public class ReportFile implements Report {

    private final String reportId;
    private final String title;
    private final String classification; 

    private String content;
    private boolean loaded = false;

    public ReportFile(String reportId, String title, String classification) {
        this.reportId = reportId;
        this.title = title;
        this.classification = classification;
    }

    @Override
    public void display(User user) {

        if (!loaded) {
            content = loadFromDisk();
            loaded = true;
        }

        System.out.println("REPORT -> id=" + reportId
                + " title=" + title
                + " classification=" + classification
                + " openedBy=" + user.getName());

        System.out.println("CONTENT: " + content);
    }

    private String loadFromDisk() {
        System.out.println("[disk] loading report " + reportId + " ...");

        try {
            Thread.sleep(120); 
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        return "Internal report body for " + title;
    }

    public String getClassification() {
        return classification;
    }
}
