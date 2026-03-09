
package com.example.reports;

public class ReportProxy implements Report {

    private final String reportId;
    private final String title;
    private final String classification;

    private final AccessControl accessControl = new AccessControl();

    // cached real report
    private RealReport realReport;

    public ReportProxy(String reportId, String title, String classification) {
        this.reportId = reportId;
        this.title = title;
        this.classification = classification;
    }

    @Override
    public void display(User user) {

        if (!accessControl.canAccess(user, classification)) {
            System.out.println("ACCESS DENIED for user " 
                + user.getName() + " to report " + reportId);
            return;
        }

        if (realReport == null) {
            System.out.println("[Proxy] Lazy loading report: " + reportId);
            realReport = new RealReport(reportId, title, classification);
        } else {
            System.out.println("[Proxy] Using cached report: " + reportId);
        }

        realReport.display(user);
    }
}