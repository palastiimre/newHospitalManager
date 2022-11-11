package com.hospitalmanager.entities;

import lombok.Getter;
import lombok.Setter;

import java.util.Collection;

@Setter
@Getter
public class MedicalRecord {
    private Patient patient;
    private Collection<DailyInterventions> dailyInterventions;
    private NursingHistory nursingHistory;
    private GDPR gdpr;
    private OutpatientSheet outpatientSheet;
    private SummarySheet summarySheet;
    private FinalReport finalReport;
    private Collection<Appendix> appendices;

}
