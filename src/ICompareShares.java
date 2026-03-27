package interfaces;

import model.ComparisonData;
import java.time.LocalDate;

public interface ICompareShares {
    ComparisonData compareShares(String s1, String s2, LocalDate start, LocalDate end);
}
