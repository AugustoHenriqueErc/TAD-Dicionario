package controller;

public class TimeFormatter {

    public static String formatElapsedTime(long nanos) {
        if (nanos < 1_000) {
            return nanos + " ns";
        } else if (nanos < 1_000_000) {
            return String.format("%.3f µs", nanos / 1_000.0);
        } else if (nanos < 1_000_000_000) {
            return String.format("%.3f ms", nanos / 1_000_000.0);
        } else if (nanos < 60L * 1_000_000_000) {
            return String.format("%.3f s", nanos / 1_000_000_000.0);
        } else {
            return String.format("%.3f min", nanos / (60.0 * 1_000_000_000.0));
        }
    }
}