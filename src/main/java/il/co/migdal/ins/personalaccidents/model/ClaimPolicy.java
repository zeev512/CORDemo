package il.co.migdal.ins.personalaccidents.model;

import java.util.ArrayList;
import java.util.List;

public class ClaimPolicy {
    private List<ClaimCoverage> coverages = new ArrayList<ClaimCoverage>();
    private List<Paragraph> paragraphs = new ArrayList<Paragraph>();
    private List<PhysicianDecision> decisions = new ArrayList<PhysicianDecision>();

    public ClaimPolicy() {
        ClaimCoverage coverage = new ClaimCoverage();
        Paragraph paragraph = new Paragraph();
        PhysicianDecision decision = new PhysicianDecision();
        coverages.add(coverage);
        paragraphs.add(paragraph);
        decisions.add(decision);
    }

}

