
package org.generator.acceptancefilter;

import org.generator.AcceptanceFilter;
import org.generator.Candidate;
import org.generator.Cell;
import org.generator.Sheet;
import org.generator.SubSheet;
import java.util.List;
import java.util.stream.Collectors;

public class AcceptanceFilterUniqueInRow implements AcceptanceFilter {
    @Override
    public boolean isAccepted(Candidate candidate, Sheet sheet, SubSheet subSheet, Cell cell) {
        int y = cell.getY();
        List<Cell> yCells = subSheet.getCells(null, y);

        return yCells.stream()
            .filter(c -> c.getCandidate() != null && c.getCandidate().getId() == candidate.getId())
            .collect(Collectors.toList())
            .isEmpty();
    }
}