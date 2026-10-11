package org.generator;

public interface AcceptanceFilter {
    boolean isAccepted(Candidate candidate, Sheet sheet, SubSheet subSheet, Cell cell);
}
