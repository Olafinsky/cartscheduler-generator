package org.generator.postgenerationfilter;

import org.generator.PostGenerationFilter;
import org.generator.Candidate;
import org.generator.Cell;
import org.generator.Sheet;
import org.generator.SubSheet;
import java.util.List;

public class PostGenerationFilterMinAppearanceCount implements PostGenerationFilter {

    int candidateId;
    int minAppearanceCount;

    public PostGenerationFilterMinAppearanceCount(int candidateId, int minAppearanceCount) {
        this.candidateId = candidateId;
        this.minAppearanceCount = minAppearanceCount;
    }

    @Override
    public boolean isAccepted(Sheet sheet, SubSheet subSheet) {
        List<Cell> cells = subSheet.getCells();

        return cells.stream()
            .filter(c -> c.getCandidate() != null && c.getCandidate().getId() == this.candidateId)
            .count() >= this.minAppearanceCount;
    }
}