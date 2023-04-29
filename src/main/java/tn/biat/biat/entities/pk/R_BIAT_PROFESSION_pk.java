package tn.biat.biat.entities.pk;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

public class R_BIAT_PROFESSION_pk implements Serializable {

    private String ID;
    private int CDRBIATPRFS;
    private int DATDEBVLD;
}
