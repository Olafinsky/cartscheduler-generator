
package org.generator.acceptancefilter;

import org.generator.AcceptanceFilter;
import org.generator.Candidate;
import org.generator.Cell;
import org.generator.Sheet;
import org.generator.SubSheet;
import java.util.List;

public class AcceptanceFilterCandidateQualifiesForRows implements AcceptanceFilter {

    List<Integer> qualifiedRowNumers;
    int candidateId;

    public AcceptanceFilterCandidateQualifiesForRows(int candidateId, List<Integer> qualifiedRowNumers) {
        this.candidateId = candidateId;
        this.qualifiedRowNumers = qualifiedRowNumers;
    }

    @Override
    public boolean isAccepted(Candidate candidate, Sheet sheet, SubSheet subSheet, Cell cell) {
        if (candidate.getId() != this.candidateId) {
            return true;
        }
        return qualifiedRowNumers.contains(cell.getY());
    }
}