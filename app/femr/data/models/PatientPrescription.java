/*
     fEMR - fast Electronic Medical Records
     Copyright (C) 2014  Team fEMR

     fEMR is free software: you can redistribute it and/or modify
     it under the terms of the GNU General Public License as published by
     the Free Software Foundation, either version 3 of the License, or
     (at your option) any later version.

     fEMR is distributed in the hope that it will be useful,
     but WITHOUT ANY WARRANTY; without even the implied warranty of
     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
     GNU General Public License for more details.

     You should have received a copy of the GNU General Public License
     along with fEMR.  If not, see <http://www.gnu.org/licenses/>. If
     you have any questions, contact <info@teamfemr.org>.
*/
package femr.data.models;

import org.joda.time.DateTime;
import javax.persistence.*;

@Entity
@Table(name = "patient_prescriptions")
public class PatientPrescription implements IPatientPrescription {
    @Id
    @Column(name = "id", unique = true, nullable = false)
    private int id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "encounter_id", nullable = false)
    private PatientEncounter patientEncounter;
    @ManyToOne(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinColumn(name = "medication_id", nullable = false, insertable = true, updatable = true)
    private Medication medication;
    @ManyToOne
    @JoinColumn(name = "medication_administrations_id", nullable = true)
    private MedicationAdministration medicationAdministration;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    private User physician;
    @Column(name = "amount", nullable = true)
    private  int amount;
    @Column(name = "date_taken", nullable = false)
    private DateTime dateTaken;
    //not sure if eBean can handle self referencing fields (some ORMs freak out with infinite loops)
    @Column(name = "replacement_id", nullable = true)
    private Integer replacementId;
    @Column(name = "special_instructions", nullable = true)
    private String specialInstructions;

    @Override
    public int getId() {
        return id;
    }

    @Override
    public IPatientEncounter getPatientEncounter() {
        return patientEncounter;
    }

    @Override
    public void setPatientEncounter(IPatientEncounter patientEncounter) {
        this.patientEncounter = (PatientEncounter) patientEncounter;
    }

    @Override
    public IMedication getMedication() {
        return medication;
    }

    @Override
    public void setMedication(IMedication medication) {
        this.medication = (Medication) medication;
    }

    @Override
    public IMedicationAdministration getMedicationAdministration() {
        return medicationAdministration;
    }

    @Override
    public void setMedicationAdministration(IMedicationAdministration medicationAdministration) {
        this.medicationAdministration = (MedicationAdministration) medicationAdministration;
    }

    @Override
    public IUser getPhysician() {
        return physician;
    }

    @Override
    public void setPhysician(IUser physician) {
        this.physician = (User) physician;
    }

    @Override
    public int getAmount() {
        return amount;
    }

    @Override
    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public Integer getReplacementId() {
        return replacementId;
    }

    @Override
    public void setReplacementId(Integer replacementId) {
        this.replacementId = replacementId;
    }

    @Override
    public DateTime getDateTaken() {
        return dateTaken;
    }

    @Override
    public void setDateTaken(DateTime dateTaken) {
        this.dateTaken = dateTaken;
    }

    @Override
    public String getSpecialInstructions() {
        return specialInstructions;
    }

    @Override
    public void setSpecialInstructions(String specialInstructions) {
        this.specialInstructions = specialInstructions;
    }
}
