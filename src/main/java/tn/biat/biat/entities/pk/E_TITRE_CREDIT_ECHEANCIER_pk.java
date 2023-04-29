package tn.biat.biat.entities.pk;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

public class E_TITRE_CREDIT_ECHEANCIER_pk implements Serializable {
    private int CDR_TITR;
    private String REF_TITR;
    private int DATDEBVLD;
}
