
package org.generator.acceptancefilter;

import org.generator.AcceptanceFilter;
import org.generator.Candidate;
import org.generator.Cell;
import org.generator.Sheet;
import org.generator.SubSheet;
import java.util.List;

public class AcceptanceFilterAppearanceLimit implements AcceptanceFilter {

    int candidateId;
    int appearanceLimit;

    public AcceptanceFilterAppearanceLimit(int candidateId, int appearanceLimit) {
        this.candidateId = candidateId;
        this.appearanceLimit = appearanceLimit;
    }

    @Override
    public boolean isAccepted(Candidate candidate, Sheet sheet, SubSheet subSheet, Cell cell) {
        if (candidate.getId() != this.candidateId) {
            return true;
        }

        List<Cell> cells = subSheet.getCells();

        return cells.stream()
            .filter(c -> c.getCandidate() != null && c.getCandidate().getId() == this.candidateId)
            .count() < this.appearanceLimit;
    }
}