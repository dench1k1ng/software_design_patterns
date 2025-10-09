package client;

import delivery.DeliveryChannel;
import delivery.EmailSender;
import delivery.Printer;
import report.FinancialReport;
import report.Report;
import report.TechnicalReport;


public class Main {
    public static void main(String[] args) {

        // --- Setup Implementors (Delivery Channels) ---
        // We can create concrete implementations independently
        DeliveryChannel emailChannel = new EmailSender("ceo@company.com");
        DeliveryChannel printerChannel = new Printer("HQ_LaserJet_P500");

        System.out.println("");

        // --- Scenario 1: Financial Report delivered via Email ---
        System.out.println("==================================================");
        Report q4Financials = new FinancialReport(
                "Q3 2025 Earnings Summary",
                emailChannel, // Bridge established here
                2025
        );
        q4Financials.generateAndDeliver();

        // --- Scenario 2: Technical Report delivered via Printer ---
        System.out.println("==================================================");
        Report productionMetrics = new TechnicalReport(
                "Monthly Production Metrics",
                printerChannel, // Bridge established here
                "Phoenix_Platform"
        );
        productionMetrics.generateAndDeliver();

        // --- Scenario 3: Same Report Type, Different Delivery Channel ---
        System.out.println("==================================================");
        System.out.println("Re-sending Technical Report via Email:");
        // Re-use the TechnicalReport type, but swap the Implementor
        Report emailMetrics = new TechnicalReport(
                "Monthly Production Metrics (Email Copy)",
                emailChannel, // New Bridge connection
                "Phoenix_Platform"
        );
        emailMetrics.generateAndDeliver();
        System.out.println("==================================================");
    }
}
